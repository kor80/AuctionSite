package auction.controller;

import auction.model.*;
import auction.model.auctions.AuctionInfo;
import auction.search.SearchInfo;
import auction.service.ArticleServer;
import io.grpc.inprocess.InProcessServerBuilder;
import io.grpc.testing.GrpcCleanupRule;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ClientControllerTest {
    @Rule
    public final GrpcCleanupRule grpcCleanup = new GrpcCleanupRule(); // automatic graceful shutdown channel at the end of test

    private ArticleServer server;

    private ClientController client;

    @BeforeAll
    public void setUp() throws Exception {
        String serverName = InProcessServerBuilder.generateName();
        InProcessServerBuilder serverBuilder = InProcessServerBuilder.forName(serverName).directExecutor();

        server = new ArticleServer(serverBuilder, 8080);
        server.start();

        client = new ClientController();
        client.setUsername("Username");
    }//setUp

    @AfterAll
    public void tearDown() throws Exception {
        server.stop();
    }//tearDown

    @Test
    public void uploadConsistentArticle(){
        ArticleInfo consistentArticle = createConsistentArticle();
        boolean upshot = client.createArticle(consistentArticle);
        assertTrue(upshot);
    }//createConsistentArticle

    private ArticleInfo createConsistentArticle(){
        Date sDate = Date.newBuilder().setYear(2023).setMonth(7).setDay(3).build();
        Date eDate = Date.newBuilder().setYear(2023).setMonth(7).setDay(3).build();
        Time sTime = Time.newBuilder().setHour(18).setMinutes(20).build();
        Time eTime = Time.newBuilder().setHour(20).setMinutes(0).build();
        ArticleInfo info = ArticleInfo.newBuilder().setName("Test").setStartingDate(sDate).setEndingDate(eDate).setStartingTime(sTime).setEndingTime(eTime)
                .setStartingPrice(1).setBuyNowPrice(1).setType(ArticleType.BOOKS).setDescription("Test description").build();
        return info;
    }//createConsistentArticle

    @Test
    public void uploadStartingDateAfterEndingDateArticle(){
        ArticleInfo startingDateAfterEndingDateArticle = createStartingDateAfterEndingDateArticle();
        boolean upshot = client.createArticle(startingDateAfterEndingDateArticle);
        assertFalse(upshot);
    }//uploadStartingDateAfterEndingDateArticle

    private ArticleInfo createStartingDateAfterEndingDateArticle(){
        Date sDate = Date.newBuilder().setYear(2023).setMonth(7).setDay(6).build();
        Date eDate = Date.newBuilder().setYear(2023).setMonth(7).setDay(3).build();
        Time sTime = Time.newBuilder().setHour(18).setMinutes(20).build();
        Time eTime = Time.newBuilder().setHour(20).setMinutes(0).build();
        ArticleInfo info = ArticleInfo.newBuilder().setName("Test 2").setStartingDate(sDate).setEndingDate(eDate).setStartingTime(sTime).setEndingTime(eTime)
                .setStartingPrice(1).setBuyNowPrice(1).setType(ArticleType.BOOKS).setDescription("Test description").build();
        return info;
    }//createStartingDateAfterEndingDateArticle

    @Test
    public void uploadStartingTimeAfterEndingTimeArticle(){
        ArticleInfo startingTimeAfterEndingTimeArticle = createStartingTimeAfterEndingTimeArticle();
        boolean upshot = client.createArticle(startingTimeAfterEndingTimeArticle);
        assertFalse(upshot);
    }//uploadStartingTimeAfterEndingTimeArticle

    private ArticleInfo createStartingTimeAfterEndingTimeArticle(){
        Date sDate = Date.newBuilder().setYear(2023).setMonth(7).setDay(6).build();
        Date eDate = Date.newBuilder().setYear(2023).setMonth(7).setDay(6).build();
        Time sTime = Time.newBuilder().setHour(20).setMinutes(0).build();
        Time eTime = Time.newBuilder().setHour(8).setMinutes(0).build();
        ArticleInfo info = ArticleInfo.newBuilder().setName("Test 2").setStartingDate(sDate).setEndingDate(eDate).setStartingTime(sTime).setEndingTime(eTime)
                .setStartingPrice(1).setBuyNowPrice(1).setType(ArticleType.BOOKS).setDescription("Test description").build();
        return info;
    }//createStartingTimeAfterEndingTimeArticle

    @Test
    public void uploadInvalidStartingPriceArticle(){
        ArticleInfo invalidStartingPriceArticle = createInvalidStartingPriceArticle();
        boolean upshot = client.createArticle(invalidStartingPriceArticle);
        assertFalse(upshot);
    }//uploadInvalidStartingPriceArticle

    private ArticleInfo createInvalidStartingPriceArticle(){
        Date sDate = Date.newBuilder().setYear(2023).setMonth(7).setDay(3).build();
        Date eDate = Date.newBuilder().setYear(2023).setMonth(7).setDay(6).build();
        Time sTime = Time.newBuilder().setHour(8).setMinutes(0).build();
        Time eTime = Time.newBuilder().setHour(20).setMinutes(30).build();
        ArticleInfo info = ArticleInfo.newBuilder().setName("Test 2").setStartingDate(sDate).setEndingDate(eDate).setStartingTime(sTime).setEndingTime(eTime)
                .setStartingPrice(-4).setBuyNowPrice(1).setType(ArticleType.BOOKS).setDescription("Test description").build();
        return info;
    }//createInvalidStartingPriceArticle

    @Test
    public void uploadInvaliBuyNowPriceArticle(){
        ArticleInfo invaliBuyNowPriceArticle = createInvaliBuyNowPriceArticle();
        boolean upshot = client.createArticle(invaliBuyNowPriceArticle);
        assertFalse(upshot);
    }//uploadInvaliBuyNowPriceArticle

    private ArticleInfo createInvaliBuyNowPriceArticle(){
        Date sDate = Date.newBuilder().setYear(2023).setMonth(7).setDay(3).build();
        Date eDate = Date.newBuilder().setYear(2023).setMonth(7).setDay(6).build();
        Time sTime = Time.newBuilder().setHour(8).setMinutes(0).build();
        Time eTime = Time.newBuilder().setHour(20).setMinutes(30).build();
        ArticleInfo info = ArticleInfo.newBuilder().setName("Test 2").setStartingDate(sDate).setEndingDate(eDate).setStartingTime(sTime).setEndingTime(eTime)
                .setStartingPrice(4).setBuyNowPrice(-1).setType(ArticleType.BOOKS).setDescription("Test description").build();
        return info;
    }//createInvaliBuyNowPriceArticle

    @Test
    public void searchAllArticles(){
        Collection<ArticleInfo> results = client.searchArticles(SearchInfo.newBuilder()
                .setName("")
                .setMaxPrice(0.0)
                .setMinPrice(0.0)
                .setType(ArticleType.UNKNOWN)
                .build()
        );

        assertNotNull(results);
        assertEquals(1, results.size());
    }//searchAllArticles

    @Test
    public void searchNotPresentArticles(){
        Collection<ArticleInfo> results = client.searchArticles(SearchInfo.newBuilder()
                .setName("")
                .setMaxPrice(0.0)
                .setMinPrice(0.0)
                .setType(ArticleType.TECH)
                .build()
        );

        assertNotNull(results);
        assertEquals(0, results.size());
    }//searchNotPresentArticles

    @Test
    public void searchArticleTypeArticles(){
        Collection<ArticleInfo> results = client.searchArticles(SearchInfo.newBuilder()
                .setName("")
                .setMaxPrice(0.0)
                .setMinPrice(0.0)
                .setType(ArticleType.HOME)
                .build()
        );

        assertNotNull(results);
        assertEquals(1, results.size());
    }//searchArticleTypeArticles

    @Test
    public void searchOwnedAuctions(){
        //Username = "Username"
        Collection<AuctionInfo> results = client.getOwnedAuctions();
        assertNotNull(results);
        assertEquals(1, results.size());
    }//searchOwnedAuctions

    @Test
    public void searchOwnedAuctionsEmpty(){
        //Username = "Username1"
        Collection<AuctionInfo> results = client.getOwnedAuctions();
        assertNotNull(results);
        assertEquals(0, results.size());
    }//searchOwnedAuctionsEmpty

    @Test
    public void registerToAuctionWithValidId(){
        boolean upshot = client.registerToTheAuction(0);
        assertTrue(upshot);
    }//registerToAuctionWithValidId

    @Test
    public void registerToAuctionWithInvalidId(){
        boolean upshot = client.registerToTheAuction(100);
        assertFalse(upshot);
    }//registerToAuctionWithInvalidId

    @Test
    public void getRegisteredAuctions(){
        Collection<ArticleInfo> results = client.getRegisteredAuctions();
        assertNotNull(results);
        assertEquals(1,results.size());
    }//getRegisteredAuctions

    @Test
    public void makeOfferToClosedAuction(){
        boolean upshot = client.makeOffer(0,110.0);
        assertFalse(upshot);
    }//makeOfferToClosedAuction

    @Test
    public void makeOfferLessThanMinToOpenedAuction(){
        boolean upshot = client.makeOffer(0,90.0);
        assertFalse(upshot);
    }//makeOfferLessThanMinToOpenedAuction

    @Test
    public void makeOfferToOpenedAuction(){
        double offer = 110.0;
        client.registerToTheAuction(0);
        boolean upshot = client.makeOffer(0,offer);
        double newAmount = 0.0;
        String newWinner = "";
        for( AuctionInfo auction : client.getUserActiveAuctions() )
            if( auction.getArticleId() == 0 ){
                newAmount = auction.getCurrentOffer();
                newWinner = auction.getCurrentWinner();
            }
        assertTrue(upshot);
        assertEquals(offer,newAmount);
        assertEquals("Username",newWinner);
    }//makeOfferToOpenedAuction
}//ClientControllerTest