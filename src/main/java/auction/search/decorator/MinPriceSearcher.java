package auction.search.decorator;

import auction.managment.ArticleInfo;

import java.util.LinkedList;

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