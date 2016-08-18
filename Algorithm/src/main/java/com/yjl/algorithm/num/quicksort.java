package com.yjl.algorithm.num;

/**
 * Created by YangJunLin on 2016/8/17.
 */
public class quicksort {
    public static void main(String[] args) {
        int[] array = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0, -1, -2, -3};

        System.out.println("Before sort:");
        printArray(array);

        quickSort(array);

        System.out.println("After sort:");
        printArray(array);
    }

    public static void quickSort(int[] array) {
        subQuickSort(array, 0, array.length - 1);
    }

    private static void subQuickSort(int[] array, int start, int end) {
        if (array == null || (end - start + 1) < 2) {
            return;
        }

        int part = partition(array, start, end);

        if (part == start) {
            subQuickSort(array, part + 1, end);
        } else if (part == end) {
            subQuickSort(array, start, part - 1);
        } else {
            subQuickSort(array, start, part - 1);
            subQuickSort(array, part + 1, end);
        }
    }

    private static int partition(int[] array, int start, int end) {
        int value = array[end];
        int index = start - 1;

        for (int i = start; i < end; i++) {
            if (array[i] < value) {
                index++;
                if (index != i) {
                    exchangeElements(array, index, i);
                }
            }
        }

        if ((index + 1) != end) {
            exchangeElements(array, index + 1, end);
        }

        return index + 1;
    }

    public static void printArray(int[] array) {
        System.out.print("{");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("}");
    }

    public static void exchangeElements(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
