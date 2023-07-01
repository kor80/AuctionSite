package auction.controller;

import auction.model.auctions.AuctionInfo;
import auction.view.observer.GUIObserverIF;

public interface ControllerSubjectIF
{
    void attach(GUIObserverIF observer);
    void detach(GUIObserverIF observer);
    void notifyListeners(AuctionInfo info);
}//ControllerSubjectIF
