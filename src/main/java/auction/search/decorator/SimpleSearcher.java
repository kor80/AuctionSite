package auction.search.decorator;

import auction.model.ArticleInfo;
import auction.model.memory.MemoryManager;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * <h1>Simple Searcher</h1>
 * This class implements the naive article search, returning all
 * the articles saved in the server.
 *
 * @author Cosimo Russo
 * @version 1.0
 */
public class SimpleSearcher implements ArticleSearcher
{
    @Override
    public LinkedList<ArticleInfo> search(){
        MemoryManager memoryManager = MemoryManager.getInstance();
        LinkedList<ArticleInfo> results = memoryManager.getArticles();

        results.removeIf(article -> memoryManager.isAuctionClosed(article.getId()));

        return results;
    }//search
}//SimpleSearcher
