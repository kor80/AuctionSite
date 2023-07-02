package auction.view;

import auction.controller.AdminController;
import auction.model.ArticleInfo;
import auction.utils.DateChecker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Collection;

public class AdminView extends JFrame
{
    public final static int WIDTH = 1500;
    public final static int HEIGHT = 900;

    private AdminController admin;

    private boolean isCenterSet;

    public AdminView() throws IOException {
        admin = new AdminController();

        setLayout(new BorderLayout());
        setSize(WIDTH,HEIGHT);
        isCenterSet = false;

        JToolBar toolBar = new JToolBar();
        JButton refreshButton = new JButton("Aggiorna");
        refreshButton.addActionListener(e -> showView());
        toolBar.add(refreshButton);
        add(toolBar,BorderLayout.NORTH);

        if (showView()) return;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Admin page");
        setVisible(true);
    }

    private boolean showView() {
        Collection<ArticleInfo> articles = admin.getArticles();
        if( articles==null ) return true;
        JPanel auctionsPanel = new JPanel();
        auctionsPanel.setLayout(new BoxLayout(auctionsPanel,BoxLayout.Y_AXIS));

        for( ArticleInfo article : articles ){
            auctionsPanel.add(getItemPanel(article));
            auctionsPanel.add(new JSeparator());
        }

        JScrollPane scrollPane = new JScrollPane(auctionsPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        if( isCenterSet )
            getContentPane().remove(1);
        else
            isCenterSet = true;

        getContentPane().add(scrollPane,BorderLayout.CENTER);
        revalidate();
        return false;
    }

    private JPanel getItemPanel( ArticleInfo item ){
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

        JButton removeButton = new JButton("Rimuovi");
        removeButton.addActionListener(new RemoveArticleListener(item.getId()));
        itemPanel.add(removeButton);

        return itemPanel;
    }

    private class RemoveArticleListener implements ActionListener{
        private int id;

        public RemoveArticleListener(int id){ this.id = id; }

        @Override
        public void actionPerformed(ActionEvent e) {
            boolean upshot = admin.deleteArticle(id);
            if( upshot )
                JOptionPane.showMessageDialog(null,"Articolo eliminato","Successo",JOptionPane.PLAIN_MESSAGE);
            else
                JOptionPane.showMessageDialog(null,"Errore durante l'eliminazione dell'articolo","Errore",JOptionPane.ERROR_MESSAGE);
            showView();
        }//actionPerformed
    }//RemoveArticleListener

    public static void main(String[] args) throws IOException{
        AdminView view = new AdminView();
    }//main
}//AdminView
