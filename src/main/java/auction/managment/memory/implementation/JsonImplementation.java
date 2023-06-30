package auction.managment.memory.implementation;

import auction.managment.Article;
import auction.managment.auctions.AuctionInfo;
import auction.managment.auctions.RegistrationInfo;
import auction.managment.memory.builder.reader.*;
import auction.managment.memory.builder.writer.*;

import java.util.Collection;

public class JsonImplementation implements MemoryImplementation
{
    private final String articlesPath = "articles.json";
    private final String registrationsPath = "registrations.json";
    private final String closedAuctionsPath = "closedAuctions.json";

    private MemoryReader readerBuilder;
    private ArrayReader registrationReaderBuilder;
    private ArrayReader closedAuctionsReaderBuilder;
    private MemoryReaderDirector articlesReaderDirector;
    private RegistrationReaderDirector registrationReaderDirector;
    private ClosedAuctionsReaderDirector closedAuctionsReaderDirector;

    private MemoryWriter articlesWriterBuilder;
    private MemoryWriter registrationsWriterBuilder;
    private MemoryWriter closedAuctionsWriterBuilder;
    private MemoryWriterDirector articlesWriterDirector;
    private RegistrationsWriterDirector registrationsWriterDirector;
    private ClosedAuctionsWriterDirector closedAuctionsWriterDirector;

    public JsonImplementation(){
        readerBuilder = new JsonReader(articlesPath);
        registrationReaderBuilder = new JsonArrayReader(registrationsPath);
        closedAuctionsReaderBuilder = new JsonArrayReader(closedAuctionsPath);
        articlesReaderDirector = new MemoryReaderDirector(readerBuilder);
        registrationReaderDirector = new RegistrationReaderDirector(registrationReaderBuilder);
        closedAuctionsReaderDirector = new ClosedAuctionsReaderDirector(closedAuctionsReaderBuilder);

        articlesWriterBuilder = new JsonWriter(articlesPath);
        registrationsWriterBuilder = new JsonWriter(registrationsPath);
        closedAuctionsWriterBuilder = new JsonWriter(closedAuctionsPath);
        articlesWriterDirector = new MemoryWriterDirector(articlesWriterBuilder);
        registrationsWriterDirector = new RegistrationsWriterDirector(registrationsWriterBuilder);
        closedAuctionsWriterDirector = new ClosedAuctionsWriterDirector(closedAuctionsWriterBuilder);
    }

    @Override
    public void saveArticle(Article article) {
        articlesWriterDirector.save(article);
    }//saveArticle

    @Override
    public void saveRegistration(RegistrationInfo registration) {
        registrationsWriterDirector.save(registration);
    }//saveRegistrations

    @Override
    public void saveClosedAuction(AuctionInfo auction) {
        closedAuctionsWriterDirector.save(auction);
    }//saveClosedAuction

    @Override
    public Collection<Article> loadAllArticles() {
        return articlesReaderDirector.buildMemory();
    }//loadAllArticles

    @Override
    public Collection<RegistrationInfo> loadAllRegistrations() {
        return registrationReaderDirector.buildMemory();
    }//loadAllRegistrations

    @Override
    public Collection<AuctionInfo> loadAllClosedAuctions() {
        return closedAuctionsReaderDirector.buildMemory();
    }//loadAllClosedAuctions


}
