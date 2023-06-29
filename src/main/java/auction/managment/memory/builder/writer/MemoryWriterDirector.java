package auction.managment.memory.builder.writer;

import auction.managment.Article;
import auction.managment.ArticleInfo;

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
