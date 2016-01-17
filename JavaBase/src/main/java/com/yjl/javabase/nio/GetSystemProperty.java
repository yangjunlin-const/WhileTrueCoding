package com.yjl.javabase.nio;

import java.util.Properties;
import java.util.Set;

/**
 * Created by yangjunlin on 2016/1/17.
 */
public class GetSystemProperty {
    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));
        Properties properties = System.getProperties();
        Set<String> names = properties.stringPropertyNames();
        for (String name : names) {
            System.out.print(name + "  :  ");
            System.out.println(properties.getProperty(name));
        }
    }
}
