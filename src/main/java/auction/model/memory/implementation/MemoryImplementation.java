package auction.model.memory.implementation;

import auction.model.Article;
import auction.model.auctions.AuctionInfo;
import auction.model.auctions.RegistrationInfo;

import java.util.Collection;

public interface MemoryImplementation
{
    void saveArticle(Article article);
    void saveRegistration(RegistrationInfo registrations);
    void saveClosedAuction(AuctionInfo auction);
    Collection<Article> loadAllArticles();
    Collection<RegistrationInfo> loadAllRegistrations();
    Collection<AuctionInfo> loadAllClosedAuctions();
    void deleteArticle(int id);
    void deleteRegistration(int id);
}
