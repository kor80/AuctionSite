package auction.model.memory.builder.writer;

import auction.model.Article;
import auction.model.ArticleInfo;

/**
 * <h1>Memory Writer Director</h1>
 * This class specifies the right instructions
 * for writing an article in the database.
 *
 * @author Cosimo Russo
 * @version 1.0
 */
public class MemoryWriterDirector
{
    MemoryWriter builder;

    public MemoryWriterDirector(MemoryWriter builder){
        this.builder = builder;
    }

    public void save(Article article) {
        ArticleInfo info = article.getInfo();
        builder.openMemory();
        builder.saveUser(article.getUser());
        builder.addInfo();
        builder.saveName(info.getName());
        builder.saveStartingDate(info.getStartingDate());
        builder.saveEndingDate(info.getEndingDate());
        builder.saveStartingTime(info.getStartingTime());
        builder.saveEndingTime(info.getEndingTime());
        builder.saveStartingPrice(info.getStartingPrice());
        builder.saveBuyNowPrice(info.getBuyNowPrice());
        builder.saveType(info.getType());
        builder.saveDescription(info.getDescription());
        builder.saveArticleId(info.getId());
        builder.closeMemory();
    }//save
}//MemoryWriterDirector
