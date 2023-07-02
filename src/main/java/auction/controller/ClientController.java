package auction.controller;

import auction.model.ArticleInfo;
import auction.model.auctions.AuctionInfo;
import auction.search.SearchInfo;
import auction.service.ArticleClient;
import auction.utils.ConsistencyChecker;

import java.io.IOException;
import java.util.Collection;
import java.util.Random;

/**
 * <h1>Client Controller</h1>
 * This class is used for separating the GUI and the
 * code who interacts with the server.
 * Every action that the user can make is a method of this class.
 *
 * @author Cosimo Russo
 * @version 1.0
 */
public class ClientController extends AbstractController
{
    private ArticleClient articleClient;
    private final String ip;
    private String username = null;

    public ClientController() throws IOException {
        ip = "0.0.0.0";
    }

    /**
     * Saves the article {@param article} in the server.
     * The change modifies the database.
     *
     * @param  info  The info of the article to be loaded.
     * @return true if the article is saved correctly,
     * false if the article is not consistent.
     * @see ArticleInfo
     */
    public boolean createArticle(ArticleInfo info){
        if( !ConsistencyChecker.isArticleInfoConsistent(info) ) return false;
        boolean upshot = articleClient.createArticle(info);
        if( upshot ) System.out.println("Article loaded");
        else System.out.println("Something went wrong while trying to load the article");
        return upshot;
    }//createArticle

    /**
     * Searches the articles with auction not started which satisfies
     * the {@param searchInfo} constraints.
     *
     * @param  searchInfo  The constraints which the articles has to satisfy.
     * @return a collection of ArticleInfo that match the search parameters.
     * @see ArticleInfo
     * @see SearchInfo
     */
    public Collection<ArticleInfo> searchArticles(SearchInfo searchInfo){
        return articleClient.searchArticle(searchInfo);
    }//searchArticles

    /**
     * Searches the auctions owned by the current user.
     * We define an auction "owned" when the article was saved
     * in the server by the current user.
     *
     * @return a collection of AuctionInfo, the owned auctions.
     * @see AuctionInfo
     */
    public Collection<AuctionInfo> getOwnedAuctions(){
        return articleClient.getOwnedAuctions();
    }//getOwnedAuctions

    /**
     * Returns the auctions to which the user had
     * previously registered and now are active.
     *
     * @return a collection of AuctionInfo, the active auctions.
     * @see AuctionInfo
     */
    public Collection<AuctionInfo> getUserActiveAuctions(){
        return articleClient.getUserActiveAuctions();
    }//getUserActiveAuctions

    /**
     * Returns the articles to which the user had
     * previously registered, active or not active.
     *
     * @return a collection of ArticleInfo, the registered auctions.
     * @see ArticleInfo
     */
    public Collection<ArticleInfo> getRegisteredAuctions(){
        return articleClient.getRegisteredAuctions();
    }//getRegisteredAuctions

    /**
     * Send a registration request to the server for the auction
     * with id {@param id}.
     *
     * @return true if registration was accepted, false otherwise.
     */
    public boolean registerToTheAuction( int auctionId ){
        boolean upshot = articleClient.registerToTheAuction(auctionId);
        if( upshot ) System.out.println("Registration successful");
        else System.out.println("Something went wrong with registration..");
        return upshot;
    }//registerToTheAuction

    /**
     * Used to the server to send active auctions updates.
     * When called it notifies all its listeners with the updated info.
     *
     * @param info the updated info.
     * @see AuctionInfo
     */
    public void updateOffer(AuctionInfo info){
        notifyListeners(info);
    }//updateOffer

    /**
     * Send an offer request for the auction {@param auctionId}
     * of amount {@param amount} to the server.
     * The user has to be registered to the auction at first.
     *
     * @param auctionId the id of the auction to which the offer has to be sent.
     * @param amount the amount to offer.
     * @return true if the offer was accepted, false otherwise.
     */
    public boolean makeOffer(int auctionId, double amount){
        boolean upshot = articleClient.makeOffer(auctionId,amount);
        if( upshot ) System.out.println("The offer was accepted");
        else System.out.println("The offer was refused");
        return upshot;
    }//makeOffer

    /**
     * Returns all the closed auction to which the user has partecipated.
     * Also if the user didn't send any offer but was registered, the auction was
     * returned.
     *
     * @return Collection of AuctionInfo of closed auctions.
     * @see AuctionInfo
     */
    public Collection<AuctionInfo> getClosedAuctions(){
        return articleClient.getClosedAuctions();
    }//getClosedAuctions

    /**
     * Send an buy now request for the auction {@param auctionId}
     * to the server.
     * The user has to be registered to the auction at first.
     * The auction should allow buy now action.
     *
     * @param auctionId the id of the auction to buy instantly.
     * @return true if the buy now was accepted, false otherwise.
     */
    public boolean buyNow(int auctionId){
        boolean upshot = articleClient.buyNow(auctionId);
        if( upshot ) System.out.println("Article "+auctionId+" bought");
        else System.out.println("Unable to buy now article  "+auctionId);
        return upshot;
    }//buyNow

    /**
     * Set username with value {@param username} and starts the client server.
     * If the username is not set, the client cannot interact with the system.
     *
     * @param username the username of the user.
     */
    public void setUsername(String username) throws IOException {
        this.username = username;
        Random rand = new Random();
        int clientPort = rand.nextInt(65536);
        articleClient = new ArticleClient("0.0.0.0", 8080,username,clientPort, ip,this);
    }//setUsername

    public String getUsername(){
        return username;
    }//getUsername
}//ClientController
