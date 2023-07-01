package auction.specificcommand;

import auction.command.Command;
import auction.controller.ClientController;
import auction.view.observer.LabelUpdater;

import javax.swing.*;

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
