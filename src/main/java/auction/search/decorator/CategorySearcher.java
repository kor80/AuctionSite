package auction.search.decorator;

import auction.model.ArticleInfo;
import auction.model.ArticleType;

import java.util.LinkedList;

/**
 * <h1>Category Searcher</h1>
 * This class filters the results of a previous search by category.
 *
 * @author Cosimo Russo
 * @version 1.0
 */
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