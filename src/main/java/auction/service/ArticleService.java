package auction.service;

import auction.managment.*;
import auction.managment.auctions.AuctionsManager;
import auction.managment.auctions.RegistrationInfo;
import auction.managment.memory.MemoryManager;
import auction.managment.registrations.RegistrationManager;
import auction.managment.view.ClientRequestsHandler;
import auction.search.SearchManager;
import io.grpc.Context;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;

import java.util.logging.Logger;

public class ArticleService extends ArticleServiceGrpc.ArticleServiceImplBase
{
    private static final Logger logger = Logger.getLogger(ArticleService.class.getName());

    private final MemoryManager memoryManager;
    private final SearchManager searchManager;
    private final RegistrationManager registrationManager;
    private final ClientRequestsHandler clientRequestsHandler;
    private final AuctionsManager auctionsManager;

    public ArticleService(){
        //TODO set memory manager factoru
        memoryManager = MemoryManager.getInstance();
        searchManager = SearchManager.getInstance();
        registrationManager = RegistrationManager.getInstance();
        clientRequestsHandler = ClientRequestsHandler.getInstance();
        auctionsManager = AuctionsManager.getInstance();
    }

    @Override
    public void createArticle(CreateArticleRequest request, StreamObserver<CreateArticleResponse> responseObserver){
        String user = request.getUser();
        ArticleInfo info = request.getInfo();

        logger.info("got a create-article request from user: " + user);

        if(Context.current().isCancelled()){
            logger.info("request is cancelled");
            responseObserver.onError(
                    Status.CANCELLED
                            .withDescription("request is cancelled")
                            .asRuntimeException()
            );
            return;
        }

        boolean upshot = false;
        try{
            upshot = memoryManager.userLoadArticle(user,info);
            //memoryManager.saveArticle(user, info);
        }
        catch( Exception e ){
            responseObserver.onError(
                    Status.INTERNAL
                            .withDescription(e.getMessage())
                            .asRuntimeException()
            );
            return;
        }

        CreateArticleResponse response = CreateArticleResponse.newBuilder().setUpshot(upshot).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();

        logger.info("saved article of user: " + user);
    }//createArticle

    @Override
    public void searchArticle(SearchArticleRequest request, StreamObserver<SearchArticleResponse> responseObserver){

        logger.info("got a search-article request "+request.getInfo());

        if(Context.current().isCancelled()){
            logger.info("request is cancelled");
            responseObserver.onError(
                    Status.CANCELLED
                            .withDescription("request is cancelled")
                            .asRuntimeException()
            );
            return;
        }

        try{
            SearchArticleResponse response = SearchArticleResponse.newBuilder().addAllInfo(searchManager.search(request.getInfo())).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
            logger.info("Articles found");
        }
        catch( Exception e ){
            responseObserver.onError(
                    Status.INTERNAL
                            .withDescription(e.getMessage())
                            .asRuntimeException()
            );
            return;
        }
    }//searchArticle

    @Override
    public void getOwnedAuctions(GetOwnedAuctionRequest request, StreamObserver<GetOwnedAuctionResponse> responseObserver){
        String user = request.getUser();

        logger.info("got a get-owned-auctions request from user: "+user);

        if(Context.current().isCancelled()){
            logger.info("request is cancelled");
            responseObserver.onError(
                    Status.CANCELLED
                            .withDescription("request is cancelled")
                            .asRuntimeException()
            );
            return;
        }

        try{
            GetOwnedAuctionResponse response = GetOwnedAuctionResponse.newBuilder()
                    .addAllInfo(clientRequestsHandler.getOwnedAuctions(user)).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
            logger.info("Owned Auction returned");
        }
        catch( Exception e ){
            responseObserver.onError(
                    Status.INTERNAL
                            .withDescription(e.getMessage())
                            .asRuntimeException()
            );
            return;
        }
    }//getOwnedAuctions

    @Override
    public void registerForTheAuction(RegisterForTheAuctionRequest request, StreamObserver<RegisterForTheAuctionResponse> responseObserver){
        RegistrationInfo info = request.getInfo();
        String user = info.getUser();
        int id = info.getArticleId();

        logger.info("got a register-for-the-auction "+id+" request from user: "+user);

        if(Context.current().isCancelled()){
            logger.info("request is cancelled");
            responseObserver.onError(
                    Status.CANCELLED
                            .withDescription("request is cancelled")
                            .asRuntimeException()
            );
            return;
        }

        try{
            RegisterForTheAuctionResponse response = RegisterForTheAuctionResponse.newBuilder()
                    .setUpshot(registrationManager.registerAuction(info)).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
        catch( Exception e ){
            responseObserver.onError(
                    Status.INTERNAL
                            .withDescription(e.getMessage())
                            .asRuntimeException()
            );
            return;
        }
    }//registerForTheAuction

    @Override
    public void getUserActiveAuctions(GetUserActiveAuctionsRequest request, StreamObserver<GetUserActiveAuctionsResponse> responseObserver){
        String user = request.getUser();

        logger.info("got a get-active-auction-request from user: "+user);

        if(Context.current().isCancelled()){
            logger.info("request is cancelled");
            responseObserver.onError(
                    Status.CANCELLED
                            .withDescription("request is cancelled")
                            .asRuntimeException()
            );
            return;
        }

        try{
            GetUserActiveAuctionsResponse response = GetUserActiveAuctionsResponse.newBuilder()
                    .addAllInfo(auctionsManager.getUserActiveAuctions(user)).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
            logger.info("User "+user+" gets all his active auctions");
        }
        catch( Exception e ){
            responseObserver.onError(
                    Status.INTERNAL
                            .withDescription(e.getMessage())
                            .asRuntimeException()
            );
            return;
        }
    }//getUserActiveAuctions

    @Override
    public void getRegisteredAuctions(GetRegisteredAuctionsRequest request, StreamObserver<GetRegisteredAuctionsResponse> responseObserver){
        String user = request.getUser();

        logger.info("got a get-registered-auction-request from user: "+user);

        if(Context.current().isCancelled()){
            logger.info("request is cancelled");
            responseObserver.onError(
                    Status.CANCELLED
                            .withDescription("request is cancelled")
                            .asRuntimeException()
            );
            return;
        }

        try{
            GetRegisteredAuctionsResponse response = GetRegisteredAuctionsResponse.newBuilder()
                    .addAllInfo(registrationManager.getRegisteredAuctions(user)).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
            logger.info("User "+user+" gets all his registered auctions");
        }
        catch( Exception e ){
            responseObserver.onError(
                    Status.INTERNAL
                            .withDescription(e.getMessage())
                            .asRuntimeException()
            );
            return;
        }
    }//getUserActiveAuctions

    @Override
    public void makeOffer(MakeOfferRequest request, StreamObserver<MakeOfferResponse> responseObserver){
        String user = request.getUser();
        double amount = request.getAmount();
        int auctionID = request.getAuctionId();

        logger.info("got a make-offer-request from user: "+user+" for auction "+auctionID+" of amount "+amount);

        if(Context.current().isCancelled()){
            logger.info("request is cancelled");
            responseObserver.onError(
                    Status.CANCELLED
                            .withDescription("request is cancelled")
                            .asRuntimeException()
            );
            return;
        }

        try{
            MakeOfferResponse response = MakeOfferResponse.newBuilder()
                    .setUpshot(auctionsManager.makeOffer(auctionID,amount,user)).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
            logger.info("User "+user+" make the offer");
        }
        catch( Exception e ){
            responseObserver.onError(
                    Status.INTERNAL
                            .withDescription(e.getMessage())
                            .asRuntimeException()
            );
            return;
        }
    }//makeOffer

    @Override
    public void getClosedAuctions(GetClosedAuctionsRequest request, StreamObserver<GetClosedAuctionsResponse> responseObserver){
        String user = request.getUser();

        logger.info("got a get-closed-auctions-request from user: "+user);

        if(Context.current().isCancelled()){
            logger.info("request is cancelled");
            responseObserver.onError(
                    Status.CANCELLED
                            .withDescription("request is cancelled")
                            .asRuntimeException()
            );
            return;
        }

        try{
            GetClosedAuctionsResponse response = GetClosedAuctionsResponse.newBuilder()
                    .addAllInfo(clientRequestsHandler.getClosedAuctions(user)).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
            logger.info("User "+user+" gets the closed auctions");
        }
        catch( Exception e ){
            responseObserver.onError(
                    Status.INTERNAL
                            .withDescription(e.getMessage())
                            .asRuntimeException()
            );
            return;
        }
    }//getClosedAuctions

    @Override
    public void buyNow(BuyNowRequest request, StreamObserver<BuyNowResponse> responseObserver ){
        int auctionId = request.getAuctionId();
        String user = request.getUser();

        logger.info("got a get-buy-now-request from user: "+user+" for auction "+1);

        if(Context.current().isCancelled()){
            logger.info("request is cancelled");
            responseObserver.onError(
                    Status.CANCELLED
                            .withDescription("request is cancelled")
                            .asRuntimeException()
            );
            return;
        }

        try{
            BuyNowResponse response = BuyNowResponse.newBuilder()
                    .setUpshot(auctionsManager.buyNow(auctionId,user)).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
            logger.info("User "+user+" buy now auction "+auctionId);
        }
        catch( Exception e ){
            responseObserver.onError(
                    Status.INTERNAL
                            .withDescription(e.getMessage())
                            .asRuntimeException()
            );
            return;
        }
    }//buyNow
}//ArticleService
