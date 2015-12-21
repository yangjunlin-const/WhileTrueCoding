package com.yjl.javabase.other;


/**
 * Created by on 12/21/15.
 */
public class GetMethodName {
    public static void main(String[] args) {
        test();
    }

    static void test() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        System.out.println(methodName);

    }
}
