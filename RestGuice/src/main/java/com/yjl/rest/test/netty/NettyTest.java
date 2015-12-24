package com.yjl.rest.test.netty;

import com.yjl.rest.Util.Constant;
import org.apache.log4j.Logger;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by on 12/24/15.
 */
public class NettyTest {
    private static Logger logger = Logger.getLogger(NettyTest.class);
    private static ExecutorService executorService = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {
        try {
            for (int i = 0; i < 1; i++) {
                executorService.execute(new Runnable() {
                    @Override
                    public void run() {
                        Message.OpMessage.Builder builder = new Message.OpMessage.Builder().setAge("23").setName("yangjunlin").setCount(-1);
                        ClientHandler clientHandler = new ClientHandler(builder.build());
                        Client.sendMessage(Constant.localHost, Constant.nettyPort, clientHandler);
                        if (!clientHandler.isSuccess()) {
                            logger.info("get result from clientHandler success.");
                            logger.info("the result is :" + clientHandler.getMessage().getName() + " , " + clientHandler.getMessage().getAge() + " , " + clientHandler.getMessage().getCount());
                        }
                    }
                });
            }
        } finally {
            executorService.shutdown();
            logger.info("executorservice shutdown now.");
        }
    }
}
