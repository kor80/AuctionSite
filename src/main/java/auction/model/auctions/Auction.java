package auction.model.auctions;

import auction.model.memory.MemoryManager;
import auction.utils.DateChecker;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Auction extends AbstractAuction
{
    private double buyNowPrice;
    private Semaphore offerLock;
    private Semaphore timeLock;

    public Auction( double startingPrice, int id, double buyNowPrice){
        this.id = id;
        this.buyNowPrice = buyNowPrice;
        this.currentOffer = startingPrice;
        currentWinner = "";
        isOpened = true;
        offerLock = new Semaphore(1);
        timeLock = new Semaphore(1);
    }

    @Override
    public boolean makeOffer(double amount, String user) {
        try{
            offerLock.acquire();
            if( amount<=currentOffer ){
                offerLock.release();
                return false;
            }
            currentOffer = amount;
            currentWinner = user;
            offerLock.release();
            timeLock.acquire();
            notifyListeners();
            if( timeOut < 30 ) timeOut = 30;
            timeLock.release();
            return true;
        }catch (InterruptedException e){
            offerLock.release();
            timeLock.release();
            return false;
        }
    }//makeOffer

    @Override
    public boolean buyNow(String user) {
        try{
            offerLock.acquire();
            if( buyNowPrice == 0 ){
                offerLock.release();
                return false;
            }
            currentWinner = user;
            currentOffer = buyNowPrice;
            offerLock.release();
            timeOut = 0;
            return true;
        }catch (InterruptedException e){ offerLock.release(); return false;}
    }//buyNow

    @Override
    public synchronized void close() {
        isOpened = false;
        notifyListeners();
        removeAllListeners();
        AuctionsManager.getInstance().closeAuction(id);
    }//close

    @Override
    public void startTimer(){
        (new Timer()).start();
    }//startTimer

    private class Timer extends Thread{
        @Override
        public void run(){
            timeOut = DateChecker.getRemainingTimeInSeconds(MemoryManager.getInstance().getArticle(id));
            try{
                while( timeOut > 0 ){
                    TimeUnit.SECONDS.sleep(1);
                    timeLock.acquire();
                    System.out.println(timeOut);
                    timeOut--;
                    timeLock.release();
                }
                close();
            }catch( InterruptedException e ){ timeLock.release();}
        }//run
    }//Timer
}//Auction
