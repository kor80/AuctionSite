package auction.search.decorator;

import auction.managment.ArticleInfo;
import java.util.LinkedList;

public interface ArticleSearcher
{
    LinkedList<ArticleInfo> search();
}//ArticleSearcher
