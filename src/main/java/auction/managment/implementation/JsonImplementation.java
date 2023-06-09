package auction.managment.implementation;

import auction.managment.Article;
import auction.managment.builder.reader.JsonReader;
import auction.managment.builder.reader.MemoryReaderDirector;
import auction.managment.builder.writer.JsonWriter;
import auction.managment.builder.writer.MemoryWriterDirector;

import java.util.Collection;

public class JsonImplementation implements MemoryImplementation
{
    private final String path = "articles.json";

    private JsonReader readerBuilder;
    private MemoryReaderDirector readerDirector;

    private JsonWriter writerBuilder;
    private MemoryWriterDirector writerDirector;

    public JsonImplementation(){
        readerBuilder = new JsonReader(path);
        readerDirector = new MemoryReaderDirector(readerBuilder);

        writerBuilder = new JsonWriter(path);
        writerDirector = new MemoryWriterDirector(writerBuilder);
    }

    @Override
    public void save(Article article) {
        writerDirector.save(article);
    }//save

    @Override
    public Collection<Article> loadAll() {
        return readerDirector.buildMemory();
    }
}
