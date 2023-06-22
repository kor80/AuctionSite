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

    private ConcurrentMap<String, LinkedList<ArticleInfo>> articles;
    private ConcurrentMap<String, LinkedList<ArticleInfo>> newArticles;

    private int lastArticleID=0;

    private MemoryManager(){
        memoryImpl = factory.createMemoryImplementation();
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

        if( !articles.containsKey(user) ) {
            LinkedList<ArticleInfo> temp =
                    new LinkedList<>();
            temp.add(info);
            articles.put(user, temp);
        }
        else articles.get(user).add(info);
        System.out.println("Caricato in memoria primaria l'articolo: ");
        printArticle(user, info);
    }//loadArticle

    public synchronized void userLoadArticle(String user, ArticleInfo info){
        ArticleInfo newInfo = info.toBuilder().setId(lastArticleID).build();
        lastArticleID++;
        if( !newArticles.containsKey(user) ) {
            LinkedList<ArticleInfo> temp =
                    new LinkedList<>();
            temp.add(newInfo);
            newArticles.put(user, temp);
        }
        else newArticles.get(user).add(newInfo);
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
        for( Map.Entry<String, LinkedList<ArticleInfo>> user : newArticles.entrySet() ){
            for( ArticleInfo articleInfo : user.getValue() )
                saveArticle(user.getKey(),articleInfo);
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

    public LinkedList<ArticleInfo> getArticles(){
        LinkedList<ArticleInfo> ret = new LinkedList<>();

        for( Map.Entry<String,LinkedList<ArticleInfo>> entry : articles.entrySet() )
            ret.addAll(entry.getValue());

        for( Map.Entry<String,LinkedList<ArticleInfo>> entry : newArticles.entrySet() )
            ret.addAll(entry.getValue());

        return ret;
    }//getArticles
}
