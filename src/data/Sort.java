package data;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int[] arr = {1, 6, 8, 7, 3, 5, 16, 4, 11, 36, 13, 44};
        System.out.println(Arrays.toString(arr));
        System.out.println("---------------------------");
        BubbleSort(arr);
    }

    /**
     * 冒泡排序
     */
    private static void BubbleSort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - 1 - i; j++) {
                if (arr[j] > arr[j+1]) {        // 相邻元素两两对比
                    int temp = arr[j+1];        // 元素交换
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 快速排序
     */
    private static void QSort(int[] a, int start, int end) {
        if (a.length < 0) {
            return;
        }
        if (start >= end) {
            return;
        }
        int left = start;
        int right = end;
        int temp = a[left];
        while (left < right) {
            while (left < right && a[right] >= temp) {
                right--;
            }
            a[left] = a[right];
            while (left < right && a[left] <= temp) {
                left++;
            }
            a[right] = a[left];
        }
        a[left] = temp;
        System.out.println(Arrays.toString(a));
        QSort(a, start, left - 1);
        QSort(a, left + 1, end);
    }
}
