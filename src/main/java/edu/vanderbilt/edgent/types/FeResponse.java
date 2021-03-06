// automatically generated by the FlatBuffers compiler, do not modify

package edu.vanderbilt.edgent.types;

import java.nio.*;
import java.lang.*;
import java.util.*;
import com.google.flatbuffers.*;

@SuppressWarnings("unused")
public final class FeResponse extends Table {
  public static FeResponse getRootAsFeResponse(ByteBuffer _bb) { return getRootAsFeResponse(_bb, new FeResponse()); }
  public static FeResponse getRootAsFeResponse(ByteBuffer _bb, FeResponse obj) { _bb.order(ByteOrder.LITTLE_ENDIAN); return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb)); }
  public void __init(int _i, ByteBuffer _bb) { bb_pos = _i; bb = _bb; }
  public FeResponse __assign(int _i, ByteBuffer _bb) { __init(_i, _bb); return this; }

  public int code() { int o = __offset(4); return o != 0 ? bb.getInt(o + bb_pos) : 0; }
  public String msg() { int o = __offset(6); return o != 0 ? __string(o + bb_pos) : null; }
  public ByteBuffer msgAsByteBuffer() { return __vector_as_bytebuffer(6, 1); }
  public TopicConnector connectors(int j) { return connectors(new TopicConnector(), j); }
  public TopicConnector connectors(TopicConnector obj, int j) { int o = __offset(8); return o != 0 ? obj.__assign(__indirect(__vector(o) + j * 4), bb) : null; }
  public int connectorsLength() { int o = __offset(8); return o != 0 ? __vector_len(o) : 0; }

  public static int createFeResponse(FlatBufferBuilder builder,
      int code,
      int msgOffset,
      int connectorsOffset) {
    builder.startObject(3);
    FeResponse.addConnectors(builder, connectorsOffset);
    FeResponse.addMsg(builder, msgOffset);
    FeResponse.addCode(builder, code);
    return FeResponse.endFeResponse(builder);
  }

  public static void startFeResponse(FlatBufferBuilder builder) { builder.startObject(3); }
  public static void addCode(FlatBufferBuilder builder, int code) { builder.addInt(0, code, 0); }
  public static void addMsg(FlatBufferBuilder builder, int msgOffset) { builder.addOffset(1, msgOffset, 0); }
  public static void addConnectors(FlatBufferBuilder builder, int connectorsOffset) { builder.addOffset(2, connectorsOffset, 0); }
  public static int createConnectorsVector(FlatBufferBuilder builder, int[] data) { builder.startVector(4, data.length, 4); for (int i = data.length - 1; i >= 0; i--) builder.addOffset(data[i]); return builder.endVector(); }
  public static void startConnectorsVector(FlatBufferBuilder builder, int numElems) { builder.startVector(4, numElems, 4); }
  public static int endFeResponse(FlatBufferBuilder builder) {
    int o = builder.endObject();
    return o;
  }
  public static void finishFeResponseBuffer(FlatBufferBuilder builder, int offset) { builder.finish(offset); }
}

