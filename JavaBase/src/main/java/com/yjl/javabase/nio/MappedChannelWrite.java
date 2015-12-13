package com.yjl.javabase.nio;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Created by yangjunlin on 2015/12/13.
 */
public class MappedChannelWrite {
    public static void main(String[] args) {
        try (FileChannel fileChannel = (FileChannel) Files.newByteChannel(Paths.get("C:\\Users\\yangjunlin\\IdeaProjects\\WhileTrueCoding\\JavaBase\\doc\\test.txt"), StandardOpenOption.WRITE, StandardOpenOption.READ)) {
            MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, 10240000);
            for (int i = 0; i < 10240000; i++) {
                mappedByteBuffer.put((byte) 'm');
            }
            System.out.println("success");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
