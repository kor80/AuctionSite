// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: article_info.proto

package auction.managment;

public final class ArticleInfoOuterClass {
  private ArticleInfoOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_auction_Date_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_auction_Date_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_auction_Time_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_auction_Time_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_auction_ArticleInfo_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_auction_ArticleInfo_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\022article_info.proto\022\007auction\"0\n\004Date\022\014\n" +
      "\004year\030\001 \001(\005\022\r\n\005month\030\002 \001(\005\022\013\n\003day\030\003 \001(\005\"" +
      "%\n\004Time\022\014\n\004hour\030\001 \001(\005\022\017\n\007minutes\030\002 \001(\005\"\234" +
      "\002\n\013ArticleInfo\022\014\n\004name\030\001 \001(\t\022#\n\014starting" +
      "Date\030\002 \001(\0132\r.auction.Date\022!\n\nendingDate\030" +
      "\003 \001(\0132\r.auction.Date\022#\n\014startingTime\030\004 \001" +
      "(\0132\r.auction.Time\022!\n\nendingTime\030\005 \001(\0132\r." +
      "auction.Time\022\025\n\rstartingPrice\030\006 \001(\001\022\023\n\013b" +
      "uyNowPrice\030\007 \001(\001\022\"\n\004type\030\010 \001(\0162\024.auction" +
      ".ArticleType\022\023\n\013description\030\t \001(\t\022\n\n\002id\030" +
      "\n \001(\005*]\n\013ArticleType\022\013\n\007UNKNOWN\020\000\022\010\n\004TEC" +
      "H\020\001\022\010\n\004HOME\020\002\022\t\n\005BOOKS\020\003\022\t\n\005GAMES\020\004\022\t\n\005S" +
      "PORT\020\005\022\014\n\010CLOTHING\020\006B\025\n\021auction.managmen" +
      "tP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_auction_Date_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_auction_Date_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_auction_Date_descriptor,
        new java.lang.String[] { "Year", "Month", "Day", });
    internal_static_auction_Time_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_auction_Time_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_auction_Time_descriptor,
        new java.lang.String[] { "Hour", "Minutes", });
    internal_static_auction_ArticleInfo_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_auction_ArticleInfo_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_auction_ArticleInfo_descriptor,
        new java.lang.String[] { "Name", "StartingDate", "EndingDate", "StartingTime", "EndingTime", "StartingPrice", "BuyNowPrice", "Type", "Description", "Id", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
