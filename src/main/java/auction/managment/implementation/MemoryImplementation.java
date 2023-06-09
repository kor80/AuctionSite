package auction.managment.implementation;

import auction.managment.Article;

import java.util.Collection;

public interface MemoryImplementation
{
    void save(Article article);
    Collection<Article> loadAll();
}
