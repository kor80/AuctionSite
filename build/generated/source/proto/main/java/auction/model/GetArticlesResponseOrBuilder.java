// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: article_service.proto

package auction.model;

public interface GetArticlesResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:auction.GetArticlesResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>repeated .auction.ArticleInfo articles = 1;</code>
   */
  java.util.List<auction.model.ArticleInfo> 
      getArticlesList();
  /**
   * <code>repeated .auction.ArticleInfo articles = 1;</code>
   */
  auction.model.ArticleInfo getArticles(int index);
  /**
   * <code>repeated .auction.ArticleInfo articles = 1;</code>
   */
  int getArticlesCount();
  /**
   * <code>repeated .auction.ArticleInfo articles = 1;</code>
   */
  java.util.List<? extends auction.model.ArticleInfoOrBuilder> 
      getArticlesOrBuilderList();
  /**
   * <code>repeated .auction.ArticleInfo articles = 1;</code>
   */
  auction.model.ArticleInfoOrBuilder getArticlesOrBuilder(
      int index);
}
