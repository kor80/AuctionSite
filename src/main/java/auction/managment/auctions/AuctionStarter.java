package auction.managment.auctions;

import auction.managment.ArticleInfo;
import auction.managment.memory.MemoryManager;
import auction.utils.DateChecker;

import java.util.concurrent.TimeUnit;

public class AuctionStarter extends Thread
{
    private AuctionsManager auctionsManager;
    private final int CHECKING_PERIOD = 5; //sec

    public AuctionStarter(AuctionsManager auctionsManager){
        this.auctionsManager = auctionsManager;
    }

    @Override
    public void run() {
        try{
            while( true ){
                for(ArticleInfo info : MemoryManager.getInstance().getArticles() ){
                    if( DateChecker.isStarted(info) && !MemoryManager.getInstance().isAuctionClosed(info.getId()) )
                        auctionsManager.activateAuction(info.getId());
                }
                TimeUnit.SECONDS.sleep(CHECKING_PERIOD);
            }
        }catch(InterruptedException e ){}
    }//run
}//AuctionStarter
