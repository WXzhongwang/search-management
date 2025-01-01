// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: admin/meta.proto

package com.rany.service.platform.meta;

/**
 * Protobuf type {@code ListIndexDetailsReply}
 */
public  final class ListIndexDetailsReply extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:ListIndexDetailsReply)
    ListIndexDetailsReplyOrBuilder {
private static final long serialVersionUID = 0L;
  // Use ListIndexDetailsReply.newBuilder() to construct.
  private ListIndexDetailsReply(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ListIndexDetailsReply() {
    code_ = 0;
    message_ = "";
    indices_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private ListIndexDetailsReply(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    int mutable_bitField0_ = 0;
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
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
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
            if (!((mutable_bitField0_ & 0x00000004) == 0x00000004)) {
              indices_ = new java.util.ArrayList<com.rany.service.platform.meta.IndexInfo>();
              mutable_bitField0_ |= 0x00000004;
            }
            indices_.add(
                input.readMessage(com.rany.service.platform.meta.IndexInfo.parser(), extensionRegistry));
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
      if (((mutable_bitField0_ & 0x00000004) == 0x00000004)) {
        indices_ = java.util.Collections.unmodifiableList(indices_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.rany.service.platform.meta.SearchMiddlePlatformMetaService.internal_static_ListIndexDetailsReply_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.rany.service.platform.meta.SearchMiddlePlatformMetaService.internal_static_ListIndexDetailsReply_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.rany.service.platform.meta.ListIndexDetailsReply.class, com.rany.service.platform.meta.ListIndexDetailsReply.Builder.class);
  }

  private int bitField0_;
  public static final int CODE_FIELD_NUMBER = 1;
  private int code_;
  /**
   * <code>int32 code = 1;</code>
   */
  public int getCode() {
    return code_;
  }

  public static final int MESSAGE_FIELD_NUMBER = 2;
  private volatile java.lang.Object message_;
  /**
   * <code>string message = 2;</code>
   */
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
   */
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

  public static final int INDICES_FIELD_NUMBER = 3;
  private java.util.List<com.rany.service.platform.meta.IndexInfo> indices_;
  /**
   * <code>repeated .IndexInfo indices = 3;</code>
   */
  public java.util.List<com.rany.service.platform.meta.IndexInfo> getIndicesList() {
    return indices_;
  }
  /**
   * <code>repeated .IndexInfo indices = 3;</code>
   */
  public java.util.List<? extends com.rany.service.platform.meta.IndexInfoOrBuilder> 
      getIndicesOrBuilderList() {
    return indices_;
  }
  /**
   * <code>repeated .IndexInfo indices = 3;</code>
   */
  public int getIndicesCount() {
    return indices_.size();
  }
  /**
   * <code>repeated .IndexInfo indices = 3;</code>
   */
  public com.rany.service.platform.meta.IndexInfo getIndices(int index) {
    return indices_.get(index);
  }
  /**
   * <code>repeated .IndexInfo indices = 3;</code>
   */
  public com.rany.service.platform.meta.IndexInfoOrBuilder getIndicesOrBuilder(
      int index) {
    return indices_.get(index);
  }

  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (code_ != 0) {
      output.writeInt32(1, code_);
    }
    if (!getMessageBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, message_);
    }
    for (int i = 0; i < indices_.size(); i++) {
      output.writeMessage(3, indices_.get(i));
    }
    unknownFields.writeTo(output);
  }

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
    for (int i = 0; i < indices_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(3, indices_.get(i));
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
    if (!(obj instanceof com.rany.service.platform.meta.ListIndexDetailsReply)) {
      return super.equals(obj);
    }
    com.rany.service.platform.meta.ListIndexDetailsReply other = (com.rany.service.platform.meta.ListIndexDetailsReply) obj;

    boolean result = true;
    result = result && (getCode()
        == other.getCode());
    result = result && getMessage()
        .equals(other.getMessage());
    result = result && getIndicesList()
        .equals(other.getIndicesList());
    result = result && unknownFields.equals(other.unknownFields);
    return result;
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
    if (getIndicesCount() > 0) {
      hash = (37 * hash) + INDICES_FIELD_NUMBER;
      hash = (53 * hash) + getIndicesList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.rany.service.platform.meta.ListIndexDetailsReply parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.rany.service.platform.meta.ListIndexDetailsReply parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.rany.service.platform.meta.ListIndexDetailsReply parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.rany.service.platform.meta.ListIndexDetailsReply parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.rany.service.platform.meta.ListIndexDetailsReply parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.rany.service.platform.meta.ListIndexDetailsReply parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.rany.service.platform.meta.ListIndexDetailsReply parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.rany.service.platform.meta.ListIndexDetailsReply parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.rany.service.platform.meta.ListIndexDetailsReply parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.rany.service.platform.meta.ListIndexDetailsReply parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.rany.service.platform.meta.ListIndexDetailsReply parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.rany.service.platform.meta.ListIndexDetailsReply parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.rany.service.platform.meta.ListIndexDetailsReply prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
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
   * Protobuf type {@code ListIndexDetailsReply}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:ListIndexDetailsReply)
      com.rany.service.platform.meta.ListIndexDetailsReplyOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.rany.service.platform.meta.SearchMiddlePlatformMetaService.internal_static_ListIndexDetailsReply_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.rany.service.platform.meta.SearchMiddlePlatformMetaService.internal_static_ListIndexDetailsReply_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.rany.service.platform.meta.ListIndexDetailsReply.class, com.rany.service.platform.meta.ListIndexDetailsReply.Builder.class);
    }

    // Construct using com.rany.service.platform.meta.ListIndexDetailsReply.newBuilder()
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
        getIndicesFieldBuilder();
      }
    }
    public Builder clear() {
      super.clear();
      code_ = 0;

      message_ = "";

      if (indicesBuilder_ == null) {
        indices_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000004);
      } else {
        indicesBuilder_.clear();
      }
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.rany.service.platform.meta.SearchMiddlePlatformMetaService.internal_static_ListIndexDetailsReply_descriptor;
    }

    public com.rany.service.platform.meta.ListIndexDetailsReply getDefaultInstanceForType() {
      return com.rany.service.platform.meta.ListIndexDetailsReply.getDefaultInstance();
    }

    public com.rany.service.platform.meta.ListIndexDetailsReply build() {
      com.rany.service.platform.meta.ListIndexDetailsReply result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.rany.service.platform.meta.ListIndexDetailsReply buildPartial() {
      com.rany.service.platform.meta.ListIndexDetailsReply result = new com.rany.service.platform.meta.ListIndexDetailsReply(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      result.code_ = code_;
      result.message_ = message_;
      if (indicesBuilder_ == null) {
        if (((bitField0_ & 0x00000004) == 0x00000004)) {
          indices_ = java.util.Collections.unmodifiableList(indices_);
          bitField0_ = (bitField0_ & ~0x00000004);
        }
        result.indices_ = indices_;
      } else {
        result.indices_ = indicesBuilder_.build();
      }
      result.bitField0_ = to_bitField0_;
      onBuilt();
      return result;
    }

    public Builder clone() {
      return (Builder) super.clone();
    }
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.rany.service.platform.meta.ListIndexDetailsReply) {
        return mergeFrom((com.rany.service.platform.meta.ListIndexDetailsReply)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.rany.service.platform.meta.ListIndexDetailsReply other) {
      if (other == com.rany.service.platform.meta.ListIndexDetailsReply.getDefaultInstance()) return this;
      if (other.getCode() != 0) {
        setCode(other.getCode());
      }
      if (!other.getMessage().isEmpty()) {
        message_ = other.message_;
        onChanged();
      }
      if (indicesBuilder_ == null) {
        if (!other.indices_.isEmpty()) {
          if (indices_.isEmpty()) {
            indices_ = other.indices_;
            bitField0_ = (bitField0_ & ~0x00000004);
          } else {
            ensureIndicesIsMutable();
            indices_.addAll(other.indices_);
          }
          onChanged();
        }
      } else {
        if (!other.indices_.isEmpty()) {
          if (indicesBuilder_.isEmpty()) {
            indicesBuilder_.dispose();
            indicesBuilder_ = null;
            indices_ = other.indices_;
            bitField0_ = (bitField0_ & ~0x00000004);
            indicesBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getIndicesFieldBuilder() : null;
          } else {
            indicesBuilder_.addAllMessages(other.indices_);
          }
        }
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      com.rany.service.platform.meta.ListIndexDetailsReply parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.rany.service.platform.meta.ListIndexDetailsReply) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private int code_ ;
    /**
     * <code>int32 code = 1;</code>
     */
    public int getCode() {
      return code_;
    }
    /**
     * <code>int32 code = 1;</code>
     */
    public Builder setCode(int value) {
      
      code_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 code = 1;</code>
     */
    public Builder clearCode() {
      
      code_ = 0;
      onChanged();
      return this;
    }

    private java.lang.Object message_ = "";
    /**
     * <code>string message = 2;</code>
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
     */
    public Builder clearMessage() {
      
      message_ = getDefaultInstance().getMessage();
      onChanged();
      return this;
    }
    /**
     * <code>string message = 2;</code>
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

    private java.util.List<com.rany.service.platform.meta.IndexInfo> indices_ =
      java.util.Collections.emptyList();
    private void ensureIndicesIsMutable() {
      if (!((bitField0_ & 0x00000004) == 0x00000004)) {
        indices_ = new java.util.ArrayList<com.rany.service.platform.meta.IndexInfo>(indices_);
        bitField0_ |= 0x00000004;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.rany.service.platform.meta.IndexInfo, com.rany.service.platform.meta.IndexInfo.Builder, com.rany.service.platform.meta.IndexInfoOrBuilder> indicesBuilder_;

    /**
     * <code>repeated .IndexInfo indices = 3;</code>
     */
    public java.util.List<com.rany.service.platform.meta.IndexInfo> getIndicesList() {
      if (indicesBuilder_ == null) {
        return java.util.Collections.unmodifiableList(indices_);
      } else {
        return indicesBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .IndexInfo indices = 3;</code>
     */
    public int getIndicesCount() {
      if (indicesBuilder_ == null) {
        return indices_.size();
      } else {
        return indicesBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .IndexInfo indices = 3;</code>
     */
    public com.rany.service.platform.meta.IndexInfo getIndices(int index) {
      if (indicesBuilder_ == null) {
        return indices_.get(index);
      } else {
        return indicesBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .IndexInfo indices = 3;</code>
     */
    public Builder setIndices(
        int index, com.rany.service.platform.meta.IndexInfo value) {
      if (indicesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureIndicesIsMutable();
        indices_.set(index, value);
        onChanged();
      } else {
        indicesBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .IndexInfo indices = 3;</code>
     */
    public Builder setIndices(
        int index, com.rany.service.platform.meta.IndexInfo.Builder builderForValue) {
      if (indicesBuilder_ == null) {
        ensureIndicesIsMutable();
        indices_.set(index, builderForValue.build());
        onChanged();
      } else {
        indicesBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .IndexInfo indices = 3;</code>
     */
    public Builder addIndices(com.rany.service.platform.meta.IndexInfo value) {
      if (indicesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureIndicesIsMutable();
        indices_.add(value);
        onChanged();
      } else {
        indicesBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .IndexInfo indices = 3;</code>
     */
    public Builder addIndices(
        int index, com.rany.service.platform.meta.IndexInfo value) {
      if (indicesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureIndicesIsMutable();
        indices_.add(index, value);
        onChanged();
      } else {
        indicesBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .IndexInfo indices = 3;</code>
     */
    public Builder addIndices(
        com.rany.service.platform.meta.IndexInfo.Builder builderForValue) {
      if (indicesBuilder_ == null) {
        ensureIndicesIsMutable();
        indices_.add(builderForValue.build());
        onChanged();
      } else {
        indicesBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .IndexInfo indices = 3;</code>
     */
    public Builder addIndices(
        int index, com.rany.service.platform.meta.IndexInfo.Builder builderForValue) {
      if (indicesBuilder_ == null) {
        ensureIndicesIsMutable();
        indices_.add(index, builderForValue.build());
        onChanged();
      } else {
        indicesBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .IndexInfo indices = 3;</code>
     */
    public Builder addAllIndices(
        java.lang.Iterable<? extends com.rany.service.platform.meta.IndexInfo> values) {
      if (indicesBuilder_ == null) {
        ensureIndicesIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, indices_);
        onChanged();
      } else {
        indicesBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .IndexInfo indices = 3;</code>
     */
    public Builder clearIndices() {
      if (indicesBuilder_ == null) {
        indices_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000004);
        onChanged();
      } else {
        indicesBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .IndexInfo indices = 3;</code>
     */
    public Builder removeIndices(int index) {
      if (indicesBuilder_ == null) {
        ensureIndicesIsMutable();
        indices_.remove(index);
        onChanged();
      } else {
        indicesBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .IndexInfo indices = 3;</code>
     */
    public com.rany.service.platform.meta.IndexInfo.Builder getIndicesBuilder(
        int index) {
      return getIndicesFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .IndexInfo indices = 3;</code>
     */
    public com.rany.service.platform.meta.IndexInfoOrBuilder getIndicesOrBuilder(
        int index) {
      if (indicesBuilder_ == null) {
        return indices_.get(index);  } else {
        return indicesBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .IndexInfo indices = 3;</code>
     */
    public java.util.List<? extends com.rany.service.platform.meta.IndexInfoOrBuilder> 
         getIndicesOrBuilderList() {
      if (indicesBuilder_ != null) {
        return indicesBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(indices_);
      }
    }
    /**
     * <code>repeated .IndexInfo indices = 3;</code>
     */
    public com.rany.service.platform.meta.IndexInfo.Builder addIndicesBuilder() {
      return getIndicesFieldBuilder().addBuilder(
          com.rany.service.platform.meta.IndexInfo.getDefaultInstance());
    }
    /**
     * <code>repeated .IndexInfo indices = 3;</code>
     */
    public com.rany.service.platform.meta.IndexInfo.Builder addIndicesBuilder(
        int index) {
      return getIndicesFieldBuilder().addBuilder(
          index, com.rany.service.platform.meta.IndexInfo.getDefaultInstance());
    }
    /**
     * <code>repeated .IndexInfo indices = 3;</code>
     */
    public java.util.List<com.rany.service.platform.meta.IndexInfo.Builder> 
         getIndicesBuilderList() {
      return getIndicesFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.rany.service.platform.meta.IndexInfo, com.rany.service.platform.meta.IndexInfo.Builder, com.rany.service.platform.meta.IndexInfoOrBuilder> 
        getIndicesFieldBuilder() {
      if (indicesBuilder_ == null) {
        indicesBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            com.rany.service.platform.meta.IndexInfo, com.rany.service.platform.meta.IndexInfo.Builder, com.rany.service.platform.meta.IndexInfoOrBuilder>(
                indices_,
                ((bitField0_ & 0x00000004) == 0x00000004),
                getParentForChildren(),
                isClean());
        indices_ = null;
      }
      return indicesBuilder_;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:ListIndexDetailsReply)
  }

  // @@protoc_insertion_point(class_scope:ListIndexDetailsReply)
  private static final com.rany.service.platform.meta.ListIndexDetailsReply DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.rany.service.platform.meta.ListIndexDetailsReply();
  }

  public static com.rany.service.platform.meta.ListIndexDetailsReply getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ListIndexDetailsReply>
      PARSER = new com.google.protobuf.AbstractParser<ListIndexDetailsReply>() {
    public ListIndexDetailsReply parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new ListIndexDetailsReply(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<ListIndexDetailsReply> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ListIndexDetailsReply> getParserForType() {
    return PARSER;
  }

  public com.rany.service.platform.meta.ListIndexDetailsReply getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
