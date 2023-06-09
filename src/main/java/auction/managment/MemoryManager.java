package auction.managment;

import auction.managment.implementation.JsonFactory;
import auction.managment.implementation.MemoryImplFactory;
import auction.managment.implementation.MemoryImplementation;

import java.util.LinkedList;
import java.util.concurrent.*;

public class MemoryManager
{
    private static MemoryManager memoryManager;

    private static MemoryImplFactory factory = new JsonFactory();
    private final MemoryImplementation memoryImpl;

    private ConcurrentMap<String, ConcurrentLinkedQueue<ArticleInfo>> articles;

    private MemoryManager(){
        memoryImpl = factory.createMemoryImplementation();
        articles = new ConcurrentHashMap<>();
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

        //TEST
        for( Article a : articles ) printArticle(a.getInfo(), a.getUser());
    }//loadArticles

    /**
     * Puts the article loaded by user {@user user} with {@info info}
     * inside the predefined data structure
     *
     * @param  user  the user who loaded the article
     * @param  info the informations of the article
     */
    private synchronized void loadArticle(String user, ArticleInfo info){
        if( !articles.containsKey(user) ) {
            ConcurrentLinkedQueue<ArticleInfo> temp =
                    new ConcurrentLinkedQueue<>();
            temp.add(info);
            articles.put(user, temp);
        }
        else articles.get(user).add(info);
    }//loadArticle

    public synchronized void saveArticle(String user, ArticleInfo info){
        memoryImpl.save(Article.newBuilder().setUser(user).setInfo(info).build());
        printArticle(info,user);
    }//saveArticle

    //TEST
    private void printArticle(ArticleInfo info, String user){
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
}
