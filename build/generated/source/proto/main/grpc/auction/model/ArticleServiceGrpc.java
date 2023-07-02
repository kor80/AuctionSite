package auction.model;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.55.1)",
    comments = "Source: article_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ArticleServiceGrpc {

  private ArticleServiceGrpc() {}

  public static final String SERVICE_NAME = "auction.ArticleService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<auction.model.CreateArticleRequest,
      auction.model.CreateArticleResponse> getCreateArticleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateArticle",
      requestType = auction.model.CreateArticleRequest.class,
      responseType = auction.model.CreateArticleResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<auction.model.CreateArticleRequest,
      auction.model.CreateArticleResponse> getCreateArticleMethod() {
    io.grpc.MethodDescriptor<auction.model.CreateArticleRequest, auction.model.CreateArticleResponse> getCreateArticleMethod;
    if ((getCreateArticleMethod = ArticleServiceGrpc.getCreateArticleMethod) == null) {
      synchronized (ArticleServiceGrpc.class) {
        if ((getCreateArticleMethod = ArticleServiceGrpc.getCreateArticleMethod) == null) {
          ArticleServiceGrpc.getCreateArticleMethod = getCreateArticleMethod =
              io.grpc.MethodDescriptor.<auction.model.CreateArticleRequest, auction.model.CreateArticleResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateArticle"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  auction.model.CreateArticleRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  auction.model.CreateArticleResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ArticleServiceMethodDescriptorSupplier("CreateArticle"))
              .build();
        }
      }
    }
    return getCreateArticleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<auction.model.SearchArticleRequest,
      auction.model.SearchArticleResponse> getSearchArticleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SearchArticle",
      requestType = auction.model.SearchArticleRequest.class,
      responseType = auction.model.SearchArticleResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<auction.model.SearchArticleRequest,
      auction.model.SearchArticleResponse> getSearchArticleMethod() {
    io.grpc.MethodDescriptor<auction.model.SearchArticleRequest, auction.model.SearchArticleResponse> getSearchArticleMethod;
    if ((getSearchArticleMethod = ArticleServiceGrpc.getSearchArticleMethod) == null) {
      synchronized (ArticleServiceGrpc.class) {
        if ((getSearchArticleMethod = ArticleServiceGrpc.getSearchArticleMethod) == null) {
          ArticleServiceGrpc.getSearchArticleMethod = getSearchArticleMethod =
              io.grpc.MethodDescriptor.<auction.model.SearchArticleRequest, auction.model.SearchArticleResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SearchArticle"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  auction.model.SearchArticleRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  auction.model.SearchArticleResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ArticleServiceMethodDescriptorSupplier("SearchArticle"))
              .build();
        }
      }
    }
    return getSearchArticleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<auction.model.GetOwnedAuctionRequest,
      auction.model.GetOwnedAuctionResponse> getGetOwnedAuctionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetOwnedAuctions",
      requestType = auction.model.GetOwnedAuctionRequest.class,
      responseType = auction.model.GetOwnedAuctionResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<auction.model.GetOwnedAuctionRequest,
      auction.model.GetOwnedAuctionResponse> getGetOwnedAuctionsMethod() {
    io.grpc.MethodDescriptor<auction.model.GetOwnedAuctionRequest, auction.model.GetOwnedAuctionResponse> getGetOwnedAuctionsMethod;
    if ((getGetOwnedAuctionsMethod = ArticleServiceGrpc.getGetOwnedAuctionsMethod) == null) {
      synchronized (ArticleServiceGrpc.class) {
        if ((getGetOwnedAuctionsMethod = ArticleServiceGrpc.getGetOwnedAuctionsMethod) == null) {
          ArticleServiceGrpc.getGetOwnedAuctionsMethod = getGetOwnedAuctionsMethod =
              io.grpc.MethodDescriptor.<auction.model.GetOwnedAuctionRequest, auction.model.GetOwnedAuctionResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetOwnedAuctions"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  auction.model.GetOwnedAuctionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  auction.model.GetOwnedAuctionResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ArticleServiceMethodDescriptorSupplier("GetOwnedAuctions"))
              .build();
        }
      }
    }
    return getGetOwnedAuctionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<auction.model.RegisterForTheAuctionRequest,
      auction.model.RegisterForTheAuctionResponse> getRegisterForTheAuctionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RegisterForTheAuction",
      requestType = auction.model.RegisterForTheAuctionRequest.class,
      responseType = auction.model.RegisterForTheAuctionResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<auction.model.RegisterForTheAuctionRequest,
      auction.model.RegisterForTheAuctionResponse> getRegisterForTheAuctionMethod() {
    io.grpc.MethodDescriptor<auction.model.RegisterForTheAuctionRequest, auction.model.RegisterForTheAuctionResponse> getRegisterForTheAuctionMethod;
    if ((getRegisterForTheAuctionMethod = ArticleServiceGrpc.getRegisterForTheAuctionMethod) == null) {
      synchronized (ArticleServiceGrpc.class) {
        if ((getRegisterForTheAuctionMethod = ArticleServiceGrpc.getRegisterForTheAuctionMethod) == null) {
          ArticleServiceGrpc.getRegisterForTheAuctionMethod = getRegisterForTheAuctionMethod =
              io.grpc.MethodDescriptor.<auction.model.RegisterForTheAuctionRequest, auction.model.RegisterForTheAuctionResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RegisterForTheAuction"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  auction.model.RegisterForTheAuctionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  auction.model.RegisterForTheAuctionResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ArticleServiceMethodDescriptorSupplier("RegisterForTheAuction"))
              .build();
        }
      }
    }
    return getRegisterForTheAuctionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<auction.model.GetUserActiveAuctionsRequest,
      auction.model.GetUserActiveAuctionsResponse> getGetUserActiveAuctionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetUserActiveAuctions",
      requestType = auction.model.GetUserActiveAuctionsRequest.class,
      responseType = auction.model.GetUserActiveAuctionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<auction.model.GetUserActiveAuctionsRequest,
      auction.model.GetUserActiveAuctionsResponse> getGetUserActiveAuctionsMethod() {
    io.grpc.MethodDescriptor<auction.model.GetUserActiveAuctionsRequest, auction.model.GetUserActiveAuctionsResponse> getGetUserActiveAuctionsMethod;
    if ((getGetUserActiveAuctionsMethod = ArticleServiceGrpc.getGetUserActiveAuctionsMethod) == null) {
      synchronized (ArticleServiceGrpc.class) {
        if ((getGetUserActiveAuctionsMethod = ArticleServiceGrpc.getGetUserActiveAuctionsMethod) == null) {
          ArticleServiceGrpc.getGetUserActiveAuctionsMethod = getGetUserActiveAuctionsMethod =
              io.grpc.MethodDescriptor.<auction.model.GetUserActiveAuctionsRequest, auction.model.GetUserActiveAuctionsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetUserActiveAuctions"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  auction.model.GetUserActiveAuctionsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  auction.model.GetUserActiveAuctionsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ArticleServiceMethodDescriptorSupplier("GetUserActiveAuctions"))
              .build();
        }
      }
    }
    return getGetUserActiveAuctionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<auction.model.GetRegisteredAuctionsRequest,
      auction.model.GetRegisteredAuctionsResponse> getGetRegisteredAuctionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetRegisteredAuctions",
      requestType = auction.model.GetRegisteredAuctionsRequest.class,
      responseType = auction.model.GetRegisteredAuctionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<auction.model.GetRegisteredAuctionsRequest,
      auction.model.GetRegisteredAuctionsResponse> getGetRegisteredAuctionsMethod() {
    io.grpc.MethodDescriptor<auction.model.GetRegisteredAuctionsRequest, auction.model.GetRegisteredAuctionsResponse> getGetRegisteredAuctionsMethod;
    if ((getGetRegisteredAuctionsMethod = ArticleServiceGrpc.getGetRegisteredAuctionsMethod) == null) {
      synchronized (ArticleServiceGrpc.class) {
        if ((getGetRegisteredAuctionsMethod = ArticleServiceGrpc.getGetRegisteredAuctionsMethod) == null) {
          ArticleServiceGrpc.getGetRegisteredAuctionsMethod = getGetRegisteredAuctionsMethod =
              io.grpc.MethodDescriptor.<auction.model.GetRegisteredAuctionsRequest, auction.model.GetRegisteredAuctionsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetRegisteredAuctions"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  auction.model.GetRegisteredAuctionsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  auction.model.GetRegisteredAuctionsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ArticleServiceMethodDescriptorSupplier("GetRegisteredAuctions"))
              .build();
        }
      }
    }
    return getGetRegisteredAuctionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<auction.model.MakeOfferRequest,
      auction.model.MakeOfferResponse> getMakeOfferMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "MakeOffer",
      requestType = auction.model.MakeOfferRequest.class,
      responseType = auction.model.MakeOfferResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<auction.model.MakeOfferRequest,
      auction.model.MakeOfferResponse> getMakeOfferMethod() {
    io.grpc.MethodDescriptor<auction.model.MakeOfferRequest, auction.model.MakeOfferResponse> getMakeOfferMethod;
    if ((getMakeOfferMethod = ArticleServiceGrpc.getMakeOfferMethod) == null) {
      synchronized (ArticleServiceGrpc.class) {
        if ((getMakeOfferMethod = ArticleServiceGrpc.getMakeOfferMethod) == null) {
          ArticleServiceGrpc.getMakeOfferMethod = getMakeOfferMethod =
              io.grpc.MethodDescriptor.<auction.model.MakeOfferRequest, auction.model.MakeOfferResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "MakeOffer"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  auction.model.MakeOfferRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  auction.model.MakeOfferResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ArticleServiceMethodDescriptorSupplier("MakeOffer"))
              .build();
        }
      }
    }
    return getMakeOfferMethod;
  }

  private static volatile io.grpc.MethodDescriptor<auction.model.GetClosedAuctionsRequest,
      auction.model.GetClosedAuctionsResponse> getGetClosedAuctionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetClosedAuctions",
      requestType = auction.model.GetClosedAuctionsRequest.class,
      responseType = auction.model.GetClosedAuctionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<auction.model.GetClosedAuctionsRequest,
      auction.model.GetClosedAuctionsResponse> getGetClosedAuctionsMethod() {
    io.grpc.MethodDescriptor<auction.model.GetClosedAuctionsRequest, auction.model.GetClosedAuctionsResponse> getGetClosedAuctionsMethod;
    if ((getGetClosedAuctionsMethod = ArticleServiceGrpc.getGetClosedAuctionsMethod) == null) {
      synchronized (ArticleServiceGrpc.class) {
        if ((getGetClosedAuctionsMethod = ArticleServiceGrpc.getGetClosedAuctionsMethod) == null) {
          ArticleServiceGrpc.getGetClosedAuctionsMethod = getGetClosedAuctionsMethod =
              io.grpc.MethodDescriptor.<auction.model.GetClosedAuctionsRequest, auction.model.GetClosedAuctionsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetClosedAuctions"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  auction.model.GetClosedAuctionsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  auction.model.GetClosedAuctionsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ArticleServiceMethodDescriptorSupplier("GetClosedAuctions"))
              .build();
        }
      }
    }
    return getGetClosedAuctionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<auction.model.BuyNowRequest,
      auction.model.BuyNowResponse> getBuyNowMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BuyNow",
      requestType = auction.model.BuyNowRequest.class,
      responseType = auction.model.BuyNowResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<auction.model.BuyNowRequest,
      auction.model.BuyNowResponse> getBuyNowMethod() {
    io.grpc.MethodDescriptor<auction.model.BuyNowRequest, auction.model.BuyNowResponse> getBuyNowMethod;
    if ((getBuyNowMethod = ArticleServiceGrpc.getBuyNowMethod) == null) {
      synchronized (ArticleServiceGrpc.class) {
        if ((getBuyNowMethod = ArticleServiceGrpc.getBuyNowMethod) == null) {
          ArticleServiceGrpc.getBuyNowMethod = getBuyNowMethod =
              io.grpc.MethodDescriptor.<auction.model.BuyNowRequest, auction.model.BuyNowResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "BuyNow"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  auction.model.BuyNowRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  auction.model.BuyNowResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ArticleServiceMethodDescriptorSupplier("BuyNow"))
              .build();
        }
      }
    }
    return getBuyNowMethod;
  }

  private static volatile io.grpc.MethodDescriptor<auction.model.DeleteArticleRequest,
      auction.model.DeleteArticleResponse> getDeleteArticleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteArticle",
      requestType = auction.model.DeleteArticleRequest.class,
      responseType = auction.model.DeleteArticleResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<auction.model.DeleteArticleRequest,
      auction.model.DeleteArticleResponse> getDeleteArticleMethod() {
    io.grpc.MethodDescriptor<auction.model.DeleteArticleRequest, auction.model.DeleteArticleResponse> getDeleteArticleMethod;
    if ((getDeleteArticleMethod = ArticleServiceGrpc.getDeleteArticleMethod) == null) {
      synchronized (ArticleServiceGrpc.class) {
        if ((getDeleteArticleMethod = ArticleServiceGrpc.getDeleteArticleMethod) == null) {
          ArticleServiceGrpc.getDeleteArticleMethod = getDeleteArticleMethod =
              io.grpc.MethodDescriptor.<auction.model.DeleteArticleRequest, auction.model.DeleteArticleResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteArticle"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  auction.model.DeleteArticleRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  auction.model.DeleteArticleResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ArticleServiceMethodDescriptorSupplier("DeleteArticle"))
              .build();
        }
      }
    }
    return getDeleteArticleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<auction.model.GetArticlesRequest,
      auction.model.GetArticlesResponse> getGetArticlesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetArticles",
      requestType = auction.model.GetArticlesRequest.class,
      responseType = auction.model.GetArticlesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<auction.model.GetArticlesRequest,
      auction.model.GetArticlesResponse> getGetArticlesMethod() {
    io.grpc.MethodDescriptor<auction.model.GetArticlesRequest, auction.model.GetArticlesResponse> getGetArticlesMethod;
    if ((getGetArticlesMethod = ArticleServiceGrpc.getGetArticlesMethod) == null) {
      synchronized (ArticleServiceGrpc.class) {
        if ((getGetArticlesMethod = ArticleServiceGrpc.getGetArticlesMethod) == null) {
          ArticleServiceGrpc.getGetArticlesMethod = getGetArticlesMethod =
              io.grpc.MethodDescriptor.<auction.model.GetArticlesRequest, auction.model.GetArticlesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetArticles"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  auction.model.GetArticlesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  auction.model.GetArticlesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ArticleServiceMethodDescriptorSupplier("GetArticles"))
              .build();
        }
      }
    }
    return getGetArticlesMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ArticleServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ArticleServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ArticleServiceStub>() {
        @java.lang.Override
        public ArticleServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ArticleServiceStub(channel, callOptions);
        }
      };
    return ArticleServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ArticleServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ArticleServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ArticleServiceBlockingStub>() {
        @java.lang.Override
        public ArticleServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ArticleServiceBlockingStub(channel, callOptions);
        }
      };
    return ArticleServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ArticleServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ArticleServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ArticleServiceFutureStub>() {
        @java.lang.Override
        public ArticleServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ArticleServiceFutureStub(channel, callOptions);
        }
      };
    return ArticleServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void createArticle(auction.model.CreateArticleRequest request,
        io.grpc.stub.StreamObserver<auction.model.CreateArticleResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateArticleMethod(), responseObserver);
    }

    /**
     */
    default void searchArticle(auction.model.SearchArticleRequest request,
        io.grpc.stub.StreamObserver<auction.model.SearchArticleResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSearchArticleMethod(), responseObserver);
    }

    /**
     */
    default void getOwnedAuctions(auction.model.GetOwnedAuctionRequest request,
        io.grpc.stub.StreamObserver<auction.model.GetOwnedAuctionResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetOwnedAuctionsMethod(), responseObserver);
    }

    /**
     */
    default void registerForTheAuction(auction.model.RegisterForTheAuctionRequest request,
        io.grpc.stub.StreamObserver<auction.model.RegisterForTheAuctionResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRegisterForTheAuctionMethod(), responseObserver);
    }

    /**
     */
    default void getUserActiveAuctions(auction.model.GetUserActiveAuctionsRequest request,
        io.grpc.stub.StreamObserver<auction.model.GetUserActiveAuctionsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetUserActiveAuctionsMethod(), responseObserver);
    }

    /**
     */
    default void getRegisteredAuctions(auction.model.GetRegisteredAuctionsRequest request,
        io.grpc.stub.StreamObserver<auction.model.GetRegisteredAuctionsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetRegisteredAuctionsMethod(), responseObserver);
    }

    /**
     */
    default void makeOffer(auction.model.MakeOfferRequest request,
        io.grpc.stub.StreamObserver<auction.model.MakeOfferResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getMakeOfferMethod(), responseObserver);
    }

    /**
     */
    default void getClosedAuctions(auction.model.GetClosedAuctionsRequest request,
        io.grpc.stub.StreamObserver<auction.model.GetClosedAuctionsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetClosedAuctionsMethod(), responseObserver);
    }

    /**
     */
    default void buyNow(auction.model.BuyNowRequest request,
        io.grpc.stub.StreamObserver<auction.model.BuyNowResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getBuyNowMethod(), responseObserver);
    }

    /**
     */
    default void deleteArticle(auction.model.DeleteArticleRequest request,
        io.grpc.stub.StreamObserver<auction.model.DeleteArticleResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteArticleMethod(), responseObserver);
    }

    /**
     */
    default void getArticles(auction.model.GetArticlesRequest request,
        io.grpc.stub.StreamObserver<auction.model.GetArticlesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetArticlesMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ArticleService.
   */
  public static abstract class ArticleServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return ArticleServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ArticleService.
   */
  public static final class ArticleServiceStub
      extends io.grpc.stub.AbstractAsyncStub<ArticleServiceStub> {
    private ArticleServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ArticleServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ArticleServiceStub(channel, callOptions);
    }

    /**
     */
    public void createArticle(auction.model.CreateArticleRequest request,
        io.grpc.stub.StreamObserver<auction.model.CreateArticleResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateArticleMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void searchArticle(auction.model.SearchArticleRequest request,
        io.grpc.stub.StreamObserver<auction.model.SearchArticleResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSearchArticleMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getOwnedAuctions(auction.model.GetOwnedAuctionRequest request,
        io.grpc.stub.StreamObserver<auction.model.GetOwnedAuctionResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetOwnedAuctionsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void registerForTheAuction(auction.model.RegisterForTheAuctionRequest request,
        io.grpc.stub.StreamObserver<auction.model.RegisterForTheAuctionResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRegisterForTheAuctionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getUserActiveAuctions(auction.model.GetUserActiveAuctionsRequest request,
        io.grpc.stub.StreamObserver<auction.model.GetUserActiveAuctionsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetUserActiveAuctionsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getRegisteredAuctions(auction.model.GetRegisteredAuctionsRequest request,
        io.grpc.stub.StreamObserver<auction.model.GetRegisteredAuctionsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetRegisteredAuctionsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void makeOffer(auction.model.MakeOfferRequest request,
        io.grpc.stub.StreamObserver<auction.model.MakeOfferResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getMakeOfferMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getClosedAuctions(auction.model.GetClosedAuctionsRequest request,
        io.grpc.stub.StreamObserver<auction.model.GetClosedAuctionsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetClosedAuctionsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void buyNow(auction.model.BuyNowRequest request,
        io.grpc.stub.StreamObserver<auction.model.BuyNowResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBuyNowMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteArticle(auction.model.DeleteArticleRequest request,
        io.grpc.stub.StreamObserver<auction.model.DeleteArticleResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteArticleMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getArticles(auction.model.GetArticlesRequest request,
        io.grpc.stub.StreamObserver<auction.model.GetArticlesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetArticlesMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ArticleService.
   */
  public static final class ArticleServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ArticleServiceBlockingStub> {
    private ArticleServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ArticleServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ArticleServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public auction.model.CreateArticleResponse createArticle(auction.model.CreateArticleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateArticleMethod(), getCallOptions(), request);
    }

    /**
     */
    public auction.model.SearchArticleResponse searchArticle(auction.model.SearchArticleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSearchArticleMethod(), getCallOptions(), request);
    }

    /**
     */
    public auction.model.GetOwnedAuctionResponse getOwnedAuctions(auction.model.GetOwnedAuctionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetOwnedAuctionsMethod(), getCallOptions(), request);
    }

    /**
     */
    public auction.model.RegisterForTheAuctionResponse registerForTheAuction(auction.model.RegisterForTheAuctionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRegisterForTheAuctionMethod(), getCallOptions(), request);
    }

    /**
     */
    public auction.model.GetUserActiveAuctionsResponse getUserActiveAuctions(auction.model.GetUserActiveAuctionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetUserActiveAuctionsMethod(), getCallOptions(), request);
    }

    /**
     */
    public auction.model.GetRegisteredAuctionsResponse getRegisteredAuctions(auction.model.GetRegisteredAuctionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetRegisteredAuctionsMethod(), getCallOptions(), request);
    }

    /**
     */
    public auction.model.MakeOfferResponse makeOffer(auction.model.MakeOfferRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getMakeOfferMethod(), getCallOptions(), request);
    }

    /**
     */
    public auction.model.GetClosedAuctionsResponse getClosedAuctions(auction.model.GetClosedAuctionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetClosedAuctionsMethod(), getCallOptions(), request);
    }

    /**
     */
    public auction.model.BuyNowResponse buyNow(auction.model.BuyNowRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBuyNowMethod(), getCallOptions(), request);
    }

    /**
     */
    public auction.model.DeleteArticleResponse deleteArticle(auction.model.DeleteArticleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteArticleMethod(), getCallOptions(), request);
    }

    /**
     */
    public auction.model.GetArticlesResponse getArticles(auction.model.GetArticlesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetArticlesMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service ArticleService.
   */
  public static final class ArticleServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<ArticleServiceFutureStub> {
    private ArticleServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ArticleServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ArticleServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<auction.model.CreateArticleResponse> createArticle(
        auction.model.CreateArticleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateArticleMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<auction.model.SearchArticleResponse> searchArticle(
        auction.model.SearchArticleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSearchArticleMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<auction.model.GetOwnedAuctionResponse> getOwnedAuctions(
        auction.model.GetOwnedAuctionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetOwnedAuctionsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<auction.model.RegisterForTheAuctionResponse> registerForTheAuction(
        auction.model.RegisterForTheAuctionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRegisterForTheAuctionMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<auction.model.GetUserActiveAuctionsResponse> getUserActiveAuctions(
        auction.model.GetUserActiveAuctionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetUserActiveAuctionsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<auction.model.GetRegisteredAuctionsResponse> getRegisteredAuctions(
        auction.model.GetRegisteredAuctionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetRegisteredAuctionsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<auction.model.MakeOfferResponse> makeOffer(
        auction.model.MakeOfferRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getMakeOfferMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<auction.model.GetClosedAuctionsResponse> getClosedAuctions(
        auction.model.GetClosedAuctionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetClosedAuctionsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<auction.model.BuyNowResponse> buyNow(
        auction.model.BuyNowRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBuyNowMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<auction.model.DeleteArticleResponse> deleteArticle(
        auction.model.DeleteArticleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteArticleMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<auction.model.GetArticlesResponse> getArticles(
        auction.model.GetArticlesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetArticlesMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_ARTICLE = 0;
  private static final int METHODID_SEARCH_ARTICLE = 1;
  private static final int METHODID_GET_OWNED_AUCTIONS = 2;
  private static final int METHODID_REGISTER_FOR_THE_AUCTION = 3;
  private static final int METHODID_GET_USER_ACTIVE_AUCTIONS = 4;
  private static final int METHODID_GET_REGISTERED_AUCTIONS = 5;
  private static final int METHODID_MAKE_OFFER = 6;
  private static final int METHODID_GET_CLOSED_AUCTIONS = 7;
  private static final int METHODID_BUY_NOW = 8;
  private static final int METHODID_DELETE_ARTICLE = 9;
  private static final int METHODID_GET_ARTICLES = 10;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_ARTICLE:
          serviceImpl.createArticle((auction.model.CreateArticleRequest) request,
              (io.grpc.stub.StreamObserver<auction.model.CreateArticleResponse>) responseObserver);
          break;
        case METHODID_SEARCH_ARTICLE:
          serviceImpl.searchArticle((auction.model.SearchArticleRequest) request,
              (io.grpc.stub.StreamObserver<auction.model.SearchArticleResponse>) responseObserver);
          break;
        case METHODID_GET_OWNED_AUCTIONS:
          serviceImpl.getOwnedAuctions((auction.model.GetOwnedAuctionRequest) request,
              (io.grpc.stub.StreamObserver<auction.model.GetOwnedAuctionResponse>) responseObserver);
          break;
        case METHODID_REGISTER_FOR_THE_AUCTION:
          serviceImpl.registerForTheAuction((auction.model.RegisterForTheAuctionRequest) request,
              (io.grpc.stub.StreamObserver<auction.model.RegisterForTheAuctionResponse>) responseObserver);
          break;
        case METHODID_GET_USER_ACTIVE_AUCTIONS:
          serviceImpl.getUserActiveAuctions((auction.model.GetUserActiveAuctionsRequest) request,
              (io.grpc.stub.StreamObserver<auction.model.GetUserActiveAuctionsResponse>) responseObserver);
          break;
        case METHODID_GET_REGISTERED_AUCTIONS:
          serviceImpl.getRegisteredAuctions((auction.model.GetRegisteredAuctionsRequest) request,
              (io.grpc.stub.StreamObserver<auction.model.GetRegisteredAuctionsResponse>) responseObserver);
          break;
        case METHODID_MAKE_OFFER:
          serviceImpl.makeOffer((auction.model.MakeOfferRequest) request,
              (io.grpc.stub.StreamObserver<auction.model.MakeOfferResponse>) responseObserver);
          break;
        case METHODID_GET_CLOSED_AUCTIONS:
          serviceImpl.getClosedAuctions((auction.model.GetClosedAuctionsRequest) request,
              (io.grpc.stub.StreamObserver<auction.model.GetClosedAuctionsResponse>) responseObserver);
          break;
        case METHODID_BUY_NOW:
          serviceImpl.buyNow((auction.model.BuyNowRequest) request,
              (io.grpc.stub.StreamObserver<auction.model.BuyNowResponse>) responseObserver);
          break;
        case METHODID_DELETE_ARTICLE:
          serviceImpl.deleteArticle((auction.model.DeleteArticleRequest) request,
              (io.grpc.stub.StreamObserver<auction.model.DeleteArticleResponse>) responseObserver);
          break;
        case METHODID_GET_ARTICLES:
          serviceImpl.getArticles((auction.model.GetArticlesRequest) request,
              (io.grpc.stub.StreamObserver<auction.model.GetArticlesResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getCreateArticleMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              auction.model.CreateArticleRequest,
              auction.model.CreateArticleResponse>(
                service, METHODID_CREATE_ARTICLE)))
        .addMethod(
          getSearchArticleMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              auction.model.SearchArticleRequest,
              auction.model.SearchArticleResponse>(
                service, METHODID_SEARCH_ARTICLE)))
        .addMethod(
          getGetOwnedAuctionsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              auction.model.GetOwnedAuctionRequest,
              auction.model.GetOwnedAuctionResponse>(
                service, METHODID_GET_OWNED_AUCTIONS)))
        .addMethod(
          getRegisterForTheAuctionMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              auction.model.RegisterForTheAuctionRequest,
              auction.model.RegisterForTheAuctionResponse>(
                service, METHODID_REGISTER_FOR_THE_AUCTION)))
        .addMethod(
          getGetUserActiveAuctionsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              auction.model.GetUserActiveAuctionsRequest,
              auction.model.GetUserActiveAuctionsResponse>(
                service, METHODID_GET_USER_ACTIVE_AUCTIONS)))
        .addMethod(
          getGetRegisteredAuctionsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              auction.model.GetRegisteredAuctionsRequest,
              auction.model.GetRegisteredAuctionsResponse>(
                service, METHODID_GET_REGISTERED_AUCTIONS)))
        .addMethod(
          getMakeOfferMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              auction.model.MakeOfferRequest,
              auction.model.MakeOfferResponse>(
                service, METHODID_MAKE_OFFER)))
        .addMethod(
          getGetClosedAuctionsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              auction.model.GetClosedAuctionsRequest,
              auction.model.GetClosedAuctionsResponse>(
                service, METHODID_GET_CLOSED_AUCTIONS)))
        .addMethod(
          getBuyNowMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              auction.model.BuyNowRequest,
              auction.model.BuyNowResponse>(
                service, METHODID_BUY_NOW)))
        .addMethod(
          getDeleteArticleMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              auction.model.DeleteArticleRequest,
              auction.model.DeleteArticleResponse>(
                service, METHODID_DELETE_ARTICLE)))
        .addMethod(
          getGetArticlesMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              auction.model.GetArticlesRequest,
              auction.model.GetArticlesResponse>(
                service, METHODID_GET_ARTICLES)))
        .build();
  }

  private static abstract class ArticleServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ArticleServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return auction.model.ArticleServiceOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ArticleService");
    }
  }

  private static final class ArticleServiceFileDescriptorSupplier
      extends ArticleServiceBaseDescriptorSupplier {
    ArticleServiceFileDescriptorSupplier() {}
  }

  private static final class ArticleServiceMethodDescriptorSupplier
      extends ArticleServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ArticleServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ArticleServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ArticleServiceFileDescriptorSupplier())
              .addMethod(getCreateArticleMethod())
              .addMethod(getSearchArticleMethod())
              .addMethod(getGetOwnedAuctionsMethod())
              .addMethod(getRegisterForTheAuctionMethod())
              .addMethod(getGetUserActiveAuctionsMethod())
              .addMethod(getGetRegisteredAuctionsMethod())
              .addMethod(getMakeOfferMethod())
              .addMethod(getGetClosedAuctionsMethod())
              .addMethod(getBuyNowMethod())
              .addMethod(getDeleteArticleMethod())
              .addMethod(getGetArticlesMethod())
              .build();
        }
      }
    }
    return result;
  }
}
