package auction.view;

import auction.controller.ClientController;
import auction.model.ArticleInfo;
import auction.utils.ConsistencyChecker;

import javax.swing.*;
import java.awt.*;
import java.util.Collection;

public class RegistrationMenu extends AbstractMenu
{

    public RegistrationMenu(ClientController client){
        if( !ConsistencyChecker.isUserSet(client) ) return;
        setLayout(new BorderLayout());

        Collection<ArticleInfo> items = client.getRegisteredAuctions();
        if( items==null ) return;
        JPanel itemsPanel = new JPanel();
        itemsPanel.setLayout(new BoxLayout(itemsPanel,BoxLayout.Y_AXIS));

        for( ArticleInfo item : items ){
            itemsPanel.add(createItemView(item));
            itemsPanel.add(new JSeparator());
        }

        JScrollPane scrollPane = new JScrollPane(itemsPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        add(scrollPane,BorderLayout.CENTER);
        revalidate();
    }
}//RegistrationMenu
