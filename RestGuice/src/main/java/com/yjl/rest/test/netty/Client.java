package com.yjl.rest.test.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;
import org.apache.log4j.Logger;

/**
 * Created by on 12/24/15.
 */
public class Client {
    private static Logger logger = Logger.getLogger(Client.class);

    private static EventLoopGroup eventLoopGroup;
    private static Bootstrap bootstrap;

    static {
        eventLoopGroup = new NioEventLoopGroup();
        bootstrap = new Bootstrap();
        bootstrap.group(eventLoopGroup).channel(NioSocketChannel.class)
                .option(ChannelOption.TCP_NODELAY, true);
    }

    public static void sendMessage(final String host, final int port,
                                   final ChannelHandlerAdapter handler) {
        bootstrap.handler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel channel) throws Exception {
                channel.pipeline().addLast(new ProtobufVarint32FrameDecoder());
                channel.pipeline().addLast(
                        new ProtobufDecoder(Message.OpMessage.getDefaultInstance()));
                channel.pipeline().addLast(new ProtobufVarint32LengthFieldPrepender());
                channel.pipeline().addLast(new ProtobufEncoder());
                channel.pipeline().addLast(handler);
                logger.info("initChannel success, host : " + host + " , port : " + port);
            }
        });

        try {
            ChannelFuture f = bootstrap.connect(host, port).sync();
//            f.channel().closeFuture().sync();
            f.channel().closeFuture().sync();
          /*  f.addListener(new GenericFutureListener<Future<? super Void>>() {
                @Override
                public void operationComplete(Future<? super Void> future) throws Exception {
                    Message.OpMessage message = (Message.OpMessage) future.getNow();
                    logger.info("listenler : " + message.getCount());
                }
            });*/
            logger.info("message session(" + host + ":" + port + ")  complete and exit !");
        } catch (InterruptedException e) {
            logger.error("Remote server(" + host + ":" + port + ") connect failed.");
            e.printStackTrace();
        }
    }

    static {
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                eventLoopGroup.shutdownGracefully();
            }
        }));
    }
}
