package auction.model.registrations;

import auction.model.ArticleInfo;
import auction.model.memory.MemoryManager;
import auction.model.auctions.AuctionsManager;
import auction.model.auctions.RegistrationInfo;
import auction.utils.DateChecker;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

public class RegistrationManager
{
    private static RegistrationManager INSTANCE;

    private MemoryManager memoryManager;
    private AuctionsManager auctionsManager;

    private ConcurrentHashMap<String, HashSet<Integer>> registeredAuctions;
    private ConcurrentHashMap<String, HashSet<Integer>> newRegisteredAuctions;

    private RegistrationManager(){
        auctionsManager = AuctionsManager.getInstance();
        memoryManager = MemoryManager.getInstance();
        readRegistrations(memoryManager.loadRegisteredAuctions());
        newRegisteredAuctions = new ConcurrentHashMap<>();
    }

    public static synchronized RegistrationManager getInstance(){
        if( INSTANCE==null ) INSTANCE = new RegistrationManager();
        return INSTANCE;
    }//getInstance

    /**
     * Subscribes the user to the auction specified in {@info info}.
     *
     * @param  info  auction_id, user, user_IP and user_port
     * @see RegistrationInfo
     * @return true if the subscription is accepted, false otherwise
     */
    public synchronized boolean registerAuction(RegistrationInfo info){
        String user = info.getUser();
        int auctionId = info.getArticleId();

        if( registeredAuctions.containsKey(user) && registeredAuctions.get(user).contains(auctionId) ) return false;
        ArticleInfo articleInfo = memoryManager.getArticle(auctionId);
        if( articleInfo == null ) return false;
        if( DateChecker.isExpired(articleInfo) ) return false;

        if( newRegisteredAuctions.containsKey(user) ) {
            if (newRegisteredAuctions.get(user).contains(auctionId)) return false;
            newRegisteredAuctions.get(user).add(auctionId);
        }else{
            HashSet<Integer> t = new HashSet<>();
            t.add(auctionId);
            newRegisteredAuctions.put(user,t);
        }

        boolean upshot = auctionsManager.subscribeUser(info);
        if( upshot )
            System.out.println("User "+user+" successfully registered to auction "+auctionId);
        else
            System.out.println("Something went wrong with the registration of "+user+" to auction "+auctionId);

        //ONLY FOR TESTING!!
        memoryManager.saveRegistration(info);
        return true;
    }//registerAuction

    /**
     * Loads in main memory all the subscriptions,
     * activating the subject (listener).
     *
     * @param  registrations a collection of Registration object
     * @see RegistrationInfo
     */
    private void readRegistrations(Collection<RegistrationInfo> registrations){
        registeredAuctions = new ConcurrentHashMap<>();

        for( RegistrationInfo registration : registrations ){
            String user = registration.getUser();
            int id = registration.getArticleId();
            System.out.println("Loading registration of user "+user+" with id "+id+" in main memory");
            if( registeredAuctions.containsKey(user) ) registeredAuctions.get(user).add(id);
            else{
                HashSet<Integer> t = new HashSet<>();
                t.add(id);
                registeredAuctions.put(user,t);
            }

            ArticleInfo articleInfo = memoryManager.getArticle(id);
            if( DateChecker.isExpired(articleInfo) ) continue;

            auctionsManager.subscribeUser(registration);
        }//for
    }//readRegisteredAuctions

    public synchronized LinkedList<ArticleInfo> getRegisteredAuctions(String user){
        LinkedList<ArticleInfo> result = new LinkedList<>();
        if( registeredAuctions.containsKey(user) )
            for( int id : registeredAuctions.get(user) )
                result.add(memoryManager.getArticle(id));

        if( newRegisteredAuctions.containsKey(user) )
            for( int id : newRegisteredAuctions.get(user) )
                result.add(memoryManager.getArticle(id) );

        return result;
    }//getRegisteredAuctions

    public synchronized boolean isRegistered(String user, int auctionId){
        return (registeredAuctions.containsKey(user) && registeredAuctions.get(user).contains(auctionId)) ||
                (newRegisteredAuctions.containsKey(user) && newRegisteredAuctions.get(user).contains(auctionId));
    }//isRegistered
}//RegistrationManager
