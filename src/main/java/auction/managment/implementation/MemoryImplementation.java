package auction.managment.implementation;

import auction.managment.Article;
import auction.managment.auctions.ClosedAuction;
import auction.managment.auctions.RegistrationInfo;

import java.util.Collection;

public interface MemoryImplementation
{
    void saveArticle(Article article);
    void saveRegistration(RegistrationInfo registrations);
    void saveClosedAuction(ClosedAuction auction);
    Collection<Article> loadAllArticles();
    Collection<RegistrationInfo> loadAllRegistrations();
    Collection<ClosedAuction> loadAllClosedAuctions();
}
