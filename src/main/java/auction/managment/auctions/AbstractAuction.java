package auction.managment.auctions;

import auction.managment.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public abstract class AbstractAuction implements AuctionIF
{
    protected int id;
    protected double currentOffer;
    protected String currentWinner;
    protected boolean isOpened;

    private ConcurrentHashMap<String,ClientServiceGrpc.ClientServiceBlockingStub> listeners = new ConcurrentHashMap<>();

    @Override
    public void addListener(RegistrationInfo info) {
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress(info.getUserIP(), info.getUserPort())
                .usePlaintext().build();

        listeners.put(info.getUser(),ClientServiceGrpc.newBlockingStub(channel));
    }//addListener

    @Override
    public void removeListener(RegistrationInfo info){
        listeners.remove(info.getUser());
    }//removeListener

    protected void removeAllListeners(){
        listeners.clear();
    }//removeAllListeners

    protected void notifyListeners(){
        AuctionInfo info = AuctionInfo.newBuilder().setArticleId(id)
                .setCurrentOffer(currentOffer)
                .setCurrentWinner(currentWinner)
                .setIsOpened(isOpened)
                .build();

        OfferChangedRequest request = OfferChangedRequest.newBuilder()
                .setInfo(info).build();

        for(Map.Entry<String, ClientServiceGrpc.ClientServiceBlockingStub> entry : listeners.entrySet() ){
            try {
                entry.getValue().withDeadlineAfter(5, TimeUnit.SECONDS).offerChanged(request);
            }catch( Exception e ){
                System.out.println("Cannot contact user "+entry.getValue());
            }
        }
    }//notifyListeners

    public double getCurrentOffer(){ return currentOffer; }
    public String getCurrentWinner(){ return currentWinner; }
    public synchronized boolean isOpened(){ return isOpened; }
}//AbstractAuction
