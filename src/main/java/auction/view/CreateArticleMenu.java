package auction.view;

import auction.command.CommandHandler;
import auction.model.ArticleInfo;
import auction.model.ArticleType;
import auction.model.Date;
import auction.model.Time;
import auction.controller.ClientController;
import auction.specificcommand.SaveArticleCommand;
import auction.utils.ConsistencyChecker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateArticleMenu extends JPanel
{
    private final int ROWS = 10;
    private final int COLUMNS = 1;

    private ClientController client;
    private CommandHandler handler;

    private JTextField nameField;
    private JSpinner startingYearSpinner;
    private JSpinner startingMonthSpinner;
    private JSpinner startingDaySpinner;
    private JSpinner startingHourSpinner;
    private JSpinner startingMinuteSpinner;
    private JSpinner endingYearSpinner;
    private JSpinner endingMonthSpinner;
    private JSpinner endingDaySpinner;
    private JSpinner endingHourSpinner;
    private JSpinner endingMinuteSpinner;
    private JTextField startingPriceField;
    private JTextField buyNowPriceField;
    private JComboBox<ArticleType> typeCombo;
    private JTextArea desctiptionField;


    public CreateArticleMenu(ClientController client, CommandHandler handler){
        this.client = client;
        this.handler = handler;

        GridLayout gridLayout = new GridLayout(ROWS,COLUMNS);
        gridLayout.setHgap(10);
        setLayout(gridLayout);

        JPanel namePanel = new JPanel();
        JLabel nameLabel = new JLabel("Nome:");
        nameField = new JTextField(20);
        namePanel.add(nameLabel);
        namePanel.add(nameField);
        add(namePanel);

        //-------------------------------STARTING DATE-------------------------------
        JPanel startingDatePanel = new JPanel();
        JLabel startingDateLabel = new JLabel("Data inizio");
        startingYearSpinner =
                new JSpinner(new SpinnerNumberModel(1970,1970,2030,1));
        startingMonthSpinner =
                new JSpinner(new SpinnerNumberModel(1,1,12,1));
        startingDaySpinner =
                new JSpinner(new SpinnerNumberModel(1,1,31,1));
        startingDatePanel.add(startingDateLabel);
        startingDatePanel.add(startingYearSpinner);
        startingDatePanel.add(startingMonthSpinner);
        startingDatePanel.add(startingDaySpinner);
        add(startingDatePanel);

        //-------------------------------STARTING TIME-------------------------------
        JPanel startingTimePanel = new JPanel();
        JLabel startingTimeLabel = new JLabel("Ora inizio");
        startingHourSpinner =
                new JSpinner(new SpinnerNumberModel(0,0,23,1));
        startingMinuteSpinner =
                new JSpinner(new SpinnerNumberModel(0,0,59,1));

        startingTimePanel.add(startingTimeLabel);
        startingTimePanel.add(startingHourSpinner);
        startingTimePanel.add(startingMinuteSpinner);
        add(startingTimePanel);

        //-------------------------------ENDING DATE-------------------------------
        JPanel endingDatePanel = new JPanel();
        JLabel endingDateLabel = new JLabel("Data fine");
        endingYearSpinner =
                new JSpinner(new SpinnerNumberModel(1970,1970,2030,1));
        endingMonthSpinner =
                new JSpinner(new SpinnerNumberModel(1,1,12,1));
        endingDaySpinner =
                new JSpinner(new SpinnerNumberModel(1,1,31,1));
        endingDatePanel.add(endingDateLabel);
        endingDatePanel.add(endingYearSpinner);
        endingDatePanel.add(endingMonthSpinner);
        endingDatePanel.add(endingDaySpinner);
        add(endingDatePanel);

        //-------------------------------ENDING TIME-------------------------------
        JPanel endingTimePanel = new JPanel();
        JLabel endingTimeLabel = new JLabel("Ora fine");
        endingHourSpinner =
                new JSpinner(new SpinnerNumberModel(0,0,23,1));
        endingMinuteSpinner =
                new JSpinner(new SpinnerNumberModel(0,0,59,1));

        endingTimePanel.add(endingTimeLabel);
        endingTimePanel.add(endingHourSpinner);
        endingTimePanel.add(endingMinuteSpinner);
        add(endingTimePanel);

        //-------------------------------STARTING PRICE-------------------------------
        JPanel startingPricePanel = new JPanel();
        JLabel startingPriceLabel = new JLabel("Prezzo iniziale");
        startingPriceField = new JTextField(7);

        startingPricePanel.add(startingPriceLabel);
        startingPricePanel.add(startingPriceField);
        add(startingPricePanel);

        //-------------------------------BUY NOW PRICE-------------------------------
        JPanel buyNowPricePanel = new JPanel();
        JLabel buyNowPriceLabel = new JLabel("Prezzo compra ora");
        buyNowPriceField = new JTextField(7);

        buyNowPricePanel.add(buyNowPriceLabel);
        buyNowPricePanel.add(buyNowPriceField);
        add(buyNowPricePanel);

        //-------------------------------ARTICLE TYPE-------------------------------
        JPanel typePanel = new JPanel();
        JLabel typeLabel = new JLabel("Categoria");
        typeCombo = new JComboBox<>(ArticleType.values());

        typePanel.add(typeLabel);
        typePanel.add(typeCombo);
        add(typePanel);

        //-------------------------------DESCRIPTION-------------------------------
        JPanel desctiptionPanel = new JPanel();
        JLabel desctiptionLabel = new JLabel("Descrizione");
        desctiptionField = new JTextArea(7,20);
        desctiptionField.setLineWrap(true);

        desctiptionPanel.add(desctiptionLabel);
        desctiptionPanel.add(desctiptionField);
        add(desctiptionPanel);

        //-------------------------------LOAD ARTICLE-------------------------------
        JButton saveArticleButton = new JButton("Carica articolo");
        saveArticleButton.addActionListener(new SaveArticleListener());
        add(saveArticleButton);
    }//CreateArticleMenu

    private ArticleInfo buildArticle(){
        /*
        if( !startingYearSpinner.getValue().toString().matches("[0-9]+")) return null;
        if( !startingMonthSpinner.getValue().toString().matches("[0-9]+")) return null;
        if( !startingDaySpinner.getValue().toString().matches("[0-9]+")) return null;
        if( !startingHourSpinner.getValue().toString().matches("[0-9]+")) return null;
        if( !startingMinuteSpinner.getValue().toString().matches("[0-9]+")) return null;

        if( !endingYearSpinner.getValue().toString().matches("[0-9]+")) return null;
        if( !endingMonthSpinner.getValue().toString().matches("[0-9]+")) return null;
        if( !endingDaySpinner.getValue().toString().matches("[0-9]+")) return null;
        if( !endingHourSpinner.getValue().toString().matches("[0-9]+")) return null;
        if( !endingMinuteSpinner.getValue().toString().matches("[0-9]+")) return null;
         */

        if( !startingPriceField.getText().matches("[0-9]+")) return null;

        int buyNowPrice = 0;
        if( !buyNowPriceField.getText().equals("") ){
            if( !buyNowPriceField.getText().matches("[0-9]+") ) return null;
            else
                buyNowPrice = Integer.parseInt(buyNowPriceField.getText());
        }

        return ArticleInfo.newBuilder()
                .setName(nameField.getText())
                .setStartingDate(Date.newBuilder()
                        .setYear(Integer.parseInt(startingYearSpinner.getValue().toString()))
                        .setMonth(Integer.parseInt(startingMonthSpinner.getValue().toString()))
                        .setDay(Integer.parseInt(startingDaySpinner.getValue().toString()))
                        .build())
                .setEndingDate(Date.newBuilder()
                        .setYear(Integer.parseInt(endingYearSpinner.getValue().toString()))
                        .setMonth(Integer.parseInt(endingMonthSpinner.getValue().toString()))
                        .setDay(Integer.parseInt(endingDaySpinner.getValue().toString()))
                        .build())
                .setStartingTime(Time.newBuilder()
                        .setHour(Integer.parseInt(startingHourSpinner.getValue().toString()))
                        .setMinutes(Integer.parseInt(startingMinuteSpinner.getValue().toString()))
                        .build())
                .setEndingTime(Time.newBuilder()
                        .setHour(Integer.parseInt(endingHourSpinner.getValue().toString()))
                        .setMinutes(Integer.parseInt(endingMinuteSpinner.getValue().toString()))
                        .build())
                .setStartingPrice(Integer.parseInt(startingPriceField.getText()))
                .setBuyNowPrice(buyNowPrice)
                .setType((ArticleType) typeCombo.getSelectedItem())
                .setDescription(desctiptionField.getText())
                .build();
    }//buildArticle

    private class SaveArticleListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if( !ConsistencyChecker.isUserSet(client) ) return;
            boolean upshot = false;
            ArticleInfo info = buildArticle();
            if( info != null )
                upshot = handler.handle(new SaveArticleCommand(client,buildArticle()));
            if( upshot ) JOptionPane.showMessageDialog(null,"L'articolo è stato caricato","Successo",JOptionPane.PLAIN_MESSAGE);
            else JOptionPane.showMessageDialog(null,
                    "L'Errore durante il caricamento dell'articolo. Controlla che tutti i campi siano consistenti e riprova.","Errore",JOptionPane.ERROR_MESSAGE);
        }//actionPerformed
    }//SaveArticleListener
}//CreateArticleMenu
