package auction.search.decorator;

import auction.model.ArticleInfo;

import java.util.LinkedList;

/**
 * <h1>Max Price Searcher</h1>
 * This class filters the results of a previous search by max price.
 *
 * @author Cosimo Russo
 * @version 1.0
 */
public class MaxPriceSearcher extends SearcherDecorator
{
    private double price;

    public MaxPriceSearcher(ArticleSearcher searcher, double minPrice){
        super(searcher);
        price = minPrice;
    }

    @Override
    public LinkedList<ArticleInfo> search(){
        if( price == 0 ) return super.search();

        LinkedList<ArticleInfo> results = new LinkedList<>();
        for( ArticleInfo info : super.search())
            if( info.getStartingPrice() <= price) results.add(info);

        return results;
    }//search
}//MaxPriceSearcher