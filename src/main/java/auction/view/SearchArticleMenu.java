package auction.view;

import auction.command.CommandHandler;
import auction.controller.ClientController;
import auction.model.ArticleInfo;
import auction.model.ArticleType;
import auction.search.SearchInfo;
import auction.utils.ConsistencyChecker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

public class SearchArticleMenu extends AbstractMenu
{

    private ClientController client;
    private CommandHandler handler;

    private JTextField nameField;
    private JTextField minPriceField;
    private JTextField maxPriceField;
    private JComboBox<ArticleType> typeCombo;

    public SearchArticleMenu(ClientController client, CommandHandler handler){
        this.client = client;
        this.handler = handler;

        setLayout(new BorderLayout());

        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new GridLayout(1,5));
        //-------------------------------NAME-------------------------------
        JPanel namePanel = new JPanel();
        JLabel nameLabel = new JLabel("Nome:");
        nameField = new JTextField(10);
        namePanel.add(nameLabel);
        namePanel.add(nameField);
        searchPanel.add(namePanel);

        //-------------------------------MIN PRICE-------------------------------
        JPanel minPricePanel = new JPanel();
        JLabel minPriceLabel = new JLabel("Prezzo minimo");
        minPriceField = new JTextField(7);
        minPricePanel.add(minPriceLabel);
        minPricePanel.add(minPriceField);
        searchPanel.add(minPricePanel);

        //-------------------------------MAX PRICE-------------------------------
        JPanel maxPricePanel = new JPanel();
        JLabel maxPriceLabel = new JLabel("Prezzo massimo");
        maxPriceField = new JTextField(7);
        maxPricePanel.add(maxPriceLabel);
        maxPricePanel.add(maxPriceField);
        searchPanel.add(maxPricePanel);

        //-------------------------------ARTICLE TYPE-------------------------------
        JPanel typePanel = new JPanel();
        JLabel typeLabel = new JLabel("Categoria");
        typeCombo = new JComboBox<>(ArticleType.values());
        typePanel.add(typeLabel);
        typePanel.add(typeCombo);
        searchPanel.add(typePanel);

        JButton searchButton = new JButton("cerca");
        searchButton.addActionListener(new SearchButtonListener());
        searchPanel.add(searchButton);

        add(searchPanel,BorderLayout.NORTH);
    }

    private SearchInfo buildSearchInfo(){
        double minPrice = 0;
        double maxPrice = 0;

        if( minPriceField.getText().length() > 0){
            if( !minPriceField.getText().matches("[0-9]+")) return null;
            minPrice = Double.parseDouble(minPriceField.getText());
        }
        if( maxPriceField.getText().length() > 0 ){
            if( !maxPriceField.getText().matches("[0-9]+")) return null;
            maxPrice = Double.parseDouble(maxPriceField.getText());
        }

        return SearchInfo.newBuilder()
                .setName(nameField.getText())
                .setMinPrice(minPrice)
                .setMaxPrice(maxPrice)
                .setType((ArticleType) typeCombo.getSelectedItem())
                .build();
    }//buildSearchInfo

    private void displayItems(Collection<ArticleInfo> items){
        if( items==null ) return;
        JPanel itemsPanel = new JPanel();
        itemsPanel.setLayout(new BoxLayout(itemsPanel,BoxLayout.Y_AXIS));

        for( ArticleInfo item : items ){
            itemsPanel.add(createItemView(item));
            itemsPanel.add(new JSeparator());
        }

        JScrollPane scrollPane = new JScrollPane(itemsPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        if( ((BorderLayout) getLayout()).getLayoutComponent(BorderLayout.CENTER) != null )
            remove(1);
        add(scrollPane,BorderLayout.CENTER);
        revalidate();
    }//displayItems

    protected JPanel createItemView(ArticleInfo item){
        JPanel itemPanel = super.createItemView(item);
        JButton registrationButton = new JButton("Registrati");
        registrationButton.addActionListener(new RegistrationButtonListener(item.getId()));
        registrationButton.setBackground(Color.GREEN);
        itemPanel.add(registrationButton);

        return itemPanel;
    }//createItemView

    private class RegistrationButtonListener implements ActionListener{
        private int id;

        public RegistrationButtonListener(int id){
            this.id = id;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            boolean upshot = client.registerToTheAuction(id);
            if( upshot ) JOptionPane.showMessageDialog(null,"Registrazione avvenuta con successo.","Successo",JOptionPane.PLAIN_MESSAGE);
            else JOptionPane.showMessageDialog(null,
                    "Sei già registrato a questa asta.","Errore",JOptionPane.ERROR_MESSAGE);
        }//actionPerformed
    }//RegistrationButtonListener

    private class SearchButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            if( !ConsistencyChecker.isUserSet(client) ) return;
            SearchInfo searchInfo = buildSearchInfo();
            if( searchInfo==null ){
                JOptionPane.showMessageDialog(null,
                        "Parametri di ricerca inconsistenti.", "Errore", JOptionPane.ERROR_MESSAGE);
                return;
            }
            displayItems(client.searchArticles(searchInfo));
        }//actionPerformed
    }//SearchButtonListener
}//SearchArticleMenu
