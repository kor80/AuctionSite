package auction.view;

import auction.controller.ClientController;
import auction.model.auctions.AuctionInfo;
import auction.utils.ConsistencyChecker;

import javax.swing.*;
import java.awt.*;
import java.util.Collection;

public class OwnedAuctionsMenu extends AbstractMenu {
    public OwnedAuctionsMenu(ClientController client){
        if( !ConsistencyChecker.isUserSet(client) ) return;
        setLayout(new BorderLayout());

        Collection<AuctionInfo> auctions = client.getOwnedAuctions();
        if( auctions==null ) return;
        JPanel auctionsPanel = new JPanel();
        auctionsPanel.setLayout(new BoxLayout(auctionsPanel,BoxLayout.Y_AXIS));

        for( AuctionInfo auction : auctions ){
            auctionsPanel.add(createAuctionView(auction));
            auctionsPanel.add(new JSeparator());
        }

        JScrollPane scrollPane = new JScrollPane(auctionsPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        add(scrollPane,BorderLayout.CENTER);
        revalidate();
    }
}//OwnedAuctionsMenu
