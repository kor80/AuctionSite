package auction.managment.builder.writer;

import auction.managment.ArticleType;
import auction.managment.Date;
import auction.managment.Time;

public interface MemoryWriter
{
    void openMemory();
    void saveUser(String user);
    void closeMemory();

    //Useful for articles
    void addInfo();
    void saveName(String name);
    void saveStartingDate(Date date);
    void saveEndingDate(Date date);
    void saveStartingTime(Time time);
    void saveEndingTime(Time time);
    void saveStartingPrice(double price);
    void saveBuyNowPrice(double price);
    void saveWinner(String winner);
    void saveEndingPrice(double price);
    void saveAuctionId(int id);
    void savePort(int port);
    void saveIP(String ip);
    void saveType(ArticleType type);
    void saveDescription(String description);
    void saveArticleId(int id);

    //Useful for auction registrations
    void saveRegistrationId(int id);

}
