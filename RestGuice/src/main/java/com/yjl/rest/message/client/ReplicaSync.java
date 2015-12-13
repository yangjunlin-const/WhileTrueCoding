package com.yjl.rest.message.client;

import com.yjl.rest.core.CollectionCore;
import com.yjl.rest.core.Node;
import com.yjl.rest.message.protos.MessageProtos;
import org.jboss.netty.bootstrap.ClientBootstrap;
import org.jboss.netty.channel.*;
import org.jboss.netty.channel.socket.nio.NioClientSocketChannelFactory;
import org.jboss.netty.handler.codec.protobuf.ProtobufDecoder;
import org.jboss.netty.handler.codec.protobuf.ProtobufEncoder;
import org.jboss.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import org.jboss.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;

import java.net.InetSocketAddress;
import java.util.List;
import java.util.concurrent.Executors;

public class ReplicaSync {

  private List<Node> nodes;
  private ClientBootstrap bootstrap =
      new ClientBootstrap(new NioClientSocketChannelFactory(Executors.newCachedThreadPool(),
          Executors.newCachedThreadPool()));
  
  public ReplicaSync(CollectionCore core){
//    this.nodes = core.getNodes();
  }
  
  public static void main(String[] args) {
    new ReplicaSync(null).sync();
  }
  
  public void sync(){
    MessageProtos.SyncMessage.Builder builder = MessageProtos.SyncMessage.newBuilder();
    builder.setTenant("tenant");
    builder.setCollection("collection1");
    builder.setMethod(MessageProtos.HTTP_METHODS.POST);
    builder.setContent("{\"name\":\"cong\"}");
    ProtobufHandler handler = new ProtobufHandler(builder.build());
    SyncChannelPipeline pipeline = new SyncChannelPipeline(handler);
    bootstrap.setPipelineFactory(pipeline);
    bootstrap.connect(new InetSocketAddress("127.0.0.1", 18000));
  }
  
  class SyncChannelPipeline implements ChannelPipelineFactory{
    ChannelHandler handler;
    public SyncChannelPipeline(ChannelHandler handler){
      this.handler = handler;
    }
    @Override
    public ChannelPipeline getPipeline() throws Exception {
      ChannelPipeline p = Channels.pipeline();
      p.addLast("frameDecoder", new ProtobufVarint32FrameDecoder()); 
      p.addLast("protobufDecoder", new ProtobufDecoder(MessageProtos.SyncMessage.getDefaultInstance()));
      p.addLast("frameEncoder", new ProtobufVarint32LengthFieldPrepender());
      p.addLast("protobufEncoder", new ProtobufEncoder());
      p.addLast("handler", handler);
      return p;
    }
  }
  
  class ProtobufHandler extends SimpleChannelUpstreamHandler{
    Object message;
    public ProtobufHandler(Object message){
      this.message = message;
    }
    
    @Override
    public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
      super.channelConnected(ctx, e);
      ChannelFuture future = e.getChannel().write(message).sync();
    }
  }
}
