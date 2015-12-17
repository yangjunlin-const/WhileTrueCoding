package com.yjl.javabase.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by on 12/17/15.
 */
public class PathGet {
    public static void main(String[] args) {
        String home = "/home/yangjunlin/iedaWorkspace/WhileTrueCoding/JavaBase/doc/";
        Path path = Paths.get(home, "/test/buaa/");
       /* if (!Files.exists(path)) {
            try {
                Files.createDirectories(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/
        try {
            checkPath(path);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    private static void checkPath(Path path) throws Exception {
        if (!Files.exists(path)) {
            try {
                Files.createDirectories(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            throw new Exception("the path is exist");
        }
    }
}
