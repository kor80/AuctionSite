package auction.specificcommand;

import auction.command.Command;
import auction.model.ArticleInfo;
import auction.controller.ClientController;

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
