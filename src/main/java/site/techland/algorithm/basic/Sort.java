package site.techland.algorithm.basic;

import java.util.Arrays;

/**
 * @author liquanfeng
 * @date 2025/9/9
 * @description
 */
public class Sort {
    public static void main(String[] args) {
        int[] nums = {2, 5, 34, 23, 46, 22, 65, 35};
        //bubbleSort(nums);
        //selectionSort(nums);
        insertionSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 冒泡排序，每一个都与前一个比较 时间复杂度为O(n^2)
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

    /**
     * 选择排序, 与冒泡排序一样进行交换，因此时间复杂度一样O(n^2)，但是交换次数更少
     * @param arr
     */
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int max = arr[0], index = 0, last = arr.length - i - 1;
            for (int j = 1; j <= last; j++) {
                if (arr[j] > max) {
                    max = arr[j];
                    index = j;
                }
            }
            arr[index] = arr[last];
            arr[last] = max;
        }
    }

    /**
     * 插入排序，时间复杂度为O(n^2),最好情况下每轮只需要比较一次
     * @param arr
     */
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int currVal = arr[i], index = i;
            while (index == 0 || currVal < arr[index - 1]) {
                arr[index] = arr[index - 1];
                index--;
            }
            arr[index] = currVal;
        }
    }
}
