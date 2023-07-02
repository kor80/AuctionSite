package auction.model.auctions;

import auction.model.ArticleInfo;
import auction.model.memory.MemoryManager;
import auction.model.registrations.RegistrationManager;

import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

public class AuctionsManager
{
    private static AuctionsManager INSTANCE;

    private ConcurrentHashMap<Integer,Auction> auctions;
    private ConcurrentHashMap<Integer,Auction> activeAuctions;

    private MemoryManager memoryManager;

    private AuctionsManager(){
        memoryManager = MemoryManager.getInstance();
        loadAuctions();
        activeAuctions = new ConcurrentHashMap<>();
    }

    public static synchronized AuctionsManager getInstance(){
        if( INSTANCE == null ){
            INSTANCE = new AuctionsManager();
            (new AuctionStarter(INSTANCE)).start();
        }
        return INSTANCE;
    }//getInstance

    private void loadAuctions(){
        auctions = new ConcurrentHashMap<>();
        for( ArticleInfo info : memoryManager.getArticles()){
            auctions.put(info.getId(),
                    new Auction(info.getStartingPrice(),info.getId(),info.getBuyNowPrice())
            );
        }
    }//loadAuctions

    /**
     * Subscribes the user specified in {@info info} to the auction.
     * If the auction is started or if it is not, the registration will be successful.
     *
     * @param  info username, article_id, user_ip, user_port
     * @see RegistrationInfo
     * @return true if the registration was successful, false otherwise
     */
    public synchronized boolean subscribeUser(RegistrationInfo info){
        int id = info.getArticleId();
        if( auctions.containsKey(id) ){
            auctions.get(id).addListener(info);
            return true;
        }
        if( activeAuctions.containsKey(id) ){
            activeAuctions.get(id).addListener(info);
            return true;
        }
        return false;
    }//subscribeUser

    public synchronized void addAuction(ArticleInfo info){
        int id = info.getId();
        System.out.println("Trying to add "+id);
        if( auctions.containsKey(id) ) return;
        auctions.put(id,
                new Auction(info.getStartingPrice(),id,info.getBuyNowPrice())
        );
        System.out.println("Added auction "+id);
    } //addAuction

    public synchronized void activateAuction(int id){
        if( activeAuctions.containsKey(id) ) return;
        if( !auctions.containsKey(id) ) return;
        ArticleInfo info = memoryManager.getArticle(id);
        if( info == null ) return;
        activeAuctions.put(id,auctions.get(id)); //Aliasing
        auctions.remove(id);
        activeAuctions.get(id).startTimer();
        System.out.println("Auction "+id+" is now active!");
    }//activateAuction

    public synchronized void closeAuction(int id){
        if(!activeAuctions.containsKey(id)) return;
        AuctionInfo closedAuction = AuctionInfo.newBuilder()
                                        .setArticleId(id)
                                        .setCurrentWinner(activeAuctions.get(id).getCurrentWinner())
                                        .setCurrentOffer(activeAuctions.get(id).getCurrentOffer())
                                        .setIsOpened(false)
                                        .build();
        memoryManager.saveClosedAuction(closedAuction);
        activeAuctions.remove(id);
        System.out.println("Auction "+id+" is now closed!");
    }//closeAuction

    public synchronized LinkedList<AuctionInfo> getUserActiveAuctions(String user) {
        LinkedList<AuctionInfo> result = new LinkedList<>();
        for (ArticleInfo articleInfo : RegistrationManager.getInstance().getRegisteredAuctions(user)){
            if (activeAuctions.containsKey(articleInfo.getId())) {
                Auction auction = activeAuctions.get(articleInfo.getId());
                result.add(AuctionInfo.newBuilder().setArticleId(auction.id)
                        .setCurrentWinner(auction.currentWinner)
                        .setCurrentOffer(auction.currentOffer)
                        .setArticleName(articleInfo.getName())
                        .setIsOpened(auction.isOpened)
                        .setRemainingTime(auction.timeOut)
                        .build()
                );
            }
        }
        return result;
    }//getUserActiveAuctions

    public synchronized boolean makeOffer(int auctionId, double amount, String user){
        if( !activeAuctions.containsKey(auctionId) ) return false;
        if( !RegistrationManager.getInstance().isRegistered(user,auctionId) ) return false;
        return activeAuctions.get(auctionId).makeOffer(amount,user);
    }//makeOffer

    public synchronized boolean buyNow(int auctionId, String user){
        if( !activeAuctions.containsKey(auctionId) ) return false;
        if( !RegistrationManager.getInstance().isRegistered(user,auctionId) ) return false;
        return activeAuctions.get(auctionId).buyNow(user);
    }//buyNow

    public LinkedList<Integer> getNotStartedAuctionsIds(){
        LinkedList<Integer> result = new LinkedList<>();
        for( int id : auctions.keySet() )  result.add(id);
        return result;
    }//getNotStartedAuctionsIds

    public boolean removeAuction(int id){
        Auction value = auctions.remove(id);
        return value != null;
    }//removeAuction
}//AuctionsManager
