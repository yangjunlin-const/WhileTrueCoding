package com.yjl.javabase.nio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by on 12/16/15.
 */
public class FileLockTest {
    public static void main(String[] args) {
        Path path = Paths.get("/mnt/pbSearch/farm1/aa.txt");
        try {
            FileChannel fileChannel = new RandomAccessFile(path.toString(), "rw").getChannel();
            FileLock fileLock = fileChannel.lock();
            Files.delete(path);
            fileLock.release();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("success");
       /* String[] children = path.toFile().list();
        for (String s : children) {
            System.out.println(s);
        }*/
    }

    private static boolean delete(File collection) {
        if (collection.isDirectory()) {
            String[] children = collection.list();
            for (int i = 0; i < children.length; i++) {
                boolean tmp = delete(new File(collection, children[i]));
                if (!tmp) {
                    return false;
                }
            }
        }
        return collection.delete();
    }

}
