package auction.search.decorator;

import auction.model.ArticleInfo;
import java.util.LinkedList;

public interface ArticleSearcher
{
    LinkedList<ArticleInfo> search();
}//ArticleSearcher
