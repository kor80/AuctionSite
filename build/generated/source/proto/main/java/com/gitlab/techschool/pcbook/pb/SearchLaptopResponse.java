// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: laptop_service.proto

package com.gitlab.techschool.pcbook.pb;

/**
 * Protobuf type {@code techschool.pcbook.SearchLaptopResponse}
 */
public final class SearchLaptopResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:techschool.pcbook.SearchLaptopResponse)
    SearchLaptopResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use SearchLaptopResponse.newBuilder() to construct.
  private SearchLaptopResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private SearchLaptopResponse() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new SearchLaptopResponse();
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.gitlab.techschool.pcbook.pb.LaptopServiceOuterClass.internal_static_techschool_pcbook_SearchLaptopResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.gitlab.techschool.pcbook.pb.LaptopServiceOuterClass.internal_static_techschool_pcbook_SearchLaptopResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.gitlab.techschool.pcbook.pb.SearchLaptopResponse.class, com.gitlab.techschool.pcbook.pb.SearchLaptopResponse.Builder.class);
  }

  public static final int LAPTOP_FIELD_NUMBER = 1;
  private com.gitlab.techschool.pcbook.pb.Laptop laptop_;
  /**
   * <code>.techschool.pcbook.Laptop laptop = 1;</code>
   * @return Whether the laptop field is set.
   */
  @java.lang.Override
  public boolean hasLaptop() {
    return laptop_ != null;
  }
  /**
   * <code>.techschool.pcbook.Laptop laptop = 1;</code>
   * @return The laptop.
   */
  @java.lang.Override
  public com.gitlab.techschool.pcbook.pb.Laptop getLaptop() {
    return laptop_ == null ? com.gitlab.techschool.pcbook.pb.Laptop.getDefaultInstance() : laptop_;
  }
  /**
   * <code>.techschool.pcbook.Laptop laptop = 1;</code>
   */
  @java.lang.Override
  public com.gitlab.techschool.pcbook.pb.LaptopOrBuilder getLaptopOrBuilder() {
    return laptop_ == null ? com.gitlab.techschool.pcbook.pb.Laptop.getDefaultInstance() : laptop_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (laptop_ != null) {
      output.writeMessage(1, getLaptop());
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (laptop_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getLaptop());
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.gitlab.techschool.pcbook.pb.SearchLaptopResponse)) {
      return super.equals(obj);
    }
    com.gitlab.techschool.pcbook.pb.SearchLaptopResponse other = (com.gitlab.techschool.pcbook.pb.SearchLaptopResponse) obj;

    if (hasLaptop() != other.hasLaptop()) return false;
    if (hasLaptop()) {
      if (!getLaptop()
          .equals(other.getLaptop())) return false;
    }
    if (!getUnknownFields().equals(other.getUnknownFields())) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (hasLaptop()) {
      hash = (37 * hash) + LAPTOP_FIELD_NUMBER;
      hash = (53 * hash) + getLaptop().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.gitlab.techschool.pcbook.pb.SearchLaptopResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.gitlab.techschool.pcbook.pb.SearchLaptopResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.gitlab.techschool.pcbook.pb.SearchLaptopResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.gitlab.techschool.pcbook.pb.SearchLaptopResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.gitlab.techschool.pcbook.pb.SearchLaptopResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.gitlab.techschool.pcbook.pb.SearchLaptopResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.gitlab.techschool.pcbook.pb.SearchLaptopResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.gitlab.techschool.pcbook.pb.SearchLaptopResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static com.gitlab.techschool.pcbook.pb.SearchLaptopResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static com.gitlab.techschool.pcbook.pb.SearchLaptopResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.gitlab.techschool.pcbook.pb.SearchLaptopResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.gitlab.techschool.pcbook.pb.SearchLaptopResponse parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.gitlab.techschool.pcbook.pb.SearchLaptopResponse prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code techschool.pcbook.SearchLaptopResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:techschool.pcbook.SearchLaptopResponse)
      com.gitlab.techschool.pcbook.pb.SearchLaptopResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.gitlab.techschool.pcbook.pb.LaptopServiceOuterClass.internal_static_techschool_pcbook_SearchLaptopResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.gitlab.techschool.pcbook.pb.LaptopServiceOuterClass.internal_static_techschool_pcbook_SearchLaptopResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.gitlab.techschool.pcbook.pb.SearchLaptopResponse.class, com.gitlab.techschool.pcbook.pb.SearchLaptopResponse.Builder.class);
    }

    // Construct using com.gitlab.techschool.pcbook.pb.SearchLaptopResponse.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      laptop_ = null;
      if (laptopBuilder_ != null) {
        laptopBuilder_.dispose();
        laptopBuilder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.gitlab.techschool.pcbook.pb.LaptopServiceOuterClass.internal_static_techschool_pcbook_SearchLaptopResponse_descriptor;
    }

    @java.lang.Override
    public com.gitlab.techschool.pcbook.pb.SearchLaptopResponse getDefaultInstanceForType() {
      return com.gitlab.techschool.pcbook.pb.SearchLaptopResponse.getDefaultInstance();
    }

    @java.lang.Override
    public com.gitlab.techschool.pcbook.pb.SearchLaptopResponse build() {
      com.gitlab.techschool.pcbook.pb.SearchLaptopResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.gitlab.techschool.pcbook.pb.SearchLaptopResponse buildPartial() {
      com.gitlab.techschool.pcbook.pb.SearchLaptopResponse result = new com.gitlab.techschool.pcbook.pb.SearchLaptopResponse(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(com.gitlab.techschool.pcbook.pb.SearchLaptopResponse result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.laptop_ = laptopBuilder_ == null
            ? laptop_
            : laptopBuilder_.build();
      }
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.gitlab.techschool.pcbook.pb.SearchLaptopResponse) {
        return mergeFrom((com.gitlab.techschool.pcbook.pb.SearchLaptopResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.gitlab.techschool.pcbook.pb.SearchLaptopResponse other) {
      if (other == com.gitlab.techschool.pcbook.pb.SearchLaptopResponse.getDefaultInstance()) return this;
      if (other.hasLaptop()) {
        mergeLaptop(other.getLaptop());
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 10: {
              input.readMessage(
                  getLaptopFieldBuilder().getBuilder(),
                  extensionRegistry);
              bitField0_ |= 0x00000001;
              break;
            } // case 10
            default: {
              if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                done = true; // was an endgroup tag
              }
              break;
            } // default:
          } // switch (tag)
        } // while (!done)
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.unwrapIOException();
      } finally {
        onChanged();
      } // finally
      return this;
    }
    private int bitField0_;

    private com.gitlab.techschool.pcbook.pb.Laptop laptop_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.gitlab.techschool.pcbook.pb.Laptop, com.gitlab.techschool.pcbook.pb.Laptop.Builder, com.gitlab.techschool.pcbook.pb.LaptopOrBuilder> laptopBuilder_;
    /**
     * <code>.techschool.pcbook.Laptop laptop = 1;</code>
     * @return Whether the laptop field is set.
     */
    public boolean hasLaptop() {
      return ((bitField0_ & 0x00000001) != 0);
    }
    /**
     * <code>.techschool.pcbook.Laptop laptop = 1;</code>
     * @return The laptop.
     */
    public com.gitlab.techschool.pcbook.pb.Laptop getLaptop() {
      if (laptopBuilder_ == null) {
        return laptop_ == null ? com.gitlab.techschool.pcbook.pb.Laptop.getDefaultInstance() : laptop_;
      } else {
        return laptopBuilder_.getMessage();
      }
    }
    /**
     * <code>.techschool.pcbook.Laptop laptop = 1;</code>
     */
    public Builder setLaptop(com.gitlab.techschool.pcbook.pb.Laptop value) {
      if (laptopBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        laptop_ = value;
      } else {
        laptopBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>.techschool.pcbook.Laptop laptop = 1;</code>
     */
    public Builder setLaptop(
        com.gitlab.techschool.pcbook.pb.Laptop.Builder builderForValue) {
      if (laptopBuilder_ == null) {
        laptop_ = builderForValue.build();
      } else {
        laptopBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>.techschool.pcbook.Laptop laptop = 1;</code>
     */
    public Builder mergeLaptop(com.gitlab.techschool.pcbook.pb.Laptop value) {
      if (laptopBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0) &&
          laptop_ != null &&
          laptop_ != com.gitlab.techschool.pcbook.pb.Laptop.getDefaultInstance()) {
          getLaptopBuilder().mergeFrom(value);
        } else {
          laptop_ = value;
        }
      } else {
        laptopBuilder_.mergeFrom(value);
      }
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>.techschool.pcbook.Laptop laptop = 1;</code>
     */
    public Builder clearLaptop() {
      bitField0_ = (bitField0_ & ~0x00000001);
      laptop_ = null;
      if (laptopBuilder_ != null) {
        laptopBuilder_.dispose();
        laptopBuilder_ = null;
      }
      onChanged();
      return this;
    }
    /**
     * <code>.techschool.pcbook.Laptop laptop = 1;</code>
     */
    public com.gitlab.techschool.pcbook.pb.Laptop.Builder getLaptopBuilder() {
      bitField0_ |= 0x00000001;
      onChanged();
      return getLaptopFieldBuilder().getBuilder();
    }
    /**
     * <code>.techschool.pcbook.Laptop laptop = 1;</code>
     */
    public com.gitlab.techschool.pcbook.pb.LaptopOrBuilder getLaptopOrBuilder() {
      if (laptopBuilder_ != null) {
        return laptopBuilder_.getMessageOrBuilder();
      } else {
        return laptop_ == null ?
            com.gitlab.techschool.pcbook.pb.Laptop.getDefaultInstance() : laptop_;
      }
    }
    /**
     * <code>.techschool.pcbook.Laptop laptop = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.gitlab.techschool.pcbook.pb.Laptop, com.gitlab.techschool.pcbook.pb.Laptop.Builder, com.gitlab.techschool.pcbook.pb.LaptopOrBuilder> 
        getLaptopFieldBuilder() {
      if (laptopBuilder_ == null) {
        laptopBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.gitlab.techschool.pcbook.pb.Laptop, com.gitlab.techschool.pcbook.pb.Laptop.Builder, com.gitlab.techschool.pcbook.pb.LaptopOrBuilder>(
                getLaptop(),
                getParentForChildren(),
                isClean());
        laptop_ = null;
      }
      return laptopBuilder_;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:techschool.pcbook.SearchLaptopResponse)
  }

  // @@protoc_insertion_point(class_scope:techschool.pcbook.SearchLaptopResponse)
  private static final com.gitlab.techschool.pcbook.pb.SearchLaptopResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.gitlab.techschool.pcbook.pb.SearchLaptopResponse();
  }

  public static com.gitlab.techschool.pcbook.pb.SearchLaptopResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<SearchLaptopResponse>
      PARSER = new com.google.protobuf.AbstractParser<SearchLaptopResponse>() {
    @java.lang.Override
    public SearchLaptopResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      Builder builder = newBuilder();
      try {
        builder.mergeFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(builder.buildPartial());
      } catch (com.google.protobuf.UninitializedMessageException e) {
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(e)
            .setUnfinishedMessage(builder.buildPartial());
      }
      return builder.buildPartial();
    }
  };

  public static com.google.protobuf.Parser<SearchLaptopResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<SearchLaptopResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.gitlab.techschool.pcbook.pb.SearchLaptopResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

