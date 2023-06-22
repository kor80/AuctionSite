package auction.service;

import auction.managment.*;
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

    public ArticleService(){
        //TODO set memory manager factoru
        memoryManager = MemoryManager.getInstance();
        searchManager = SearchManager.getInstance();
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
        }
        catch( Exception e ){
            responseObserver.onError(
                    Status.INTERNAL
                            .withDescription(e.getMessage())
                            .asRuntimeException()
            );
            return;
        }
        logger.info("Articles found");
    }//searchArticle

}//ArticleService
