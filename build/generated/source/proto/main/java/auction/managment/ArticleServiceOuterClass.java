// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: article_service.proto

package auction.managment;

public final class ArticleServiceOuterClass {
  private ArticleServiceOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_auction_CreateArticleRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_auction_CreateArticleRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_auction_CreateArticleResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_auction_CreateArticleResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_auction_SearchArticleRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_auction_SearchArticleRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_auction_SearchArticleResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_auction_SearchArticleResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\025article_service.proto\022\007auction\032\022articl" +
      "e_info.proto\032\021search_info.proto\"H\n\024Creat" +
      "eArticleRequest\022\014\n\004user\030\001 \001(\t\022\"\n\004info\030\002 " +
      "\001(\0132\024.auction.ArticleInfo\"6\n\025CreateArtic" +
      "leResponse\022\035\n\005state\030\001 \001(\0162\016.auction.Stat" +
      "e\"9\n\024SearchArticleRequest\022!\n\004info\030\001 \001(\0132" +
      "\023.auction.SearchInfo\";\n\025SearchArticleRes" +
      "ponse\022\"\n\004info\030\001 \003(\0132\024.auction.ArticleInf" +
      "o*\037\n\005State\022\013\n\007SUCCESS\020\000\022\t\n\005ERROR\020\0012\264\001\n\016A" +
      "rticleService\022P\n\rCreateArticle\022\035.auction" +
      ".CreateArticleRequest\032\036.auction.CreateAr" +
      "ticleResponse\"\000\022P\n\rSearchArticle\022\035.aucti" +
      "on.SearchArticleRequest\032\036.auction.Search" +
      "ArticleResponse\"\000B\025\n\021auction.managmentP\001" +
      "b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          auction.managment.ArticleInfoOuterClass.getDescriptor(),
          auction.search.SearchInfoOuterClass.getDescriptor(),
        });
    internal_static_auction_CreateArticleRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_auction_CreateArticleRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_auction_CreateArticleRequest_descriptor,
        new java.lang.String[] { "User", "Info", });
    internal_static_auction_CreateArticleResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_auction_CreateArticleResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_auction_CreateArticleResponse_descriptor,
        new java.lang.String[] { "State", });
    internal_static_auction_SearchArticleRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_auction_SearchArticleRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_auction_SearchArticleRequest_descriptor,
        new java.lang.String[] { "Info", });
    internal_static_auction_SearchArticleResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_auction_SearchArticleResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_auction_SearchArticleResponse_descriptor,
        new java.lang.String[] { "Info", });
    auction.managment.ArticleInfoOuterClass.getDescriptor();
    auction.search.SearchInfoOuterClass.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
