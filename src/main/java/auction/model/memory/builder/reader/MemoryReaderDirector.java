package auction.model.memory.builder.reader;

import auction.model.Article;

import java.util.Collection;

/**
 * <h1>Memory Reader Director</h1>
 * This class specifies the right instructions
 * for reading an article from the database.
 *
 * @author Cosimo Russo
 * @version 1.0
 */
public class MemoryReaderDirector
{
    private MemoryReader builder;

    public MemoryReaderDirector(MemoryReader builder){
        this.builder = builder;
    }

    public Collection<Article> buildMemory(){
        int numArticles = builder.openMemory();
        for( int i=0; i<numArticles; i++){
            builder.openArticle(i);
            builder.readUser();
            builder.addInfo();
            builder.readName();
            builder.readStartingDate();
            builder.readEndingDate();
            builder.readStartingTime();
            builder.readEndingTime();
            builder.readStartingPrice();
            builder.readBuyNowPrice();
            builder.readType();
            builder.readDescription();
            builder.readId();
            builder.closeArticle();
        }
        return builder.getArticles();
    }//buildMemory
}//MemoryReaderDirector
