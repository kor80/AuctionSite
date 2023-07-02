package auction.model.auctions;

import auction.model.ArticleInfo;
import auction.model.memory.MemoryManager;
import auction.model.registrations.RegistrationManager;

import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <h1>Auctions Manager</h1>
 * This is a singleton class used to interact with the auctions.
 * Only the server can see this class and it interacts with others
 * singleton classes like registration manager and memory manager.
 *
 * @author Cosimo Russo
 * @version 1.0
 * @see RegistrationManager
 * @see MemoryManager
 */
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

    /**
     * Is used by the Auction manager to load the auctions
     * which are not stared yet in the main memory.
     */
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
     * If the auction is not ended the registration will be successful.
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

    /**
     * Adds an auction which is not ended in main memory.
     * Then the auction is ready to be started.
     *
     * @param  info username, article_id, user_ip, user_port
     * @see ArticleInfo
     */
    public synchronized void addAuction(ArticleInfo info){
        int id = info.getId();
        if( auctions.containsKey(id) ) return;
        auctions.put(id,
                new Auction(info.getStartingPrice(),id,info.getBuyNowPrice())
        );
    } //addAuction

    /**
     * Activate the auction with id {@param id}, but only if
     * the auction with that id exists.
     *
     * @param  id the id of the auction to activate
     */
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

    /**
     * Closes the auction with id {@param id}, but only if
     * the auction with that id was previously activated.
     * After the execution of this method the Auctions manager
     * loses every pointer to that auction.
     *
     * @param  id the id of the auction to close.
     */
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
    }//closeAuction

    /**
     * Returns all the active auctions of the user {@param user}.
     * The user has to register to the auction at first.
     *
     * @param  user the user that has requested the active auctions.
     * @return a LinkedList with the AuctionInfo of the active auctions.
     * @see AuctionInfo
     */
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

    /**
     * Make an offer to the auction with {@param auctionId} from the user {@param user}
     * which is in main memory.
     * If the auction is not active the auction manager ignores the request.
     *
     * @param  auctionId the id of the auction to which make the offer.
     * @param  amount the amount of the offer.
     * @param  user the user who make the offer.
     * @return true if the offer is accepted, false otherwise
     */
    public synchronized boolean makeOffer(int auctionId, double amount, String user){
        if( !activeAuctions.containsKey(auctionId) ) return false;
        if( !RegistrationManager.getInstance().isRegistered(user,auctionId) ) return false;
        return activeAuctions.get(auctionId).makeOffer(amount,user);
    }//makeOffer

    /**
     * Make buy now request to the auction with {@param auctionId} from the user {@param user}
     * which is in main memory.
     * If the auction is not active the auction manager ignores the request.
     *
     * @param  auctionId the id of the auction to buy now.
     * @param  user the user who advanced the buy now request.
     * @return true if the request is accepted, false otherwise
     */
    public synchronized boolean buyNow(int auctionId, String user){
        if( !activeAuctions.containsKey(auctionId) ) return false;
        if( !RegistrationManager.getInstance().isRegistered(user,auctionId) ) return false;
        return activeAuctions.get(auctionId).buyNow(user);
    }//buyNow

    /**
     * Returns all the auction ids of the auctions
     * which are not started yet, but are ready to start when
     * their time comes.
     *
     * @return a LinkedList with the ids of the auctions not started.
     */
    public LinkedList<Integer> getNotStartedAuctionsIds(){
        LinkedList<Integer> result = new LinkedList<>();
        for( int id : auctions.keySet() )  result.add(id);
        return result;
    }//getNotStartedAuctionsIds

    /**
     * Removes the auction with id {@param id}.
     * The auction is removed only if it is not active.
     *
     * @param id the id of the auction to be removed.
     * @return true if the auction is removed correctly, false otherwise.
     */
    public boolean removeAuction(int id){
        Auction value = auctions.remove(id);
        return value != null;
    }//removeAuction
}//AuctionsManager
