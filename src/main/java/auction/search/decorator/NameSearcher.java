package auction.search.decorator;

import auction.model.ArticleInfo;

import java.util.LinkedList;

public class NameSearcher extends SearcherDecorator
{
    private String name;

    public NameSearcher(ArticleSearcher searcher, String name){
        super(searcher);
        this.name = name;
    }

    @Override
    public LinkedList<ArticleInfo> search(){
        if( name == null ) return super.search();

        LinkedList<ArticleInfo> results = new LinkedList<>();
        for( ArticleInfo info : super.search())
            if( info.getName().toLowerCase().contains(name.toLowerCase())) results.add(info);

        return results;
    }//search
}//NameSearcher
