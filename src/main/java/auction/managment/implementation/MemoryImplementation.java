package auction.managment.implementation;

import auction.managment.Article;
import auction.managment.auctions.ClosedAuction;
import auction.managment.auctions.Registration;

import java.util.Collection;

public interface MemoryImplementation
{
    void saveArticle(Article article);
    void saveRegistration(Registration registrations);
    void saveClosedAuction(ClosedAuction auction);
    Collection<Article> loadAllArticles();
    Collection<Registration> loadAllRegistrations();
    Collection<ClosedAuction> loadAllClosedAuctions();
}
