package auction.search;

import auction.model.ArticleInfo;
import auction.search.decorator.*;

import java.util.LinkedList;

public class SearchManager
{
    public static SearchManager INSTANCE;

    private SearchManager(){}

    public static synchronized SearchManager getInstance(){
        if( INSTANCE == null )
            INSTANCE = new SearchManager();
        return INSTANCE;
    }//getInstance

    public LinkedList<ArticleInfo> search(SearchInfo info){
        SimpleSearcher searcher = new SimpleSearcher();
        NameSearcher nameSearcher = new NameSearcher(searcher, info.getName());
        MinPriceSearcher minPriceSearcher = new MinPriceSearcher(nameSearcher, info.getMinPrice());
        MaxPriceSearcher maxPriceSearcher = new MaxPriceSearcher(minPriceSearcher, info.getMaxPrice());
        CategorySearcher categorySearcher = new CategorySearcher(maxPriceSearcher,info.getType());
        return categorySearcher.search();
    }//search
}//SearchManager
