package auction.search.decorator;

import auction.managment.ArticleInfo;
import auction.managment.ArticleType;

import java.util.LinkedList;

public class CategorySearcher extends SearcherDecorator
{
    private ArticleType category;

    public CategorySearcher(ArticleSearcher searcher, ArticleType category){
        super(searcher);
        this.category = category;
    }

    @Override
    public LinkedList<ArticleInfo> search(){
        if( category == ArticleType.UNKNOWN ) return super.search();

        LinkedList<ArticleInfo> results = new LinkedList<>();
        for( ArticleInfo info : super.search())
            if( info.getType().getNumber() == category.getNumber()) results.add(info);

        return results;
    }//search
}//CategorySearcher