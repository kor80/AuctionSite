package auction.search.decorator;

import auction.model.ArticleInfo;

import java.util.LinkedList;

/**
 * <h1>Name Searcher</h1>
 * This class filters the results of a previous search by name,
 * checking if the name is included in the article title or it is not.
 *
 * @author Cosimo Russo
 * @version 1.0
 */
public class NameSearcher extends SearcherDecorator
{
    private String name;

    public NameSearcher(ArticleSearcher searcher, String name){
        super(searcher);
        this.name = name;
    }

    @Override
    public LinkedList<ArticleInfo> search(){
        if( name.equals("") ) return super.search();

        LinkedList<ArticleInfo> results = new LinkedList<>();
        for( ArticleInfo info : super.search())
            if( info.getName().toLowerCase().contains(name.toLowerCase())) results.add(info);

        return results;
    }//search
}//NameSearcher
