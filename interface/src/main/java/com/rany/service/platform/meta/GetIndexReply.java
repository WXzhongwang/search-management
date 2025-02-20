// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: admin/meta.proto

package com.rany.service.platform.meta;

/**
 * Protobuf type {@code GetIndexReply}
 */
public final class GetIndexReply extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:GetIndexReply)
    GetIndexReplyOrBuilder {
private static final long serialVersionUID = 0L;
  // Use GetIndexReply.newBuilder() to construct.
  private GetIndexReply(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private GetIndexReply() {
    message_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new GetIndexReply();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private GetIndexReply(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 8: {

            code_ = input.readInt32();
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            message_ = s;
            break;
          }
          case 26: {
            com.rany.service.platform.meta.IndexInfo.Builder subBuilder = null;
            if (index_ != null) {
              subBuilder = index_.toBuilder();
            }
            index_ = input.readMessage(com.rany.service.platform.meta.IndexInfo.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(index_);
              index_ = subBuilder.buildPartial();
            }

            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.rany.service.platform.meta.SearchMiddlePlatformMetaService.internal_static_GetIndexReply_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.rany.service.platform.meta.SearchMiddlePlatformMetaService.internal_static_GetIndexReply_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.rany.service.platform.meta.GetIndexReply.class, com.rany.service.platform.meta.GetIndexReply.Builder.class);
  }

  public static final int CODE_FIELD_NUMBER = 1;
  private int code_;
  /**
   * <code>int32 code = 1;</code>
   * @return The code.
   */
  @java.lang.Override
  public int getCode() {
    return code_;
  }

  public static final int MESSAGE_FIELD_NUMBER = 2;
  private volatile java.lang.Object message_;
  /**
   * <code>string message = 2;</code>
   * @return The message.
   */
  @java.lang.Override
  public java.lang.String getMessage() {
    java.lang.Object ref = message_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      message_ = s;
      return s;
    }
  }
  /**
   * <code>string message = 2;</code>
   * @return The bytes for message.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getMessageBytes() {
    java.lang.Object ref = message_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      message_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int INDEX_FIELD_NUMBER = 3;
  private com.rany.service.platform.meta.IndexInfo index_;
  /**
   * <code>.IndexInfo index = 3;</code>
   * @return Whether the index field is set.
   */
  @java.lang.Override
  public boolean hasIndex() {
    return index_ != null;
  }
  /**
   * <code>.IndexInfo index = 3;</code>
   * @return The index.
   */
  @java.lang.Override
  public com.rany.service.platform.meta.IndexInfo getIndex() {
    return index_ == null ? com.rany.service.platform.meta.IndexInfo.getDefaultInstance() : index_;
  }
  /**
   * <code>.IndexInfo index = 3;</code>
   */
  @java.lang.Override
  public com.rany.service.platform.meta.IndexInfoOrBuilder getIndexOrBuilder() {
    return getIndex();
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
    if (code_ != 0) {
      output.writeInt32(1, code_);
    }
    if (!getMessageBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, message_);
    }
    if (index_ != null) {
      output.writeMessage(3, getIndex());
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (code_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, code_);
    }
    if (!getMessageBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, message_);
    }
    if (index_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(3, getIndex());
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.rany.service.platform.meta.GetIndexReply)) {
      return super.equals(obj);
    }
    com.rany.service.platform.meta.GetIndexReply other = (com.rany.service.platform.meta.GetIndexReply) obj;

    if (getCode()
        != other.getCode()) return false;
    if (!getMessage()
        .equals(other.getMessage())) return false;
    if (hasIndex() != other.hasIndex()) return false;
    if (hasIndex()) {
      if (!getIndex()
          .equals(other.getIndex())) return false;
    }
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + CODE_FIELD_NUMBER;
    hash = (53 * hash) + getCode();
    hash = (37 * hash) + MESSAGE_FIELD_NUMBER;
    hash = (53 * hash) + getMessage().hashCode();
    if (hasIndex()) {
      hash = (37 * hash) + INDEX_FIELD_NUMBER;
      hash = (53 * hash) + getIndex().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.rany.service.platform.meta.GetIndexReply parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.rany.service.platform.meta.GetIndexReply parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.rany.service.platform.meta.GetIndexReply parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.rany.service.platform.meta.GetIndexReply parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.rany.service.platform.meta.GetIndexReply parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.rany.service.platform.meta.GetIndexReply parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.rany.service.platform.meta.GetIndexReply parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.rany.service.platform.meta.GetIndexReply parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.rany.service.platform.meta.GetIndexReply parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.rany.service.platform.meta.GetIndexReply parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.rany.service.platform.meta.GetIndexReply parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.rany.service.platform.meta.GetIndexReply parseFrom(
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
  public static Builder newBuilder(com.rany.service.platform.meta.GetIndexReply prototype) {
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
   * Protobuf type {@code GetIndexReply}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:GetIndexReply)
      com.rany.service.platform.meta.GetIndexReplyOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.rany.service.platform.meta.SearchMiddlePlatformMetaService.internal_static_GetIndexReply_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.rany.service.platform.meta.SearchMiddlePlatformMetaService.internal_static_GetIndexReply_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.rany.service.platform.meta.GetIndexReply.class, com.rany.service.platform.meta.GetIndexReply.Builder.class);
    }

    // Construct using com.rany.service.platform.meta.GetIndexReply.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      code_ = 0;

      message_ = "";

      if (indexBuilder_ == null) {
        index_ = null;
      } else {
        index_ = null;
        indexBuilder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.rany.service.platform.meta.SearchMiddlePlatformMetaService.internal_static_GetIndexReply_descriptor;
    }

    @java.lang.Override
    public com.rany.service.platform.meta.GetIndexReply getDefaultInstanceForType() {
      return com.rany.service.platform.meta.GetIndexReply.getDefaultInstance();
    }

    @java.lang.Override
    public com.rany.service.platform.meta.GetIndexReply build() {
      com.rany.service.platform.meta.GetIndexReply result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.rany.service.platform.meta.GetIndexReply buildPartial() {
      com.rany.service.platform.meta.GetIndexReply result = new com.rany.service.platform.meta.GetIndexReply(this);
      result.code_ = code_;
      result.message_ = message_;
      if (indexBuilder_ == null) {
        result.index_ = index_;
      } else {
        result.index_ = indexBuilder_.build();
      }
      onBuilt();
      return result;
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
      if (other instanceof com.rany.service.platform.meta.GetIndexReply) {
        return mergeFrom((com.rany.service.platform.meta.GetIndexReply)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.rany.service.platform.meta.GetIndexReply other) {
      if (other == com.rany.service.platform.meta.GetIndexReply.getDefaultInstance()) return this;
      if (other.getCode() != 0) {
        setCode(other.getCode());
      }
      if (!other.getMessage().isEmpty()) {
        message_ = other.message_;
        onChanged();
      }
      if (other.hasIndex()) {
        mergeIndex(other.getIndex());
      }
      this.mergeUnknownFields(other.unknownFields);
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
      com.rany.service.platform.meta.GetIndexReply parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.rany.service.platform.meta.GetIndexReply) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int code_ ;
    /**
     * <code>int32 code = 1;</code>
     * @return The code.
     */
    @java.lang.Override
    public int getCode() {
      return code_;
    }
    /**
     * <code>int32 code = 1;</code>
     * @param value The code to set.
     * @return This builder for chaining.
     */
    public Builder setCode(int value) {
      
      code_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 code = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearCode() {
      
      code_ = 0;
      onChanged();
      return this;
    }

    private java.lang.Object message_ = "";
    /**
     * <code>string message = 2;</code>
     * @return The message.
     */
    public java.lang.String getMessage() {
      java.lang.Object ref = message_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        message_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string message = 2;</code>
     * @return The bytes for message.
     */
    public com.google.protobuf.ByteString
        getMessageBytes() {
      java.lang.Object ref = message_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        message_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string message = 2;</code>
     * @param value The message to set.
     * @return This builder for chaining.
     */
    public Builder setMessage(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      message_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string message = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearMessage() {
      
      message_ = getDefaultInstance().getMessage();
      onChanged();
      return this;
    }
    /**
     * <code>string message = 2;</code>
     * @param value The bytes for message to set.
     * @return This builder for chaining.
     */
    public Builder setMessageBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      message_ = value;
      onChanged();
      return this;
    }

    private com.rany.service.platform.meta.IndexInfo index_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.rany.service.platform.meta.IndexInfo, com.rany.service.platform.meta.IndexInfo.Builder, com.rany.service.platform.meta.IndexInfoOrBuilder> indexBuilder_;
    /**
     * <code>.IndexInfo index = 3;</code>
     * @return Whether the index field is set.
     */
    public boolean hasIndex() {
      return indexBuilder_ != null || index_ != null;
    }
    /**
     * <code>.IndexInfo index = 3;</code>
     * @return The index.
     */
    public com.rany.service.platform.meta.IndexInfo getIndex() {
      if (indexBuilder_ == null) {
        return index_ == null ? com.rany.service.platform.meta.IndexInfo.getDefaultInstance() : index_;
      } else {
        return indexBuilder_.getMessage();
      }
    }
    /**
     * <code>.IndexInfo index = 3;</code>
     */
    public Builder setIndex(com.rany.service.platform.meta.IndexInfo value) {
      if (indexBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        index_ = value;
        onChanged();
      } else {
        indexBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.IndexInfo index = 3;</code>
     */
    public Builder setIndex(
        com.rany.service.platform.meta.IndexInfo.Builder builderForValue) {
      if (indexBuilder_ == null) {
        index_ = builderForValue.build();
        onChanged();
      } else {
        indexBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.IndexInfo index = 3;</code>
     */
    public Builder mergeIndex(com.rany.service.platform.meta.IndexInfo value) {
      if (indexBuilder_ == null) {
        if (index_ != null) {
          index_ =
            com.rany.service.platform.meta.IndexInfo.newBuilder(index_).mergeFrom(value).buildPartial();
        } else {
          index_ = value;
        }
        onChanged();
      } else {
        indexBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.IndexInfo index = 3;</code>
     */
    public Builder clearIndex() {
      if (indexBuilder_ == null) {
        index_ = null;
        onChanged();
      } else {
        index_ = null;
        indexBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.IndexInfo index = 3;</code>
     */
    public com.rany.service.platform.meta.IndexInfo.Builder getIndexBuilder() {
      
      onChanged();
      return getIndexFieldBuilder().getBuilder();
    }
    /**
     * <code>.IndexInfo index = 3;</code>
     */
    public com.rany.service.platform.meta.IndexInfoOrBuilder getIndexOrBuilder() {
      if (indexBuilder_ != null) {
        return indexBuilder_.getMessageOrBuilder();
      } else {
        return index_ == null ?
            com.rany.service.platform.meta.IndexInfo.getDefaultInstance() : index_;
      }
    }
    /**
     * <code>.IndexInfo index = 3;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.rany.service.platform.meta.IndexInfo, com.rany.service.platform.meta.IndexInfo.Builder, com.rany.service.platform.meta.IndexInfoOrBuilder> 
        getIndexFieldBuilder() {
      if (indexBuilder_ == null) {
        indexBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.rany.service.platform.meta.IndexInfo, com.rany.service.platform.meta.IndexInfo.Builder, com.rany.service.platform.meta.IndexInfoOrBuilder>(
                getIndex(),
                getParentForChildren(),
                isClean());
        index_ = null;
      }
      return indexBuilder_;
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


    // @@protoc_insertion_point(builder_scope:GetIndexReply)
  }

  // @@protoc_insertion_point(class_scope:GetIndexReply)
  private static final com.rany.service.platform.meta.GetIndexReply DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.rany.service.platform.meta.GetIndexReply();
  }

  public static com.rany.service.platform.meta.GetIndexReply getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<GetIndexReply>
      PARSER = new com.google.protobuf.AbstractParser<GetIndexReply>() {
    @java.lang.Override
    public GetIndexReply parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new GetIndexReply(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<GetIndexReply> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<GetIndexReply> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.rany.service.platform.meta.GetIndexReply getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

