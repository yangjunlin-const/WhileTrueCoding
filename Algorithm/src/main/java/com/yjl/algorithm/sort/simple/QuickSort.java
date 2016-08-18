package com.yjl.algorithm.sort.simple;

import java.util.Random;

/**
 * Created by YangJunLin on 2016/8/18.
 */
public class QuickSort {

    private static int[] array;

    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            array = null;
            array = new int[1000];
            for (int j = 0; j < 1000; j++) {
                array[j] = random.nextInt();
            }
            quickSort(0, array.length - 1);
            if (!checkResult()) {
                System.out.println("wrong!");
                display();
            }else {
                System.out.println("yes");
            }
        }
    }

    private static boolean checkResult() {
        if (array.length == 1) {
            return true;
        } else {
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void display() {
        for (int key : array) {
            System.out.print(key + " ");
        }
        System.out.println();
    }

    private static void quickSort(int start, int end) {
        if (start < end) {
            int flag = partition(start, end);
            quickSort(start, flag - 1);
            quickSort(flag + 1, end);
        }
    }

    private static int partition(int start, int end) {
        int flag = start + new Random().nextInt(end - start);
        exchangeElement(start, flag);
        int key = array[start];
        while (start < end) {
            while (array[end] >= key && start < end) {
                end--;
            }
            if (start < end) {
                array[start] = array[end];
                start++;
            }
            while (array[start] <= key && start < end) {
                start++;
            }
            if (start < end) {
                array[end] = array[start];
                end--;
            }
        }
        array[start] = key;
//        display();
        return start;
    }

    private static void exchangeElement(int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
