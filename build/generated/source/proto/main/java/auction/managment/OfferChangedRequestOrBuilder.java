// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: client_service.proto

package auction.managment;

public interface OfferChangedRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:auction.OfferChangedRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.auction.AuctionInfo info = 1;</code>
   * @return Whether the info field is set.
   */
  boolean hasInfo();
  /**
   * <code>.auction.AuctionInfo info = 1;</code>
   * @return The info.
   */
  auction.managment.auctions.AuctionInfo getInfo();
  /**
   * <code>.auction.AuctionInfo info = 1;</code>
   */
  auction.managment.auctions.AuctionInfoOrBuilder getInfoOrBuilder();
}
