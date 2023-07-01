package auction.model;

import auction.model.auctions.AuctionInfo;
import auction.model.memory.MemoryManager;
import auction.model.registrations.RegistrationManager;

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
        System.out.println("Closed: "+results.size());
        return results;
    }//getClosedAuctions
}//ClientRequestsHandler
