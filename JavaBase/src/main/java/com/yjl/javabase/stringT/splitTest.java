package com.yjl.javabase.stringT;

/**
 * Created by on 12/17/15.
 */
public class splitTest {
    public static void main(String[] args) {
        String string = ".test.buaa";
        String[] strings = string.split("\\.");
        for (String str : strings) {
            System.out.println(str);
        }
    }
}
