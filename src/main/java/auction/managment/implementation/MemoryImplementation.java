package auction.managment.implementation;

import auction.managment.Article;
import auction.managment.auctions.Registration;

import java.util.Collection;

public interface MemoryImplementation
{
    void saveArticle(Article article);
    void saveRegistrations(Registration registrations);
    Collection<Article> loadAllArticles();
    Collection<Registration> loadAllRegistrations();
}
