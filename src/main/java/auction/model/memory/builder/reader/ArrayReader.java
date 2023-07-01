package auction.model.memory.builder.reader;

import auction.model.auctions.AuctionInfo;
import auction.model.auctions.RegistrationInfo;

public interface ArrayReader
{
    int openMemory();
    RegistrationInfo readRegistration(int index);
    AuctionInfo readClosedAuction(int index);
}//ArrayReader
