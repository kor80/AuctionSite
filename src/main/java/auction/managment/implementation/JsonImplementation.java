package auction.managment.implementation;

import auction.managment.Article;
import auction.managment.auctions.Registration;
import auction.managment.builder.reader.*;
import auction.managment.builder.writer.JsonWriter;
import auction.managment.builder.writer.MemoryWriter;
import auction.managment.builder.writer.MemoryWriterDirector;
import auction.managment.builder.writer.RegistrationsWriterDirector;

import java.util.Collection;

public class JsonImplementation implements MemoryImplementation
{
    private final String articlesPath = "articles.json";
    private final String registrationsPath = "registrations.json";

    private MemoryReader readerBuilder;
    private RegistrationReader registrationReaderBuilder;
    private MemoryReaderDirector articlesReaderDirector;
    private RegistrationReaderDirector registrationReaderDirector;

    private MemoryWriter articlesWriterBuilder;
    private MemoryWriter registrationsWriterBuilder;
    private MemoryWriterDirector articlesWriterDirector;
    private RegistrationsWriterDirector registrationsWriterDirector;

    public JsonImplementation(){
        readerBuilder = new JsonReader(articlesPath);
        registrationReaderBuilder = new JsonRegistrationReader(registrationsPath);
        articlesReaderDirector = new MemoryReaderDirector(readerBuilder);
        registrationReaderDirector = new RegistrationReaderDirector(registrationReaderBuilder);

        articlesWriterBuilder = new JsonWriter(articlesPath);
        registrationsWriterBuilder = new JsonWriter(registrationsPath);
        articlesWriterDirector = new MemoryWriterDirector(articlesWriterBuilder);
        registrationsWriterDirector = new RegistrationsWriterDirector(registrationsWriterBuilder);
    }

    @Override
    public void saveArticle(Article article) {
        articlesWriterDirector.save(article);
    }//saveArticle

    @Override
    public void saveRegistrations(Registration registrations) {
        registrationsWriterDirector.save(registrations);
    }//saveRegistrations

    @Override
    public Collection<Article> loadAllArticles() {
        return articlesReaderDirector.buildMemory();
    }//loadAllArticles

    @Override
    public Collection<Registration> loadAllRegistrations() {
        return registrationReaderDirector.buildMemory();
    }//loadAllRegistrations


}
