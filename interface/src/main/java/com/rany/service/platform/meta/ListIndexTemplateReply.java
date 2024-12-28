// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: admin/meta.proto

package com.rany.service.platform.meta;

/**
 * Protobuf type {@code ListIndexTemplateReply}
 */
public  final class ListIndexTemplateReply extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:ListIndexTemplateReply)
    ListIndexTemplateReplyOrBuilder {
private static final long serialVersionUID = 0L;
  // Use ListIndexTemplateReply.newBuilder() to construct.
  private ListIndexTemplateReply(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ListIndexTemplateReply() {
    code_ = 0;
    message_ = "";
    templates_ = com.google.protobuf.LazyStringArrayList.EMPTY;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private ListIndexTemplateReply(
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
            java.lang.String s = input.readStringRequireUtf8();
            if (!((mutable_bitField0_ & 0x00000004) == 0x00000004)) {
              templates_ = new com.google.protobuf.LazyStringArrayList();
              mutable_bitField0_ |= 0x00000004;
            }
            templates_.add(s);
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
        templates_ = templates_.getUnmodifiableView();
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.rany.service.platform.meta.SearchMiddlePlatformMetaService.internal_static_ListIndexTemplateReply_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.rany.service.platform.meta.SearchMiddlePlatformMetaService.internal_static_ListIndexTemplateReply_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.rany.service.platform.meta.ListIndexTemplateReply.class, com.rany.service.platform.meta.ListIndexTemplateReply.Builder.class);
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

  public static final int TEMPLATES_FIELD_NUMBER = 3;
  private com.google.protobuf.LazyStringList templates_;
  /**
   * <code>repeated string templates = 3;</code>
   */
  public com.google.protobuf.ProtocolStringList
      getTemplatesList() {
    return templates_;
  }
  /**
   * <code>repeated string templates = 3;</code>
   */
  public int getTemplatesCount() {
    return templates_.size();
  }
  /**
   * <code>repeated string templates = 3;</code>
   */
  public java.lang.String getTemplates(int index) {
    return templates_.get(index);
  }
  /**
   * <code>repeated string templates = 3;</code>
   */
  public com.google.protobuf.ByteString
      getTemplatesBytes(int index) {
    return templates_.getByteString(index);
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
    for (int i = 0; i < templates_.size(); i++) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, templates_.getRaw(i));
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
    {
      int dataSize = 0;
      for (int i = 0; i < templates_.size(); i++) {
        dataSize += computeStringSizeNoTag(templates_.getRaw(i));
      }
      size += dataSize;
      size += 1 * getTemplatesList().size();
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
    if (!(obj instanceof com.rany.service.platform.meta.ListIndexTemplateReply)) {
      return super.equals(obj);
    }
    com.rany.service.platform.meta.ListIndexTemplateReply other = (com.rany.service.platform.meta.ListIndexTemplateReply) obj;

    boolean result = true;
    result = result && (getCode()
        == other.getCode());
    result = result && getMessage()
        .equals(other.getMessage());
    result = result && getTemplatesList()
        .equals(other.getTemplatesList());
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
    if (getTemplatesCount() > 0) {
      hash = (37 * hash) + TEMPLATES_FIELD_NUMBER;
      hash = (53 * hash) + getTemplatesList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.rany.service.platform.meta.ListIndexTemplateReply parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.rany.service.platform.meta.ListIndexTemplateReply parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.rany.service.platform.meta.ListIndexTemplateReply parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.rany.service.platform.meta.ListIndexTemplateReply parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.rany.service.platform.meta.ListIndexTemplateReply parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.rany.service.platform.meta.ListIndexTemplateReply parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.rany.service.platform.meta.ListIndexTemplateReply parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.rany.service.platform.meta.ListIndexTemplateReply parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.rany.service.platform.meta.ListIndexTemplateReply parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.rany.service.platform.meta.ListIndexTemplateReply parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.rany.service.platform.meta.ListIndexTemplateReply parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.rany.service.platform.meta.ListIndexTemplateReply parseFrom(
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
  public static Builder newBuilder(com.rany.service.platform.meta.ListIndexTemplateReply prototype) {
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
   * Protobuf type {@code ListIndexTemplateReply}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:ListIndexTemplateReply)
      com.rany.service.platform.meta.ListIndexTemplateReplyOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.rany.service.platform.meta.SearchMiddlePlatformMetaService.internal_static_ListIndexTemplateReply_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.rany.service.platform.meta.SearchMiddlePlatformMetaService.internal_static_ListIndexTemplateReply_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.rany.service.platform.meta.ListIndexTemplateReply.class, com.rany.service.platform.meta.ListIndexTemplateReply.Builder.class);
    }

    // Construct using com.rany.service.platform.meta.ListIndexTemplateReply.newBuilder()
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
    public Builder clear() {
      super.clear();
      code_ = 0;

      message_ = "";

      templates_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      bitField0_ = (bitField0_ & ~0x00000004);
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.rany.service.platform.meta.SearchMiddlePlatformMetaService.internal_static_ListIndexTemplateReply_descriptor;
    }

    public com.rany.service.platform.meta.ListIndexTemplateReply getDefaultInstanceForType() {
      return com.rany.service.platform.meta.ListIndexTemplateReply.getDefaultInstance();
    }

    public com.rany.service.platform.meta.ListIndexTemplateReply build() {
      com.rany.service.platform.meta.ListIndexTemplateReply result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.rany.service.platform.meta.ListIndexTemplateReply buildPartial() {
      com.rany.service.platform.meta.ListIndexTemplateReply result = new com.rany.service.platform.meta.ListIndexTemplateReply(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      result.code_ = code_;
      result.message_ = message_;
      if (((bitField0_ & 0x00000004) == 0x00000004)) {
        templates_ = templates_.getUnmodifiableView();
        bitField0_ = (bitField0_ & ~0x00000004);
      }
      result.templates_ = templates_;
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
      if (other instanceof com.rany.service.platform.meta.ListIndexTemplateReply) {
        return mergeFrom((com.rany.service.platform.meta.ListIndexTemplateReply)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.rany.service.platform.meta.ListIndexTemplateReply other) {
      if (other == com.rany.service.platform.meta.ListIndexTemplateReply.getDefaultInstance()) return this;
      if (other.getCode() != 0) {
        setCode(other.getCode());
      }
      if (!other.getMessage().isEmpty()) {
        message_ = other.message_;
        onChanged();
      }
      if (!other.templates_.isEmpty()) {
        if (templates_.isEmpty()) {
          templates_ = other.templates_;
          bitField0_ = (bitField0_ & ~0x00000004);
        } else {
          ensureTemplatesIsMutable();
          templates_.addAll(other.templates_);
        }
        onChanged();
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
      com.rany.service.platform.meta.ListIndexTemplateReply parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.rany.service.platform.meta.ListIndexTemplateReply) e.getUnfinishedMessage();
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

    private com.google.protobuf.LazyStringList templates_ = com.google.protobuf.LazyStringArrayList.EMPTY;
    private void ensureTemplatesIsMutable() {
      if (!((bitField0_ & 0x00000004) == 0x00000004)) {
        templates_ = new com.google.protobuf.LazyStringArrayList(templates_);
        bitField0_ |= 0x00000004;
       }
    }
    /**
     * <code>repeated string templates = 3;</code>
     */
    public com.google.protobuf.ProtocolStringList
        getTemplatesList() {
      return templates_.getUnmodifiableView();
    }
    /**
     * <code>repeated string templates = 3;</code>
     */
    public int getTemplatesCount() {
      return templates_.size();
    }
    /**
     * <code>repeated string templates = 3;</code>
     */
    public java.lang.String getTemplates(int index) {
      return templates_.get(index);
    }
    /**
     * <code>repeated string templates = 3;</code>
     */
    public com.google.protobuf.ByteString
        getTemplatesBytes(int index) {
      return templates_.getByteString(index);
    }
    /**
     * <code>repeated string templates = 3;</code>
     */
    public Builder setTemplates(
        int index, java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  ensureTemplatesIsMutable();
      templates_.set(index, value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string templates = 3;</code>
     */
    public Builder addTemplates(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  ensureTemplatesIsMutable();
      templates_.add(value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string templates = 3;</code>
     */
    public Builder addAllTemplates(
        java.lang.Iterable<java.lang.String> values) {
      ensureTemplatesIsMutable();
      com.google.protobuf.AbstractMessageLite.Builder.addAll(
          values, templates_);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string templates = 3;</code>
     */
    public Builder clearTemplates() {
      templates_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      bitField0_ = (bitField0_ & ~0x00000004);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string templates = 3;</code>
     */
    public Builder addTemplatesBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      ensureTemplatesIsMutable();
      templates_.add(value);
      onChanged();
      return this;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:ListIndexTemplateReply)
  }

  // @@protoc_insertion_point(class_scope:ListIndexTemplateReply)
  private static final com.rany.service.platform.meta.ListIndexTemplateReply DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.rany.service.platform.meta.ListIndexTemplateReply();
  }

  public static com.rany.service.platform.meta.ListIndexTemplateReply getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ListIndexTemplateReply>
      PARSER = new com.google.protobuf.AbstractParser<ListIndexTemplateReply>() {
    public ListIndexTemplateReply parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new ListIndexTemplateReply(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<ListIndexTemplateReply> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ListIndexTemplateReply> getParserForType() {
    return PARSER;
  }

  public com.rany.service.platform.meta.ListIndexTemplateReply getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

