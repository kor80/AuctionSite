package auction.view;

import auction.model.ArticleInfo;
import auction.model.auctions.AuctionInfo;
import auction.utils.DateChecker;

import javax.swing.*;

public abstract class AbstractMenu extends JPanel
{
    protected JPanel createItemView(ArticleInfo item) {
        JPanel itemPanel = new JPanel();

        JLabel nameLabel = new JLabel("nome: " + item.getName());
        itemPanel.add(nameLabel);
        itemPanel.add(new JSeparator(JSeparator.VERTICAL));


        String sDate = DateChecker.getLocalDateTime(item.getStartingDate(), item.getStartingTime()).toString();
        JLabel sDateLabel = new JLabel("Data inizio: " + sDate);
        itemPanel.add(sDateLabel);
        itemPanel.add(new JSeparator(JSeparator.VERTICAL));

        String eDate = DateChecker.getLocalDateTime(item.getEndingDate(), item.getEndingTime()).toString();
        JLabel eDateLabel = new JLabel("Data fine: " + eDate);
        itemPanel.add(eDateLabel);
        itemPanel.add(new JSeparator(JSeparator.VERTICAL));

        JLabel sPriceLabel = new JLabel("Prezzo iniziale: " + item.getStartingPrice());
        itemPanel.add(sPriceLabel);
        itemPanel.add(new JSeparator(JSeparator.VERTICAL));

        if( item.getBuyNowPrice() != 0){
            JLabel buyNowPriceLabel = new JLabel("Prezzo compra ora: " + item.getBuyNowPrice());
            itemPanel.add(buyNowPriceLabel);
            itemPanel.add(new JSeparator(JSeparator.VERTICAL));
        }

        JLabel typeLabel = new JLabel("Categoria: " + item.getType().name());
        itemPanel.add(typeLabel);

        JTextArea descriptionArea = new JTextArea(10, 10);
        descriptionArea.setText("Descrizione: " + item.getDescription());
        descriptionArea.setEditable(false);
        itemPanel.add(descriptionArea);

        return itemPanel;
    }//createItemView

    protected JPanel createAuctionView(AuctionInfo auction){
        JPanel auctionPanel = new JPanel();

        JLabel nameLabel = new JLabel("Nome: " + auction.getArticleName());
        auctionPanel.add(nameLabel);
        auctionPanel.add(new JSeparator(JSeparator.VERTICAL));

        JLabel finalOfferLabel = new JLabel("Prezzo attuale: " + auction.getCurrentOffer());
        auctionPanel.add(finalOfferLabel);
        auctionPanel.add(new JSeparator(JSeparator.VERTICAL));

        String state = auction.getIsOpened() ? "Aperta" : "Chiusa";
        JLabel statusLabel = new JLabel("Stato: " + state);
        auctionPanel.add(statusLabel);
        auctionPanel.add(new JSeparator(JSeparator.VERTICAL));

        JLabel winnerLabel = new JLabel("Vincitore corrente: " + auction.getCurrentWinner());
        auctionPanel.add(winnerLabel);
        auctionPanel.add(new JSeparator(JSeparator.VERTICAL));

        return auctionPanel;
    }//createAuctionView
}//AbstractMenu
