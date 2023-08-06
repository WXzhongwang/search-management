// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: admin/meta.proto

package com.rany.service.platform.meta;

/**
 * Protobuf type {@code GetIndexTemplateRequest}
 */
public final class GetIndexTemplateRequest extends
        com.google.protobuf.GeneratedMessageV3 implements
        // @@protoc_insertion_point(message_implements:GetIndexTemplateRequest)
        GetIndexTemplateRequestOrBuilder {
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int PROJECT_FIELD_NUMBER = 2;
    private static final long serialVersionUID = 0L;
    // @@protoc_insertion_point(class_scope:GetIndexTemplateRequest)
    private static final com.rany.service.platform.meta.GetIndexTemplateRequest DEFAULT_INSTANCE;
    private static final com.google.protobuf.Parser<GetIndexTemplateRequest>
            PARSER = new com.google.protobuf.AbstractParser<GetIndexTemplateRequest>() {
        public GetIndexTemplateRequest parsePartialFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return new GetIndexTemplateRequest(input, extensionRegistry);
        }
    };

    static {
        DEFAULT_INSTANCE = new com.rany.service.platform.meta.GetIndexTemplateRequest();
    }

    private volatile java.lang.Object name_;
    private volatile java.lang.Object project_;
    private byte memoizedIsInitialized = -1;

    // Use GetIndexTemplateRequest.newBuilder() to construct.
    private GetIndexTemplateRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
        super(builder);
    }

    private GetIndexTemplateRequest() {
        name_ = "";
        project_ = "";
    }

    private GetIndexTemplateRequest(
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
                    case 10: {
                        java.lang.String s = input.readStringRequireUtf8();

                        name_ = s;
                        break;
                    }
                    case 18: {
                        java.lang.String s = input.readStringRequireUtf8();

                        project_ = s;
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
        return com.rany.service.platform.meta.SearchMiddlePlatformMetaService.internal_static_GetIndexTemplateRequest_descriptor;
    }

    public static com.rany.service.platform.meta.GetIndexTemplateRequest parseFrom(
            java.nio.ByteBuffer data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static com.rany.service.platform.meta.GetIndexTemplateRequest parseFrom(
            java.nio.ByteBuffer data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.rany.service.platform.meta.GetIndexTemplateRequest parseFrom(
            com.google.protobuf.ByteString data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static com.rany.service.platform.meta.GetIndexTemplateRequest parseFrom(
            com.google.protobuf.ByteString data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.rany.service.platform.meta.GetIndexTemplateRequest parseFrom(byte[] data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static com.rany.service.platform.meta.GetIndexTemplateRequest parseFrom(
            byte[] data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.rany.service.platform.meta.GetIndexTemplateRequest parseFrom(java.io.InputStream input)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input);
    }

    public static com.rany.service.platform.meta.GetIndexTemplateRequest parseFrom(
            java.io.InputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public static com.rany.service.platform.meta.GetIndexTemplateRequest parseDelimitedFrom(java.io.InputStream input)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseDelimitedWithIOException(PARSER, input);
    }

    public static com.rany.service.platform.meta.GetIndexTemplateRequest parseDelimitedFrom(
            java.io.InputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }

    public static com.rany.service.platform.meta.GetIndexTemplateRequest parseFrom(
            com.google.protobuf.CodedInputStream input)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input);
    }

    public static com.rany.service.platform.meta.GetIndexTemplateRequest parseFrom(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(com.rany.service.platform.meta.GetIndexTemplateRequest prototype) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }

    public static com.rany.service.platform.meta.GetIndexTemplateRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static com.google.protobuf.Parser<GetIndexTemplateRequest> parser() {
        return PARSER;
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
        return this.unknownFields;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
    internalGetFieldAccessorTable() {
        return com.rany.service.platform.meta.SearchMiddlePlatformMetaService.internal_static_GetIndexTemplateRequest_fieldAccessorTable
                .ensureFieldAccessorsInitialized(
                        com.rany.service.platform.meta.GetIndexTemplateRequest.class, com.rany.service.platform.meta.GetIndexTemplateRequest.Builder.class);
    }

    /**
     * <code>string name = 1;</code>
     */
    public java.lang.String getName() {
        java.lang.Object ref = name_;
        if (ref instanceof java.lang.String) {
            return (java.lang.String) ref;
        } else {
            com.google.protobuf.ByteString bs =
                    (com.google.protobuf.ByteString) ref;
            java.lang.String s = bs.toStringUtf8();
            name_ = s;
            return s;
        }
    }

    /**
     * <code>string name = 1;</code>
     */
    public com.google.protobuf.ByteString
    getNameBytes() {
        java.lang.Object ref = name_;
        if (ref instanceof java.lang.String) {
            com.google.protobuf.ByteString b =
                    com.google.protobuf.ByteString.copyFromUtf8(
                            (java.lang.String) ref);
            name_ = b;
            return b;
        } else {
            return (com.google.protobuf.ByteString) ref;
        }
    }

    /**
     * <code>string project = 2;</code>
     */
    public java.lang.String getProject() {
        java.lang.Object ref = project_;
        if (ref instanceof java.lang.String) {
            return (java.lang.String) ref;
        } else {
            com.google.protobuf.ByteString bs =
                    (com.google.protobuf.ByteString) ref;
            java.lang.String s = bs.toStringUtf8();
            project_ = s;
            return s;
        }
    }

    /**
     * <code>string project = 2;</code>
     */
    public com.google.protobuf.ByteString
    getProjectBytes() {
        java.lang.Object ref = project_;
        if (ref instanceof java.lang.String) {
            com.google.protobuf.ByteString b =
                    com.google.protobuf.ByteString.copyFromUtf8(
                            (java.lang.String) ref);
            project_ = b;
            return b;
        } else {
            return (com.google.protobuf.ByteString) ref;
        }
    }

    public final boolean isInitialized() {
        byte isInitialized = memoizedIsInitialized;
        if (isInitialized == 1) return true;
        if (isInitialized == 0) return false;

        memoizedIsInitialized = 1;
        return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
            throws java.io.IOException {
        if (!getNameBytes().isEmpty()) {
            com.google.protobuf.GeneratedMessageV3.writeString(output, 1, name_);
        }
        if (!getProjectBytes().isEmpty()) {
            com.google.protobuf.GeneratedMessageV3.writeString(output, 2, project_);
        }
        unknownFields.writeTo(output);
    }

    public int getSerializedSize() {
        int size = memoizedSize;
        if (size != -1) return size;

        size = 0;
        if (!getNameBytes().isEmpty()) {
            size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, name_);
        }
        if (!getProjectBytes().isEmpty()) {
            size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, project_);
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
        if (!(obj instanceof com.rany.service.platform.meta.GetIndexTemplateRequest)) {
            return super.equals(obj);
        }
        com.rany.service.platform.meta.GetIndexTemplateRequest other = (com.rany.service.platform.meta.GetIndexTemplateRequest) obj;

        boolean result = true;
        result = result && getName()
                .equals(other.getName());
        result = result && getProject()
                .equals(other.getProject());
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
        hash = (37 * hash) + NAME_FIELD_NUMBER;
        hash = (53 * hash) + getName().hashCode();
        hash = (37 * hash) + PROJECT_FIELD_NUMBER;
        hash = (53 * hash) + getProject().hashCode();
        hash = (29 * hash) + unknownFields.hashCode();
        memoizedHashCode = hash;
        return hash;
    }

    public Builder newBuilderForType() {
        return newBuilder();
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

    @java.lang.Override
    public com.google.protobuf.Parser<GetIndexTemplateRequest> getParserForType() {
        return PARSER;
    }

    public com.rany.service.platform.meta.GetIndexTemplateRequest getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    /**
     * Protobuf type {@code GetIndexTemplateRequest}
     */
    public static final class Builder extends
            com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
            // @@protoc_insertion_point(builder_implements:GetIndexTemplateRequest)
            com.rany.service.platform.meta.GetIndexTemplateRequestOrBuilder {
        private java.lang.Object name_ = "";
        private java.lang.Object project_ = "";

        // Construct using com.rany.service.platform.meta.GetIndexTemplateRequest.newBuilder()
        private Builder() {
            maybeForceBuilderInitialization();
        }

        private Builder(
                com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
            super(parent);
            maybeForceBuilderInitialization();
        }

        public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
            return com.rany.service.platform.meta.SearchMiddlePlatformMetaService.internal_static_GetIndexTemplateRequest_descriptor;
        }

        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
            return com.rany.service.platform.meta.SearchMiddlePlatformMetaService.internal_static_GetIndexTemplateRequest_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            com.rany.service.platform.meta.GetIndexTemplateRequest.class, com.rany.service.platform.meta.GetIndexTemplateRequest.Builder.class);
        }

        private void maybeForceBuilderInitialization() {
            if (com.google.protobuf.GeneratedMessageV3
                    .alwaysUseFieldBuilders) {
            }
        }

        public Builder clear() {
            super.clear();
            name_ = "";

            project_ = "";

            return this;
        }

        public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
            return com.rany.service.platform.meta.SearchMiddlePlatformMetaService.internal_static_GetIndexTemplateRequest_descriptor;
        }

        public com.rany.service.platform.meta.GetIndexTemplateRequest getDefaultInstanceForType() {
            return com.rany.service.platform.meta.GetIndexTemplateRequest.getDefaultInstance();
        }

        public com.rany.service.platform.meta.GetIndexTemplateRequest build() {
            com.rany.service.platform.meta.GetIndexTemplateRequest result = buildPartial();
            if (!result.isInitialized()) {
                throw newUninitializedMessageException(result);
            }
            return result;
        }

        public com.rany.service.platform.meta.GetIndexTemplateRequest buildPartial() {
            com.rany.service.platform.meta.GetIndexTemplateRequest result = new com.rany.service.platform.meta.GetIndexTemplateRequest(this);
            result.name_ = name_;
            result.project_ = project_;
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
            if (other instanceof com.rany.service.platform.meta.GetIndexTemplateRequest) {
                return mergeFrom((com.rany.service.platform.meta.GetIndexTemplateRequest) other);
            } else {
                super.mergeFrom(other);
                return this;
            }
        }

        public Builder mergeFrom(com.rany.service.platform.meta.GetIndexTemplateRequest other) {
            if (other == com.rany.service.platform.meta.GetIndexTemplateRequest.getDefaultInstance()) return this;
            if (!other.getName().isEmpty()) {
                name_ = other.name_;
                onChanged();
            }
            if (!other.getProject().isEmpty()) {
                project_ = other.project_;
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
            com.rany.service.platform.meta.GetIndexTemplateRequest parsedMessage = null;
            try {
                parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
            } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                parsedMessage = (com.rany.service.platform.meta.GetIndexTemplateRequest) e.getUnfinishedMessage();
                throw e.unwrapIOException();
            } finally {
                if (parsedMessage != null) {
                    mergeFrom(parsedMessage);
                }
            }
            return this;
        }

        /**
         * <code>string name = 1;</code>
         */
        public java.lang.String getName() {
            java.lang.Object ref = name_;
            if (!(ref instanceof java.lang.String)) {
                com.google.protobuf.ByteString bs =
                        (com.google.protobuf.ByteString) ref;
                java.lang.String s = bs.toStringUtf8();
                name_ = s;
                return s;
            } else {
                return (java.lang.String) ref;
            }
        }

        /**
         * <code>string name = 1;</code>
         */
        public Builder setName(
                java.lang.String value) {
            if (value == null) {
                throw new NullPointerException();
            }

            name_ = value;
            onChanged();
            return this;
        }

        /**
         * <code>string name = 1;</code>
         */
        public com.google.protobuf.ByteString
        getNameBytes() {
            java.lang.Object ref = name_;
            if (ref instanceof String) {
                com.google.protobuf.ByteString b =
                        com.google.protobuf.ByteString.copyFromUtf8(
                                (java.lang.String) ref);
                name_ = b;
                return b;
            } else {
                return (com.google.protobuf.ByteString) ref;
            }
        }

        /**
         * <code>string name = 1;</code>
         */
        public Builder setNameBytes(
                com.google.protobuf.ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            }
            checkByteStringIsUtf8(value);

            name_ = value;
            onChanged();
            return this;
        }

        /**
         * <code>string name = 1;</code>
         */
        public Builder clearName() {

            name_ = getDefaultInstance().getName();
            onChanged();
            return this;
        }

        /**
         * <code>string project = 2;</code>
         */
        public java.lang.String getProject() {
            java.lang.Object ref = project_;
            if (!(ref instanceof java.lang.String)) {
                com.google.protobuf.ByteString bs =
                        (com.google.protobuf.ByteString) ref;
                java.lang.String s = bs.toStringUtf8();
                project_ = s;
                return s;
            } else {
                return (java.lang.String) ref;
            }
        }

        /**
         * <code>string project = 2;</code>
         */
        public Builder setProject(
                java.lang.String value) {
            if (value == null) {
                throw new NullPointerException();
            }

            project_ = value;
            onChanged();
            return this;
        }

        /**
         * <code>string project = 2;</code>
         */
        public com.google.protobuf.ByteString
        getProjectBytes() {
            java.lang.Object ref = project_;
            if (ref instanceof String) {
                com.google.protobuf.ByteString b =
                        com.google.protobuf.ByteString.copyFromUtf8(
                                (java.lang.String) ref);
                project_ = b;
                return b;
            } else {
                return (com.google.protobuf.ByteString) ref;
            }
        }

        /**
         * <code>string project = 2;</code>
         */
        public Builder setProjectBytes(
                com.google.protobuf.ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            }
            checkByteStringIsUtf8(value);

            project_ = value;
            onChanged();
            return this;
        }

        /**
         * <code>string project = 2;</code>
         */
        public Builder clearProject() {

            project_ = getDefaultInstance().getProject();
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


        // @@protoc_insertion_point(builder_scope:GetIndexTemplateRequest)
    }

}

