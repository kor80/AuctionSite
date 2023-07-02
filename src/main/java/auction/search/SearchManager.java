package auction.search;

import auction.model.ArticleInfo;
import auction.search.decorator.*;

import java.util.LinkedList;

/**
 * <h1>Search Manager</h1>
 * This is a singleton class which has the only responsibility to
 * search articles in the server memory.
 *
 * @author Cosimo Russo
 * @version 1.0
 */
public class SearchManager
{
    public static SearchManager INSTANCE;

    private SearchManager(){}

    public static synchronized SearchManager getInstance(){
        if( INSTANCE == null )
            INSTANCE = new SearchManager();
        return INSTANCE;
    }//getInstance

    /**
     * Returns all the articles that meet the search criteria.
     *
     * @param  info  A SearchInfo object containing the search criteria.
     * @return A LinkedList containing the ArticleInfo of the articles
     * that meet the search criteria.
     * @see ArticleInfo
     * @see SearchInfo
     */
    public LinkedList<ArticleInfo> search(SearchInfo info){
        SimpleSearcher searcher = new SimpleSearcher();
        NameSearcher nameSearcher = new NameSearcher(searcher, info.getName());
        MinPriceSearcher minPriceSearcher = new MinPriceSearcher(nameSearcher, info.getMinPrice());
        MaxPriceSearcher maxPriceSearcher = new MaxPriceSearcher(minPriceSearcher, info.getMaxPrice());
        CategorySearcher categorySearcher = new CategorySearcher(maxPriceSearcher,info.getType());
        return categorySearcher.search();
    }//search
}//SearchManager
