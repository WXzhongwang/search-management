// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: admin/meta.proto

package com.rany.service.platform.meta;

public interface ListClusterDetailsReplyOrBuilder extends
    // @@protoc_insertion_point(interface_extends:ListClusterDetailsReply)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int32 code = 1;</code>
   * @return The code.
   */
  int getCode();

  /**
   * <code>string message = 2;</code>
   * @return The message.
   */
  java.lang.String getMessage();
  /**
   * <code>string message = 2;</code>
   * @return The bytes for message.
   */
  com.google.protobuf.ByteString
      getMessageBytes();

  /**
   * <code>repeated .ClusterInfo clusters = 3;</code>
   */
  java.util.List<com.rany.service.platform.meta.ClusterInfo> 
      getClustersList();
  /**
   * <code>repeated .ClusterInfo clusters = 3;</code>
   */
  com.rany.service.platform.meta.ClusterInfo getClusters(int index);
  /**
   * <code>repeated .ClusterInfo clusters = 3;</code>
   */
  int getClustersCount();
  /**
   * <code>repeated .ClusterInfo clusters = 3;</code>
   */
  java.util.List<? extends com.rany.service.platform.meta.ClusterInfoOrBuilder> 
      getClustersOrBuilderList();
  /**
   * <code>repeated .ClusterInfo clusters = 3;</code>
   */
  com.rany.service.platform.meta.ClusterInfoOrBuilder getClustersOrBuilder(
      int index);
}
