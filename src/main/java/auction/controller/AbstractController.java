package auction.controller;

import auction.model.auctions.AuctionInfo;
import auction.view.observer.GUIObserverIF;

import java.util.concurrent.ConcurrentLinkedQueue;

public class AbstractController implements ControllerSubjectIF
{
    private ConcurrentLinkedQueue<GUIObserverIF> observers;

    protected AbstractController(){
        observers = new ConcurrentLinkedQueue<>();
    }

    @Override
    public void attach(GUIObserverIF observer){
        observers.add(observer);
    }//attach

    @Override
    public void detach(GUIObserverIF observer){
        observers.remove(observer);
    }//attach

    public void notifyListeners(AuctionInfo info){
        for( GUIObserverIF observer : observers )
            observer.updateGUI(info);
    }//notifyListeners

}//AbstractController
