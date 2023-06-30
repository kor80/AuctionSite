package auction.managment.auctions;

public interface AuctionIF
{
    void addListener(RegistrationInfo info);
    void removeListener(RegistrationInfo info);
    boolean makeOffer(double amount, String user);
    boolean buyNow(String user);
    void startTimer();
    void close();
}//AuctionIF
