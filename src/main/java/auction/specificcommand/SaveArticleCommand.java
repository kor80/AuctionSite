package auction.specificcommand;

import auction.command.Command;
import auction.model.ArticleInfo;
import auction.controller.ClientController;

/**
 * <h1>Save Article Command</h1>
 * This class is a concretization of the command interface.
 * It takes an ArticleInfo and updates it on the server.
 *
 * @author Cosimo Russo
 * @version 1.0
 */
public class SaveArticleCommand implements Command
{
    private ClientController client;
    private ArticleInfo article;

    public SaveArticleCommand(ClientController client, ArticleInfo article){
        this.client = client;
        this.article = article;
    }

    @Override
    public boolean doIt() {
        return client.createArticle(article);
    }//doIt
}//SaveArticleCommand
