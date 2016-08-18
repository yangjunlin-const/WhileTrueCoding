package com.yjl.algorithm;

/**
 * Created by YangJunLin on 2016/8/9.
 */
public class printTwoArray {
    public static void main(String[] args) {
        print();
    }

    private static void print() {
        int array[][] = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int x = 3;
        int y = 3;
        for (int i = 0; i < x * y; i++) {
            int a = i / x;
            int b = i % y;
            System.out.println(array[a][b]);
        }
    }
}
