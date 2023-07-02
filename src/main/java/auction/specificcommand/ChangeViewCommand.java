package auction.specificcommand;

import auction.command.Command;

import javax.swing.*;
import java.awt.*;

/**
 * <h1>Change View Command</h1>
 * This class is a concretization of the command interface.
 * It takes a JPanel and a JFrame, updating the view of the latter one
 * with the JPanel.
 *
 * @author Cosimo Russo
 * @version 1.0
 */
public class ChangeViewCommand implements Command
{
    private JPanel panel;
    private JFrame frame;

    public ChangeViewCommand(JPanel panel, JFrame frame){
        this.panel = panel;
        this.frame = frame;
    }

    @Override
    public boolean doIt() {
        frame.getContentPane().remove(1);
        frame.getContentPane().add(panel,BorderLayout.CENTER);
        frame.revalidate();
        return true;
    }//doIt
}//ChangeViewCommand
