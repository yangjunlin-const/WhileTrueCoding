package com.yjl.javabase.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by yangjunlin on 2015/12/13.
 */
public class ExplicitChannelRead {
    public static void main(String[] args) {
        try (SeekableByteChannel channel = Files.newByteChannel(Paths.get("C:\\Users\\yangjunlin\\IdeaProjects\\WhileTrueCoding\\JavaBase\\doc\\test.txt"))) {
            ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);
            int count = 0;
            do {
                count = channel.read(byteBuffer);
                if (count != -1) {
                    byteBuffer.rewind();
//                    byteBuffer.flip();
                    System.out.println(count);
                    for (int i = 0; i < count; i++) {
                        System.out.print((char) byteBuffer.get());
                    }
                    byteBuffer.rewind();
                }
            } while (count != -1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
