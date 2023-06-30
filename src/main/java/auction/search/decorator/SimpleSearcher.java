package auction.search.decorator;

import auction.managment.ArticleInfo;
import auction.managment.memory.MemoryManager;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.LinkedList;

public class SimpleSearcher implements ArticleSearcher
{
    @Override
    public LinkedList<ArticleInfo> search(){
        MemoryManager memoryManager = MemoryManager.getInstance();
        LinkedList<ArticleInfo> results = memoryManager.getArticles();

        Iterator<ArticleInfo> it = results.iterator();
        while(it.hasNext() ){
            ArticleInfo article = it.next();
        }//while

        return results;
    }//search
}//SimpleSearcher
