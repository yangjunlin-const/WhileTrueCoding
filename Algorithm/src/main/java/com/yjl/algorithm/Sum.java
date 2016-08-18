package com.yjl.algorithm;

/**
 * Created by YangJunLin on 2016/8/9.
 */
public class Sum {
    public static void main(String[] args) {
        testDiguiSum();
    }

    private static void testDiguiSum() {
        int a[] = new int[]{1, 2, 3, 4, 5, 6, 7,8};
        System.out.println(getSumDigui(a, a.length - 1));
    }

    private static int getSumDigui(int[] array, int length) {
        if (length == 0) {
            return array[0];
        } else {
            return array[length] + getSumDigui(array, length - 1);
        }
    }
}
