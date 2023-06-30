package auction.managment;

import auction.managment.auctions.AuctionInfo;
import auction.managment.memory.MemoryManager;
import auction.managment.registrations.RegistrationManager;
import auction.utils.DateChecker;

import java.util.LinkedList;

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

    public LinkedList<AuctionInfo> getOwnedAuctions(String user){
        System.out.println("Returning "+user+"'s items..");
        LinkedList<AuctionInfo> results = new LinkedList<>();
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
        return results;
    }//getOwnedAuctions

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
