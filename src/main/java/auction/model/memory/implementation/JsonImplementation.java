package auction.model.memory.implementation;

import auction.model.Article;
import auction.model.auctions.AuctionInfo;
import auction.model.auctions.RegistrationInfo;
import auction.model.memory.builder.deleter.DeleterDirector;
import auction.model.memory.builder.deleter.JsonArticleDeleter;
import auction.model.memory.builder.deleter.JsonRegistrationDeleter;
import auction.model.memory.builder.deleter.MemoryDeleter;
import auction.model.memory.builder.reader.*;
import auction.model.memory.builder.writer.*;

import java.util.Collection;

/**
 * <h1>Json Implementation</h1>
 * This class specializes the instructions
 * used to interact with a Json database.
 *
 * @author Cosimo Russo
 * @version 1.0
 */
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

    private MemoryDeleter articleDeleterBiulder;
    private MemoryDeleter registrationDeleterBuilder;
    private DeleterDirector articleDeleterDirector;
    private DeleterDirector registrationDeleterDirector;

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

        articleDeleterBiulder = new JsonArticleDeleter(articlesPath);
        registrationDeleterBuilder = new JsonRegistrationDeleter(registrationsPath);
        articleDeleterDirector = new DeleterDirector(articleDeleterBiulder);
        registrationDeleterDirector = new DeleterDirector(registrationDeleterBuilder);
    }

    /**
     * Saves the article {@param article} in the Json database.
     *
     * @param article the article to be saved
     * @see Article
     */
    @Override
    public void saveArticle(Article article) {
        articlesWriterDirector.save(article);
    }//saveArticle

    /**
     * Saves the registration {@param registration} in the Json database.
     *
     * @param registration the registration to be saved
     * @see RegistrationInfo
     */
    @Override
    public void saveRegistration(RegistrationInfo registration) {
        registrationsWriterDirector.save(registration);
    }//saveRegistrations

    /**
     * Saves the closed auction {@param auction} in the Json database.
     *
     * @param auction the closed auction to be saved
     * @see AuctionInfo
     */
    @Override
    public void saveClosedAuction(AuctionInfo auction) {
        closedAuctionsWriterDirector.save(auction);
    }//saveClosedAuction

    /**
     * Loads all the articles from the Json database.
     *
     * @return a Collection of the Articles previously saved in the database.
     * @see Article
     */
    @Override
    public Collection<Article> loadAllArticles() {
        return articlesReaderDirector.buildMemory();
    }//loadAllArticles

    /**
     * Loads all the registrations from the Json database.
     *
     * @return a Collection of the RegistrationInfo previously saved in the database.
     * @see RegistrationInfo
     */
    @Override
    public Collection<RegistrationInfo> loadAllRegistrations() {
        return registrationReaderDirector.buildMemory();
    }//loadAllRegistrations

    /**
     * Loads all the closed auctions from the Json database.
     *
     * @return a Collection of the closed AuctionInfo previously saved in the database.
     * @see AuctionInfo
     */
    @Override
    public Collection<AuctionInfo> loadAllClosedAuctions() {
        return closedAuctionsReaderDirector.buildMemory();
    }//loadAllClosedAuctions

    /**
     * Deletes the article with id {@param id} from the Json database.
     *
     * @param id the id of the article to be deleted.
     */
    @Override
    public void deleteArticle(int id){
        articleDeleterDirector.delete(id);
    }//deleteArticle

    /**
     * Deletes all the registration to the article with id {@param id} from the Json database.
     *
     * @param id the id of the article to be deleted.
     */
    @Override
    public void deleteRegistration(int id){
        registrationDeleterDirector.delete(id);
    }//deleteRegistration
}//JsonImplementation
