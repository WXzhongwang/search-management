# Generated by the protocol buffer compiler.  DO NOT EDIT!
# source: admin/admin.proto

import sys
_b=sys.version_info[0]<3 and (lambda x:x) or (lambda x:x.encode('latin1'))
from google.protobuf import descriptor as _descriptor
from google.protobuf import message as _message
from google.protobuf import reflection as _reflection
from google.protobuf import symbol_database as _symbol_database
from google.protobuf import descriptor_pb2
# @@protoc_insertion_point(imports)

_sym_db = _symbol_database.Default()




DESCRIPTOR = _descriptor.FileDescriptor(
  name='admin/admin.proto',
  package='',
  syntax='proto3',
  serialized_pb=_b('\n\x11\x61\x64min/admin.proto\"\x1b\n\x0bPingRequest\x12\x0c\n\x04ping\x18\x01 \x01(\t\"\x19\n\tPingReply\x12\x0c\n\x04pong\x18\x01 \x01(\t\"\x14\n\x12SetReadOnlyRequest\"1\n\x10ReadOnlyResponse\x12\x0c\n\x04\x63ode\x18\x01 \x01(\x05\x12\x0f\n\x07message\x18\x02 \x01(\t\"\x15\n\x13SetInServiceRequest\"2\n\x11InServiceResponse\x12\x0c\n\x04\x63ode\x18\x01 \x01(\x05\x12\x0f\n\x07message\x18\x02 \x01(\t\"\x13\n\x11SetSuspendRequest\"0\n\x0fSuspendResponse\x12\x0c\n\x04\x63ode\x18\x01 \x01(\x05\x12\x0f\n\x07message\x18\x02 \x01(\t\"\x17\n\x15GetServiceModeRequest\"B\n\x13ServiceModeResponse\x12\x0c\n\x04\x63ode\x18\x01 \x01(\x05\x12\x0f\n\x07message\x18\x02 \x01(\t\x12\x0c\n\x04mode\x18\x03 \x01(\t\"\x1a\n\x18SuspendWorkThreadRequest\":\n\x19SuspendWorkThreadResponse\x12\x0c\n\x04\x63ode\x18\x01 \x01(\x05\x12\x0f\n\x07message\x18\x02 \x01(\t\"\x19\n\x17ResumeWorkThreadRequest\"9\n\x18ResumeWorkThreadResponse\x12\x0c\n\x04\x63ode\x18\x01 \x01(\x05\x12\x0f\n\x07message\x18\x02 \x01(\t\"\x1c\n\x1aGetWorkThreadStatusRequest\"M\n\x1bGetWorkThreadStatusResponse\x12\x0c\n\x04\x63ode\x18\x01 \x01(\x05\x12\x0f\n\x07message\x18\x02 \x01(\t\x12\x0f\n\x07running\x18\x03 \x01(\x08\x32\xad\x04\n\x0c\x41\x64minService\x12\"\n\x04Ping\x12\x0c.PingRequest\x1a\n.PingReply\"\x00\x12>\n\x12SetServiceReadOnly\x12\x13.SetReadOnlyRequest\x1a\x11.ReadOnlyResponse\"\x00\x12\x41\n\x13SetServiceInService\x12\x14.SetInServiceRequest\x1a\x12.InServiceResponse\"\x00\x12;\n\x11SetServiceSuspend\x12\x12.SetSuspendRequest\x1a\x10.SuspendResponse\"\x00\x12@\n\x0eGetServiceMode\x12\x16.GetServiceModeRequest\x1a\x14.ServiceModeResponse\"\x00\x12P\n\x15SuspendBackendThreads\x12\x19.SuspendWorkThreadRequest\x1a\x1a.SuspendWorkThreadResponse\"\x00\x12M\n\x14ResumeBackendThreads\x12\x18.ResumeWorkThreadRequest\x1a\x19.ResumeWorkThreadResponse\"\x00\x12V\n\x17GetBackendThreadsStatus\x12\x1b.GetWorkThreadStatusRequest\x1a\x1c.GetWorkThreadStatusResponse\"\x00\x42\x45\n\x1f\x63om.rany.service.platform.adminB SearchMiddlePlatformAdminServiceP\x01\x62\x06proto3')
)




_PINGREQUEST = _descriptor.Descriptor(
  name='PingRequest',
  full_name='PingRequest',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  fields=[
    _descriptor.FieldDescriptor(
      name='ping', full_name='PingRequest.ping', index=0,
      number=1, type=9, cpp_type=9, label=1,
      has_default_value=False, default_value=_b("").decode('utf-8'),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      options=None),
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
  ],
  options=None,
  is_extendable=False,
  syntax='proto3',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=21,
  serialized_end=48,
)


_PINGREPLY = _descriptor.Descriptor(
  name='PingReply',
  full_name='PingReply',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  fields=[
    _descriptor.FieldDescriptor(
      name='pong', full_name='PingReply.pong', index=0,
      number=1, type=9, cpp_type=9, label=1,
      has_default_value=False, default_value=_b("").decode('utf-8'),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      options=None),
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
  ],
  options=None,
  is_extendable=False,
  syntax='proto3',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=50,
  serialized_end=75,
)


_SETREADONLYREQUEST = _descriptor.Descriptor(
  name='SetReadOnlyRequest',
  full_name='SetReadOnlyRequest',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  fields=[
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
  ],
  options=None,
  is_extendable=False,
  syntax='proto3',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=77,
  serialized_end=97,
)


_READONLYRESPONSE = _descriptor.Descriptor(
  name='ReadOnlyResponse',
  full_name='ReadOnlyResponse',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  fields=[
    _descriptor.FieldDescriptor(
      name='code', full_name='ReadOnlyResponse.code', index=0,
      number=1, type=5, cpp_type=1, label=1,
      has_default_value=False, default_value=0,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      options=None),
    _descriptor.FieldDescriptor(
      name='message', full_name='ReadOnlyResponse.message', index=1,
      number=2, type=9, cpp_type=9, label=1,
      has_default_value=False, default_value=_b("").decode('utf-8'),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      options=None),
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
  ],
  options=None,
  is_extendable=False,
  syntax='proto3',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=99,
  serialized_end=148,
)


_SETINSERVICEREQUEST = _descriptor.Descriptor(
  name='SetInServiceRequest',
  full_name='SetInServiceRequest',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  fields=[
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
  ],
  options=None,
  is_extendable=False,
  syntax='proto3',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=150,
  serialized_end=171,
)


_INSERVICERESPONSE = _descriptor.Descriptor(
  name='InServiceResponse',
  full_name='InServiceResponse',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  fields=[
    _descriptor.FieldDescriptor(
      name='code', full_name='InServiceResponse.code', index=0,
      number=1, type=5, cpp_type=1, label=1,
      has_default_value=False, default_value=0,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      options=None),
    _descriptor.FieldDescriptor(
      name='message', full_name='InServiceResponse.message', index=1,
      number=2, type=9, cpp_type=9, label=1,
      has_default_value=False, default_value=_b("").decode('utf-8'),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      options=None),
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
  ],
  options=None,
  is_extendable=False,
  syntax='proto3',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=173,
  serialized_end=223,
)


_SETSUSPENDREQUEST = _descriptor.Descriptor(
  name='SetSuspendRequest',
  full_name='SetSuspendRequest',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  fields=[
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
  ],
  options=None,
  is_extendable=False,
  syntax='proto3',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=225,
  serialized_end=244,
)


_SUSPENDRESPONSE = _descriptor.Descriptor(
  name='SuspendResponse',
  full_name='SuspendResponse',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  fields=[
    _descriptor.FieldDescriptor(
      name='code', full_name='SuspendResponse.code', index=0,
      number=1, type=5, cpp_type=1, label=1,
      has_default_value=False, default_value=0,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      options=None),
    _descriptor.FieldDescriptor(
      name='message', full_name='SuspendResponse.message', index=1,
      number=2, type=9, cpp_type=9, label=1,
      has_default_value=False, default_value=_b("").decode('utf-8'),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      options=None),
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
  ],
  options=None,
  is_extendable=False,
  syntax='proto3',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=246,
  serialized_end=294,
)


_GETSERVICEMODEREQUEST = _descriptor.Descriptor(
  name='GetServiceModeRequest',
  full_name='GetServiceModeRequest',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  fields=[
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
  ],
  options=None,
  is_extendable=False,
  syntax='proto3',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=296,
  serialized_end=319,
)


_SERVICEMODERESPONSE = _descriptor.Descriptor(
  name='ServiceModeResponse',
  full_name='ServiceModeResponse',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  fields=[
    _descriptor.FieldDescriptor(
      name='code', full_name='ServiceModeResponse.code', index=0,
      number=1, type=5, cpp_type=1, label=1,
      has_default_value=False, default_value=0,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      options=None),
    _descriptor.FieldDescriptor(
      name='message', full_name='ServiceModeResponse.message', index=1,
      number=2, type=9, cpp_type=9, label=1,
      has_default_value=False, default_value=_b("").decode('utf-8'),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      options=None),
    _descriptor.FieldDescriptor(
      name='mode', full_name='ServiceModeResponse.mode', index=2,
      number=3, type=9, cpp_type=9, label=1,
      has_default_value=False, default_value=_b("").decode('utf-8'),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      options=None),
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
  ],
  options=None,
  is_extendable=False,
  syntax='proto3',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=321,
  serialized_end=387,
)


_SUSPENDWORKTHREADREQUEST = _descriptor.Descriptor(
  name='SuspendWorkThreadRequest',
  full_name='SuspendWorkThreadRequest',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  fields=[
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
  ],
  options=None,
  is_extendable=False,
  syntax='proto3',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=389,
  serialized_end=415,
)


_SUSPENDWORKTHREADRESPONSE = _descriptor.Descriptor(
  name='SuspendWorkThreadResponse',
  full_name='SuspendWorkThreadResponse',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  fields=[
    _descriptor.FieldDescriptor(
      name='code', full_name='SuspendWorkThreadResponse.code', index=0,
      number=1, type=5, cpp_type=1, label=1,
      has_default_value=False, default_value=0,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      options=None),
    _descriptor.FieldDescriptor(
      name='message', full_name='SuspendWorkThreadResponse.message', index=1,
      number=2, type=9, cpp_type=9, label=1,
      has_default_value=False, default_value=_b("").decode('utf-8'),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      options=None),
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
  ],
  options=None,
  is_extendable=False,
  syntax='proto3',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=417,
  serialized_end=475,
)


_RESUMEWORKTHREADREQUEST = _descriptor.Descriptor(
  name='ResumeWorkThreadRequest',
  full_name='ResumeWorkThreadRequest',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  fields=[
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
  ],
  options=None,
  is_extendable=False,
  syntax='proto3',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=477,
  serialized_end=502,
)


_RESUMEWORKTHREADRESPONSE = _descriptor.Descriptor(
  name='ResumeWorkThreadResponse',
  full_name='ResumeWorkThreadResponse',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  fields=[
    _descriptor.FieldDescriptor(
      name='code', full_name='ResumeWorkThreadResponse.code', index=0,
      number=1, type=5, cpp_type=1, label=1,
      has_default_value=False, default_value=0,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      options=None),
    _descriptor.FieldDescriptor(
      name='message', full_name='ResumeWorkThreadResponse.message', index=1,
      number=2, type=9, cpp_type=9, label=1,
      has_default_value=False, default_value=_b("").decode('utf-8'),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      options=None),
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
  ],
  options=None,
  is_extendable=False,
  syntax='proto3',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=504,
  serialized_end=561,
)


_GETWORKTHREADSTATUSREQUEST = _descriptor.Descriptor(
  name='GetWorkThreadStatusRequest',
  full_name='GetWorkThreadStatusRequest',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  fields=[
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
  ],
  options=None,
  is_extendable=False,
  syntax='proto3',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=563,
  serialized_end=591,
)


_GETWORKTHREADSTATUSRESPONSE = _descriptor.Descriptor(
  name='GetWorkThreadStatusResponse',
  full_name='GetWorkThreadStatusResponse',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  fields=[
    _descriptor.FieldDescriptor(
      name='code', full_name='GetWorkThreadStatusResponse.code', index=0,
      number=1, type=5, cpp_type=1, label=1,
      has_default_value=False, default_value=0,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      options=None),
    _descriptor.FieldDescriptor(
      name='message', full_name='GetWorkThreadStatusResponse.message', index=1,
      number=2, type=9, cpp_type=9, label=1,
      has_default_value=False, default_value=_b("").decode('utf-8'),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      options=None),
    _descriptor.FieldDescriptor(
      name='running', full_name='GetWorkThreadStatusResponse.running', index=2,
      number=3, type=8, cpp_type=7, label=1,
      has_default_value=False, default_value=False,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      options=None),
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
  ],
  options=None,
  is_extendable=False,
  syntax='proto3',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=593,
  serialized_end=670,
)

DESCRIPTOR.message_types_by_name['PingRequest'] = _PINGREQUEST
DESCRIPTOR.message_types_by_name['PingReply'] = _PINGREPLY
DESCRIPTOR.message_types_by_name['SetReadOnlyRequest'] = _SETREADONLYREQUEST
DESCRIPTOR.message_types_by_name['ReadOnlyResponse'] = _READONLYRESPONSE
DESCRIPTOR.message_types_by_name['SetInServiceRequest'] = _SETINSERVICEREQUEST
DESCRIPTOR.message_types_by_name['InServiceResponse'] = _INSERVICERESPONSE
DESCRIPTOR.message_types_by_name['SetSuspendRequest'] = _SETSUSPENDREQUEST
DESCRIPTOR.message_types_by_name['SuspendResponse'] = _SUSPENDRESPONSE
DESCRIPTOR.message_types_by_name['GetServiceModeRequest'] = _GETSERVICEMODEREQUEST
DESCRIPTOR.message_types_by_name['ServiceModeResponse'] = _SERVICEMODERESPONSE
DESCRIPTOR.message_types_by_name['SuspendWorkThreadRequest'] = _SUSPENDWORKTHREADREQUEST
DESCRIPTOR.message_types_by_name['SuspendWorkThreadResponse'] = _SUSPENDWORKTHREADRESPONSE
DESCRIPTOR.message_types_by_name['ResumeWorkThreadRequest'] = _RESUMEWORKTHREADREQUEST
DESCRIPTOR.message_types_by_name['ResumeWorkThreadResponse'] = _RESUMEWORKTHREADRESPONSE
DESCRIPTOR.message_types_by_name['GetWorkThreadStatusRequest'] = _GETWORKTHREADSTATUSREQUEST
DESCRIPTOR.message_types_by_name['GetWorkThreadStatusResponse'] = _GETWORKTHREADSTATUSRESPONSE
_sym_db.RegisterFileDescriptor(DESCRIPTOR)

PingRequest = _reflection.GeneratedProtocolMessageType('PingRequest', (_message.Message,), dict(
  DESCRIPTOR = _PINGREQUEST,
  __module__ = 'admin.admin_pb2'
  # @@protoc_insertion_point(class_scope:PingRequest)
  ))
_sym_db.RegisterMessage(PingRequest)

PingReply = _reflection.GeneratedProtocolMessageType('PingReply', (_message.Message,), dict(
  DESCRIPTOR = _PINGREPLY,
  __module__ = 'admin.admin_pb2'
  # @@protoc_insertion_point(class_scope:PingReply)
  ))
_sym_db.RegisterMessage(PingReply)

SetReadOnlyRequest = _reflection.GeneratedProtocolMessageType('SetReadOnlyRequest', (_message.Message,), dict(
  DESCRIPTOR = _SETREADONLYREQUEST,
  __module__ = 'admin.admin_pb2'
  # @@protoc_insertion_point(class_scope:SetReadOnlyRequest)
  ))
_sym_db.RegisterMessage(SetReadOnlyRequest)

ReadOnlyResponse = _reflection.GeneratedProtocolMessageType('ReadOnlyResponse', (_message.Message,), dict(
  DESCRIPTOR = _READONLYRESPONSE,
  __module__ = 'admin.admin_pb2'
  # @@protoc_insertion_point(class_scope:ReadOnlyResponse)
  ))
_sym_db.RegisterMessage(ReadOnlyResponse)

SetInServiceRequest = _reflection.GeneratedProtocolMessageType('SetInServiceRequest', (_message.Message,), dict(
  DESCRIPTOR = _SETINSERVICEREQUEST,
  __module__ = 'admin.admin_pb2'
  # @@protoc_insertion_point(class_scope:SetInServiceRequest)
  ))
_sym_db.RegisterMessage(SetInServiceRequest)

InServiceResponse = _reflection.GeneratedProtocolMessageType('InServiceResponse', (_message.Message,), dict(
  DESCRIPTOR = _INSERVICERESPONSE,
  __module__ = 'admin.admin_pb2'
  # @@protoc_insertion_point(class_scope:InServiceResponse)
  ))
_sym_db.RegisterMessage(InServiceResponse)

SetSuspendRequest = _reflection.GeneratedProtocolMessageType('SetSuspendRequest', (_message.Message,), dict(
  DESCRIPTOR = _SETSUSPENDREQUEST,
  __module__ = 'admin.admin_pb2'
  # @@protoc_insertion_point(class_scope:SetSuspendRequest)
  ))
_sym_db.RegisterMessage(SetSuspendRequest)

SuspendResponse = _reflection.GeneratedProtocolMessageType('SuspendResponse', (_message.Message,), dict(
  DESCRIPTOR = _SUSPENDRESPONSE,
  __module__ = 'admin.admin_pb2'
  # @@protoc_insertion_point(class_scope:SuspendResponse)
  ))
_sym_db.RegisterMessage(SuspendResponse)

GetServiceModeRequest = _reflection.GeneratedProtocolMessageType('GetServiceModeRequest', (_message.Message,), dict(
  DESCRIPTOR = _GETSERVICEMODEREQUEST,
  __module__ = 'admin.admin_pb2'
  # @@protoc_insertion_point(class_scope:GetServiceModeRequest)
  ))
_sym_db.RegisterMessage(GetServiceModeRequest)

ServiceModeResponse = _reflection.GeneratedProtocolMessageType('ServiceModeResponse', (_message.Message,), dict(
  DESCRIPTOR = _SERVICEMODERESPONSE,
  __module__ = 'admin.admin_pb2'
  # @@protoc_insertion_point(class_scope:ServiceModeResponse)
  ))
_sym_db.RegisterMessage(ServiceModeResponse)

SuspendWorkThreadRequest = _reflection.GeneratedProtocolMessageType('SuspendWorkThreadRequest', (_message.Message,), dict(
  DESCRIPTOR = _SUSPENDWORKTHREADREQUEST,
  __module__ = 'admin.admin_pb2'
  # @@protoc_insertion_point(class_scope:SuspendWorkThreadRequest)
  ))
_sym_db.RegisterMessage(SuspendWorkThreadRequest)

SuspendWorkThreadResponse = _reflection.GeneratedProtocolMessageType('SuspendWorkThreadResponse', (_message.Message,), dict(
  DESCRIPTOR = _SUSPENDWORKTHREADRESPONSE,
  __module__ = 'admin.admin_pb2'
  # @@protoc_insertion_point(class_scope:SuspendWorkThreadResponse)
  ))
_sym_db.RegisterMessage(SuspendWorkThreadResponse)

ResumeWorkThreadRequest = _reflection.GeneratedProtocolMessageType('ResumeWorkThreadRequest', (_message.Message,), dict(
  DESCRIPTOR = _RESUMEWORKTHREADREQUEST,
  __module__ = 'admin.admin_pb2'
  # @@protoc_insertion_point(class_scope:ResumeWorkThreadRequest)
  ))
_sym_db.RegisterMessage(ResumeWorkThreadRequest)

ResumeWorkThreadResponse = _reflection.GeneratedProtocolMessageType('ResumeWorkThreadResponse', (_message.Message,), dict(
  DESCRIPTOR = _RESUMEWORKTHREADRESPONSE,
  __module__ = 'admin.admin_pb2'
  # @@protoc_insertion_point(class_scope:ResumeWorkThreadResponse)
  ))
_sym_db.RegisterMessage(ResumeWorkThreadResponse)

GetWorkThreadStatusRequest = _reflection.GeneratedProtocolMessageType('GetWorkThreadStatusRequest', (_message.Message,), dict(
  DESCRIPTOR = _GETWORKTHREADSTATUSREQUEST,
  __module__ = 'admin.admin_pb2'
  # @@protoc_insertion_point(class_scope:GetWorkThreadStatusRequest)
  ))
_sym_db.RegisterMessage(GetWorkThreadStatusRequest)

GetWorkThreadStatusResponse = _reflection.GeneratedProtocolMessageType('GetWorkThreadStatusResponse', (_message.Message,), dict(
  DESCRIPTOR = _GETWORKTHREADSTATUSRESPONSE,
  __module__ = 'admin.admin_pb2'
  # @@protoc_insertion_point(class_scope:GetWorkThreadStatusResponse)
  ))
_sym_db.RegisterMessage(GetWorkThreadStatusResponse)


DESCRIPTOR.has_options = True
DESCRIPTOR._options = _descriptor._ParseOptions(descriptor_pb2.FileOptions(), _b('\n\037com.rany.service.platform.adminB SearchMiddlePlatformAdminServiceP\001'))

_ADMINSERVICE = _descriptor.ServiceDescriptor(
  name='AdminService',
  full_name='AdminService',
  file=DESCRIPTOR,
  index=0,
  options=None,
  serialized_start=673,
  serialized_end=1230,
  methods=[
  _descriptor.MethodDescriptor(
    name='Ping',
    full_name='AdminService.Ping',
    index=0,
    containing_service=None,
    input_type=_PINGREQUEST,
    output_type=_PINGREPLY,
    options=None,
  ),
  _descriptor.MethodDescriptor(
    name='SetServiceReadOnly',
    full_name='AdminService.SetServiceReadOnly',
    index=1,
    containing_service=None,
    input_type=_SETREADONLYREQUEST,
    output_type=_READONLYRESPONSE,
    options=None,
  ),
  _descriptor.MethodDescriptor(
    name='SetServiceInService',
    full_name='AdminService.SetServiceInService',
    index=2,
    containing_service=None,
    input_type=_SETINSERVICEREQUEST,
    output_type=_INSERVICERESPONSE,
    options=None,
  ),
  _descriptor.MethodDescriptor(
    name='SetServiceSuspend',
    full_name='AdminService.SetServiceSuspend',
    index=3,
    containing_service=None,
    input_type=_SETSUSPENDREQUEST,
    output_type=_SUSPENDRESPONSE,
    options=None,
  ),
  _descriptor.MethodDescriptor(
    name='GetServiceMode',
    full_name='AdminService.GetServiceMode',
    index=4,
    containing_service=None,
    input_type=_GETSERVICEMODEREQUEST,
    output_type=_SERVICEMODERESPONSE,
    options=None,
  ),
  _descriptor.MethodDescriptor(
    name='SuspendBackendThreads',
    full_name='AdminService.SuspendBackendThreads',
    index=5,
    containing_service=None,
    input_type=_SUSPENDWORKTHREADREQUEST,
    output_type=_SUSPENDWORKTHREADRESPONSE,
    options=None,
  ),
  _descriptor.MethodDescriptor(
    name='ResumeBackendThreads',
    full_name='AdminService.ResumeBackendThreads',
    index=6,
    containing_service=None,
    input_type=_RESUMEWORKTHREADREQUEST,
    output_type=_RESUMEWORKTHREADRESPONSE,
    options=None,
  ),
  _descriptor.MethodDescriptor(
    name='GetBackendThreadsStatus',
    full_name='AdminService.GetBackendThreadsStatus',
    index=7,
    containing_service=None,
    input_type=_GETWORKTHREADSTATUSREQUEST,
    output_type=_GETWORKTHREADSTATUSRESPONSE,
    options=None,
  ),
])
_sym_db.RegisterServiceDescriptor(_ADMINSERVICE)

DESCRIPTOR.services_by_name['AdminService'] = _ADMINSERVICE

# @@protoc_insertion_point(module_scope)
