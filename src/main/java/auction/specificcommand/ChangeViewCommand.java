package auction.specificcommand;

import auction.command.Command;

import javax.swing.*;
import java.awt.*;

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
