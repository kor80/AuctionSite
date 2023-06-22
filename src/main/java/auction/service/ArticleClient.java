package auction.service;

import auction.managment.*;
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
        }
        catch (StatusRuntimeException e) {
            if (e.getStatus().getCode() == Status.Code.ALREADY_EXISTS) {
                // not a big deal
                logger.info("laptop ID already exists");
                return;
            }
            logger.log(Level.SEVERE, "request failed: " + e.getMessage());
            return;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "request failed: " + e.getMessage());
            return;
        }

        logger.info("Article created with state: " + response.getState());
    }//createArticle

    public static void main(String[] args) throws InterruptedException{
        ArticleClient client = new ArticleClient("0.0.0.0", 8080, "Tonino");

        try {
            ArticleInfo info =  ArticleInfo.newBuilder().setName("Pallina da tennis")
                    .setStartingDate(Date.newBuilder().setYear(2023).setMonth(6).setDay(24).build())
                    .setEndingDate(Date.newBuilder().setYear(2023).setMonth(6).setDay(24).build())
                    .setStartingTime(Time.newBuilder().setHour(6).setMinutes(30).build())
                    .setEndingTime(Time.newBuilder().setHour(18).setMinutes(30).build())
                    .setStartingPrice(7548.99)
                    .setType(ArticleType.SPORT)
                    .setDescription("Pallina da tennis firmata da Giuvann u ciot")
                    .build();
            client.createArticle(info);
        } finally {
            client.shutdown();
        }
    }
}//ArticleClient
