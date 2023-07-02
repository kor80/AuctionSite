package auction.model.memory.builder.writer;

import auction.model.auctions.AuctionInfo;

/**
 * <h1>Closed Auctions  Writer Director</h1>
 * This class specifies the right instructions
 * for writing a closed auction in the database.
 *
 * @author Cosimo Russo
 * @version 1.0
 */
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
