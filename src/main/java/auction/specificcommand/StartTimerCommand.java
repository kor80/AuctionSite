package auction.specificcommand;

import auction.command.Command;
import auction.command.CommandHandler;
import auction.controller.ClientController;
import auction.view.observer.CountDownThread;

import javax.swing.*;

/**
 * <h1>Start Timer Command</h1>
 * This class is a concretization of the command interface.
 * It subscribes an observer to the auctions changes, starting
 * a timeout thread which is responsible to update the auction time
 * each second and to restart from a certain amount of time according
 * to the auction updates.
 *
 * @author Cosimo Russo
 * @version 1.0
 */
public class StartTimerCommand implements Command
{
    private ClientController client;
    private CommandHandler handler;
    private JFrame frame;
    private JLabel label;
    private long remainingTime;

    public StartTimerCommand(ClientController client, CommandHandler handler, JFrame frame, JLabel remainingTimeLabel, long remainingTime){
        this.client = client;
        this.handler = handler;
        this.frame = frame;
        this.label = remainingTimeLabel;
        this.remainingTime = remainingTime;
    }

    @Override
    public boolean doIt() {
        CountDownThread countDownThread = new CountDownThread(client,handler,frame,label,remainingTime);
        client.attach(countDownThread);
        countDownThread.start();
        return true;
    }//doIt
}//StartTimerCommand
