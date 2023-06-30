package auction.view;

import auction.command.CommandHandler;
import auction.command.ThreadedCommandHandler;
import auction.controller.ClientController;
import auction.specificcommand.ChangeViewCommand;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class SystemView extends JFrame
{
    public final static int WIDTH = 1500;
    public final static int HEIGHT = 900;

    public SystemView() throws IOException {
        ClientController client = new ClientController();
        CommandHandler handler = new ThreadedCommandHandler();

        //setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(new BorderLayout());
        setSize(WIDTH,HEIGHT);

        //TODO create menu
        JToolBar toolBar = new JToolBar();

        JButton accountButton = new JButton("Account");
        JButton createArticleButton = new JButton("Crea asta");
        JButton searchArticleButton = new JButton("Cerca articoli");
        JButton registeredAuctionsButton = new JButton("Registrazioni");
        JButton closedAuctionsButton = new JButton("Aste terminate");
        JButton ownedAuctionsButton = new JButton("Aste create");

        accountButton.addActionListener(e -> handler.handle(new ChangeViewCommand(new AccountMenu(client),this)));
        createArticleButton.addActionListener(e -> handler.handle(new ChangeViewCommand(new CreateArticleMenu(client,handler),this)));
        searchArticleButton.addActionListener(e -> handler.handle(new ChangeViewCommand(new SearchArticleMenu(client,handler),this)));
        registeredAuctionsButton.addActionListener(e -> handler.handle(new ChangeViewCommand(new RegistrationMenu(client),this)));
        closedAuctionsButton.addActionListener(e -> handler.handle(new ChangeViewCommand(new ClosedAuctionsMenu(client),this)));
        ownedAuctionsButton.addActionListener(e -> handler.handle(new ChangeViewCommand(new OwnedAuctionsMenu(client),this)));

        toolBar.add(accountButton);
        toolBar.add(createArticleButton);
        toolBar.add(searchArticleButton);
        toolBar.add(registeredAuctionsButton);
        toolBar.add(closedAuctionsButton);
        toolBar.add(ownedAuctionsButton);

        getContentPane().add(toolBar,BorderLayout.NORTH);

        getContentPane().add(new AccountMenu(client), BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Auction site");
        setVisible(true);
    }

    public static void main(String[] args) throws IOException {
        SystemView view = new SystemView();
    }//main
}//SystemView
