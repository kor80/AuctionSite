package auction.service;

import auction.managment.*;
import io.grpc.Context;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;

import java.util.logging.Logger;

public class ArticleService extends ArticleServiceGrpc.ArticleServiceImplBase
{
    private static final Logger logger = Logger.getLogger(ArticleService.class.getName());

    private final MemoryManager memoryManager;

    public ArticleService(){
        //TODO set memory manager factoru
        memoryManager = MemoryManager.getInstance();
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
            memoryManager.saveArticle(user, info);
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

}//ArticleService
