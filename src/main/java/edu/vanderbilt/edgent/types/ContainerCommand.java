// automatically generated by the FlatBuffers compiler, do not modify

package edu.vanderbilt.edgent.types;

import java.nio.*;
import java.lang.*;
import java.util.*;
import com.google.flatbuffers.*;

@SuppressWarnings("unused")
public final class ContainerCommand extends Table {
  public static ContainerCommand getRootAsContainerCommand(ByteBuffer _bb) { return getRootAsContainerCommand(_bb, new ContainerCommand()); }
  public static ContainerCommand getRootAsContainerCommand(ByteBuffer _bb, ContainerCommand obj) { _bb.order(ByteOrder.LITTLE_ENDIAN); return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb)); }
  public void __init(int _i, ByteBuffer _bb) { bb_pos = _i; bb = _bb; }
  public ContainerCommand __assign(int _i, ByteBuffer _bb) { __init(_i, _bb); return this; }

  public int type() { int o = __offset(4); return o != 0 ? bb.getInt(o + bb_pos) : 0; }
  public String containerId() { int o = __offset(6); return o != 0 ? __string(o + bb_pos) : null; }
  public ByteBuffer containerIdAsByteBuffer() { return __vector_as_bytebuffer(6, 1); }
  public edu.vanderbilt.edgent.types.TopicConnector topicConnector() { return topicConnector(new edu.vanderbilt.edgent.types.TopicConnector()); }
  public edu.vanderbilt.edgent.types.TopicConnector topicConnector(edu.vanderbilt.edgent.types.TopicConnector obj) { int o = __offset(8); return o != 0 ? obj.__assign(__indirect(o + bb_pos), bb) : null; }

  public static int createContainerCommand(FlatBufferBuilder builder,
      int type,
      int containerIdOffset,
      int topicConnectorOffset) {
    builder.startObject(3);
    ContainerCommand.addTopicConnector(builder, topicConnectorOffset);
    ContainerCommand.addContainerId(builder, containerIdOffset);
    ContainerCommand.addType(builder, type);
    return ContainerCommand.endContainerCommand(builder);
  }

  public static void startContainerCommand(FlatBufferBuilder builder) { builder.startObject(3); }
  public static void addType(FlatBufferBuilder builder, int type) { builder.addInt(0, type, 0); }
  public static void addContainerId(FlatBufferBuilder builder, int containerIdOffset) { builder.addOffset(1, containerIdOffset, 0); }
  public static void addTopicConnector(FlatBufferBuilder builder, int topicConnectorOffset) { builder.addOffset(2, topicConnectorOffset, 0); }
  public static int endContainerCommand(FlatBufferBuilder builder) {
    int o = builder.endObject();
    return o;
  }
}
