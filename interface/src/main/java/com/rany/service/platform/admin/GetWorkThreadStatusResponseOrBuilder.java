// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: admin/admin.proto

package com.rany.service.platform.admin;

public interface GetWorkThreadStatusResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:GetWorkThreadStatusResponse)
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
   * <code>bool running = 3;</code>
   * @return The running.
   */
  boolean getRunning();
}
