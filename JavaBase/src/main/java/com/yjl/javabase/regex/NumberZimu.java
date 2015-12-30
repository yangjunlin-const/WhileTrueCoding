package com.yjl.javabase.regex;

import java.util.regex.Pattern;

/**
 * Created by on 12/30/15.
 */
public class NumberZimu {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[a-zA-Z0-9]{1,}\\.test\\.com");
        boolean regex = pattern.matcher("54_151-5sdfd.test.com").matches();
        System.out.println(regex);
    }
}
