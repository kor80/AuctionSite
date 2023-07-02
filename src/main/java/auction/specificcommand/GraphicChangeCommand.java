package auction.specificcommand;

import auction.command.Command;
import auction.controller.ClientController;
import auction.view.observer.LabelUpdater;

import javax.swing.*;

/**
 * <h1>Graphic Change Command</h1>
 * This class is a concretization of the command interface.
 * It subscribes an observer to the auctions changes, starting
 * a graphic updater thread which is responsible to listen to the
 * updates and update the labels in real time.
 *
 * @author Cosimo Russo
 * @version 1.0
 */
public class GraphicChangeCommand implements Command
{
    ClientController client;
    private JLabel offer, status, winner;

    public GraphicChangeCommand(ClientController client, JLabel offer, JLabel status, JLabel winner){
        this.client = client;
        this.offer = offer;
        this.status = status;
        this.winner = winner;
    }

    @Override
    public boolean doIt() {
        LabelUpdater labelUpdater = new LabelUpdater(offer,status,winner);
        client.attach(labelUpdater);
        return true;
    }//doIt
}//GraphicChangeCommand
