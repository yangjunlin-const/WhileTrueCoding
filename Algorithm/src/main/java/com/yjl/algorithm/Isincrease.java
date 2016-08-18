package com.yjl.algorithm;

/**
 * Created by YangJunLin on 2016/8/9.
 */
public class Isincrease {
    public static void main(String[] args) {
        int array[] = new int[]{1, 2, 3, 0, 4, 5, 6, 7, 8};
        System.out.println(isin(array, array.length));

    }

    private static boolean isin(int array[], int length) {
        if (length == 1) {
            return true;
        } else {
            return (array[length - 1] > array[length - 2]) && isin(array, length - 1);
        }
    }
}
