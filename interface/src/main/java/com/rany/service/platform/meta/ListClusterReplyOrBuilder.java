// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: admin/meta.proto

package com.rany.service.platform.meta;

public interface ListClusterReplyOrBuilder extends
    // @@protoc_insertion_point(interface_extends:ListClusterReply)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int32 code = 1;</code>
   */
  int getCode();

  /**
   * <code>string message = 2;</code>
   */
  java.lang.String getMessage();
  /**
   * <code>string message = 2;</code>
   */
  com.google.protobuf.ByteString
      getMessageBytes();

  /**
   * <code>repeated string clusters = 3;</code>
   */
  java.util.List<java.lang.String>
      getClustersList();
  /**
   * <code>repeated string clusters = 3;</code>
   */
  int getClustersCount();
  /**
   * <code>repeated string clusters = 3;</code>
   */
  java.lang.String getClusters(int index);
  /**
   * <code>repeated string clusters = 3;</code>
   */
  com.google.protobuf.ByteString
      getClustersBytes(int index);
}
