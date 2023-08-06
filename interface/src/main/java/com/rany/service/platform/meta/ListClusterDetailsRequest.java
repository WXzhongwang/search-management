// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: admin/meta.proto

package com.rany.service.platform.meta;

/**
 * Protobuf type {@code ListClusterDetailsRequest}
 */
public final class ListClusterDetailsRequest extends
        com.google.protobuf.GeneratedMessageV3 implements
        // @@protoc_insertion_point(message_implements:ListClusterDetailsRequest)
        ListClusterDetailsRequestOrBuilder {
    private static final long serialVersionUID = 0L;
    // @@protoc_insertion_point(class_scope:ListClusterDetailsRequest)
    private static final com.rany.service.platform.meta.ListClusterDetailsRequest DEFAULT_INSTANCE;
    private static final com.google.protobuf.Parser<ListClusterDetailsRequest>
            PARSER = new com.google.protobuf.AbstractParser<ListClusterDetailsRequest>() {
        public ListClusterDetailsRequest parsePartialFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return new ListClusterDetailsRequest(input, extensionRegistry);
        }
    };

    static {
        DEFAULT_INSTANCE = new com.rany.service.platform.meta.ListClusterDetailsRequest();
    }

    private byte memoizedIsInitialized = -1;

    // Use ListClusterDetailsRequest.newBuilder() to construct.
    private ListClusterDetailsRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
        super(builder);
    }

    private ListClusterDetailsRequest() {
    }

    private ListClusterDetailsRequest(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        this();
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
        return com.rany.service.platform.meta.SearchMiddlePlatformMetaService.internal_static_ListClusterDetailsRequest_descriptor;
    }

    public static com.rany.service.platform.meta.ListClusterDetailsRequest parseFrom(
            java.nio.ByteBuffer data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static com.rany.service.platform.meta.ListClusterDetailsRequest parseFrom(
            java.nio.ByteBuffer data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.rany.service.platform.meta.ListClusterDetailsRequest parseFrom(
            com.google.protobuf.ByteString data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static com.rany.service.platform.meta.ListClusterDetailsRequest parseFrom(
            com.google.protobuf.ByteString data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.rany.service.platform.meta.ListClusterDetailsRequest parseFrom(byte[] data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static com.rany.service.platform.meta.ListClusterDetailsRequest parseFrom(
            byte[] data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.rany.service.platform.meta.ListClusterDetailsRequest parseFrom(java.io.InputStream input)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input);
    }

    public static com.rany.service.platform.meta.ListClusterDetailsRequest parseFrom(
            java.io.InputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public static com.rany.service.platform.meta.ListClusterDetailsRequest parseDelimitedFrom(java.io.InputStream input)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseDelimitedWithIOException(PARSER, input);
    }

    public static com.rany.service.platform.meta.ListClusterDetailsRequest parseDelimitedFrom(
            java.io.InputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }

    public static com.rany.service.platform.meta.ListClusterDetailsRequest parseFrom(
            com.google.protobuf.CodedInputStream input)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input);
    }

    public static com.rany.service.platform.meta.ListClusterDetailsRequest parseFrom(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(com.rany.service.platform.meta.ListClusterDetailsRequest prototype) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }

    public static com.rany.service.platform.meta.ListClusterDetailsRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static com.google.protobuf.Parser<ListClusterDetailsRequest> parser() {
        return PARSER;
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
        return this.unknownFields;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
    internalGetFieldAccessorTable() {
        return com.rany.service.platform.meta.SearchMiddlePlatformMetaService.internal_static_ListClusterDetailsRequest_fieldAccessorTable
                .ensureFieldAccessorsInitialized(
                        com.rany.service.platform.meta.ListClusterDetailsRequest.class, com.rany.service.platform.meta.ListClusterDetailsRequest.Builder.class);
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
        unknownFields.writeTo(output);
    }

    public int getSerializedSize() {
        int size = memoizedSize;
        if (size != -1) return size;

        size = 0;
        size += unknownFields.getSerializedSize();
        memoizedSize = size;
        return size;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof com.rany.service.platform.meta.ListClusterDetailsRequest)) {
            return super.equals(obj);
        }
        com.rany.service.platform.meta.ListClusterDetailsRequest other = (com.rany.service.platform.meta.ListClusterDetailsRequest) obj;

        boolean result = true;
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
    public com.google.protobuf.Parser<ListClusterDetailsRequest> getParserForType() {
        return PARSER;
    }

    public com.rany.service.platform.meta.ListClusterDetailsRequest getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    /**
     * Protobuf type {@code ListClusterDetailsRequest}
     */
    public static final class Builder extends
            com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
            // @@protoc_insertion_point(builder_implements:ListClusterDetailsRequest)
            com.rany.service.platform.meta.ListClusterDetailsRequestOrBuilder {
        // Construct using com.rany.service.platform.meta.ListClusterDetailsRequest.newBuilder()
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
            return com.rany.service.platform.meta.SearchMiddlePlatformMetaService.internal_static_ListClusterDetailsRequest_descriptor;
        }

        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
            return com.rany.service.platform.meta.SearchMiddlePlatformMetaService.internal_static_ListClusterDetailsRequest_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            com.rany.service.platform.meta.ListClusterDetailsRequest.class, com.rany.service.platform.meta.ListClusterDetailsRequest.Builder.class);
        }

        private void maybeForceBuilderInitialization() {
            if (com.google.protobuf.GeneratedMessageV3
                    .alwaysUseFieldBuilders) {
            }
        }

        public Builder clear() {
            super.clear();
            return this;
        }

        public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
            return com.rany.service.platform.meta.SearchMiddlePlatformMetaService.internal_static_ListClusterDetailsRequest_descriptor;
        }

        public com.rany.service.platform.meta.ListClusterDetailsRequest getDefaultInstanceForType() {
            return com.rany.service.platform.meta.ListClusterDetailsRequest.getDefaultInstance();
        }

        public com.rany.service.platform.meta.ListClusterDetailsRequest build() {
            com.rany.service.platform.meta.ListClusterDetailsRequest result = buildPartial();
            if (!result.isInitialized()) {
                throw newUninitializedMessageException(result);
            }
            return result;
        }

        public com.rany.service.platform.meta.ListClusterDetailsRequest buildPartial() {
            com.rany.service.platform.meta.ListClusterDetailsRequest result = new com.rany.service.platform.meta.ListClusterDetailsRequest(this);
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
            if (other instanceof com.rany.service.platform.meta.ListClusterDetailsRequest) {
                return mergeFrom((com.rany.service.platform.meta.ListClusterDetailsRequest) other);
            } else {
                super.mergeFrom(other);
                return this;
            }
        }

        public Builder mergeFrom(com.rany.service.platform.meta.ListClusterDetailsRequest other) {
            if (other == com.rany.service.platform.meta.ListClusterDetailsRequest.getDefaultInstance()) return this;
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
            com.rany.service.platform.meta.ListClusterDetailsRequest parsedMessage = null;
            try {
                parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
            } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                parsedMessage = (com.rany.service.platform.meta.ListClusterDetailsRequest) e.getUnfinishedMessage();
                throw e.unwrapIOException();
            } finally {
                if (parsedMessage != null) {
                    mergeFrom(parsedMessage);
                }
            }
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


        // @@protoc_insertion_point(builder_scope:ListClusterDetailsRequest)
    }

}

