// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: article_service.proto

package auction.model;

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
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_auction_GetOwnedAuctionRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_auction_GetOwnedAuctionRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_auction_GetOwnedAuctionResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_auction_GetOwnedAuctionResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_auction_RegisterForTheAuctionRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_auction_RegisterForTheAuctionRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_auction_RegisterForTheAuctionResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_auction_RegisterForTheAuctionResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_auction_GetUserActiveAuctionsRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_auction_GetUserActiveAuctionsRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_auction_GetUserActiveAuctionsResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_auction_GetUserActiveAuctionsResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_auction_GetRegisteredAuctionsRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_auction_GetRegisteredAuctionsRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_auction_GetRegisteredAuctionsResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_auction_GetRegisteredAuctionsResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_auction_GetClosedAuctionsRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_auction_GetClosedAuctionsRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_auction_GetClosedAuctionsResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_auction_GetClosedAuctionsResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_auction_MakeOfferRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_auction_MakeOfferRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_auction_MakeOfferResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_auction_MakeOfferResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_auction_BuyNowRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_auction_BuyNowRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_auction_BuyNowResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_auction_BuyNowResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\025article_service.proto\022\007auction\032\022articl" +
      "e_info.proto\032\021search_info.proto\032\027registr" +
      "ation_info.proto\032\022auction_info.proto\"H\n\024" +
      "CreateArticleRequest\022\014\n\004user\030\001 \001(\t\022\"\n\004in" +
      "fo\030\002 \001(\0132\024.auction.ArticleInfo\"\'\n\025Create" +
      "ArticleResponse\022\016\n\006upshot\030\001 \001(\010\"9\n\024Searc" +
      "hArticleRequest\022!\n\004info\030\001 \001(\0132\023.auction." +
      "SearchInfo\";\n\025SearchArticleResponse\022\"\n\004i" +
      "nfo\030\001 \003(\0132\024.auction.ArticleInfo\"&\n\026GetOw" +
      "nedAuctionRequest\022\014\n\004user\030\001 \001(\t\"=\n\027GetOw" +
      "nedAuctionResponse\022\"\n\004info\030\001 \003(\0132\024.aucti" +
      "on.AuctionInfo\"G\n\034RegisterForTheAuctionR" +
      "equest\022\'\n\004info\030\001 \001(\0132\031.auction.Registrat" +
      "ionInfo\"/\n\035RegisterForTheAuctionResponse" +
      "\022\016\n\006upshot\030\001 \001(\010\",\n\034GetUserActiveAuction" +
      "sRequest\022\014\n\004user\030\001 \001(\t\"C\n\035GetUserActiveA" +
      "uctionsResponse\022\"\n\004info\030\001 \003(\0132\024.auction." +
      "AuctionInfo\",\n\034GetRegisteredAuctionsRequ" +
      "est\022\014\n\004user\030\001 \001(\t\"C\n\035GetRegisteredAuctio" +
      "nsResponse\022\"\n\004info\030\001 \003(\0132\024.auction.Artic" +
      "leInfo\"(\n\030GetClosedAuctionsRequest\022\014\n\004us" +
      "er\030\001 \001(\t\"?\n\031GetClosedAuctionsResponse\022\"\n" +
      "\004info\030\001 \003(\0132\024.auction.AuctionInfo\"C\n\020Mak" +
      "eOfferRequest\022\021\n\tauctionId\030\001 \001(\005\022\016\n\006amou" +
      "nt\030\002 \001(\001\022\014\n\004user\030\003 \001(\t\"#\n\021MakeOfferRespo" +
      "nse\022\016\n\006upshot\030\001 \001(\010\"0\n\rBuyNowRequest\022\021\n\t" +
      "auctionId\030\001 \001(\005\022\014\n\004user\030\002 \001(\t\" \n\016BuyNowR" +
      "esponse\022\016\n\006upshot\030\001 \001(\0102\254\006\n\016ArticleServi" +
      "ce\022P\n\rCreateArticle\022\035.auction.CreateArti" +
      "cleRequest\032\036.auction.CreateArticleRespon" +
      "se\"\000\022P\n\rSearchArticle\022\035.auction.SearchAr" +
      "ticleRequest\032\036.auction.SearchArticleResp" +
      "onse\"\000\022W\n\020GetOwnedAuctions\022\037.auction.Get" +
      "OwnedAuctionRequest\032 .auction.GetOwnedAu" +
      "ctionResponse\"\000\022h\n\025RegisterForTheAuction" +
      "\022%.auction.RegisterForTheAuctionRequest\032" +
      "&.auction.RegisterForTheAuctionResponse\"" +
      "\000\022h\n\025GetUserActiveAuctions\022%.auction.Get" +
      "UserActiveAuctionsRequest\032&.auction.GetU" +
      "serActiveAuctionsResponse\"\000\022h\n\025GetRegist" +
      "eredAuctions\022%.auction.GetRegisteredAuct" +
      "ionsRequest\032&.auction.GetRegisteredAucti" +
      "onsResponse\"\000\022D\n\tMakeOffer\022\031.auction.Mak" +
      "eOfferRequest\032\032.auction.MakeOfferRespons" +
      "e\"\000\022\\\n\021GetClosedAuctions\022!.auction.GetCl" +
      "osedAuctionsRequest\032\".auction.GetClosedA" +
      "uctionsResponse\"\000\022;\n\006BuyNow\022\026.auction.Bu" +
      "yNowRequest\032\027.auction.BuyNowResponse\"\000B\021" +
      "\n\rauction.modelP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          auction.model.ArticleInfoOuterClass.getDescriptor(),
          auction.search.SearchInfoOuterClass.getDescriptor(),
          auction.model.auctions.RegistrationInfoOuterClass.getDescriptor(),
          auction.model.auctions.AuctionInfoOuterClass.getDescriptor(),
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
        new java.lang.String[] { "Upshot", });
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
    internal_static_auction_GetOwnedAuctionRequest_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_auction_GetOwnedAuctionRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_auction_GetOwnedAuctionRequest_descriptor,
        new java.lang.String[] { "User", });
    internal_static_auction_GetOwnedAuctionResponse_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_auction_GetOwnedAuctionResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_auction_GetOwnedAuctionResponse_descriptor,
        new java.lang.String[] { "Info", });
    internal_static_auction_RegisterForTheAuctionRequest_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_auction_RegisterForTheAuctionRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_auction_RegisterForTheAuctionRequest_descriptor,
        new java.lang.String[] { "Info", });
    internal_static_auction_RegisterForTheAuctionResponse_descriptor =
      getDescriptor().getMessageTypes().get(7);
    internal_static_auction_RegisterForTheAuctionResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_auction_RegisterForTheAuctionResponse_descriptor,
        new java.lang.String[] { "Upshot", });
    internal_static_auction_GetUserActiveAuctionsRequest_descriptor =
      getDescriptor().getMessageTypes().get(8);
    internal_static_auction_GetUserActiveAuctionsRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_auction_GetUserActiveAuctionsRequest_descriptor,
        new java.lang.String[] { "User", });
    internal_static_auction_GetUserActiveAuctionsResponse_descriptor =
      getDescriptor().getMessageTypes().get(9);
    internal_static_auction_GetUserActiveAuctionsResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_auction_GetUserActiveAuctionsResponse_descriptor,
        new java.lang.String[] { "Info", });
    internal_static_auction_GetRegisteredAuctionsRequest_descriptor =
      getDescriptor().getMessageTypes().get(10);
    internal_static_auction_GetRegisteredAuctionsRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_auction_GetRegisteredAuctionsRequest_descriptor,
        new java.lang.String[] { "User", });
    internal_static_auction_GetRegisteredAuctionsResponse_descriptor =
      getDescriptor().getMessageTypes().get(11);
    internal_static_auction_GetRegisteredAuctionsResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_auction_GetRegisteredAuctionsResponse_descriptor,
        new java.lang.String[] { "Info", });
    internal_static_auction_GetClosedAuctionsRequest_descriptor =
      getDescriptor().getMessageTypes().get(12);
    internal_static_auction_GetClosedAuctionsRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_auction_GetClosedAuctionsRequest_descriptor,
        new java.lang.String[] { "User", });
    internal_static_auction_GetClosedAuctionsResponse_descriptor =
      getDescriptor().getMessageTypes().get(13);
    internal_static_auction_GetClosedAuctionsResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_auction_GetClosedAuctionsResponse_descriptor,
        new java.lang.String[] { "Info", });
    internal_static_auction_MakeOfferRequest_descriptor =
      getDescriptor().getMessageTypes().get(14);
    internal_static_auction_MakeOfferRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_auction_MakeOfferRequest_descriptor,
        new java.lang.String[] { "AuctionId", "Amount", "User", });
    internal_static_auction_MakeOfferResponse_descriptor =
      getDescriptor().getMessageTypes().get(15);
    internal_static_auction_MakeOfferResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_auction_MakeOfferResponse_descriptor,
        new java.lang.String[] { "Upshot", });
    internal_static_auction_BuyNowRequest_descriptor =
      getDescriptor().getMessageTypes().get(16);
    internal_static_auction_BuyNowRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_auction_BuyNowRequest_descriptor,
        new java.lang.String[] { "AuctionId", "User", });
    internal_static_auction_BuyNowResponse_descriptor =
      getDescriptor().getMessageTypes().get(17);
    internal_static_auction_BuyNowResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_auction_BuyNowResponse_descriptor,
        new java.lang.String[] { "Upshot", });
    auction.model.ArticleInfoOuterClass.getDescriptor();
    auction.search.SearchInfoOuterClass.getDescriptor();
    auction.model.auctions.RegistrationInfoOuterClass.getDescriptor();
    auction.model.auctions.AuctionInfoOuterClass.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}