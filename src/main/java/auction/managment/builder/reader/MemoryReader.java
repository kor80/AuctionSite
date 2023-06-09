package auction.managment.builder.reader;

import auction.managment.Article;

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
    void readType();
    void readDescription();
    void closeArticle();
    Collection<Article> getArticles();
}//MemoryReader
