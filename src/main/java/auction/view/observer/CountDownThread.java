package auction.view.observer;

import auction.command.CommandHandler;
import auction.controller.ClientController;
import auction.model.auctions.AuctionInfo;
import auction.specificcommand.ChangeViewCommand;
import auction.view.ActiveAuctionsMenu;

import javax.swing.*;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class CountDownThread extends Thread implements GUIObserverIF
{
    private final JLabel countDownLabel;
    private long timer; //sec
    private Semaphore timerLock;

    private ClientController client;
    private CommandHandler handler;
    private JFrame frame;

    public CountDownThread(ClientController client, CommandHandler handler, JFrame frame, JLabel remainingTimeLabel, long remainingTime){
        this.client = client;
        this.handler = handler;
        this.frame = frame;
        countDownLabel = remainingTimeLabel;
        timer = remainingTime;
        timerLock = new Semaphore(1);
    }

    private void stopTimer(){
        try{
            timerLock.acquire();
            timer = 0;
            timerLock.release();
        }catch (InterruptedException e ){ timerLock.release();}
    }//stopTimer

    public void updateTimer(){
        try{
            timerLock.acquire();
            timer = 30;
            timerLock.release();
        }catch (InterruptedException e ){ timerLock.release();}
    }//updateTimer

    @Override
    public void run(){
        while(timer > 0){
            try{
                timerLock.acquire();
                timer--;
                countDownLabel.setText(String.valueOf(timer));
                countDownLabel.revalidate();
                timerLock.release();
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e ){
                timerLock.release();
            }
        }
    }//run

    @Override
    public void updateGUI(AuctionInfo info) {
        if( !info.getIsOpened() ){
            stopTimer();
            handler.handle(new ChangeViewCommand(new ActiveAuctionsMenu(client,handler,frame),frame));
            return;
        }
        if( info.getRemainingTime()<30 ){
            updateTimer();
            return;
        }
    }//info
}//CountDownThread
