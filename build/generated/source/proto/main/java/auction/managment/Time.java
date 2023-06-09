// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: article_info.proto

package auction.managment;

/**
 * Protobuf type {@code auction.Time}
 */
public final class Time extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:auction.Time)
    TimeOrBuilder {
private static final long serialVersionUID = 0L;
  // Use Time.newBuilder() to construct.
  private Time(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private Time() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new Time();
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return auction.managment.ArticleInfoOuterClass.internal_static_auction_Time_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return auction.managment.ArticleInfoOuterClass.internal_static_auction_Time_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            auction.managment.Time.class, auction.managment.Time.Builder.class);
  }

  public static final int HOUR_FIELD_NUMBER = 1;
  private int hour_ = 0;
  /**
   * <code>int32 hour = 1;</code>
   * @return The hour.
   */
  @java.lang.Override
  public int getHour() {
    return hour_;
  }

  public static final int MINUTES_FIELD_NUMBER = 2;
  private int minutes_ = 0;
  /**
   * <code>int32 minutes = 2;</code>
   * @return The minutes.
   */
  @java.lang.Override
  public int getMinutes() {
    return minutes_;
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
    if (hour_ != 0) {
      output.writeInt32(1, hour_);
    }
    if (minutes_ != 0) {
      output.writeInt32(2, minutes_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (hour_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, hour_);
    }
    if (minutes_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, minutes_);
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
    if (!(obj instanceof auction.managment.Time)) {
      return super.equals(obj);
    }
    auction.managment.Time other = (auction.managment.Time) obj;

    if (getHour()
        != other.getHour()) return false;
    if (getMinutes()
        != other.getMinutes()) return false;
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
    hash = (37 * hash) + HOUR_FIELD_NUMBER;
    hash = (53 * hash) + getHour();
    hash = (37 * hash) + MINUTES_FIELD_NUMBER;
    hash = (53 * hash) + getMinutes();
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static auction.managment.Time parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static auction.managment.Time parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static auction.managment.Time parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static auction.managment.Time parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static auction.managment.Time parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static auction.managment.Time parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static auction.managment.Time parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static auction.managment.Time parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static auction.managment.Time parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static auction.managment.Time parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static auction.managment.Time parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static auction.managment.Time parseFrom(
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
  public static Builder newBuilder(auction.managment.Time prototype) {
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
   * Protobuf type {@code auction.Time}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:auction.Time)
      auction.managment.TimeOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return auction.managment.ArticleInfoOuterClass.internal_static_auction_Time_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return auction.managment.ArticleInfoOuterClass.internal_static_auction_Time_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              auction.managment.Time.class, auction.managment.Time.Builder.class);
    }

    // Construct using auction.managment.Time.newBuilder()
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
      hour_ = 0;
      minutes_ = 0;
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return auction.managment.ArticleInfoOuterClass.internal_static_auction_Time_descriptor;
    }

    @java.lang.Override
    public auction.managment.Time getDefaultInstanceForType() {
      return auction.managment.Time.getDefaultInstance();
    }

    @java.lang.Override
    public auction.managment.Time build() {
      auction.managment.Time result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public auction.managment.Time buildPartial() {
      auction.managment.Time result = new auction.managment.Time(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(auction.managment.Time result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.hour_ = hour_;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.minutes_ = minutes_;
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
      if (other instanceof auction.managment.Time) {
        return mergeFrom((auction.managment.Time)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(auction.managment.Time other) {
      if (other == auction.managment.Time.getDefaultInstance()) return this;
      if (other.getHour() != 0) {
        setHour(other.getHour());
      }
      if (other.getMinutes() != 0) {
        setMinutes(other.getMinutes());
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
            case 8: {
              hour_ = input.readInt32();
              bitField0_ |= 0x00000001;
              break;
            } // case 8
            case 16: {
              minutes_ = input.readInt32();
              bitField0_ |= 0x00000002;
              break;
            } // case 16
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

    private int hour_ ;
    /**
     * <code>int32 hour = 1;</code>
     * @return The hour.
     */
    @java.lang.Override
    public int getHour() {
      return hour_;
    }
    /**
     * <code>int32 hour = 1;</code>
     * @param value The hour to set.
     * @return This builder for chaining.
     */
    public Builder setHour(int value) {

      hour_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>int32 hour = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearHour() {
      bitField0_ = (bitField0_ & ~0x00000001);
      hour_ = 0;
      onChanged();
      return this;
    }

    private int minutes_ ;
    /**
     * <code>int32 minutes = 2;</code>
     * @return The minutes.
     */
    @java.lang.Override
    public int getMinutes() {
      return minutes_;
    }
    /**
     * <code>int32 minutes = 2;</code>
     * @param value The minutes to set.
     * @return This builder for chaining.
     */
    public Builder setMinutes(int value) {

      minutes_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>int32 minutes = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearMinutes() {
      bitField0_ = (bitField0_ & ~0x00000002);
      minutes_ = 0;
      onChanged();
      return this;
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


    // @@protoc_insertion_point(builder_scope:auction.Time)
  }

  // @@protoc_insertion_point(class_scope:auction.Time)
  private static final auction.managment.Time DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new auction.managment.Time();
  }

  public static auction.managment.Time getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<Time>
      PARSER = new com.google.protobuf.AbstractParser<Time>() {
    @java.lang.Override
    public Time parsePartialFrom(
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

  public static com.google.protobuf.Parser<Time> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<Time> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public auction.managment.Time getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

