// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: client_service.proto

package auction.model;

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
  auction.model.auctions.AuctionInfo getInfo();
  /**
   * <code>.auction.AuctionInfo info = 1;</code>
   */
  auction.model.auctions.AuctionInfoOrBuilder getInfoOrBuilder();
}