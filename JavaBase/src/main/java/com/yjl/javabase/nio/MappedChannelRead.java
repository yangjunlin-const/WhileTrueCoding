package com.yjl.javabase.nio;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by yangjunlin on 2015/12/13.
 */
public class MappedChannelRead {
    public static void main(String[] args) {
        int count = 0;
        try (FileChannel fileChannel = (FileChannel) Files.newByteChannel(Paths.get("C:\\Users\\yangjunlin\\IdeaProjects\\WhileTrueCoding\\JavaBase\\doc\\test.txt"))) {
            long size = fileChannel.size();
            MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, size);
            for (int i = 0; i < size; i++) {
                System.out.print((char) mappedByteBuffer.get());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
