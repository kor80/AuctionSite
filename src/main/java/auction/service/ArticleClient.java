package auction.service;

import auction.managment.*;
import auction.search.SearchInfo;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ArticleClient
{
    private static final Logger logger = Logger.getLogger(ArticleClient.class.getName());

    private final ManagedChannel channel;
    private final ArticleServiceGrpc.ArticleServiceBlockingStub blockingStub;
    private final ArticleServiceGrpc.ArticleServiceStub asyncStub;
    private final String username;

    public ArticleClient(String host, int port, String username){
        channel = ManagedChannelBuilder.forAddress(host,port)
                .usePlaintext()
                .build();

        blockingStub = ArticleServiceGrpc.newBlockingStub(channel);
        asyncStub = ArticleServiceGrpc.newStub(channel);
        this.username = username;
    }//constructor

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    public void createArticle(ArticleInfo info){
        CreateArticleRequest request = CreateArticleRequest.newBuilder()
                                        .setUser(username).setInfo(info).build();
        CreateArticleResponse response = CreateArticleResponse.getDefaultInstance();

        try{
            response = blockingStub.withDeadlineAfter(5, TimeUnit.SECONDS).createArticle(request);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "request failed: " + e.getMessage());
            return;
        }

        logger.info("Article created with state: " + response.getState());
    }//createArticle

    public void searchArticle(SearchInfo info){
        SearchArticleRequest request = SearchArticleRequest.newBuilder().setInfo(info).build();
        SearchArticleResponse response = SearchArticleResponse.getDefaultInstance();

        try{
            response = blockingStub.withDeadlineAfter(5, TimeUnit.SECONDS).searchArticle(request);
        }catch (Exception e) {
            logger.log(Level.SEVERE, "request failed: " + e.getMessage());
            return;
        }

        for( ArticleInfo i : response.getInfoList() )
            printArticleInfo(i);
    }//searchArticle

    public void getOwnedAuctions(){
        GetOwnedAuctionRequest request = GetOwnedAuctionRequest.newBuilder().setUser(username).build();
        GetOwnedAuctionResponse response = GetOwnedAuctionResponse.getDefaultInstance();

        try{
            response = blockingStub.withDeadlineAfter(5,TimeUnit.SECONDS).getOwnedAuctions(request);
        }catch( Exception e ){
            logger.log(Level.SEVERE, "request failed: " + e.getMessage());
            return;
        }

        System.out.println("Owned Auctions:");
        for( ArticleInfo i : response.getInfoList() )
            printArticleInfo(i);
    }//getOwnedAuctions

    public void registerToTheAuction(int auctionId){
        RegisterForTheAuctionRequest request = RegisterForTheAuctionRequest.newBuilder().setUser(username).setAuctionId(auctionId).build();
        RegisterForTheAuctionResponse response = RegisterForTheAuctionResponse.getDefaultInstance();

        try{
            response = blockingStub.withDeadlineAfter(5,TimeUnit.SECONDS).registerForTheAuction(request);
            if( response.getUpshot() ) System.out.println("Successfully registered to auction "+auctionId);
            else System.out.println("Error during registration..");
        }catch( Exception e ){
            logger.log(Level.SEVERE, "request failed: " + e.getMessage());
            return;
        }
    }//registerToTheAuction

    public void getUserActiveAuctions(){
        GetUserActiveAuctionsRequest request = GetUserActiveAuctionsRequest.newBuilder().setUser(username).build();
        GetUserActiveAuctionsResponse response = GetUserActiveAuctionsResponse.getDefaultInstance();

        try{
            response = blockingStub.withDeadlineAfter(5,TimeUnit.SECONDS).getUserActiveAuctions(request);
            System.out.println(username+"'s active auctions:");
            for( ArticleInfo i : response.getInfoList() )
                printArticleInfo(i);
        }catch( Exception e ){
            logger.log(Level.SEVERE, "request failed: " + e.getMessage());
            return;
        }
    }//getUserActiveAuctions

    private void printArticleInfo( ArticleInfo info ){
        StringBuilder sb = new StringBuilder();
        sb.append(info.getEndingDate().getYear());
        sb.append("/");
        sb.append(info.getEndingDate().getMonth());
        sb.append("/");
        sb.append(info.getEndingDate().getDay());
        String date = sb.toString();
        System.out.format("Article with id %d:\n" +
                        "Name: %s\nEnding date: %s\nType: %s\nDescription: %s\n\n",
                info.getId(), info.getName(), date, info.getType(), info.getDescription());
    }

    private static ArticleInfo createArticleTest(){
        Date sDate = Date.newBuilder().setYear(2023).setMonth(5).setDay(11).build();
        Date eDate = Date.newBuilder().setYear(2023).setMonth(5).setDay(12).build();
        Time sTime = Time.newBuilder().setHour(8).setMinutes(20).build();
        Time eTime = Time.newBuilder().setHour(12).setMinutes(0).build();
        ArticleInfo info = ArticleInfo.newBuilder().setName("Prova").setStartingDate(sDate).setEndingDate(eDate).setStartingTime(sTime).setEndingTime(eTime)
                .setStartingPrice(1.50).setBuyNowPrice(1.0).setType(ArticleType.BOOKS).setDescription("Test description").build();
        return info;
    }//createArticleTest

    private static SearchInfo searchArticleTest(){
        return SearchInfo.newBuilder().setName("pallina").setMaxPrice(10000).build();
    }//searchArticleTest

    public static void main(String[] args) throws InterruptedException{
        ArticleClient client = new ArticleClient("0.0.0.0", 8080, "Tonino");

        try {
            //client.createArticle(createArticleTest());
            //client.searchArticle(searchArticleTest());
            //client.getOwnedAuctions();
            client.registerToTheAuction(2);
            client.getUserActiveAuctions();
        } finally {
            client.shutdown();
        }
    }
}//ArticleClient
