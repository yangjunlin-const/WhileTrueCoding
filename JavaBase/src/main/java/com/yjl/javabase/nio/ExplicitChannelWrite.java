package com.yjl.javabase.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Created by yangjunlin on 2015/12/13.
 */
public class ExplicitChannelWrite {
    public static void main(String[] args) {
        try (FileChannel fileChannel = (FileChannel) Files.newByteChannel(Paths.get("C:\\Users\\yangjunlin\\IdeaProjects\\WhileTrueCoding\\JavaBase\\doc\\test.txt"), StandardOpenOption.WRITE, StandardOpenOption.READ)) {
            ByteBuffer byteBuffer = ByteBuffer.allocateDirect(10240);
            for (int i = 0; i < 10240; i++) {
                byteBuffer.put((byte) ('c'));
            }
            byteBuffer.rewind();
            fileChannel.write(byteBuffer);
            fileChannel.force(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
