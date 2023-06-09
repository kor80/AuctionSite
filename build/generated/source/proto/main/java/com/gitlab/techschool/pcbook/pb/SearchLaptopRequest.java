// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: laptop_service.proto

package com.gitlab.techschool.pcbook.pb;

/**
 * Protobuf type {@code techschool.pcbook.SearchLaptopRequest}
 */
public final class SearchLaptopRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:techschool.pcbook.SearchLaptopRequest)
    SearchLaptopRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use SearchLaptopRequest.newBuilder() to construct.
  private SearchLaptopRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private SearchLaptopRequest() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new SearchLaptopRequest();
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.gitlab.techschool.pcbook.pb.LaptopServiceOuterClass.internal_static_techschool_pcbook_SearchLaptopRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.gitlab.techschool.pcbook.pb.LaptopServiceOuterClass.internal_static_techschool_pcbook_SearchLaptopRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.gitlab.techschool.pcbook.pb.SearchLaptopRequest.class, com.gitlab.techschool.pcbook.pb.SearchLaptopRequest.Builder.class);
  }

  public static final int FILTER_FIELD_NUMBER = 1;
  private com.gitlab.techschool.pcbook.pb.Filter filter_;
  /**
   * <code>.techschool.pcbook.Filter filter = 1;</code>
   * @return Whether the filter field is set.
   */
  @java.lang.Override
  public boolean hasFilter() {
    return filter_ != null;
  }
  /**
   * <code>.techschool.pcbook.Filter filter = 1;</code>
   * @return The filter.
   */
  @java.lang.Override
  public com.gitlab.techschool.pcbook.pb.Filter getFilter() {
    return filter_ == null ? com.gitlab.techschool.pcbook.pb.Filter.getDefaultInstance() : filter_;
  }
  /**
   * <code>.techschool.pcbook.Filter filter = 1;</code>
   */
  @java.lang.Override
  public com.gitlab.techschool.pcbook.pb.FilterOrBuilder getFilterOrBuilder() {
    return filter_ == null ? com.gitlab.techschool.pcbook.pb.Filter.getDefaultInstance() : filter_;
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
    if (filter_ != null) {
      output.writeMessage(1, getFilter());
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (filter_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getFilter());
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
    if (!(obj instanceof com.gitlab.techschool.pcbook.pb.SearchLaptopRequest)) {
      return super.equals(obj);
    }
    com.gitlab.techschool.pcbook.pb.SearchLaptopRequest other = (com.gitlab.techschool.pcbook.pb.SearchLaptopRequest) obj;

    if (hasFilter() != other.hasFilter()) return false;
    if (hasFilter()) {
      if (!getFilter()
          .equals(other.getFilter())) return false;
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
    if (hasFilter()) {
      hash = (37 * hash) + FILTER_FIELD_NUMBER;
      hash = (53 * hash) + getFilter().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.gitlab.techschool.pcbook.pb.SearchLaptopRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.gitlab.techschool.pcbook.pb.SearchLaptopRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.gitlab.techschool.pcbook.pb.SearchLaptopRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.gitlab.techschool.pcbook.pb.SearchLaptopRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.gitlab.techschool.pcbook.pb.SearchLaptopRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.gitlab.techschool.pcbook.pb.SearchLaptopRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.gitlab.techschool.pcbook.pb.SearchLaptopRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.gitlab.techschool.pcbook.pb.SearchLaptopRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static com.gitlab.techschool.pcbook.pb.SearchLaptopRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static com.gitlab.techschool.pcbook.pb.SearchLaptopRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.gitlab.techschool.pcbook.pb.SearchLaptopRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.gitlab.techschool.pcbook.pb.SearchLaptopRequest parseFrom(
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
  public static Builder newBuilder(com.gitlab.techschool.pcbook.pb.SearchLaptopRequest prototype) {
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
   * Protobuf type {@code techschool.pcbook.SearchLaptopRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:techschool.pcbook.SearchLaptopRequest)
      com.gitlab.techschool.pcbook.pb.SearchLaptopRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.gitlab.techschool.pcbook.pb.LaptopServiceOuterClass.internal_static_techschool_pcbook_SearchLaptopRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.gitlab.techschool.pcbook.pb.LaptopServiceOuterClass.internal_static_techschool_pcbook_SearchLaptopRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.gitlab.techschool.pcbook.pb.SearchLaptopRequest.class, com.gitlab.techschool.pcbook.pb.SearchLaptopRequest.Builder.class);
    }

    // Construct using com.gitlab.techschool.pcbook.pb.SearchLaptopRequest.newBuilder()
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
      filter_ = null;
      if (filterBuilder_ != null) {
        filterBuilder_.dispose();
        filterBuilder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.gitlab.techschool.pcbook.pb.LaptopServiceOuterClass.internal_static_techschool_pcbook_SearchLaptopRequest_descriptor;
    }

    @java.lang.Override
    public com.gitlab.techschool.pcbook.pb.SearchLaptopRequest getDefaultInstanceForType() {
      return com.gitlab.techschool.pcbook.pb.SearchLaptopRequest.getDefaultInstance();
    }

    @java.lang.Override
    public com.gitlab.techschool.pcbook.pb.SearchLaptopRequest build() {
      com.gitlab.techschool.pcbook.pb.SearchLaptopRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.gitlab.techschool.pcbook.pb.SearchLaptopRequest buildPartial() {
      com.gitlab.techschool.pcbook.pb.SearchLaptopRequest result = new com.gitlab.techschool.pcbook.pb.SearchLaptopRequest(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(com.gitlab.techschool.pcbook.pb.SearchLaptopRequest result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.filter_ = filterBuilder_ == null
            ? filter_
            : filterBuilder_.build();
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
      if (other instanceof com.gitlab.techschool.pcbook.pb.SearchLaptopRequest) {
        return mergeFrom((com.gitlab.techschool.pcbook.pb.SearchLaptopRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.gitlab.techschool.pcbook.pb.SearchLaptopRequest other) {
      if (other == com.gitlab.techschool.pcbook.pb.SearchLaptopRequest.getDefaultInstance()) return this;
      if (other.hasFilter()) {
        mergeFilter(other.getFilter());
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
                  getFilterFieldBuilder().getBuilder(),
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

    private com.gitlab.techschool.pcbook.pb.Filter filter_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.gitlab.techschool.pcbook.pb.Filter, com.gitlab.techschool.pcbook.pb.Filter.Builder, com.gitlab.techschool.pcbook.pb.FilterOrBuilder> filterBuilder_;
    /**
     * <code>.techschool.pcbook.Filter filter = 1;</code>
     * @return Whether the filter field is set.
     */
    public boolean hasFilter() {
      return ((bitField0_ & 0x00000001) != 0);
    }
    /**
     * <code>.techschool.pcbook.Filter filter = 1;</code>
     * @return The filter.
     */
    public com.gitlab.techschool.pcbook.pb.Filter getFilter() {
      if (filterBuilder_ == null) {
        return filter_ == null ? com.gitlab.techschool.pcbook.pb.Filter.getDefaultInstance() : filter_;
      } else {
        return filterBuilder_.getMessage();
      }
    }
    /**
     * <code>.techschool.pcbook.Filter filter = 1;</code>
     */
    public Builder setFilter(com.gitlab.techschool.pcbook.pb.Filter value) {
      if (filterBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        filter_ = value;
      } else {
        filterBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>.techschool.pcbook.Filter filter = 1;</code>
     */
    public Builder setFilter(
        com.gitlab.techschool.pcbook.pb.Filter.Builder builderForValue) {
      if (filterBuilder_ == null) {
        filter_ = builderForValue.build();
      } else {
        filterBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>.techschool.pcbook.Filter filter = 1;</code>
     */
    public Builder mergeFilter(com.gitlab.techschool.pcbook.pb.Filter value) {
      if (filterBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0) &&
          filter_ != null &&
          filter_ != com.gitlab.techschool.pcbook.pb.Filter.getDefaultInstance()) {
          getFilterBuilder().mergeFrom(value);
        } else {
          filter_ = value;
        }
      } else {
        filterBuilder_.mergeFrom(value);
      }
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>.techschool.pcbook.Filter filter = 1;</code>
     */
    public Builder clearFilter() {
      bitField0_ = (bitField0_ & ~0x00000001);
      filter_ = null;
      if (filterBuilder_ != null) {
        filterBuilder_.dispose();
        filterBuilder_ = null;
      }
      onChanged();
      return this;
    }
    /**
     * <code>.techschool.pcbook.Filter filter = 1;</code>
     */
    public com.gitlab.techschool.pcbook.pb.Filter.Builder getFilterBuilder() {
      bitField0_ |= 0x00000001;
      onChanged();
      return getFilterFieldBuilder().getBuilder();
    }
    /**
     * <code>.techschool.pcbook.Filter filter = 1;</code>
     */
    public com.gitlab.techschool.pcbook.pb.FilterOrBuilder getFilterOrBuilder() {
      if (filterBuilder_ != null) {
        return filterBuilder_.getMessageOrBuilder();
      } else {
        return filter_ == null ?
            com.gitlab.techschool.pcbook.pb.Filter.getDefaultInstance() : filter_;
      }
    }
    /**
     * <code>.techschool.pcbook.Filter filter = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.gitlab.techschool.pcbook.pb.Filter, com.gitlab.techschool.pcbook.pb.Filter.Builder, com.gitlab.techschool.pcbook.pb.FilterOrBuilder> 
        getFilterFieldBuilder() {
      if (filterBuilder_ == null) {
        filterBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.gitlab.techschool.pcbook.pb.Filter, com.gitlab.techschool.pcbook.pb.Filter.Builder, com.gitlab.techschool.pcbook.pb.FilterOrBuilder>(
                getFilter(),
                getParentForChildren(),
                isClean());
        filter_ = null;
      }
      return filterBuilder_;
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


    // @@protoc_insertion_point(builder_scope:techschool.pcbook.SearchLaptopRequest)
  }

  // @@protoc_insertion_point(class_scope:techschool.pcbook.SearchLaptopRequest)
  private static final com.gitlab.techschool.pcbook.pb.SearchLaptopRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.gitlab.techschool.pcbook.pb.SearchLaptopRequest();
  }

  public static com.gitlab.techschool.pcbook.pb.SearchLaptopRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<SearchLaptopRequest>
      PARSER = new com.google.protobuf.AbstractParser<SearchLaptopRequest>() {
    @java.lang.Override
    public SearchLaptopRequest parsePartialFrom(
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

  public static com.google.protobuf.Parser<SearchLaptopRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<SearchLaptopRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.gitlab.techschool.pcbook.pb.SearchLaptopRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

