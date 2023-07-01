package auction.model.memory.builder.reader;

import auction.model.Article;

import java.util.Collection;

public interface MemoryReader
{
    int openMemory();
    void openArticle(int articleIndex);
    void readUser();
    void addInfo();
    void readName();
    void readStartingDate();
    void readEndingDate();
    void readStartingTime();
    void readEndingTime();
    void readStartingPrice();
    void readBuyNowPrice();
    void readType();
    void readDescription();
    void readId();
    void readWinner();
    void readEndingPrice();
    void closeArticle();
    Collection<Article> getArticles();
}//MemoryReader
