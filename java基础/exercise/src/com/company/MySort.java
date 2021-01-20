package com.company;

import java.util.Arrays;

public class MySort {
    public static void main(String[] args) {
        int[] arr = {10, 564, 21, 96, 55, 3, 5, 5456, 55, 24, 10, 53};
        MySort mySort = new MySort();
//        mySort.buppleSort(arr);
        arr=mySort.insertSort(arr);
        System.out.print(Arrays.toString(arr));

    }

    public void buppleSort(int[] array) {
        int len = array.length;
        if (len <= 1) {
            return;
        }
        for (int i = 0; i < len; i++) {
            boolean swapped = false;

            for (int j = i + 1; j < len; j++) {
                if (array[i] > array[j]) {
//                    swap(array[i],array[j]);
                    int t = array[i];
                    array[i] = array[j];
                    array[j] = t;
                    swapped = true;
                }
                // 如果没有发生交换，则排序完成；如果发生交换，则排序继续
            }
            if (!swapped) {
                break;
            }
        }
    }

    public int[] insertSort(int[] array) {
        int len = array.length;
        if (len <= 1) {
            return array;
        }
        for (int i = 1; i < len; i++) {
            int temp = array[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (array[j] > temp) {
                    array[j + 1] = array[j];
                } else {
                    break;// 找到插入位置
                }
            }
            array[j + 1] = temp;//插入
        }
        return array;
    }
}
