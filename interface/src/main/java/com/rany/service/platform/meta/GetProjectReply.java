// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: admin/meta.proto

package com.rany.service.platform.meta;

/**
 * Protobuf type {@code GetProjectReply}
 */
public final class GetProjectReply extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:GetProjectReply)
    GetProjectReplyOrBuilder {
private static final long serialVersionUID = 0L;
  // Use GetProjectReply.newBuilder() to construct.
  private GetProjectReply(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private GetProjectReply() {
    message_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new GetProjectReply();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private GetProjectReply(
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
            com.rany.service.platform.meta.ProjectInfo.Builder subBuilder = null;
            if (project_ != null) {
              subBuilder = project_.toBuilder();
            }
            project_ = input.readMessage(com.rany.service.platform.meta.ProjectInfo.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(project_);
              project_ = subBuilder.buildPartial();
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
    return com.rany.service.platform.meta.SearchMiddlePlatformMetaService.internal_static_GetProjectReply_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.rany.service.platform.meta.SearchMiddlePlatformMetaService.internal_static_GetProjectReply_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.rany.service.platform.meta.GetProjectReply.class, com.rany.service.platform.meta.GetProjectReply.Builder.class);
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

  public static final int PROJECT_FIELD_NUMBER = 3;
  private com.rany.service.platform.meta.ProjectInfo project_;
  /**
   * <code>.ProjectInfo project = 3;</code>
   * @return Whether the project field is set.
   */
  @java.lang.Override
  public boolean hasProject() {
    return project_ != null;
  }
  /**
   * <code>.ProjectInfo project = 3;</code>
   * @return The project.
   */
  @java.lang.Override
  public com.rany.service.platform.meta.ProjectInfo getProject() {
    return project_ == null ? com.rany.service.platform.meta.ProjectInfo.getDefaultInstance() : project_;
  }
  /**
   * <code>.ProjectInfo project = 3;</code>
   */
  @java.lang.Override
  public com.rany.service.platform.meta.ProjectInfoOrBuilder getProjectOrBuilder() {
    return getProject();
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
    if (project_ != null) {
      output.writeMessage(3, getProject());
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
    if (project_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(3, getProject());
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
    if (!(obj instanceof com.rany.service.platform.meta.GetProjectReply)) {
      return super.equals(obj);
    }
    com.rany.service.platform.meta.GetProjectReply other = (com.rany.service.platform.meta.GetProjectReply) obj;

    if (getCode()
        != other.getCode()) return false;
    if (!getMessage()
        .equals(other.getMessage())) return false;
    if (hasProject() != other.hasProject()) return false;
    if (hasProject()) {
      if (!getProject()
          .equals(other.getProject())) return false;
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
    if (hasProject()) {
      hash = (37 * hash) + PROJECT_FIELD_NUMBER;
      hash = (53 * hash) + getProject().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.rany.service.platform.meta.GetProjectReply parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.rany.service.platform.meta.GetProjectReply parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.rany.service.platform.meta.GetProjectReply parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.rany.service.platform.meta.GetProjectReply parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.rany.service.platform.meta.GetProjectReply parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.rany.service.platform.meta.GetProjectReply parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.rany.service.platform.meta.GetProjectReply parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.rany.service.platform.meta.GetProjectReply parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.rany.service.platform.meta.GetProjectReply parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.rany.service.platform.meta.GetProjectReply parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.rany.service.platform.meta.GetProjectReply parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.rany.service.platform.meta.GetProjectReply parseFrom(
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
  public static Builder newBuilder(com.rany.service.platform.meta.GetProjectReply prototype) {
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
   * Protobuf type {@code GetProjectReply}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:GetProjectReply)
      com.rany.service.platform.meta.GetProjectReplyOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.rany.service.platform.meta.SearchMiddlePlatformMetaService.internal_static_GetProjectReply_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.rany.service.platform.meta.SearchMiddlePlatformMetaService.internal_static_GetProjectReply_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.rany.service.platform.meta.GetProjectReply.class, com.rany.service.platform.meta.GetProjectReply.Builder.class);
    }

    // Construct using com.rany.service.platform.meta.GetProjectReply.newBuilder()
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

      if (projectBuilder_ == null) {
        project_ = null;
      } else {
        project_ = null;
        projectBuilder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.rany.service.platform.meta.SearchMiddlePlatformMetaService.internal_static_GetProjectReply_descriptor;
    }

    @java.lang.Override
    public com.rany.service.platform.meta.GetProjectReply getDefaultInstanceForType() {
      return com.rany.service.platform.meta.GetProjectReply.getDefaultInstance();
    }

    @java.lang.Override
    public com.rany.service.platform.meta.GetProjectReply build() {
      com.rany.service.platform.meta.GetProjectReply result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.rany.service.platform.meta.GetProjectReply buildPartial() {
      com.rany.service.platform.meta.GetProjectReply result = new com.rany.service.platform.meta.GetProjectReply(this);
      result.code_ = code_;
      result.message_ = message_;
      if (projectBuilder_ == null) {
        result.project_ = project_;
      } else {
        result.project_ = projectBuilder_.build();
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
      if (other instanceof com.rany.service.platform.meta.GetProjectReply) {
        return mergeFrom((com.rany.service.platform.meta.GetProjectReply)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.rany.service.platform.meta.GetProjectReply other) {
      if (other == com.rany.service.platform.meta.GetProjectReply.getDefaultInstance()) return this;
      if (other.getCode() != 0) {
        setCode(other.getCode());
      }
      if (!other.getMessage().isEmpty()) {
        message_ = other.message_;
        onChanged();
      }
      if (other.hasProject()) {
        mergeProject(other.getProject());
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
      com.rany.service.platform.meta.GetProjectReply parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.rany.service.platform.meta.GetProjectReply) e.getUnfinishedMessage();
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

    private com.rany.service.platform.meta.ProjectInfo project_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.rany.service.platform.meta.ProjectInfo, com.rany.service.platform.meta.ProjectInfo.Builder, com.rany.service.platform.meta.ProjectInfoOrBuilder> projectBuilder_;
    /**
     * <code>.ProjectInfo project = 3;</code>
     * @return Whether the project field is set.
     */
    public boolean hasProject() {
      return projectBuilder_ != null || project_ != null;
    }
    /**
     * <code>.ProjectInfo project = 3;</code>
     * @return The project.
     */
    public com.rany.service.platform.meta.ProjectInfo getProject() {
      if (projectBuilder_ == null) {
        return project_ == null ? com.rany.service.platform.meta.ProjectInfo.getDefaultInstance() : project_;
      } else {
        return projectBuilder_.getMessage();
      }
    }
    /**
     * <code>.ProjectInfo project = 3;</code>
     */
    public Builder setProject(com.rany.service.platform.meta.ProjectInfo value) {
      if (projectBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        project_ = value;
        onChanged();
      } else {
        projectBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.ProjectInfo project = 3;</code>
     */
    public Builder setProject(
        com.rany.service.platform.meta.ProjectInfo.Builder builderForValue) {
      if (projectBuilder_ == null) {
        project_ = builderForValue.build();
        onChanged();
      } else {
        projectBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.ProjectInfo project = 3;</code>
     */
    public Builder mergeProject(com.rany.service.platform.meta.ProjectInfo value) {
      if (projectBuilder_ == null) {
        if (project_ != null) {
          project_ =
            com.rany.service.platform.meta.ProjectInfo.newBuilder(project_).mergeFrom(value).buildPartial();
        } else {
          project_ = value;
        }
        onChanged();
      } else {
        projectBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.ProjectInfo project = 3;</code>
     */
    public Builder clearProject() {
      if (projectBuilder_ == null) {
        project_ = null;
        onChanged();
      } else {
        project_ = null;
        projectBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.ProjectInfo project = 3;</code>
     */
    public com.rany.service.platform.meta.ProjectInfo.Builder getProjectBuilder() {
      
      onChanged();
      return getProjectFieldBuilder().getBuilder();
    }
    /**
     * <code>.ProjectInfo project = 3;</code>
     */
    public com.rany.service.platform.meta.ProjectInfoOrBuilder getProjectOrBuilder() {
      if (projectBuilder_ != null) {
        return projectBuilder_.getMessageOrBuilder();
      } else {
        return project_ == null ?
            com.rany.service.platform.meta.ProjectInfo.getDefaultInstance() : project_;
      }
    }
    /**
     * <code>.ProjectInfo project = 3;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.rany.service.platform.meta.ProjectInfo, com.rany.service.platform.meta.ProjectInfo.Builder, com.rany.service.platform.meta.ProjectInfoOrBuilder> 
        getProjectFieldBuilder() {
      if (projectBuilder_ == null) {
        projectBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.rany.service.platform.meta.ProjectInfo, com.rany.service.platform.meta.ProjectInfo.Builder, com.rany.service.platform.meta.ProjectInfoOrBuilder>(
                getProject(),
                getParentForChildren(),
                isClean());
        project_ = null;
      }
      return projectBuilder_;
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


    // @@protoc_insertion_point(builder_scope:GetProjectReply)
  }

  // @@protoc_insertion_point(class_scope:GetProjectReply)
  private static final com.rany.service.platform.meta.GetProjectReply DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.rany.service.platform.meta.GetProjectReply();
  }

  public static com.rany.service.platform.meta.GetProjectReply getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<GetProjectReply>
      PARSER = new com.google.protobuf.AbstractParser<GetProjectReply>() {
    @java.lang.Override
    public GetProjectReply parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new GetProjectReply(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<GetProjectReply> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<GetProjectReply> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.rany.service.platform.meta.GetProjectReply getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

