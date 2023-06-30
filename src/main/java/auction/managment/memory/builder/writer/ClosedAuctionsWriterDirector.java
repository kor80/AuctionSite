package auction.managment.memory.builder.writer;

import auction.managment.auctions.AuctionInfo;

public class ClosedAuctionsWriterDirector
{
    MemoryWriter builder;

    public ClosedAuctionsWriterDirector(MemoryWriter builder){
        this.builder = builder;
    }

    public void save(AuctionInfo auction) {
        builder.openMemory();
        builder.saveAuctionId(auction.getArticleId());
        builder.saveWinner(auction.getCurrentWinner());
        builder.saveEndingPrice(auction.getCurrentOffer());
        builder.closeMemory();
    }//save
}
