package auction.managment.memory.implementation;

import auction.managment.Article;
import auction.managment.auctions.AuctionInfo;
import auction.managment.auctions.RegistrationInfo;

import java.util.Collection;

public interface MemoryImplementation
{
    void saveArticle(Article article);
    void saveRegistration(RegistrationInfo registrations);
    void saveClosedAuction(AuctionInfo auction);
    Collection<Article> loadAllArticles();
    Collection<RegistrationInfo> loadAllRegistrations();
    Collection<AuctionInfo> loadAllClosedAuctions();
}
