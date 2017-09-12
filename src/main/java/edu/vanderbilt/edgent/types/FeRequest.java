// automatically generated by the FlatBuffers compiler, do not modify

package edu.vanderbilt.edgent.types;

import java.nio.*;
import java.lang.*;
import java.util.*;
import com.google.flatbuffers.*;

@SuppressWarnings("unused")
public final class FeRequest extends Table {
  public static FeRequest getRootAsFeRequest(ByteBuffer _bb) { return getRootAsFeRequest(_bb, new FeRequest()); }
  public static FeRequest getRootAsFeRequest(ByteBuffer _bb, FeRequest obj) { _bb.order(ByteOrder.LITTLE_ENDIAN); return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb)); }
  public void __init(int _i, ByteBuffer _bb) { bb_pos = _i; bb = _bb; }
  public FeRequest __assign(int _i, ByteBuffer _bb) { __init(_i, _bb); return this; }

  public int type() { int o = __offset(4); return o != 0 ? bb.getInt(o + bb_pos) : 0; }
  public String topicName() { int o = __offset(6); return o != 0 ? __string(o + bb_pos) : null; }
  public ByteBuffer topicNameAsByteBuffer() { return __vector_as_bytebuffer(6, 1); }
  public String endpointType() { int o = __offset(8); return o != 0 ? __string(o + bb_pos) : null; }
  public ByteBuffer endpointTypeAsByteBuffer() { return __vector_as_bytebuffer(8, 1); }
  public String containerId() { int o = __offset(10); return o != 0 ? __string(o + bb_pos) : null; }
  public ByteBuffer containerIdAsByteBuffer() { return __vector_as_bytebuffer(10, 1); }
  public String ebId() { int o = __offset(12); return o != 0 ? __string(o + bb_pos) : null; }
  public ByteBuffer ebIdAsByteBuffer() { return __vector_as_bytebuffer(12, 1); }

  public static int createFeRequest(FlatBufferBuilder builder,
      int type,
      int topicNameOffset,
      int endpointTypeOffset,
      int containerIdOffset,
      int ebIdOffset) {
    builder.startObject(5);
    FeRequest.addEbId(builder, ebIdOffset);
    FeRequest.addContainerId(builder, containerIdOffset);
    FeRequest.addEndpointType(builder, endpointTypeOffset);
    FeRequest.addTopicName(builder, topicNameOffset);
    FeRequest.addType(builder, type);
    return FeRequest.endFeRequest(builder);
  }

  public static void startFeRequest(FlatBufferBuilder builder) { builder.startObject(5); }
  public static void addType(FlatBufferBuilder builder, int type) { builder.addInt(0, type, 0); }
  public static void addTopicName(FlatBufferBuilder builder, int topicNameOffset) { builder.addOffset(1, topicNameOffset, 0); }
  public static void addEndpointType(FlatBufferBuilder builder, int endpointTypeOffset) { builder.addOffset(2, endpointTypeOffset, 0); }
  public static void addContainerId(FlatBufferBuilder builder, int containerIdOffset) { builder.addOffset(3, containerIdOffset, 0); }
  public static void addEbId(FlatBufferBuilder builder, int ebIdOffset) { builder.addOffset(4, ebIdOffset, 0); }
  public static int endFeRequest(FlatBufferBuilder builder) {
    int o = builder.endObject();
    return o;
  }
  public static void finishFeRequestBuffer(FlatBufferBuilder builder, int offset) { builder.finish(offset); }
}

