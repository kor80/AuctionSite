// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: article_service.proto

package auction.managment;

public interface GetRegisteredAuctionsResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:auction.GetRegisteredAuctionsResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>repeated .auction.ArticleInfo info = 1;</code>
   */
  java.util.List<auction.managment.ArticleInfo> 
      getInfoList();
  /**
   * <code>repeated .auction.ArticleInfo info = 1;</code>
   */
  auction.managment.ArticleInfo getInfo(int index);
  /**
   * <code>repeated .auction.ArticleInfo info = 1;</code>
   */
  int getInfoCount();
  /**
   * <code>repeated .auction.ArticleInfo info = 1;</code>
   */
  java.util.List<? extends auction.managment.ArticleInfoOrBuilder> 
      getInfoOrBuilderList();
  /**
   * <code>repeated .auction.ArticleInfo info = 1;</code>
   */
  auction.managment.ArticleInfoOrBuilder getInfoOrBuilder(
      int index);
}
