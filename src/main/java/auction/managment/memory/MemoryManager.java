package auction.managment.memory;

import auction.managment.Article;
import auction.managment.ArticleInfo;
import auction.managment.auctions.ClosedAuction;
import auction.managment.auctions.RegistrationInfo;
import auction.managment.memory.implementation.JsonFactory;
import auction.managment.memory.implementation.MemoryImplFactory;
import auction.managment.memory.implementation.MemoryImplementation;
import auction.utils.DateChecker;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.*;

public class MemoryManager
{
    private static MemoryManager memoryManager;

    private static MemoryImplFactory factory = new JsonFactory();
    private final MemoryImplementation memoryImpl;

    private ConcurrentMap<String, LinkedList<Integer>> userActiveArticles;     //user,articleID
    private ConcurrentMap<String, LinkedList<Integer>> userExpiredArticles;    //user,articleID
    private ConcurrentMap<String, LinkedList<Integer>> userNewArticles;        //user,articleID

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
     */
    private void loadArticles(){
        LinkedList<Article> articles = new LinkedList<>(memoryImpl.loadAllArticles());

        for (Article article : articles){
            String user = article.getUser();
            loadArticle(user,article.getInfo());
        }
    }//loadArticles

    public Collection<RegistrationInfo> loadRegisteredAuctions(){
        return memoryImpl.loadAllRegistrations();
    }//loadRegisteredAuctions

    public Collection<ClosedAuction> loadClosedAuctions(){
        return memoryImpl.loadAllClosedAuctions();
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

        if(DateChecker.isExpired(info)){
            if( !userExpiredArticles.containsKey(user) ){
                LinkedList<Integer> temp =
                        new LinkedList<>();
                temp.add(info.getId());
                userExpiredArticles.put(user, temp);
            }
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
        System.out.println("L'utente ha caricato l'articolo: ");
        printArticle(user,info);
        return true; //TODO pass through consistency check
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
     * @see ClosedAuction
     */
    public synchronized void saveClosedAuction(ClosedAuction auction){
        memoryImpl.saveClosedAuction(auction);
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

    //TEST
    private void printArticle(String user, ArticleInfo info){
        StringBuilder sb = new StringBuilder();
        sb.append(info.getStartingDate().getYear());
        sb.append("/");
        sb.append(info.getStartingDate().getMonth());
        sb.append("/");
        sb.append(info.getStartingDate().getDay());
        String date = sb.toString();
        System.out.format("User %s loaded the following article:\n" +
                        "Name: %s\nStarting date: %s\nType: %s\nDescription: %s\n\n",
                user, info.getName(), date, info.getType(), info.getDescription());
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
     * Returns the article with specified id.
     * The search is also carried out in expired articles .
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
}
