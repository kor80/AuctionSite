package auction.search.decorator;

import auction.model.ArticleInfo;

import java.util.LinkedList;

/**
 * <h1>Min Price Searcher</h1>
 * This class filters the results of a previous search by min price.
 *
 * @author Cosimo Russo
 * @version 1.0
 */
public class MinPriceSearcher extends SearcherDecorator
{
    private double price;

    public MinPriceSearcher(ArticleSearcher searcher, double minPrice){
        super(searcher);
        price = minPrice;
    }

    @Override
    public LinkedList<ArticleInfo> search(){
        LinkedList<ArticleInfo> results = new LinkedList<>();
        for( ArticleInfo info : super.search())
            if( info.getStartingPrice() >= price) results.add(info);

        return results;
    }//search
}//MinPriceSearcher