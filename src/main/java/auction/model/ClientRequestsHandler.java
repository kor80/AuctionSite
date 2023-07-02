package auction.model;

import auction.model.auctions.AuctionInfo;
import auction.model.memory.MemoryManager;
import auction.model.registrations.RegistrationManager;

import java.util.LinkedList;

/**
 * <h1>Client Request Handler</h1>
 * This is a singleton class used to answer to the specific user
 * request, such as the articles he loaded or the closed auctions
 * to which he partecipated to.
 *
 * @author Cosimo Russo
 * @version 1.0
 */
public class ClientRequestsHandler
{
    private static ClientRequestsHandler INSTANCE;

    private MemoryManager memoryManager;
    private RegistrationManager registrationManager;

    private ClientRequestsHandler(){
        memoryManager = MemoryManager.getInstance();
        registrationManager = RegistrationManager.getInstance();
    }

    public static synchronized ClientRequestsHandler getInstance(){
        if( INSTANCE == null ) INSTANCE = new ClientRequestsHandler();
        return INSTANCE;
    }//getInstance

    /**
     * Returns the info of the auctions loaded by the user {@param user},
     * specifying the status, the current winner and the current offer.
     *
     * @param  user  The user who is asking for his auctions.
     * @return A LinkedList containing the AuctionInfo of the articles loaded bu
     * the user
     * @see AuctionInfo
     */
    public LinkedList<AuctionInfo> getOwnedAuctions(String user){
        System.out.println("Returning "+user+"'s items..");
        LinkedList<AuctionInfo> results = new LinkedList<>();
        System.out.println(memoryManager.getArticles(user).size());
        for( ArticleInfo info : memoryManager.getArticles(user) ){
            if( memoryManager.isAuctionClosed(info.getId()) ) {
                results.add(memoryManager.getClosedAuctionInfo(info.getId()));
            } else{
                results.add( AuctionInfo.newBuilder()
                        .setArticleId(info.getId())
                        .setArticleName(info.getName())
                        .setCurrentWinner("")
                        .setCurrentOffer(info.getStartingPrice())
                        .setIsOpened(true)
                        .build()
                );
            }
        }
        System.out.println("Owned: "+results.size());
        return results;
    }//getOwnedAuctions

    /**
     * Returns the info of the closed auctions in which the user {@param user}
     * partecipated, specifying the winner and the final offer.
     *
     * @param  user  The user who is asking for his closed auctions.
     * @return A LinkedList containing the AuctionInfo of the closed auction
     * in wich user partecipated.
     * @see AuctionInfo
     */
    public LinkedList<AuctionInfo> getClosedAuctions(String user){
        LinkedList<AuctionInfo> results = new LinkedList<>();
        for( ArticleInfo articleInfo : registrationManager.getRegisteredAuctions(user) ){
            int id = articleInfo.getId();
            if( !memoryManager.isAuctionClosed(id) ) continue;
            AuctionInfo closedAuction = memoryManager.getClosedAuctionInfo(id);
            results.add(AuctionInfo.newBuilder()
                    .setArticleId(id)
                    .setArticleName(articleInfo.getName())
                    .setCurrentOffer(closedAuction.getCurrentOffer())
                    .setCurrentWinner(closedAuction.getCurrentWinner())
                    .build()
            );
        }
        return results;
    }//getClosedAuctions
}//ClientRequestsHandler
