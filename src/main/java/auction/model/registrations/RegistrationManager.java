package auction.model.registrations;

import auction.model.ArticleInfo;
import auction.model.memory.MemoryManager;
import auction.model.auctions.AuctionsManager;
import auction.model.auctions.RegistrationInfo;
import auction.utils.DateChecker;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <h1>Registration Manager</h1>
 * This is a singleton class which has the responsibility to catch and
 * track the user registrations, adding the listeners (users) to the auction
 * specified in the requests.
 *
 * @author Cosimo Russo
 * @version 1.0
 */
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
     * The auctions mnager is contacted to add the new listener, either if
     * the auction is started or not.
     * The registration is saved in the database.
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

        memoryManager.saveRegistration(info);
        return true;
    }//registerAuction

    /**
     * Loads in main memory all the subscriptions,
     * activating the subject, which saves the listeners again.
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

    /**
     * Returns the article info of the auctions to which the user is registered.
     *
     * @param user the user who asks for his registrations.
     * @return A LinkedList containing the ArticleInfo of the user's registrations.
     * @see ArticleInfo
     */
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

    /**
     * Determines if the user {@param user} is registered to the auction with
     * id {@param id}.
     *
     * @param user the user who asks for his registration.
     * @param auctionId the id of the auction to which the user is supposed to be registered.
     * @return true if the user is registered to the auction, false otherwise.
     */
    public synchronized boolean isRegistered(String user, int auctionId){
        return (registeredAuctions.containsKey(user) && registeredAuctions.get(user).contains(auctionId)) ||
                (newRegisteredAuctions.containsKey(user) && newRegisteredAuctions.get(user).contains(auctionId));
    }//isRegistered

    /**
     * Removes all the registrations for the auction with id {@param id}.
     *
     * @param id the id of the auctions to remove.
     * @return true if the registrations are removed, false otherwise.
     */
    public synchronized boolean removeRegistration(int id){
        boolean found = false;
        for(Map.Entry<String,HashSet<Integer>> registrations : registeredAuctions.entrySet() )
            found = registrations.getValue().remove(id);

        if( !found)
            for(Map.Entry<String,HashSet<Integer>> registrations : newRegisteredAuctions.entrySet() )
                found = registrations.getValue().remove(id);

        return found;
    }//removeRegistration
}//RegistrationManager
