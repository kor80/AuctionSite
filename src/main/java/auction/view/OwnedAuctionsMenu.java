package auction.view;

import auction.controller.ClientController;
import auction.managment.auctions.AuctionInfo;
import auction.utils.GraphicsUtils;

import javax.swing.*;
import java.awt.*;
import java.util.Collection;

public class OwnedAuctionsMenu extends JPanel {
    public OwnedAuctionsMenu(ClientController client){
        setLayout(new BorderLayout());

        Collection<AuctionInfo> auctions = client.getOwnedAuctions();
        if( auctions==null ) return;
        JPanel auctionsPanel = new JPanel();
        auctionsPanel.setLayout(new BoxLayout(auctionsPanel,BoxLayout.Y_AXIS));

        for( AuctionInfo auction : auctions ){
            auctionsPanel.add(GraphicsUtils.createAuctionView(auction));
            auctionsPanel.add(new JSeparator());
        }

        JScrollPane scrollPane = new JScrollPane(auctionsPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        add(scrollPane,BorderLayout.CENTER);
        revalidate();
    }
}//OwnedAuctionsMenu
