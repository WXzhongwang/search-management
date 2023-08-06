// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: admin/meta.proto

package com.rany.service.platform.meta;

/**
 * Protobuf type {@code DeleteProjectRequest}
 */
public final class DeleteProjectRequest extends
        com.google.protobuf.GeneratedMessageV3 implements
        // @@protoc_insertion_point(message_implements:DeleteProjectRequest)
        DeleteProjectRequestOrBuilder {
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int STATUS_FIELD_NUMBER = 2;
    private static final long serialVersionUID = 0L;
    // @@protoc_insertion_point(class_scope:DeleteProjectRequest)
    private static final com.rany.service.platform.meta.DeleteProjectRequest DEFAULT_INSTANCE;
    private static final com.google.protobuf.Parser<DeleteProjectRequest>
            PARSER = new com.google.protobuf.AbstractParser<DeleteProjectRequest>() {
        public DeleteProjectRequest parsePartialFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return new DeleteProjectRequest(input, extensionRegistry);
        }
    };

    static {
        DEFAULT_INSTANCE = new com.rany.service.platform.meta.DeleteProjectRequest();
    }

    private volatile java.lang.Object name_;
    private int status_;
    private byte memoizedIsInitialized = -1;

    // Use DeleteProjectRequest.newBuilder() to construct.
    private DeleteProjectRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
        super(builder);
    }

    private DeleteProjectRequest() {
        name_ = "";
        status_ = 0;
    }

    private DeleteProjectRequest(
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
                    case 16: {
                        int rawValue = input.readEnum();

                        status_ = rawValue;
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
        return com.rany.service.platform.meta.SearchMiddlePlatformMetaService.internal_static_DeleteProjectRequest_descriptor;
    }

    public static com.rany.service.platform.meta.DeleteProjectRequest parseFrom(
            java.nio.ByteBuffer data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static com.rany.service.platform.meta.DeleteProjectRequest parseFrom(
            java.nio.ByteBuffer data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.rany.service.platform.meta.DeleteProjectRequest parseFrom(
            com.google.protobuf.ByteString data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static com.rany.service.platform.meta.DeleteProjectRequest parseFrom(
            com.google.protobuf.ByteString data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.rany.service.platform.meta.DeleteProjectRequest parseFrom(byte[] data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static com.rany.service.platform.meta.DeleteProjectRequest parseFrom(
            byte[] data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.rany.service.platform.meta.DeleteProjectRequest parseFrom(java.io.InputStream input)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input);
    }

    public static com.rany.service.platform.meta.DeleteProjectRequest parseFrom(
            java.io.InputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public static com.rany.service.platform.meta.DeleteProjectRequest parseDelimitedFrom(java.io.InputStream input)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseDelimitedWithIOException(PARSER, input);
    }

    public static com.rany.service.platform.meta.DeleteProjectRequest parseDelimitedFrom(
            java.io.InputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }

    public static com.rany.service.platform.meta.DeleteProjectRequest parseFrom(
            com.google.protobuf.CodedInputStream input)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input);
    }

    public static com.rany.service.platform.meta.DeleteProjectRequest parseFrom(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(com.rany.service.platform.meta.DeleteProjectRequest prototype) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }

    public static com.rany.service.platform.meta.DeleteProjectRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static com.google.protobuf.Parser<DeleteProjectRequest> parser() {
        return PARSER;
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
        return this.unknownFields;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
    internalGetFieldAccessorTable() {
        return com.rany.service.platform.meta.SearchMiddlePlatformMetaService.internal_static_DeleteProjectRequest_fieldAccessorTable
                .ensureFieldAccessorsInitialized(
                        com.rany.service.platform.meta.DeleteProjectRequest.class, com.rany.service.platform.meta.DeleteProjectRequest.Builder.class);
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
     * <code>.ProjectStatus status = 2;</code>
     */
    public int getStatusValue() {
        return status_;
    }

    /**
     * <code>.ProjectStatus status = 2;</code>
     */
    public com.rany.service.platform.meta.ProjectStatus getStatus() {
        com.rany.service.platform.meta.ProjectStatus result = com.rany.service.platform.meta.ProjectStatus.valueOf(status_);
        return result == null ? com.rany.service.platform.meta.ProjectStatus.UNRECOGNIZED : result;
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
        if (status_ != com.rany.service.platform.meta.ProjectStatus.NORMAL.getNumber()) {
            output.writeEnum(2, status_);
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
        if (status_ != com.rany.service.platform.meta.ProjectStatus.NORMAL.getNumber()) {
            size += com.google.protobuf.CodedOutputStream
                    .computeEnumSize(2, status_);
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
        if (!(obj instanceof com.rany.service.platform.meta.DeleteProjectRequest)) {
            return super.equals(obj);
        }
        com.rany.service.platform.meta.DeleteProjectRequest other = (com.rany.service.platform.meta.DeleteProjectRequest) obj;

        boolean result = true;
        result = result && getName()
                .equals(other.getName());
        result = result && status_ == other.status_;
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
        hash = (37 * hash) + STATUS_FIELD_NUMBER;
        hash = (53 * hash) + status_;
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
    public com.google.protobuf.Parser<DeleteProjectRequest> getParserForType() {
        return PARSER;
    }

    public com.rany.service.platform.meta.DeleteProjectRequest getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    /**
     * Protobuf type {@code DeleteProjectRequest}
     */
    public static final class Builder extends
            com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
            // @@protoc_insertion_point(builder_implements:DeleteProjectRequest)
            com.rany.service.platform.meta.DeleteProjectRequestOrBuilder {
        private java.lang.Object name_ = "";
        private int status_ = 0;

        // Construct using com.rany.service.platform.meta.DeleteProjectRequest.newBuilder()
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
            return com.rany.service.platform.meta.SearchMiddlePlatformMetaService.internal_static_DeleteProjectRequest_descriptor;
        }

        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
            return com.rany.service.platform.meta.SearchMiddlePlatformMetaService.internal_static_DeleteProjectRequest_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            com.rany.service.platform.meta.DeleteProjectRequest.class, com.rany.service.platform.meta.DeleteProjectRequest.Builder.class);
        }

        private void maybeForceBuilderInitialization() {
            if (com.google.protobuf.GeneratedMessageV3
                    .alwaysUseFieldBuilders) {
            }
        }

        public Builder clear() {
            super.clear();
            name_ = "";

            status_ = 0;

            return this;
        }

        public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
            return com.rany.service.platform.meta.SearchMiddlePlatformMetaService.internal_static_DeleteProjectRequest_descriptor;
        }

        public com.rany.service.platform.meta.DeleteProjectRequest getDefaultInstanceForType() {
            return com.rany.service.platform.meta.DeleteProjectRequest.getDefaultInstance();
        }

        public com.rany.service.platform.meta.DeleteProjectRequest build() {
            com.rany.service.platform.meta.DeleteProjectRequest result = buildPartial();
            if (!result.isInitialized()) {
                throw newUninitializedMessageException(result);
            }
            return result;
        }

        public com.rany.service.platform.meta.DeleteProjectRequest buildPartial() {
            com.rany.service.platform.meta.DeleteProjectRequest result = new com.rany.service.platform.meta.DeleteProjectRequest(this);
            result.name_ = name_;
            result.status_ = status_;
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
            if (other instanceof com.rany.service.platform.meta.DeleteProjectRequest) {
                return mergeFrom((com.rany.service.platform.meta.DeleteProjectRequest) other);
            } else {
                super.mergeFrom(other);
                return this;
            }
        }

        public Builder mergeFrom(com.rany.service.platform.meta.DeleteProjectRequest other) {
            if (other == com.rany.service.platform.meta.DeleteProjectRequest.getDefaultInstance()) return this;
            if (!other.getName().isEmpty()) {
                name_ = other.name_;
                onChanged();
            }
            if (other.status_ != 0) {
                setStatusValue(other.getStatusValue());
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
            com.rany.service.platform.meta.DeleteProjectRequest parsedMessage = null;
            try {
                parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
            } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                parsedMessage = (com.rany.service.platform.meta.DeleteProjectRequest) e.getUnfinishedMessage();
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
         * <code>.ProjectStatus status = 2;</code>
         */
        public int getStatusValue() {
            return status_;
        }

        /**
         * <code>.ProjectStatus status = 2;</code>
         */
        public Builder setStatusValue(int value) {
            status_ = value;
            onChanged();
            return this;
        }

        /**
         * <code>.ProjectStatus status = 2;</code>
         */
        public com.rany.service.platform.meta.ProjectStatus getStatus() {
            com.rany.service.platform.meta.ProjectStatus result = com.rany.service.platform.meta.ProjectStatus.valueOf(status_);
            return result == null ? com.rany.service.platform.meta.ProjectStatus.UNRECOGNIZED : result;
        }

        /**
         * <code>.ProjectStatus status = 2;</code>
         */
        public Builder setStatus(com.rany.service.platform.meta.ProjectStatus value) {
            if (value == null) {
                throw new NullPointerException();
            }

            status_ = value.getNumber();
            onChanged();
            return this;
        }

        /**
         * <code>.ProjectStatus status = 2;</code>
         */
        public Builder clearStatus() {

            status_ = 0;
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


        // @@protoc_insertion_point(builder_scope:DeleteProjectRequest)
    }

}

