package com.yjl.javabase.other;

import java.lang.reflect.Field;

/**
 * Created by on 12/19/15.
 */
public class equal100 {
    public static void main(String[] args) {
        /*Integer a = 1000;
        Integer b = 1000;
        System.out.println(a == b);
        Integer c = 100;
        Integer d = 100;
        System.out.println(c == d);*/
        Class cache = Integer.class.getDeclaredClasses()[0];
        try {
            Field myCache = cache.getDeclaredField("cache");
            myCache.setAccessible(true);
            Integer[] newCache = (Integer[]) myCache.get(cache);
            newCache[132] = newCache[133];
            int a = 2;
            int b = a + a;
            System.out.println(a);
            System.out.println(b);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
