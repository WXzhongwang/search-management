// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: admin/meta.proto

package com.rany.service.platform.meta;

public interface UpdateClusterInfoRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:UpdateClusterInfoRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int32 id = 1;</code>
   * @return The id.
   */
  int getId();

  /**
   * <code>string name = 2;</code>
   * @return The name.
   */
  java.lang.String getName();
  /**
   * <code>string name = 2;</code>
   * @return The bytes for name.
   */
  com.google.protobuf.ByteString
      getNameBytes();

  /**
   * <code>.ClusterStatus status = 3;</code>
   * @return The enum numeric value on the wire for status.
   */
  int getStatusValue();
  /**
   * <code>.ClusterStatus status = 3;</code>
   * @return The status.
   */
  com.rany.service.platform.meta.ClusterStatus getStatus();

  /**
   * <code>string description = 4;</code>
   * @return The description.
   */
  java.lang.String getDescription();
  /**
   * <code>string description = 4;</code>
   * @return The bytes for description.
   */
  com.google.protobuf.ByteString
      getDescriptionBytes();

  /**
   * <code>string internal_endpoint = 5;</code>
   * @return The internalEndpoint.
   */
  java.lang.String getInternalEndpoint();
  /**
   * <code>string internal_endpoint = 5;</code>
   * @return The bytes for internalEndpoint.
   */
  com.google.protobuf.ByteString
      getInternalEndpointBytes();
}
