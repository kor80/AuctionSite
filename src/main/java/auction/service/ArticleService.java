package auction.service;

import auction.managment.*;
import auction.managment.auctions.AuctionsManager;
import auction.managment.view.ClientRequestsHandler;
import auction.search.SearchManager;
import auction.search.decorator.SimpleSearcher;
import io.grpc.Context;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;

import java.util.logging.Logger;

public class ArticleService extends ArticleServiceGrpc.ArticleServiceImplBase
{
    private static final Logger logger = Logger.getLogger(ArticleService.class.getName());

    private final MemoryManager memoryManager;
    private final SearchManager searchManager;
    private final ClientRequestsHandler clientRequestsHandler;
    private final AuctionsManager auctionsManager;

    public ArticleService(){
        //TODO set memory manager factoru
        memoryManager = MemoryManager.getInstance();
        searchManager = SearchManager.getInstance();
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

        try{
            memoryManager.userLoadArticle(user,info);
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

        CreateArticleResponse response = CreateArticleResponse.newBuilder().setState(State.SUCCESS).build();
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
        String user = request.getUser();
        int id = request.getAuctionId();

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
                    .setUpshot(auctionsManager.registerAuction(user,id)).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
            logger.info("User "+user+" successfully registered to auction "+id);
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

}//ArticleService
