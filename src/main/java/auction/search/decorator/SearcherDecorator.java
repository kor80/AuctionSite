package auction.search.decorator;

import auction.model.ArticleInfo;

import java.util.LinkedList;

public abstract class SearcherDecorator implements ArticleSearcher
{
    private final ArticleSearcher searcher;

    public SearcherDecorator(ArticleSearcher searcher){
        this.searcher = searcher;
    }

    @Override
    public LinkedList<ArticleInfo> search(){
        return searcher.search();
    }//search
}//SearcherDecorator
