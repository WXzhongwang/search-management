// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: admin/meta.proto

package com.rany.service.platform.meta;

public interface ListIndexTemplateDetailsReplyOrBuilder extends
    // @@protoc_insertion_point(interface_extends:ListIndexTemplateDetailsReply)
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
   * <code>repeated .IndexTemplateInfo templates = 3;</code>
   */
  java.util.List<com.rany.service.platform.meta.IndexTemplateInfo> 
      getTemplatesList();
  /**
   * <code>repeated .IndexTemplateInfo templates = 3;</code>
   */
  com.rany.service.platform.meta.IndexTemplateInfo getTemplates(int index);
  /**
   * <code>repeated .IndexTemplateInfo templates = 3;</code>
   */
  int getTemplatesCount();
  /**
   * <code>repeated .IndexTemplateInfo templates = 3;</code>
   */
  java.util.List<? extends com.rany.service.platform.meta.IndexTemplateInfoOrBuilder> 
      getTemplatesOrBuilderList();
  /**
   * <code>repeated .IndexTemplateInfo templates = 3;</code>
   */
  com.rany.service.platform.meta.IndexTemplateInfoOrBuilder getTemplatesOrBuilder(
      int index);
}
