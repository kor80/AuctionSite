package auction.view.observer;

import auction.model.auctions.AuctionInfo;

import javax.swing.*;

public class LabelUpdater implements GUIObserverIF
{
    private JLabel offer, status, winner;

    public LabelUpdater(JLabel offer, JLabel status, JLabel winner){
        this.offer = offer;
        this.status = status;
        this.winner = winner;
    }

    @Override
    public void updateGUI(AuctionInfo info) {
        offer.setText(String.valueOf(info.getCurrentOffer()));

        String statusString = info.getIsOpened() ? "Aperta" : "Chiusa";
        status.setText(statusString);

        winner.setText(info.getCurrentWinner());
    }//updateGUI
}//LabelUpdater
