package auction.search.decorator;

import auction.model.ArticleInfo;

import java.util.LinkedList;

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