// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: auction_info.proto

package auction.managment.auctions;

public interface AuctionInfoOrBuilder extends
    // @@protoc_insertion_point(interface_extends:auction.AuctionInfo)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int32 articleId = 1;</code>
   * @return The articleId.
   */
  int getArticleId();

  /**
   * <code>double currentOffer = 2;</code>
   * @return The currentOffer.
   */
  double getCurrentOffer();

  /**
   * <code>string currentWinner = 3;</code>
   * @return The currentWinner.
   */
  java.lang.String getCurrentWinner();
  /**
   * <code>string currentWinner = 3;</code>
   * @return The bytes for currentWinner.
   */
  com.google.protobuf.ByteString
      getCurrentWinnerBytes();

  /**
   * <code>bool isOpened = 4;</code>
   * @return The isOpened.
   */
  boolean getIsOpened();

  /**
   * <code>string articleName = 5;</code>
   * @return The articleName.
   */
  java.lang.String getArticleName();
  /**
   * <code>string articleName = 5;</code>
   * @return The bytes for articleName.
   */
  com.google.protobuf.ByteString
      getArticleNameBytes();
}
