package auction.controller;

import auction.model.ArticleInfo;
import auction.model.auctions.AuctionInfo;
import auction.service.AdminClient;

import java.io.IOException;
import java.util.Collection;

/**
 * <h1>Admin Controller</h1>
 * This class is used for separating the GUI and the
 * code who interacts with the server.
 * Every action that the admin can make is a method of this class.
 *
 * @author Cosimo Russo
 * @version 1.0
 */
public class AdminController
{
    private AdminClient adminClient;

    public AdminController() throws IOException {
        adminClient = new AdminClient("0.0.0.0", 8080);
    }

    /**
     * Deletes the article with id {@param id} from the server.
     * Admin can only delete articles to which the auction is not
     * started yet (and is not closed).
     * The change modifies the database.
     *
     * @param  id  The id of the auction to be deleted.
     * @return true if the article is deleted correctly, false otherwise.
     * @see ArticleInfo
     */
    public boolean deleteArticle(int id){
        boolean upshot = adminClient.deleteArticle(id);
        if( upshot ) System.out.println("Article deleted");
        else System.out.println("Something went wrong while trying to delete the article");
        return upshot;
    }//deleteArticle

    /**
     * Returns all the auctions which are neither active nor closed.
     *
     * @return a collection of ArticleInfo.
     * @see ArticleInfo
     */
    public Collection<ArticleInfo> getArticles(){
        return adminClient.getArticles();
    }//getArticles
}//AdminController
