package auction.managment;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 *message SearchLaptopRequest { Filter filter = 1; }
 *message SearchLaptopResponse { Laptop laptop = 1; }
 *message UploadImageRequest {
 *oneof data {
 *ImageInfo info = 1;
 *bytes chunk_data = 2;
 *};
 *}
 *message ImageInfo {
 *string laptop_id = 1;
 *string image_type = 2;
 *}
 *message UploadImageResponse {
 *string id = 1;
 *uint32 size = 2;
 *}
 *message RateLaptopRequest {
 *string laptop_id = 1;
 *double score = 2;
 *}
 *message RateLaptopResponse {
 *string laptop_id = 1;
 *uint32 rated_count = 2;
 *double average_score = 3;
 *}
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.55.1)",
    comments = "Source: article_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ArticleServiceGrpc {

  private ArticleServiceGrpc() {}

  public static final String SERVICE_NAME = "auction.ArticleService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<auction.managment.CreateArticleRequest,
      auction.managment.CreateArticleResponse> getCreateArticleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateArticle",
      requestType = auction.managment.CreateArticleRequest.class,
      responseType = auction.managment.CreateArticleResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<auction.managment.CreateArticleRequest,
      auction.managment.CreateArticleResponse> getCreateArticleMethod() {
    io.grpc.MethodDescriptor<auction.managment.CreateArticleRequest, auction.managment.CreateArticleResponse> getCreateArticleMethod;
    if ((getCreateArticleMethod = ArticleServiceGrpc.getCreateArticleMethod) == null) {
      synchronized (ArticleServiceGrpc.class) {
        if ((getCreateArticleMethod = ArticleServiceGrpc.getCreateArticleMethod) == null) {
          ArticleServiceGrpc.getCreateArticleMethod = getCreateArticleMethod =
              io.grpc.MethodDescriptor.<auction.managment.CreateArticleRequest, auction.managment.CreateArticleResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateArticle"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  auction.managment.CreateArticleRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  auction.managment.CreateArticleResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ArticleServiceMethodDescriptorSupplier("CreateArticle"))
              .build();
        }
      }
    }
    return getCreateArticleMethod;
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
   * <pre>
   *message SearchLaptopRequest { Filter filter = 1; }
   *message SearchLaptopResponse { Laptop laptop = 1; }
   *message UploadImageRequest {
   *oneof data {
   *ImageInfo info = 1;
   *bytes chunk_data = 2;
   *};
   *}
   *message ImageInfo {
   *string laptop_id = 1;
   *string image_type = 2;
   *}
   *message UploadImageResponse {
   *string id = 1;
   *uint32 size = 2;
   *}
   *message RateLaptopRequest {
   *string laptop_id = 1;
   *double score = 2;
   *}
   *message RateLaptopResponse {
   *string laptop_id = 1;
   *uint32 rated_count = 2;
   *double average_score = 3;
   *}
   * </pre>
   */
  public interface AsyncService {

    /**
     */
    default void createArticle(auction.managment.CreateArticleRequest request,
        io.grpc.stub.StreamObserver<auction.managment.CreateArticleResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateArticleMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ArticleService.
   * <pre>
   *message SearchLaptopRequest { Filter filter = 1; }
   *message SearchLaptopResponse { Laptop laptop = 1; }
   *message UploadImageRequest {
   *oneof data {
   *ImageInfo info = 1;
   *bytes chunk_data = 2;
   *};
   *}
   *message ImageInfo {
   *string laptop_id = 1;
   *string image_type = 2;
   *}
   *message UploadImageResponse {
   *string id = 1;
   *uint32 size = 2;
   *}
   *message RateLaptopRequest {
   *string laptop_id = 1;
   *double score = 2;
   *}
   *message RateLaptopResponse {
   *string laptop_id = 1;
   *uint32 rated_count = 2;
   *double average_score = 3;
   *}
   * </pre>
   */
  public static abstract class ArticleServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return ArticleServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ArticleService.
   * <pre>
   *message SearchLaptopRequest { Filter filter = 1; }
   *message SearchLaptopResponse { Laptop laptop = 1; }
   *message UploadImageRequest {
   *oneof data {
   *ImageInfo info = 1;
   *bytes chunk_data = 2;
   *};
   *}
   *message ImageInfo {
   *string laptop_id = 1;
   *string image_type = 2;
   *}
   *message UploadImageResponse {
   *string id = 1;
   *uint32 size = 2;
   *}
   *message RateLaptopRequest {
   *string laptop_id = 1;
   *double score = 2;
   *}
   *message RateLaptopResponse {
   *string laptop_id = 1;
   *uint32 rated_count = 2;
   *double average_score = 3;
   *}
   * </pre>
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
    public void createArticle(auction.managment.CreateArticleRequest request,
        io.grpc.stub.StreamObserver<auction.managment.CreateArticleResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateArticleMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ArticleService.
   * <pre>
   *message SearchLaptopRequest { Filter filter = 1; }
   *message SearchLaptopResponse { Laptop laptop = 1; }
   *message UploadImageRequest {
   *oneof data {
   *ImageInfo info = 1;
   *bytes chunk_data = 2;
   *};
   *}
   *message ImageInfo {
   *string laptop_id = 1;
   *string image_type = 2;
   *}
   *message UploadImageResponse {
   *string id = 1;
   *uint32 size = 2;
   *}
   *message RateLaptopRequest {
   *string laptop_id = 1;
   *double score = 2;
   *}
   *message RateLaptopResponse {
   *string laptop_id = 1;
   *uint32 rated_count = 2;
   *double average_score = 3;
   *}
   * </pre>
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
    public auction.managment.CreateArticleResponse createArticle(auction.managment.CreateArticleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateArticleMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service ArticleService.
   * <pre>
   *message SearchLaptopRequest { Filter filter = 1; }
   *message SearchLaptopResponse { Laptop laptop = 1; }
   *message UploadImageRequest {
   *oneof data {
   *ImageInfo info = 1;
   *bytes chunk_data = 2;
   *};
   *}
   *message ImageInfo {
   *string laptop_id = 1;
   *string image_type = 2;
   *}
   *message UploadImageResponse {
   *string id = 1;
   *uint32 size = 2;
   *}
   *message RateLaptopRequest {
   *string laptop_id = 1;
   *double score = 2;
   *}
   *message RateLaptopResponse {
   *string laptop_id = 1;
   *uint32 rated_count = 2;
   *double average_score = 3;
   *}
   * </pre>
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
    public com.google.common.util.concurrent.ListenableFuture<auction.managment.CreateArticleResponse> createArticle(
        auction.managment.CreateArticleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateArticleMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_ARTICLE = 0;

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
          serviceImpl.createArticle((auction.managment.CreateArticleRequest) request,
              (io.grpc.stub.StreamObserver<auction.managment.CreateArticleResponse>) responseObserver);
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
              auction.managment.CreateArticleRequest,
              auction.managment.CreateArticleResponse>(
                service, METHODID_CREATE_ARTICLE)))
        .build();
  }

  private static abstract class ArticleServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ArticleServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return auction.managment.ArticleServiceOuterClass.getDescriptor();
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
              .build();
        }
      }
    }
    return result;
  }
}
