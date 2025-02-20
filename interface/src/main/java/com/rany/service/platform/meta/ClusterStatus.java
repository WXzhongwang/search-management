// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: admin/meta.proto

package com.rany.service.platform.meta;

/**
 * Protobuf enum {@code ClusterStatus}
 */
public enum ClusterStatus
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <code>NULL = 0;</code>
   */
  NULL(0),
  /**
   * <code>CREATING = 1;</code>
   */
  CREATING(1),
  /**
   * <code>IN_SERVICE = 2;</code>
   */
  IN_SERVICE(2),
  /**
   * <code>DISABLED = 3;</code>
   */
  DISABLED(3),
  /**
   * <code>DELETING = 4;</code>
   */
  DELETING(4),
  UNRECOGNIZED(-1),
  ;

  /**
   * <code>NULL = 0;</code>
   */
  public static final int NULL_VALUE = 0;
  /**
   * <code>CREATING = 1;</code>
   */
  public static final int CREATING_VALUE = 1;
  /**
   * <code>IN_SERVICE = 2;</code>
   */
  public static final int IN_SERVICE_VALUE = 2;
  /**
   * <code>DISABLED = 3;</code>
   */
  public static final int DISABLED_VALUE = 3;
  /**
   * <code>DELETING = 4;</code>
   */
  public static final int DELETING_VALUE = 4;


  public final int getNumber() {
    if (this == UNRECOGNIZED) {
      throw new java.lang.IllegalArgumentException(
          "Can't get the number of an unknown enum value.");
    }
    return value;
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   * @deprecated Use {@link #forNumber(int)} instead.
   */
  @java.lang.Deprecated
  public static ClusterStatus valueOf(int value) {
    return forNumber(value);
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   */
  public static ClusterStatus forNumber(int value) {
    switch (value) {
      case 0: return NULL;
      case 1: return CREATING;
      case 2: return IN_SERVICE;
      case 3: return DISABLED;
      case 4: return DELETING;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<ClusterStatus>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      ClusterStatus> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<ClusterStatus>() {
          public ClusterStatus findValueByNumber(int number) {
            return ClusterStatus.forNumber(number);
          }
        };

  public final com.google.protobuf.Descriptors.EnumValueDescriptor
      getValueDescriptor() {
    if (this == UNRECOGNIZED) {
      throw new java.lang.IllegalStateException(
          "Can't get the descriptor of an unrecognized enum value.");
    }
    return getDescriptor().getValues().get(ordinal());
  }
  public final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptorForType() {
    return getDescriptor();
  }
  public static final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptor() {
    return com.rany.service.platform.meta.SearchMiddlePlatformMetaService.getDescriptor().getEnumTypes().get(1);
  }

  private static final ClusterStatus[] VALUES = values();

  public static ClusterStatus valueOf(
      com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
    if (desc.getType() != getDescriptor()) {
      throw new java.lang.IllegalArgumentException(
        "EnumValueDescriptor is not for this type.");
    }
    if (desc.getIndex() == -1) {
      return UNRECOGNIZED;
    }
    return VALUES[desc.getIndex()];
  }

  private final int value;

  private ClusterStatus(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:ClusterStatus)
}

