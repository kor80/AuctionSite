package auction.search.decorator;

import auction.model.ArticleInfo;
import auction.model.memory.MemoryManager;

import java.util.Iterator;
import java.util.LinkedList;

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
