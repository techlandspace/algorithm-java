package site.techland.algorithm.basic;

import java.util.Arrays;

/**
 * @author liquanfeng
 * @date 2025/9/9
 * @description
 */
public class Sort {
    public static void main(String[] args) {
        int[] nums = {2, 5, 34, 23, 46, 22, 23, 65, 35, 490, 458, 2345, 2345, 22838, 398, 4536, 432};
        //bubbleSort(nums);
        //selectionSort(nums);
        //insertionSort(nums);
        //nums = mergeSort(nums);
        //quickSort(nums);
        //nums = countingSort(nums);
        radixSort(nums);
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
     * 稳定性：稳定
     * 时间复杂度：最佳：O(n) ，最差：O(n^2)， 平均：O(n2)
     * 空间复杂度：O(1)
     * 排序方式：In-place
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

    /**
     * 希尔排序：插排的优化
     * 稳定性：不稳定
     * 时间复杂度：最佳：O(nlogn)， 最差：O(n^2) 平均：O(nlogn)
     * 空间复杂度：O(1)
     * @param arr
     */
    public static void shellSort(int[] arr) {
        int length = arr.length;
        int temp;
        for (int step = length / 2; step >= 1; step /= 2) {
            for (int i = step; i < length; i++) {
                temp = arr[i];
                int j = i - step;
                while (j >= 0 && arr[j] > temp) {
                    arr[j + step] = arr[j];
                    j -= step;
                }
                arr[j + step] = temp;
            }
        }
    }

    /**
     * 归并排序：先让每个子序列有序，再使得子序列整体有序
     * 稳定性：稳定
     * 时间复杂度：最佳：O(nlogn)， 最差：O(nlogn)， 平均：O(nlogn)
     * 空间复杂度：O(n)
     * @param arr
     */
    public static int[] mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }
        int middle = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, middle);
        int[] right = Arrays.copyOfRange(arr, middle, arr.length);
        return merge(mergeSort(left), mergeSort(right));
    }

    private static int[] merge(int[] left, int[] right) {
        int[] arr = new int[left.length + right.length];
        int idx = 0, idxLeft = 0, idxRight = 0;
        while (idxLeft < left.length && idxRight < right.length) {
            if (left[idxLeft] <= right[idxRight]) {
                arr[idx++] = left[idxLeft++];
            }  else {
                arr[idx++] = right[idxRight++];
            }
        }
        while (idxLeft < left.length) {
            arr[idx++] = left[idxLeft++];
        }
        while (idxRight < right.length) {
            arr[idx++] = right[idxRight++];
        }
        return arr;
    }

    /**
     * 快速排序：通过一趟排序将待排序序列分割成独立的两部分，其中一部分记录的元素均比另一部分元素小，则可分别对这两部分子序列继续进行排序，以达到整个序列有序
     * 稳定性：不稳定
     * 时间复杂度：最佳：O(nlogn)， 最差：O(n^2)，平均：O(nlogn)
     * 空间复杂度：O(logn)
     * @param arr
     */
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int pivot = partition(arr, low, high);
        quickSort(arr, low, pivot - 1);
        quickSort(arr, pivot + 1, high);
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; //选取最后一个元素作为基准
        int i = low - 1; // 较小元素的索引
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    /**
     * 计数排序：计数排序使用一个额外的数组 C，其中第 i 个元素是待排序数组 A 中值等于 i 的元素的个数。然后根据数组 C 来将 A 中的元素排到正确的位置。它只能对整数进行排序
     * 稳定性：稳定
     * 时间复杂度：最佳：O(n+k) 最差：O(n+k) 平均：O(n+k)
     * 空间复杂度：O(k)
     * 缺点： 只适用于小范围整数排序，如果数据最大最小差值比较大，那么需要大量额外内存空间
     * @param arr
     */
    public static int[] countingSort(int[] arr) {
        if (arr == null || arr.length <= 1) return arr;
        int maxValue = arr[0];
        int minValue = arr[0];
        //步骤1： 获取数组的最小值和最大值
        for (int i : arr) {
            if (i > maxValue) {
                maxValue = i;
            } else if (i < minValue) {
                minValue = i;
            }
        }
        //步骤2： 创建计数数组，大小为数值范围
        int[] countArr = new int[maxValue - minValue + 1];
        int[] result = new int[arr.length];
        //步骤3：统计每个元素出现的次数
        for (int num : arr) {
            countArr[num - minValue]++;
        }
        // 步骤4：将计数数组转换为前缀和数组，统计当前数字结束的位置
        for (int i = 1; i < countArr.length; i++) {
            countArr[i] += countArr[i - 1];
        }
        // 步骤5：从后往前遍历原数组，将元素放到结果数组的正确位置
        for (int i = arr.length - 1; i >= 0; i--) {
            int idx = countArr[arr[i] - minValue] - 1; //计算最后一个元素在结果中的位置
            result[idx] = arr[i];
            countArr[arr[i] - minValue]--; //减少一个为了避免数组中有重复数字的时候，计算出来的位置相同。
        }
        return result;
    }

    /**
     * 基数排序：按照低位排序，然后收集；再按照高位排序，然后再收集，依此类推，直到最高位。
     * 稳定性：稳定
     * 时间复杂度：最佳：O(n×k) 最差：O(n×k) 平均：O(n×k)
     * 空间复杂度：O(n+k)
     * @param arr
     * @return
     * todo 支持负数排序
     */
    public static void radixSort(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        // 找到最大值，确定最大位数
        int max = Arrays.stream(arr).max().getAsInt();
        int exp = 1; // 当前位（1 -> 个位，10 -> 十位，100 -> 百位）

        // 临时数组保存每轮排序结果
        int[] output = new int[arr.length];

        // 按位排序，从个位 -> 十位 -> 百位 ...
        while (max / exp > 0) {
            int[] count = new int[10]; // 0-9 十个桶

            // 统计每个桶中元素个数
            for (int num : arr) {
                int digit = (num / exp) % 10;
                count[digit]++;
            }

            // 累加前缀和，确定每个桶的边界
            for (int i = 1; i < 10; i++) {
                count[i] += count[i - 1];
            }

            // 倒序遍历，保证稳定排序（相同数字保持原顺序）
            for (int i = arr.length - 1; i >= 0; i--) {
                int digit = (arr[i] / exp) % 10;
                output[count[digit] - 1] = arr[i];
                count[digit]--;
            }
            // 将结果拷贝回原数组
            System.arraycopy(output, 0, arr, 0, arr.length);
            // 下一位
            exp *= 10;
        }
    }
}
