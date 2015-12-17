package com.yjl.javabase.config;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by on 12/17/15.
 */
public class GetProperty {
    public static void main(String[] args) {
        Properties properties = new Properties();
        try {
            properties.load(new GetProperty().getClass().getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(properties.getProperty("test.test"));
    }
}
