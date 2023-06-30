// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: registration_info.proto

package auction.managment.auctions;

/**
 * Protobuf type {@code auction.RegistrationInfo}
 */
public final class RegistrationInfo extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:auction.RegistrationInfo)
    RegistrationInfoOrBuilder {
private static final long serialVersionUID = 0L;
  // Use RegistrationInfo.newBuilder() to construct.
  private RegistrationInfo(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private RegistrationInfo() {
    user_ = "";
    userIP_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new RegistrationInfo();
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return auction.managment.auctions.RegistrationInfoOuterClass.internal_static_auction_RegistrationInfo_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return auction.managment.auctions.RegistrationInfoOuterClass.internal_static_auction_RegistrationInfo_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            auction.managment.auctions.RegistrationInfo.class, auction.managment.auctions.RegistrationInfo.Builder.class);
  }

  public static final int ARTICLEID_FIELD_NUMBER = 1;
  private int articleId_ = 0;
  /**
   * <code>int32 articleId = 1;</code>
   * @return The articleId.
   */
  @java.lang.Override
  public int getArticleId() {
    return articleId_;
  }

  public static final int USER_FIELD_NUMBER = 2;
  @SuppressWarnings("serial")
  private volatile java.lang.Object user_ = "";
  /**
   * <code>string user = 2;</code>
   * @return The user.
   */
  @java.lang.Override
  public java.lang.String getUser() {
    java.lang.Object ref = user_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      user_ = s;
      return s;
    }
  }
  /**
   * <code>string user = 2;</code>
   * @return The bytes for user.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getUserBytes() {
    java.lang.Object ref = user_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      user_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int USERPORT_FIELD_NUMBER = 3;
  private int userPort_ = 0;
  /**
   * <code>int32 userPort = 3;</code>
   * @return The userPort.
   */
  @java.lang.Override
  public int getUserPort() {
    return userPort_;
  }

  public static final int USERIP_FIELD_NUMBER = 4;
  @SuppressWarnings("serial")
  private volatile java.lang.Object userIP_ = "";
  /**
   * <code>string userIP = 4;</code>
   * @return The userIP.
   */
  @java.lang.Override
  public java.lang.String getUserIP() {
    java.lang.Object ref = userIP_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      userIP_ = s;
      return s;
    }
  }
  /**
   * <code>string userIP = 4;</code>
   * @return The bytes for userIP.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getUserIPBytes() {
    java.lang.Object ref = userIP_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      userIP_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
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
    if (articleId_ != 0) {
      output.writeInt32(1, articleId_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(user_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, user_);
    }
    if (userPort_ != 0) {
      output.writeInt32(3, userPort_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(userIP_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 4, userIP_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (articleId_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, articleId_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(user_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, user_);
    }
    if (userPort_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(3, userPort_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(userIP_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, userIP_);
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
    if (!(obj instanceof auction.managment.auctions.RegistrationInfo)) {
      return super.equals(obj);
    }
    auction.managment.auctions.RegistrationInfo other = (auction.managment.auctions.RegistrationInfo) obj;

    if (getArticleId()
        != other.getArticleId()) return false;
    if (!getUser()
        .equals(other.getUser())) return false;
    if (getUserPort()
        != other.getUserPort()) return false;
    if (!getUserIP()
        .equals(other.getUserIP())) return false;
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
    hash = (37 * hash) + ARTICLEID_FIELD_NUMBER;
    hash = (53 * hash) + getArticleId();
    hash = (37 * hash) + USER_FIELD_NUMBER;
    hash = (53 * hash) + getUser().hashCode();
    hash = (37 * hash) + USERPORT_FIELD_NUMBER;
    hash = (53 * hash) + getUserPort();
    hash = (37 * hash) + USERIP_FIELD_NUMBER;
    hash = (53 * hash) + getUserIP().hashCode();
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static auction.managment.auctions.RegistrationInfo parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static auction.managment.auctions.RegistrationInfo parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static auction.managment.auctions.RegistrationInfo parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static auction.managment.auctions.RegistrationInfo parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static auction.managment.auctions.RegistrationInfo parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static auction.managment.auctions.RegistrationInfo parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static auction.managment.auctions.RegistrationInfo parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static auction.managment.auctions.RegistrationInfo parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static auction.managment.auctions.RegistrationInfo parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static auction.managment.auctions.RegistrationInfo parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static auction.managment.auctions.RegistrationInfo parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static auction.managment.auctions.RegistrationInfo parseFrom(
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
  public static Builder newBuilder(auction.managment.auctions.RegistrationInfo prototype) {
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
   * Protobuf type {@code auction.RegistrationInfo}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:auction.RegistrationInfo)
      auction.managment.auctions.RegistrationInfoOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return auction.managment.auctions.RegistrationInfoOuterClass.internal_static_auction_RegistrationInfo_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return auction.managment.auctions.RegistrationInfoOuterClass.internal_static_auction_RegistrationInfo_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              auction.managment.auctions.RegistrationInfo.class, auction.managment.auctions.RegistrationInfo.Builder.class);
    }

    // Construct using auction.managment.auctions.RegistrationInfo.newBuilder()
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
      articleId_ = 0;
      user_ = "";
      userPort_ = 0;
      userIP_ = "";
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return auction.managment.auctions.RegistrationInfoOuterClass.internal_static_auction_RegistrationInfo_descriptor;
    }

    @java.lang.Override
    public auction.managment.auctions.RegistrationInfo getDefaultInstanceForType() {
      return auction.managment.auctions.RegistrationInfo.getDefaultInstance();
    }

    @java.lang.Override
    public auction.managment.auctions.RegistrationInfo build() {
      auction.managment.auctions.RegistrationInfo result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public auction.managment.auctions.RegistrationInfo buildPartial() {
      auction.managment.auctions.RegistrationInfo result = new auction.managment.auctions.RegistrationInfo(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(auction.managment.auctions.RegistrationInfo result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.articleId_ = articleId_;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.user_ = user_;
      }
      if (((from_bitField0_ & 0x00000004) != 0)) {
        result.userPort_ = userPort_;
      }
      if (((from_bitField0_ & 0x00000008) != 0)) {
        result.userIP_ = userIP_;
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
      if (other instanceof auction.managment.auctions.RegistrationInfo) {
        return mergeFrom((auction.managment.auctions.RegistrationInfo)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(auction.managment.auctions.RegistrationInfo other) {
      if (other == auction.managment.auctions.RegistrationInfo.getDefaultInstance()) return this;
      if (other.getArticleId() != 0) {
        setArticleId(other.getArticleId());
      }
      if (!other.getUser().isEmpty()) {
        user_ = other.user_;
        bitField0_ |= 0x00000002;
        onChanged();
      }
      if (other.getUserPort() != 0) {
        setUserPort(other.getUserPort());
      }
      if (!other.getUserIP().isEmpty()) {
        userIP_ = other.userIP_;
        bitField0_ |= 0x00000008;
        onChanged();
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
              articleId_ = input.readInt32();
              bitField0_ |= 0x00000001;
              break;
            } // case 8
            case 18: {
              user_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000002;
              break;
            } // case 18
            case 24: {
              userPort_ = input.readInt32();
              bitField0_ |= 0x00000004;
              break;
            } // case 24
            case 34: {
              userIP_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000008;
              break;
            } // case 34
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

    private int articleId_ ;
    /**
     * <code>int32 articleId = 1;</code>
     * @return The articleId.
     */
    @java.lang.Override
    public int getArticleId() {
      return articleId_;
    }
    /**
     * <code>int32 articleId = 1;</code>
     * @param value The articleId to set.
     * @return This builder for chaining.
     */
    public Builder setArticleId(int value) {

      articleId_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>int32 articleId = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearArticleId() {
      bitField0_ = (bitField0_ & ~0x00000001);
      articleId_ = 0;
      onChanged();
      return this;
    }

    private java.lang.Object user_ = "";
    /**
     * <code>string user = 2;</code>
     * @return The user.
     */
    public java.lang.String getUser() {
      java.lang.Object ref = user_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        user_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string user = 2;</code>
     * @return The bytes for user.
     */
    public com.google.protobuf.ByteString
        getUserBytes() {
      java.lang.Object ref = user_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        user_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string user = 2;</code>
     * @param value The user to set.
     * @return This builder for chaining.
     */
    public Builder setUser(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      user_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>string user = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearUser() {
      user_ = getDefaultInstance().getUser();
      bitField0_ = (bitField0_ & ~0x00000002);
      onChanged();
      return this;
    }
    /**
     * <code>string user = 2;</code>
     * @param value The bytes for user to set.
     * @return This builder for chaining.
     */
    public Builder setUserBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      user_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }

    private int userPort_ ;
    /**
     * <code>int32 userPort = 3;</code>
     * @return The userPort.
     */
    @java.lang.Override
    public int getUserPort() {
      return userPort_;
    }
    /**
     * <code>int32 userPort = 3;</code>
     * @param value The userPort to set.
     * @return This builder for chaining.
     */
    public Builder setUserPort(int value) {

      userPort_ = value;
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }
    /**
     * <code>int32 userPort = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearUserPort() {
      bitField0_ = (bitField0_ & ~0x00000004);
      userPort_ = 0;
      onChanged();
      return this;
    }

    private java.lang.Object userIP_ = "";
    /**
     * <code>string userIP = 4;</code>
     * @return The userIP.
     */
    public java.lang.String getUserIP() {
      java.lang.Object ref = userIP_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        userIP_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string userIP = 4;</code>
     * @return The bytes for userIP.
     */
    public com.google.protobuf.ByteString
        getUserIPBytes() {
      java.lang.Object ref = userIP_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        userIP_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string userIP = 4;</code>
     * @param value The userIP to set.
     * @return This builder for chaining.
     */
    public Builder setUserIP(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      userIP_ = value;
      bitField0_ |= 0x00000008;
      onChanged();
      return this;
    }
    /**
     * <code>string userIP = 4;</code>
     * @return This builder for chaining.
     */
    public Builder clearUserIP() {
      userIP_ = getDefaultInstance().getUserIP();
      bitField0_ = (bitField0_ & ~0x00000008);
      onChanged();
      return this;
    }
    /**
     * <code>string userIP = 4;</code>
     * @param value The bytes for userIP to set.
     * @return This builder for chaining.
     */
    public Builder setUserIPBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      userIP_ = value;
      bitField0_ |= 0x00000008;
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


    // @@protoc_insertion_point(builder_scope:auction.RegistrationInfo)
  }

  // @@protoc_insertion_point(class_scope:auction.RegistrationInfo)
  private static final auction.managment.auctions.RegistrationInfo DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new auction.managment.auctions.RegistrationInfo();
  }

  public static auction.managment.auctions.RegistrationInfo getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<RegistrationInfo>
      PARSER = new com.google.protobuf.AbstractParser<RegistrationInfo>() {
    @java.lang.Override
    public RegistrationInfo parsePartialFrom(
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

  public static com.google.protobuf.Parser<RegistrationInfo> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<RegistrationInfo> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public auction.managment.auctions.RegistrationInfo getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

