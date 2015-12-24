package com.yjl.rest.test.netty;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import org.apache.log4j.Logger;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by on 12/24/15.
 */
public class ServerHandler extends ChannelHandlerAdapter {
    Logger logger = Logger.getLogger(ServerHandler.class);
    private static AtomicLong atomicLong = new AtomicLong(0);

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        Message.OpMessage response = (Message.OpMessage) msg;
        long count = atomicLong.incrementAndGet();
        Message.OpMessage.Builder builder = new Message.OpMessage.Builder().setName(response.getName()).setAge(response.getAge()).setCount(++count);
        response = builder.build();
        logger.info("server add one to count , now count is : " + count);
        ChannelFuture channelFuture = ctx.writeAndFlush(response);
        channelFuture.addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture future) throws Exception {
                ctx.close();
            }
        });
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        logger.info("server read complete.");
//        ctx.flush();
//        ctx.close();
    }
}
