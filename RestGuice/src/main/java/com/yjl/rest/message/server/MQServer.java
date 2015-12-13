package com.yjl.rest.message.server;

import com.yjl.rest.message.protos.MessageProtos;
import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.*;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;
import org.jboss.netty.handler.codec.protobuf.ProtobufDecoder;
import org.jboss.netty.handler.codec.protobuf.ProtobufEncoder;
import org.jboss.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import org.jboss.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class MQServer {

  public static ServerBootstrap bootstrap=
      new ServerBootstrap(new NioServerSocketChannelFactory(Executors.newCachedThreadPool(),
        Executors.newCachedThreadPool()));;
  
  public MQServer(){
    bootstrap.setPipelineFactory(new ChannelPipelineFactory() {
      public ChannelPipeline getPipeline() throws Exception {
        ChannelPipeline p = Channels.pipeline();
        p.addLast("frameDecoder", new ProtobufVarint32FrameDecoder()); 
        p.addLast("protobufDecoder", new ProtobufDecoder(MessageProtos.SyncMessage.getDefaultInstance()));
        p.addLast("frameEncoder", new ProtobufVarint32LengthFieldPrepender());
        p.addLast("protobufEncoder", new ProtobufEncoder());
        p.addLast("protobufHandler", new MessageHandler());
        return p;
      }
    });
  }
  
  public void startupServer(){
    //TODO register port to zookeeper 
    bootstrap.bind(new InetSocketAddress(18000));
  }
  
private static class MessageHandler extends SimpleChannelHandler{
  public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) throws Exception {
    MessageProtos.SyncMessage buffer = (MessageProtos.SyncMessage) e.getMessage();
    System.out.println(buffer.getContent());
  }
}
}
