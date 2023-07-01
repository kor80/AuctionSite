package auction.service;

import auction.model.ClientServiceGrpc;
import auction.model.OfferChangedRequest;
import auction.model.OfferChangedResponse;
import auction.model.auctions.AuctionInfo;
import io.grpc.Context;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;

import java.util.logging.Logger;

public class ClientService extends ClientServiceGrpc.ClientServiceImplBase
{
    private static final Logger logger = Logger.getLogger(ArticleService.class.getName());

    private final ArticleClient client;

    public ClientService(ArticleClient client){
        this.client = client;
    }

    @Override
    public void offerChanged(OfferChangedRequest request, StreamObserver<OfferChangedResponse> responseObserver){
        AuctionInfo info = request.getInfo();
        logger.info("offer for auction  "+info.getArticleId()+" is changed. Now the current winner is "+info.getCurrentWinner()+
                " and the current offer is "+info.getCurrentOffer());

        client.updateOffer(info);

        if(Context.current().isCancelled()){
            logger.info("request is cancelled");
            responseObserver.onError(
                    Status.CANCELLED
                            .withDescription("request is cancelled")
                            .asRuntimeException()
            );
            OfferChangedResponse response = OfferChangedResponse.newBuilder().setUpshot(false).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
            return;
        }

        try{
            OfferChangedResponse response = OfferChangedResponse.newBuilder().setUpshot(true).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
        catch( Exception e ){
            responseObserver.onError(
                    Status.INTERNAL
                            .withDescription(e.getMessage())
                            .asRuntimeException()
            );
            OfferChangedResponse response = OfferChangedResponse.newBuilder().setUpshot(false).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
            return;
        }
    }//offerChanged
}//ClientService
