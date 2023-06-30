package auction.managment.memory.builder.reader;

import auction.managment.auctions.AuctionInfo;
import auction.managment.auctions.RegistrationInfo;

public interface ArrayReader
{
    int openMemory();
    RegistrationInfo readRegistration(int index);
    AuctionInfo readClosedAuction(int index);
}//ArrayReader
