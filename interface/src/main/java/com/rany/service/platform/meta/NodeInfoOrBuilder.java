// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: admin/meta.proto

package com.rany.service.platform.meta;

public interface NodeInfoOrBuilder extends
    // @@protoc_insertion_point(interface_extends:NodeInfo)
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
   * <code>string ip_address = 3;</code>
   * @return The ipAddress.
   */
  java.lang.String getIpAddress();
  /**
   * <code>string ip_address = 3;</code>
   * @return The bytes for ipAddress.
   */
  com.google.protobuf.ByteString
      getIpAddressBytes();

  /**
   * <code>bool is_master = 4;</code>
   * @return The isMaster.
   */
  boolean getIsMaster();

  /**
   * <code>double cpu_percent = 5;</code>
   * @return The cpuPercent.
   */
  double getCpuPercent();

  /**
   * <code>string ram_max = 6;</code>
   * @return The ramMax.
   */
  java.lang.String getRamMax();
  /**
   * <code>string ram_max = 6;</code>
   * @return The bytes for ramMax.
   */
  com.google.protobuf.ByteString
      getRamMaxBytes();

  /**
   * <code>string ram_current = 7;</code>
   * @return The ramCurrent.
   */
  java.lang.String getRamCurrent();
  /**
   * <code>string ram_current = 7;</code>
   * @return The bytes for ramCurrent.
   */
  com.google.protobuf.ByteString
      getRamCurrentBytes();

  /**
   * <code>string heap_max = 8;</code>
   * @return The heapMax.
   */
  java.lang.String getHeapMax();
  /**
   * <code>string heap_max = 8;</code>
   * @return The bytes for heapMax.
   */
  com.google.protobuf.ByteString
      getHeapMaxBytes();

  /**
   * <code>string heap_current = 9;</code>
   * @return The heapCurrent.
   */
  java.lang.String getHeapCurrent();
  /**
   * <code>string heap_current = 9;</code>
   * @return The bytes for heapCurrent.
   */
  com.google.protobuf.ByteString
      getHeapCurrentBytes();

  /**
   * <code>string disk_avail = 10;</code>
   * @return The diskAvail.
   */
  java.lang.String getDiskAvail();
  /**
   * <code>string disk_avail = 10;</code>
   * @return The bytes for diskAvail.
   */
  com.google.protobuf.ByteString
      getDiskAvailBytes();

  /**
   * <code>double disk_percent = 11;</code>
   * @return The diskPercent.
   */
  double getDiskPercent();

  /**
   * <code>string group = 12;</code>
   * @return The group.
   */
  java.lang.String getGroup();
  /**
   * <code>string group = 12;</code>
   * @return The bytes for group.
   */
  com.google.protobuf.ByteString
      getGroupBytes();

  /**
   * <code>string tag = 13;</code>
   * @return The tag.
   */
  java.lang.String getTag();
  /**
   * <code>string tag = 13;</code>
   * @return The bytes for tag.
   */
  com.google.protobuf.ByteString
      getTagBytes();
}
