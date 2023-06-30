package auction.view;

import auction.controller.ClientController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class AccountMenu extends JPanel
{
    private final int ROWS = 3;
    private final int COLUMNS = 1;

    private ClientController client;

    private JTextField nameField;

    public AccountMenu(ClientController client){
        this.client = client;

        GridLayout gridLayout = new GridLayout(ROWS,COLUMNS);
        gridLayout.setHgap(10);
        setLayout(gridLayout);

        JPanel namePanel = new JPanel();
        JLabel nameLabel = new JLabel("Username:");
        JButton submitUserBtn = new JButton("Conferma");
        nameField = new JTextField(20);

        if( client.getUsername() != null ){
            nameField.setText(client.getUsername());
            nameField.setEnabled(false);
            submitUserBtn.setEnabled(false);
        }

        submitUserBtn.addActionListener(new SubmitUsernameListener());
        namePanel.add(nameLabel);
        namePanel.add(nameField);
        namePanel.add(submitUserBtn);
        add(namePanel);
    }

    private class SubmitUsernameListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                client.setUsername(nameField.getText());
                JOptionPane.showMessageDialog(null,"Username inserito correttamente","Successo",JOptionPane.PLAIN_MESSAGE);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }//actionPerformed
    }//SubmitUsernameListener
}//AccountMenu
