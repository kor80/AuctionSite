package auction.service;

import auction.model.*;
import io.grpc.*;

import java.io.IOException;
import java.util.Collection;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdminClient
{
    private static final Logger logger = Logger.getLogger(AdminClient.class.getName());

    private final ManagedChannel channel;
    private final ArticleServiceGrpc.ArticleServiceBlockingStub blockingStub;
    private final ArticleServiceGrpc.ArticleServiceStub asyncStub;

    public AdminClient(String host, int port) throws IOException{
        channel = ManagedChannelBuilder.forAddress(host,port)
                .usePlaintext()
                .build();


        blockingStub = ArticleServiceGrpc.newBlockingStub(channel);
        asyncStub = ArticleServiceGrpc.newStub(channel);
    }//constructor

    public boolean deleteArticle(int id){
        DeleteArticleRequest request = DeleteArticleRequest.newBuilder()
                .setAuctionId(id).build();
        DeleteArticleResponse response = DeleteArticleResponse.getDefaultInstance();

        try{
            response = blockingStub.withDeadlineAfter(5, TimeUnit.SECONDS).deleteArticle(request);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "request failed: " + e.getMessage());
            return false;
        }

        logger.info("Article deleted: "+response.getUpshot());
        return response.getUpshot();
    }//deleteArticle

    public Collection<ArticleInfo> getArticles(){
        GetArticlesRequest request = GetArticlesRequest.newBuilder().build();
        GetArticlesResponse response = GetArticlesResponse.getDefaultInstance();

        try{
            response = blockingStub.withDeadlineAfter(5,TimeUnit.SECONDS).getArticles(request);
        }catch( Exception e ){
            logger.log(Level.SEVERE, "request failed: " + e.getMessage());
            return null;
        }

        System.out.println("Owned Auctions:");
        return response.getArticlesList();
    }//getArticles
}//ArticleClient
