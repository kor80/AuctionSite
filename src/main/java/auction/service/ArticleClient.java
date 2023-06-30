package auction.service;

import auction.managment.*;
import auction.managment.auctions.AuctionInfo;
import auction.managment.auctions.RegistrationInfo;
import auction.controller.ClientController;
import auction.search.SearchInfo;
import io.grpc.*;
import io.grpc.protobuf.services.ProtoReflectionService;

import java.io.IOException;
import java.util.Collection;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ArticleClient
{
    private static final Logger logger = Logger.getLogger(ArticleClient.class.getName());

    private final int clientPort;
    private final Server server;

    private final ManagedChannel channel;
    private final ArticleServiceGrpc.ArticleServiceBlockingStub blockingStub;
    private final ArticleServiceGrpc.ArticleServiceStub asyncStub;

    private final String username;
    private final String clientIP;
    private final ClientController clientController;

    public ArticleClient(String host, int port, String username, int clientPort, String clientIP, ClientController clientController) throws IOException{
        channel = ManagedChannelBuilder.forAddress(host,port)
                .usePlaintext()
                .build();


        ClientService clientService = new ClientService(this);
        server = ServerBuilder.forPort(clientPort).addService(clientService)
                .addService(ProtoReflectionService.newInstance())
                .build();
        start();

        blockingStub = ArticleServiceGrpc.newBlockingStub(channel);
        asyncStub = ArticleServiceGrpc.newStub(channel);

        this.clientIP = clientIP;
        this.clientController = clientController;
        this.username = username;
        this.clientPort = clientPort;
    }//constructor

    private void start() throws IOException {
        server.start();
        logger.info("client is listening on port " + clientPort);

        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                System.err.println("shut down gRPC server because JVM shuts down");
                try {
                    ArticleClient.this.stop();
                } catch (InterruptedException e) {
                    e.printStackTrace(System.err);
                }
                System.err.println("client shut down");
            }
        });
    }//start

    public void stop() throws InterruptedException {
        if (server != null) {
            server.shutdown();//.awaitTermination(30, TimeUnit.SECONDS);
        }
    }//stop

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }


    //--------------------------------------------------------SERVER MANAGEMENT END--------------------------------------------------------



    public boolean createArticle(ArticleInfo info){
        CreateArticleRequest request = CreateArticleRequest.newBuilder()
                                        .setUser(username).setInfo(info).build();
        CreateArticleResponse response = CreateArticleResponse.getDefaultInstance();

        try{
            response = blockingStub.withDeadlineAfter(5, TimeUnit.SECONDS).createArticle(request);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "request failed: " + e.getMessage());
            return false;
        }

        logger.info("Article created with state: " + response.getUpshot());
        return response.getUpshot();
    }//createArticle

    public Collection<ArticleInfo> searchArticle(SearchInfo info){
        SearchArticleRequest request = SearchArticleRequest.newBuilder().setInfo(info).build();
        SearchArticleResponse response = SearchArticleResponse.getDefaultInstance();

        try{
            response = blockingStub.withDeadlineAfter(5, TimeUnit.SECONDS).searchArticle(request);
        }catch (Exception e) {
            logger.log(Level.SEVERE, "request failed: " + e.getMessage());
            return null;
        }

        return response.getInfoList();
    }//searchArticle

    public Collection<AuctionInfo> getOwnedAuctions(){
        GetOwnedAuctionRequest request = GetOwnedAuctionRequest.newBuilder().setUser(username).build();
        GetOwnedAuctionResponse response = GetOwnedAuctionResponse.getDefaultInstance();

        try{
            response = blockingStub.withDeadlineAfter(5,TimeUnit.SECONDS).getOwnedAuctions(request);
        }catch( Exception e ){
            logger.log(Level.SEVERE, "request failed: " + e.getMessage());
            return null;
        }

        System.out.println("Owned Auctions:");
        return response.getInfoList();
    }//getOwnedAuctions

    public boolean registerToTheAuction(int auctionId){
        RegistrationInfo info = RegistrationInfo.newBuilder().setUser(username).setArticleId(auctionId)
                .setUserPort(clientPort).setUserIP(clientIP).build();
        RegisterForTheAuctionRequest request = RegisterForTheAuctionRequest.newBuilder().setInfo(info).build();
        RegisterForTheAuctionResponse response = RegisterForTheAuctionResponse.getDefaultInstance();

        try{
            response = blockingStub.withDeadlineAfter(5,TimeUnit.SECONDS).registerForTheAuction(request);
            if( response.getUpshot() ) System.out.println("Successfully registered to auction "+auctionId);
            else System.out.println("Error during registration..");
            return response.getUpshot();
        }catch( Exception e ){
            logger.log(Level.SEVERE, "request failed: " + e.getMessage());
            return false;
        }
    }//registerToTheAuction

    public Collection<ArticleInfo> getUserActiveAuctions(){
        GetUserActiveAuctionsRequest request = GetUserActiveAuctionsRequest.newBuilder().setUser(username).build();
        GetUserActiveAuctionsResponse response = GetUserActiveAuctionsResponse.getDefaultInstance();

        try{
            response = blockingStub.withDeadlineAfter(5,TimeUnit.SECONDS).getUserActiveAuctions(request);
            return response.getInfoList();
        }catch( Exception e ){
            logger.log(Level.SEVERE, "request failed: " + e.getMessage());
            return null;
        }
    }//getUserActiveAuctions

    public Collection<ArticleInfo> getRegisteredAuctions(){
        GetRegisteredAuctionsRequest request = GetRegisteredAuctionsRequest.newBuilder().setUser(username).build();
        GetRegisteredAuctionsResponse response = GetRegisteredAuctionsResponse.getDefaultInstance();

        try{
            response = blockingStub.withDeadlineAfter(5,TimeUnit.SECONDS).getRegisteredAuctions(request);
            return response.getInfoList();
        }catch( Exception e ){
            logger.log(Level.SEVERE, "request failed: " + e.getMessage());
            return null;
        }
    }//getUserActiveAuctions

    public void updateOffer(AuctionInfo info){
        clientController.updateOffer(info);
    }//updateOffer

    public boolean makeOffer(int auctionId, double amount){
        MakeOfferRequest request = MakeOfferRequest.newBuilder()
                .setUser(username)
                .setAuctionId(auctionId)
                .setAmount(amount)
                .build();
        MakeOfferResponse response = MakeOfferResponse.getDefaultInstance();

        try{
            response = blockingStub.withDeadlineAfter(5,TimeUnit.SECONDS).makeOffer(request);
            return response.getUpshot();
        }catch( Exception e ){
            logger.log(Level.SEVERE, "request failed: " + e.getMessage());
            return false;
        }
    }//makeOffer

    public Collection<AuctionInfo> getClosedAuctions(){
        GetClosedAuctionsRequest request = GetClosedAuctionsRequest.newBuilder().setUser(username).build();
        GetClosedAuctionsResponse response = GetClosedAuctionsResponse.getDefaultInstance();

        try{
            response = blockingStub.withDeadlineAfter(5,TimeUnit.SECONDS).getClosedAuctions(request);
            return response.getInfoList();
        }catch( Exception e ){
            logger.log(Level.SEVERE, "request failed: " + e.getMessage());
            return null;
        }
    }//getUserActiveAuctions

    public boolean buyNow(int auctionId){
        BuyNowRequest request = BuyNowRequest.newBuilder().setUser(username).setAuctionId(auctionId).build();
        BuyNowResponse response = BuyNowResponse.getDefaultInstance();

        try{
            response = blockingStub.withDeadlineAfter(5,TimeUnit.SECONDS).buyNow(request);
            return response.getUpshot();
        }catch( Exception e ){
            logger.log(Level.SEVERE, "request failed: " + e.getMessage());
            return false;
        }
    }//getUserActiveAuctions
}//ArticleClient
