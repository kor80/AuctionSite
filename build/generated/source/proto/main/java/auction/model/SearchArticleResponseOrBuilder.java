// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: article_service.proto

package auction.model;

public interface SearchArticleResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:auction.SearchArticleResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>repeated .auction.ArticleInfo info = 1;</code>
   */
  java.util.List<auction.model.ArticleInfo> 
      getInfoList();
  /**
   * <code>repeated .auction.ArticleInfo info = 1;</code>
   */
  auction.model.ArticleInfo getInfo(int index);
  /**
   * <code>repeated .auction.ArticleInfo info = 1;</code>
   */
  int getInfoCount();
  /**
   * <code>repeated .auction.ArticleInfo info = 1;</code>
   */
  java.util.List<? extends auction.model.ArticleInfoOrBuilder> 
      getInfoOrBuilderList();
  /**
   * <code>repeated .auction.ArticleInfo info = 1;</code>
   */
  auction.model.ArticleInfoOrBuilder getInfoOrBuilder(
      int index);
}
