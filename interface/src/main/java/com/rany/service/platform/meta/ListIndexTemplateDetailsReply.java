// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: admin/meta.proto

package com.rany.service.platform.meta;

/**
 * Protobuf type {@code ListIndexTemplateDetailsReply}
 */
public final class ListIndexTemplateDetailsReply extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:ListIndexTemplateDetailsReply)
    ListIndexTemplateDetailsReplyOrBuilder {
private static final long serialVersionUID = 0L;
  // Use ListIndexTemplateDetailsReply.newBuilder() to construct.
  private ListIndexTemplateDetailsReply(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ListIndexTemplateDetailsReply() {
    message_ = "";
    templates_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new ListIndexTemplateDetailsReply();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private ListIndexTemplateDetailsReply(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
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
            if (!((mutable_bitField0_ & 0x00000001) != 0)) {
              templates_ = new java.util.ArrayList<com.rany.service.platform.meta.IndexTemplateInfo>();
              mutable_bitField0_ |= 0x00000001;
            }
            templates_.add(
                input.readMessage(com.rany.service.platform.meta.IndexTemplateInfo.parser(), extensionRegistry));
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
      if (((mutable_bitField0_ & 0x00000001) != 0)) {
        templates_ = java.util.Collections.unmodifiableList(templates_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.rany.service.platform.meta.SearchMiddlePlatformMetaService.internal_static_ListIndexTemplateDetailsReply_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.rany.service.platform.meta.SearchMiddlePlatformMetaService.internal_static_ListIndexTemplateDetailsReply_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.rany.service.platform.meta.ListIndexTemplateDetailsReply.class, com.rany.service.platform.meta.ListIndexTemplateDetailsReply.Builder.class);
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

  public static final int TEMPLATES_FIELD_NUMBER = 3;
  private java.util.List<com.rany.service.platform.meta.IndexTemplateInfo> templates_;
  /**
   * <code>repeated .IndexTemplateInfo templates = 3;</code>
   */
  @java.lang.Override
  public java.util.List<com.rany.service.platform.meta.IndexTemplateInfo> getTemplatesList() {
    return templates_;
  }
  /**
   * <code>repeated .IndexTemplateInfo templates = 3;</code>
   */
  @java.lang.Override
  public java.util.List<? extends com.rany.service.platform.meta.IndexTemplateInfoOrBuilder> 
      getTemplatesOrBuilderList() {
    return templates_;
  }
  /**
   * <code>repeated .IndexTemplateInfo templates = 3;</code>
   */
  @java.lang.Override
  public int getTemplatesCount() {
    return templates_.size();
  }
  /**
   * <code>repeated .IndexTemplateInfo templates = 3;</code>
   */
  @java.lang.Override
  public com.rany.service.platform.meta.IndexTemplateInfo getTemplates(int index) {
    return templates_.get(index);
  }
  /**
   * <code>repeated .IndexTemplateInfo templates = 3;</code>
   */
  @java.lang.Override
  public com.rany.service.platform.meta.IndexTemplateInfoOrBuilder getTemplatesOrBuilder(
      int index) {
    return templates_.get(index);
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
    for (int i = 0; i < templates_.size(); i++) {
      output.writeMessage(3, templates_.get(i));
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
    for (int i = 0; i < templates_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(3, templates_.get(i));
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
    if (!(obj instanceof com.rany.service.platform.meta.ListIndexTemplateDetailsReply)) {
      return super.equals(obj);
    }
    com.rany.service.platform.meta.ListIndexTemplateDetailsReply other = (com.rany.service.platform.meta.ListIndexTemplateDetailsReply) obj;

    if (getCode()
        != other.getCode()) return false;
    if (!getMessage()
        .equals(other.getMessage())) return false;
    if (!getTemplatesList()
        .equals(other.getTemplatesList())) return false;
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
    if (getTemplatesCount() > 0) {
      hash = (37 * hash) + TEMPLATES_FIELD_NUMBER;
      hash = (53 * hash) + getTemplatesList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.rany.service.platform.meta.ListIndexTemplateDetailsReply parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.rany.service.platform.meta.ListIndexTemplateDetailsReply parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.rany.service.platform.meta.ListIndexTemplateDetailsReply parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.rany.service.platform.meta.ListIndexTemplateDetailsReply parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.rany.service.platform.meta.ListIndexTemplateDetailsReply parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.rany.service.platform.meta.ListIndexTemplateDetailsReply parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.rany.service.platform.meta.ListIndexTemplateDetailsReply parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.rany.service.platform.meta.ListIndexTemplateDetailsReply parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.rany.service.platform.meta.ListIndexTemplateDetailsReply parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.rany.service.platform.meta.ListIndexTemplateDetailsReply parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.rany.service.platform.meta.ListIndexTemplateDetailsReply parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.rany.service.platform.meta.ListIndexTemplateDetailsReply parseFrom(
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
  public static Builder newBuilder(com.rany.service.platform.meta.ListIndexTemplateDetailsReply prototype) {
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
   * Protobuf type {@code ListIndexTemplateDetailsReply}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:ListIndexTemplateDetailsReply)
      com.rany.service.platform.meta.ListIndexTemplateDetailsReplyOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.rany.service.platform.meta.SearchMiddlePlatformMetaService.internal_static_ListIndexTemplateDetailsReply_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.rany.service.platform.meta.SearchMiddlePlatformMetaService.internal_static_ListIndexTemplateDetailsReply_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.rany.service.platform.meta.ListIndexTemplateDetailsReply.class, com.rany.service.platform.meta.ListIndexTemplateDetailsReply.Builder.class);
    }

    // Construct using com.rany.service.platform.meta.ListIndexTemplateDetailsReply.newBuilder()
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
        getTemplatesFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      code_ = 0;

      message_ = "";

      if (templatesBuilder_ == null) {
        templates_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        templatesBuilder_.clear();
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.rany.service.platform.meta.SearchMiddlePlatformMetaService.internal_static_ListIndexTemplateDetailsReply_descriptor;
    }

    @java.lang.Override
    public com.rany.service.platform.meta.ListIndexTemplateDetailsReply getDefaultInstanceForType() {
      return com.rany.service.platform.meta.ListIndexTemplateDetailsReply.getDefaultInstance();
    }

    @java.lang.Override
    public com.rany.service.platform.meta.ListIndexTemplateDetailsReply build() {
      com.rany.service.platform.meta.ListIndexTemplateDetailsReply result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.rany.service.platform.meta.ListIndexTemplateDetailsReply buildPartial() {
      com.rany.service.platform.meta.ListIndexTemplateDetailsReply result = new com.rany.service.platform.meta.ListIndexTemplateDetailsReply(this);
      int from_bitField0_ = bitField0_;
      result.code_ = code_;
      result.message_ = message_;
      if (templatesBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          templates_ = java.util.Collections.unmodifiableList(templates_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.templates_ = templates_;
      } else {
        result.templates_ = templatesBuilder_.build();
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
      if (other instanceof com.rany.service.platform.meta.ListIndexTemplateDetailsReply) {
        return mergeFrom((com.rany.service.platform.meta.ListIndexTemplateDetailsReply)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.rany.service.platform.meta.ListIndexTemplateDetailsReply other) {
      if (other == com.rany.service.platform.meta.ListIndexTemplateDetailsReply.getDefaultInstance()) return this;
      if (other.getCode() != 0) {
        setCode(other.getCode());
      }
      if (!other.getMessage().isEmpty()) {
        message_ = other.message_;
        onChanged();
      }
      if (templatesBuilder_ == null) {
        if (!other.templates_.isEmpty()) {
          if (templates_.isEmpty()) {
            templates_ = other.templates_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureTemplatesIsMutable();
            templates_.addAll(other.templates_);
          }
          onChanged();
        }
      } else {
        if (!other.templates_.isEmpty()) {
          if (templatesBuilder_.isEmpty()) {
            templatesBuilder_.dispose();
            templatesBuilder_ = null;
            templates_ = other.templates_;
            bitField0_ = (bitField0_ & ~0x00000001);
            templatesBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getTemplatesFieldBuilder() : null;
          } else {
            templatesBuilder_.addAllMessages(other.templates_);
          }
        }
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
      com.rany.service.platform.meta.ListIndexTemplateDetailsReply parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.rany.service.platform.meta.ListIndexTemplateDetailsReply) e.getUnfinishedMessage();
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

    private java.util.List<com.rany.service.platform.meta.IndexTemplateInfo> templates_ =
      java.util.Collections.emptyList();
    private void ensureTemplatesIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        templates_ = new java.util.ArrayList<com.rany.service.platform.meta.IndexTemplateInfo>(templates_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.rany.service.platform.meta.IndexTemplateInfo, com.rany.service.platform.meta.IndexTemplateInfo.Builder, com.rany.service.platform.meta.IndexTemplateInfoOrBuilder> templatesBuilder_;

    /**
     * <code>repeated .IndexTemplateInfo templates = 3;</code>
     */
    public java.util.List<com.rany.service.platform.meta.IndexTemplateInfo> getTemplatesList() {
      if (templatesBuilder_ == null) {
        return java.util.Collections.unmodifiableList(templates_);
      } else {
        return templatesBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .IndexTemplateInfo templates = 3;</code>
     */
    public int getTemplatesCount() {
      if (templatesBuilder_ == null) {
        return templates_.size();
      } else {
        return templatesBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .IndexTemplateInfo templates = 3;</code>
     */
    public com.rany.service.platform.meta.IndexTemplateInfo getTemplates(int index) {
      if (templatesBuilder_ == null) {
        return templates_.get(index);
      } else {
        return templatesBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .IndexTemplateInfo templates = 3;</code>
     */
    public Builder setTemplates(
        int index, com.rany.service.platform.meta.IndexTemplateInfo value) {
      if (templatesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureTemplatesIsMutable();
        templates_.set(index, value);
        onChanged();
      } else {
        templatesBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .IndexTemplateInfo templates = 3;</code>
     */
    public Builder setTemplates(
        int index, com.rany.service.platform.meta.IndexTemplateInfo.Builder builderForValue) {
      if (templatesBuilder_ == null) {
        ensureTemplatesIsMutable();
        templates_.set(index, builderForValue.build());
        onChanged();
      } else {
        templatesBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .IndexTemplateInfo templates = 3;</code>
     */
    public Builder addTemplates(com.rany.service.platform.meta.IndexTemplateInfo value) {
      if (templatesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureTemplatesIsMutable();
        templates_.add(value);
        onChanged();
      } else {
        templatesBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .IndexTemplateInfo templates = 3;</code>
     */
    public Builder addTemplates(
        int index, com.rany.service.platform.meta.IndexTemplateInfo value) {
      if (templatesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureTemplatesIsMutable();
        templates_.add(index, value);
        onChanged();
      } else {
        templatesBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .IndexTemplateInfo templates = 3;</code>
     */
    public Builder addTemplates(
        com.rany.service.platform.meta.IndexTemplateInfo.Builder builderForValue) {
      if (templatesBuilder_ == null) {
        ensureTemplatesIsMutable();
        templates_.add(builderForValue.build());
        onChanged();
      } else {
        templatesBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .IndexTemplateInfo templates = 3;</code>
     */
    public Builder addTemplates(
        int index, com.rany.service.platform.meta.IndexTemplateInfo.Builder builderForValue) {
      if (templatesBuilder_ == null) {
        ensureTemplatesIsMutable();
        templates_.add(index, builderForValue.build());
        onChanged();
      } else {
        templatesBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .IndexTemplateInfo templates = 3;</code>
     */
    public Builder addAllTemplates(
        java.lang.Iterable<? extends com.rany.service.platform.meta.IndexTemplateInfo> values) {
      if (templatesBuilder_ == null) {
        ensureTemplatesIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, templates_);
        onChanged();
      } else {
        templatesBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .IndexTemplateInfo templates = 3;</code>
     */
    public Builder clearTemplates() {
      if (templatesBuilder_ == null) {
        templates_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        templatesBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .IndexTemplateInfo templates = 3;</code>
     */
    public Builder removeTemplates(int index) {
      if (templatesBuilder_ == null) {
        ensureTemplatesIsMutable();
        templates_.remove(index);
        onChanged();
      } else {
        templatesBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .IndexTemplateInfo templates = 3;</code>
     */
    public com.rany.service.platform.meta.IndexTemplateInfo.Builder getTemplatesBuilder(
        int index) {
      return getTemplatesFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .IndexTemplateInfo templates = 3;</code>
     */
    public com.rany.service.platform.meta.IndexTemplateInfoOrBuilder getTemplatesOrBuilder(
        int index) {
      if (templatesBuilder_ == null) {
        return templates_.get(index);  } else {
        return templatesBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .IndexTemplateInfo templates = 3;</code>
     */
    public java.util.List<? extends com.rany.service.platform.meta.IndexTemplateInfoOrBuilder> 
         getTemplatesOrBuilderList() {
      if (templatesBuilder_ != null) {
        return templatesBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(templates_);
      }
    }
    /**
     * <code>repeated .IndexTemplateInfo templates = 3;</code>
     */
    public com.rany.service.platform.meta.IndexTemplateInfo.Builder addTemplatesBuilder() {
      return getTemplatesFieldBuilder().addBuilder(
          com.rany.service.platform.meta.IndexTemplateInfo.getDefaultInstance());
    }
    /**
     * <code>repeated .IndexTemplateInfo templates = 3;</code>
     */
    public com.rany.service.platform.meta.IndexTemplateInfo.Builder addTemplatesBuilder(
        int index) {
      return getTemplatesFieldBuilder().addBuilder(
          index, com.rany.service.platform.meta.IndexTemplateInfo.getDefaultInstance());
    }
    /**
     * <code>repeated .IndexTemplateInfo templates = 3;</code>
     */
    public java.util.List<com.rany.service.platform.meta.IndexTemplateInfo.Builder> 
         getTemplatesBuilderList() {
      return getTemplatesFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.rany.service.platform.meta.IndexTemplateInfo, com.rany.service.platform.meta.IndexTemplateInfo.Builder, com.rany.service.platform.meta.IndexTemplateInfoOrBuilder> 
        getTemplatesFieldBuilder() {
      if (templatesBuilder_ == null) {
        templatesBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            com.rany.service.platform.meta.IndexTemplateInfo, com.rany.service.platform.meta.IndexTemplateInfo.Builder, com.rany.service.platform.meta.IndexTemplateInfoOrBuilder>(
                templates_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        templates_ = null;
      }
      return templatesBuilder_;
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


    // @@protoc_insertion_point(builder_scope:ListIndexTemplateDetailsReply)
  }

  // @@protoc_insertion_point(class_scope:ListIndexTemplateDetailsReply)
  private static final com.rany.service.platform.meta.ListIndexTemplateDetailsReply DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.rany.service.platform.meta.ListIndexTemplateDetailsReply();
  }

  public static com.rany.service.platform.meta.ListIndexTemplateDetailsReply getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ListIndexTemplateDetailsReply>
      PARSER = new com.google.protobuf.AbstractParser<ListIndexTemplateDetailsReply>() {
    @java.lang.Override
    public ListIndexTemplateDetailsReply parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new ListIndexTemplateDetailsReply(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<ListIndexTemplateDetailsReply> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ListIndexTemplateDetailsReply> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.rany.service.platform.meta.ListIndexTemplateDetailsReply getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

