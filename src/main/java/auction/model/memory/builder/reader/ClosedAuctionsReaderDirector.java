package auction.model.memory.builder.reader;

import auction.model.auctions.AuctionInfo;

import java.util.Collection;
import java.util.LinkedList;

public class ClosedAuctionsReaderDirector
{
    private ArrayReader builder;

    public ClosedAuctionsReaderDirector(ArrayReader builder){
        this.builder = builder;
    }

    public Collection<AuctionInfo> buildMemory(){
        LinkedList<AuctionInfo> ret = new LinkedList<>();
        int numArticles = builder.openMemory();
        for( int i=0; i<numArticles; i++){
            ret.add(builder.readClosedAuction(i));
        }
        return ret;
    }//buildMemory
}//ClosedAuctionsReaderDirector
