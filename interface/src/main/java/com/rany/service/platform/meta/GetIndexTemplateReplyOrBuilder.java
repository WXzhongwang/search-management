// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: admin/meta.proto

package com.rany.service.platform.meta;

public interface GetIndexTemplateReplyOrBuilder extends
    // @@protoc_insertion_point(interface_extends:GetIndexTemplateReply)
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
   * <code>.IndexTemplateInfo template = 3;</code>
   * @return Whether the template field is set.
   */
  boolean hasTemplate();
  /**
   * <code>.IndexTemplateInfo template = 3;</code>
   * @return The template.
   */
  com.rany.service.platform.meta.IndexTemplateInfo getTemplate();
  /**
   * <code>.IndexTemplateInfo template = 3;</code>
   */
  com.rany.service.platform.meta.IndexTemplateInfoOrBuilder getTemplateOrBuilder();
}
