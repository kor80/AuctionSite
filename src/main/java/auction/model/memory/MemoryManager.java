package auction.model.memory;

import auction.model.Article;
import auction.model.ArticleInfo;
import auction.model.auctions.AuctionInfo;
import auction.model.auctions.AuctionsManager;
import auction.model.auctions.RegistrationInfo;
import auction.model.memory.implementation.JsonFactory;
import auction.model.memory.implementation.MemoryImplFactory;
import auction.model.memory.implementation.MemoryImplementation;
import auction.model.registrations.RegistrationManager;
import auction.utils.DateChecker;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.*;

/**
 * <h1>Memory Manager</h1>
 * This is a singleton class which has the only responsibility to
 * make database and main memory communicate, loading the persistent articles,
 * registrations and closed auctions and saving all the new info loaded in the current
 * session.
 * This class is only the abstraction, which is completely independent from the
 * "kind" of database used. The kind of database can be set using the corresponding factory.
 *
 * @author Cosimo Russo
 * @version 1.0
 */
public class MemoryManager
{
    private static MemoryManager memoryManager;

    private static MemoryImplFactory factory = new JsonFactory();
    private final MemoryImplementation memoryImpl;

    private ConcurrentMap<String, LinkedList<Integer>> userActiveArticles;     //user,articleID
    private ConcurrentMap<String, LinkedList<Integer>> userExpiredArticles;    //user,articleID
    private ConcurrentMap<String, LinkedList<Integer>> userNewArticles;        //user,articleID

    private ConcurrentMap<Integer,AuctionInfo> closedAuctions; //articleId,closedAuction

    private ConcurrentMap<Integer, ArticleInfo> articles;
    private ConcurrentMap<Integer,ArticleInfo> newArticles;

    private int lastArticleID=0;

    private MemoryManager(){
        memoryImpl = factory.createMemoryImplementation();
        userActiveArticles = new ConcurrentHashMap<>();
        userExpiredArticles = new ConcurrentHashMap<>();
        userNewArticles = new ConcurrentHashMap<>();
        articles = new ConcurrentHashMap<>();
        newArticles = new ConcurrentHashMap<>();
        loadClosedAuctions();
        loadArticles();
    }

    /**
     * Returns an instance of the Singleton class MemoryManager.
     * @return      the singleton MemoryManager instance
     */
    public static synchronized MemoryManager getInstance(){
        if( memoryManager == null)
            memoryManager = new MemoryManager();
        return memoryManager;
    }//getInstance

    /**
     * Sets the default factory for memory interactions.
     */
    public static void setMemoryImplFactory(MemoryImplFactory factory){
        MemoryManager.factory = factory;
    }//setMemoryImplFactory

    /**
     * Loads articles in main memory, supporting articles persistence
     * @see Article
     */
    private void loadArticles(){
        LinkedList<Article> articles = new LinkedList<>(memoryImpl.loadAllArticles());

        for (Article article : articles){
            String user = article.getUser();
            loadArticle(user,article.getInfo());
        }
    }//loadArticles

    /**
     * Loads registrations in main memory, supporting registration persistence
     * @see RegistrationInfo
     */
    public Collection<RegistrationInfo> loadRegisteredAuctions(){
        return memoryImpl.loadAllRegistrations();
    }//loadRegisteredAuctions

    /**
     * Loads closed auctions in main memory, useful to take decisions.
     * @see AuctionInfo
     */
    public void loadClosedAuctions(){
        closedAuctions = new ConcurrentHashMap<>();
        for( AuctionInfo closedAuction : memoryImpl.loadAllClosedAuctions()){
            int id = closedAuction.getArticleId();
            AuctionInfo newClosedAuction = closedAuction.toBuilder()
                    .setIsOpened(false)
                    .build();
            closedAuctions.put(id,newClosedAuction);
        }
    }//loadClosedAuctions

    /**
     * Saves the article previously uploaded by the user {@user user} with {@info info}
     * inside the predefined data structure in main memory
     *
     * @param  user  the user who loaded the article
     * @param  info the informations of the article
     */
    private synchronized void loadArticle(String user, ArticleInfo info){
        if(lastArticleID <= info.getId() ) lastArticleID = info.getId()+1;

        articles.put(info.getId(),info);

        if(DateChecker.isExpired(info) || closedAuctions.containsKey(info.getId())){
            if( !userExpiredArticles.containsKey(user) ){
                LinkedList<Integer> temp =
                        new LinkedList<>();
                temp.add(info.getId());
                userExpiredArticles.put(user, temp);
            }
            else userExpiredArticles.get(user).add(info.getId());
        }
        else{
            if( !userActiveArticles.containsKey(user) ) {
                LinkedList<Integer> temp =
                        new LinkedList<>();
                temp.add(info.getId());
                userActiveArticles.put(user, temp);
            }
            else userActiveArticles.get(user).add(info.getId());
        }

        System.out.println("Caricato in memoria primaria l'articolo: ");
        printArticle(user, info);
    }//loadArticle

    /**
     * Saves the article loaded by user {@user user} with {@info info}
     * inside the data structure in main memory.
     *
     * @param  user  the user who loaded the article
     * @param  info the informations of the article
     */
    public synchronized boolean userLoadArticle(String user, ArticleInfo info){
        ArticleInfo newInfo = info.toBuilder().setId(lastArticleID).build();
        lastArticleID++;

        newArticles.put(newInfo.getId(),newInfo);

        if( !userNewArticles.containsKey(user) ) {
            LinkedList<Integer> temp =
                    new LinkedList<>();
            temp.add(newInfo.getId());
            userNewArticles.put(user, temp);
        }
        else userNewArticles.get(user).add(newInfo.getId());
        printArticle(user,newInfo);

        AuctionsManager.getInstance().addAuction(newInfo);

        return true;
    }//userLoadArticle

    /**
     * Saves the article loaded by user {@user user} with {@info info}
     * inside the database chosen by current factory.
     *
     * @param  user  the user who loaded the article
     * @param  info the informations of the article
     * @see         MemoryImplFactory
     */
    public synchronized void saveArticle(String user, ArticleInfo info){
        memoryImpl.saveArticle(Article.newBuilder().setUser(user).setInfo(info).build());
        System.out.println("Salvato in memoria secondaria l'articolo: ");
        printArticle(user,info);
    }//saveArticle

    /**
     * Saves the registration {@registration registration} performed by user
     * inside the database chosen by current factory.
     *
     * @param  registration username, article_id, user_ip and user_port
     * @see RegistrationInfo
     */
    public synchronized void saveRegistration(RegistrationInfo registration){
        memoryImpl.saveRegistration(registration);
        System.out.println("Salvata in memoria secondaria la registrazione seguente:\n"+registration);
    }//saveRegistrations

    /**
     * Saves an expired auction
     * inside the database chosen by current factory.
     *
     * @param  auction  auction_id, winner and ending_price
     * @see AuctionInfo
     */
    public synchronized void saveClosedAuction(AuctionInfo auction){
        int id = auction.getArticleId();
        AuctionInfo newAuctionInfo = auction;
        if( articles.containsKey(id) )
            newAuctionInfo = auction.toBuilder().setArticleName(articles.get(id).getName()).build();
        else if( newArticles.containsKey(id) )
            newAuctionInfo = auction.toBuilder().setArticleName(newArticles.get(id).getName()).build();

        memoryImpl.saveClosedAuction(auction);
        closedAuctions.put(auction.getArticleId(),newAuctionInfo);
        System.out.println("Salvata in memoria secondaria la seguente asta chiusa:\n"+auction);
    }//saveClosedAuction

    /**
     * Saves all the new articles(articles loaded in the current server session)
     * inside the database chosen by current factory.
     */
    public void saveAllArticles(){
        for( Map.Entry<String, LinkedList<Integer>> user : userNewArticles.entrySet() ){
            for( int id : user.getValue() )
                saveArticle(user.getKey(), newArticles.get(id) );
        }//for
    }//saveAll

    private void printArticle(String user, ArticleInfo info){
        StringBuilder sb = new StringBuilder();
        sb.append(info.getStartingDate().getYear());
        sb.append("/");
        sb.append(info.getStartingDate().getMonth());
        sb.append("/");
        sb.append(info.getStartingDate().getDay());
        String date = sb.toString();
        System.out.format("User %s loaded the following article:\n" +
                        "Name: %s\nStarting date: %s\nType: %s\nDescription: %s\nId: %d\n\n",
                user, info.getName(), date, info.getType(), info.getDescription(), info.getId());
    }//printArticle

    /**
     * Returns all the articles uploaded by users and not expired.
     *
     * @see         MemoryImplFactory
     * @return LinkedList<ArticleInfo>
     */
    public LinkedList<ArticleInfo> getArticles(){
        LinkedList<ArticleInfo> ret = new LinkedList<>();

        for( Map.Entry<String,LinkedList<Integer>> entry : userActiveArticles.entrySet() )
            for( int id : entry.getValue() )
                ret.add(articles.get(id));

        for( Map.Entry<String,LinkedList<Integer>> entry : userNewArticles.entrySet() )
            for( int id : entry.getValue() )
                ret.add(newArticles.get(id));

        return ret;
    }//getArticles

    /**
     * Returns all the articles uploaded by the user {@user user}, also
     * the expired articles.
     *
     * @param  user  the user who loaded the article
     * @see ArticleInfo
     */
    public LinkedList<ArticleInfo> getArticles(String user){
        LinkedList<ArticleInfo> ret = new LinkedList<>();
        if(userActiveArticles.containsKey(user))
            for( int id : userActiveArticles.get(user) )
                ret.add(articles.get(id));

        if( userExpiredArticles.containsKey(user))
            for( int id : userExpiredArticles.get(user) )
                ret.add(articles.get(id));

        if(userNewArticles.containsKey(user))
            for( int id : userNewArticles.get(user) )
                ret.add(newArticles.get(id));

        return ret;
    }//getArticles

    /**
     * @param auctionId the id of the auction which is supposed to be closed.
     * @return true if the auction with id {@param auctionId} is closed, false otherwise.
     */
    public boolean isAuctionClosed(int auctionId){
        return closedAuctions.containsKey(auctionId);
    }//isAuctionClosed

    /**
     * Returns the info of the closed auction with id {@param auctionId} if it is closed.
     *
     * @param auctionId the id of the closed auction.
     * @return The AuctionInfo if the auction is closed, null otherwise.
     * @see AuctionInfo
     */
    public AuctionInfo getClosedAuctionInfo(int auctionId){
        if( !isAuctionClosed(auctionId) ) return null;
        closedAuctions.put(auctionId,closedAuctions.get(auctionId).toBuilder().setArticleName(getArticle(auctionId).getName()).build());
        return closedAuctions.get(auctionId);
    }//getClosedAuctionInfo

    /**
     * Returns the article with specified id.
     * The search is also carried out in expired articles.
     *
     * @param  id  the article id.
     * @see ArticleInfo
     * @return ArticleInfo if the article exists, null otherwise.
     */
    public ArticleInfo getArticle(int id){
        if( articles.containsKey(id) ) return articles.get(id);
        if( newArticles.containsKey(id) ) return newArticles.get(id);
        return null;
    }//getArticle

    /**
     * Removes the article with id {@param id} from the main memory and
     * from the database.
     * Also removes all the registrations to that article and the auction
     * not started yet with that id.
     *
     * @param id the article id.
     * @return true if the article and registrations were removed correctly, false otherwise.
     */
    public boolean removeArticle(int id){
        if( !AuctionsManager.getInstance().getNotStartedAuctionsIds().contains(id) ) return false;

        for(Map.Entry<String,LinkedList<Integer>> userArticles : userActiveArticles.entrySet() )
            userArticles.getValue().remove(Integer.valueOf(id));

        for(Map.Entry<String,LinkedList<Integer>> userArticles : userNewArticles.entrySet() )
            userArticles.getValue().remove(Integer.valueOf(id));

        memoryImpl.deleteArticle(id);
        articles.remove(id);
        newArticles.remove(id);

        AuctionsManager.getInstance().removeAuction(id);
        memoryImpl.deleteRegistration(id);
        RegistrationManager.getInstance().removeRegistration(id);

        return true;
    }//removeArticle
}
