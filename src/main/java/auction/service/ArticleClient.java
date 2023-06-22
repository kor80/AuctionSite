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

    public static void main(String[] args) throws InterruptedException{
        ArticleClient client = new ArticleClient("0.0.0.0", 8080, "Tonino");

        try {
            /*
            Date sDate = Date.newBuilder().setYear(2023).setMonth(5).setDay(11).build();
            Date eDate = Date.newBuilder().setYear(2023).setMonth(5).setDay(12).build();
            Time sTime = Time.newBuilder().setHour(8).setMinutes(20).build();
            Time eTime = Time.newBuilder().setHour(12).setMinutes(0).build();
            ArticleInfo info = ArticleInfo.newBuilder().setName("Prova").setStartingDate(sDate).setEndingDate(eDate).setStartingTime(sTime).setEndingTime(eTime)
                            .setStartingPrice(1.50).setBuyNowPrice(1.0).setType(ArticleType.BOOKS).setDescription("Test description").build();
            client.createArticle(info);
            */

            SearchInfo info = SearchInfo.newBuilder().setName("pallina").setMaxPrice(10000).build();
            client.searchArticle(info);
        } finally {
            client.shutdown();
        }
    }
}//ArticleClient
