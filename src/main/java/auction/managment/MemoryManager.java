package auction.managment;

import auction.managment.implementation.JsonFactory;
import auction.managment.implementation.MemoryImplFactory;
import auction.managment.implementation.MemoryImplementation;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.*;

public class MemoryManager
{
    private static MemoryManager memoryManager;

    private static MemoryImplFactory factory = new JsonFactory();
    private final MemoryImplementation memoryImpl;

    private ConcurrentMap<String, LinkedList<Integer>> userArticles;       //user,articleID
    private ConcurrentMap<String, LinkedList<Integer>> userNewArticles;    //user,articleID

    private ConcurrentMap<Integer,ArticleInfo> articles;
    private ConcurrentMap<Integer,ArticleInfo> newArticles;

    private int lastArticleID=0;

    private MemoryManager(){
        memoryImpl = factory.createMemoryImplementation();
        userArticles = new ConcurrentHashMap<>();
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
        LinkedList<Article> articles = new LinkedList<>(memoryImpl.loadAll());

        for (Article article : articles){
            String user = article.getUser();
            loadArticle(user,article.getInfo());
        }
    }//loadArticles

    /**
     * Puts the article loaded by user {@user user} with {@info info}
     * inside the predefined data structure in main memory
     *
     * @param  user  the user who loaded the article
     * @param  info the informations of the article
     */
    private synchronized void loadArticle(String user, ArticleInfo info){
        if(lastArticleID <= info.getId() ) lastArticleID = info.getId()+1;

        articles.put(info.getId(),info);

        if( !userArticles.containsKey(user) ) {
            LinkedList<Integer> temp =
                    new LinkedList<>();
            temp.add(info.getId());
            userArticles.put(user, temp);
        }
        else userArticles.get(user).add(info.getId());
        System.out.println("Caricato in memoria primaria l'articolo: ");
        printArticle(user, info);
    }//loadArticle

    public synchronized void userLoadArticle(String user, ArticleInfo info){
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
        memoryImpl.save(Article.newBuilder().setUser(user).setInfo(info).build());
        System.out.println("Salvato in memoria secondaria l'articolo: ");
        printArticle(user,info);
    }//saveArticle

    /**
     * Saves all the new articles(articles loaded in the current server session)
     * inside the database chosen by current factory.
     */
    public void saveAll(){
        for( Map.Entry<String, LinkedList<Integer>> user : userNewArticles.entrySet() ){
            for( Integer id : user.getValue() )
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

    public LinkedList<ArticleInfo> getUserArticles(){
        LinkedList<ArticleInfo> ret = new LinkedList<>();

        for( Map.Entry<String,LinkedList<Integer>> entry : userArticles.entrySet() )
            for( Integer id : entry.getValue() )
                ret.add(articles.get(id));

        for( Map.Entry<String,LinkedList<Integer>> entry : userNewArticles.entrySet() )
            for( Integer id : entry.getValue() )
                ret.add(newArticles.get(id));

        return ret;
    }//getArticles

    public LinkedList<ArticleInfo> getArticles(String user){
        LinkedList<ArticleInfo> ret = new LinkedList<>();
        if(userArticles.containsKey(user))
            for( Integer id : userArticles.get(user) )
                ret.add(articles.get(id));

        if(userNewArticles.containsKey(user))
            for( Integer id : userNewArticles.get(user) )
                ret.add(newArticles.get(id));

        return ret;
    }//getArticles

    public ArticleInfo getArticle(int id){
        if( articles.containsKey(id) ) return articles.get(id);
        if( newArticles.containsKey(id) ) return newArticles.get(id);
        return null;
    }//getArticle
}
