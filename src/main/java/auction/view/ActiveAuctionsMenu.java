package auction.view;

import auction.command.CommandHandler;
import auction.controller.ClientController;
import auction.model.ArticleInfo;
import auction.model.auctions.AuctionInfo;
import auction.specificcommand.GraphicChangeCommand;
import auction.specificcommand.StartTimerCommand;
import auction.utils.ConsistencyChecker;
import auction.utils.DateChecker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

public class ActiveAuctionsMenu extends AbstractMenu
{
    private  ClientController client;
    private CommandHandler handler;
    private JFrame frame;

    private Collection<ArticleInfo> articles;

    public ActiveAuctionsMenu(ClientController client, CommandHandler handler, JFrame frame){
        if( !ConsistencyChecker.isUserSet(client) ) return;

        this.client = client;
        this.handler = handler;
        this.frame = frame;

        Collection<AuctionInfo> auctions = client.getUserActiveAuctions();
        articles = client.getRegisteredAuctions();

        if( auctions==null ) return;
        JPanel auctionsPanel = new JPanel();
        auctionsPanel.setLayout(new BoxLayout(auctionsPanel,BoxLayout.Y_AXIS));

        for( AuctionInfo auction : auctions ){
            ArticleInfo article = getArticle(auction.getArticleId());
            auctionsPanel.add(createAuctionView(auction,article));
            auctionsPanel.add(Box.createVerticalStrut(30));
            auctionsPanel.add(new JSeparator());
        }

        JScrollPane scrollPane = new JScrollPane(auctionsPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        add(scrollPane, BorderLayout.CENTER);
        revalidate();
    }

    private ArticleInfo getArticle(int id){
        for( ArticleInfo article : articles )
            if( article.getId() == id )
                return article;
        return null;
    }//getArticle


    private JPanel createAuctionView(AuctionInfo auctionInfo,ArticleInfo article){
        JPanel view = new JPanel();
        //view.setLayout(new BoxLayout(view,BoxLayout.X_AXIS));
        //int horizStrut = 20;

        JLabel nameLabel = new JLabel("Nome: " + auctionInfo.getArticleName());
        view.add(nameLabel);
        //view.add(Box.createHorizontalStrut(horizStrut));

        JLabel offerTextLabel = new JLabel("Prezzo attuale: ");
        view.add(offerTextLabel);
        JLabel finalOfferLabel = new JLabel(String.valueOf(auctionInfo.getCurrentOffer()));
        view.add(finalOfferLabel);
        //view.add(Box.createHorizontalStrut(horizStrut));

        JLabel stateTextLabel = new JLabel("Stato: ");
        view.add(stateTextLabel);
        String state = auctionInfo.getIsOpened() ? "Aperta" : "Chiusa";
        JLabel statusLabel = new JLabel(state);
        view.add(statusLabel);
        //view.add(Box.createHorizontalStrut(horizStrut));

        JLabel winnerTextLabel = new JLabel("Vincitore corrente: ");
        view.add(winnerTextLabel);
        JLabel winnerLabel = new JLabel(auctionInfo.getCurrentWinner());
        view.add(winnerLabel);
        //view.add(Box.createHorizontalStrut(horizStrut));

        handler.handle(new GraphicChangeCommand(client,finalOfferLabel,statusLabel,winnerLabel));

        int id = auctionInfo.getArticleId();

        JLabel remainingTimeTextLabel = new JLabel("Remaining time");
        view.add(remainingTimeTextLabel);
        JLabel remainingTimeLabel = new JLabel();
        long remainingTime = DateChecker.getRemainingTimeInSeconds(article);
        handler.handle(new StartTimerCommand(client,handler,frame,remainingTimeLabel,remainingTime));
        view.add(remainingTimeLabel);
        //view.add(Box.createHorizontalStrut(horizStrut));


        double buyNowPrice = article.getBuyNowPrice();
        if( buyNowPrice != 0 ){
            JLabel buyNowLabel = new JLabel("compra ora: "+buyNowPrice);
            view.add(buyNowLabel);

            JButton buyNowButton = new JButton("compra ora");
            buyNowButton.addActionListener(new BuyNowListener(id));
            view.add(buyNowButton);
            //view.add(Box.createHorizontalStrut(horizStrut));
        }

        JLabel offerLabel = new JLabel("Offerta: ");
        view.add(offerLabel);
        JTextField offerField = new JTextField(10);
        view.add(offerField);
        JButton makeOfferButton = new JButton("offri");
        makeOfferButton.addActionListener(new MakeOfferListener(id,offerField));
        view.add(makeOfferButton);

        return view;
    }//createAuctionView

    private class BuyNowListener implements ActionListener{
        private int id;

        public BuyNowListener(int id ){ this.id = id; }

        @Override
        public void actionPerformed(ActionEvent e) {
            boolean upshot = client.buyNow(id);
            if( upshot ) JOptionPane.showMessageDialog(null,
                    "Compra ora effettuato.","Successo",JOptionPane.PLAIN_MESSAGE);
            else JOptionPane.showMessageDialog(null,
                    "Compra ora non andato a buon fine.","Errore",JOptionPane.ERROR_MESSAGE);
        }//actionPerformed
    }//BuyNowListener

    private class MakeOfferListener implements ActionListener{
        private int id;
        private JTextField offerField;

        public MakeOfferListener(int id, JTextField offerField ){ this.id = id; this.offerField = offerField; }

        @Override
        public void actionPerformed(ActionEvent e) {
            if( !offerField.getText().matches("[0-9]+")){
                JOptionPane.showMessageDialog(null,
                        "Inserisci un'offerta valida e riprova.","Errore",JOptionPane.ERROR_MESSAGE);
                return;
            }
            boolean upshot = client.makeOffer(id,Integer.parseInt(offerField.getText()));
            if( upshot ) JOptionPane.showMessageDialog(null,
                    "Offerta accettata.","Successo",JOptionPane.PLAIN_MESSAGE);
            else JOptionPane.showMessageDialog(null,
                    "Offerta rifiutata.","Errore",JOptionPane.ERROR_MESSAGE);
        }//actionPerformed
    }//BuyNowListener
}//ActiveAuctionsMenu
