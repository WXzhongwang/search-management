// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: admin/meta.proto

package com.rany.service.platform.meta;

public interface ListIndexNameReplyOrBuilder extends
    // @@protoc_insertion_point(interface_extends:ListIndexNameReply)
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
   * <code>repeated .IndexNameEntry indexNames = 3;</code>
   */
  java.util.List<com.rany.service.platform.meta.IndexNameEntry> 
      getIndexNamesList();
  /**
   * <code>repeated .IndexNameEntry indexNames = 3;</code>
   */
  com.rany.service.platform.meta.IndexNameEntry getIndexNames(int index);
  /**
   * <code>repeated .IndexNameEntry indexNames = 3;</code>
   */
  int getIndexNamesCount();
  /**
   * <code>repeated .IndexNameEntry indexNames = 3;</code>
   */
  java.util.List<? extends com.rany.service.platform.meta.IndexNameEntryOrBuilder> 
      getIndexNamesOrBuilderList();
  /**
   * <code>repeated .IndexNameEntry indexNames = 3;</code>
   */
  com.rany.service.platform.meta.IndexNameEntryOrBuilder getIndexNamesOrBuilder(
      int index);
}