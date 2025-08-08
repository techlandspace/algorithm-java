package site.techland.algorithm.leetcode;

/**
 * @author techland
 * @description Given two sorted arrays nums1 and nums2 of size m and n
 *              respectively, return the median of the two sorted arrays.
 * @date 2025/05/27
 */
public class H0004MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {};
        int[] nums2 = {1};
        double result = findMedianSortedArrays(nums1, nums2);
        System.out.println(result); // 2.00000
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int index1 = 0;
        int index2 = 0;
        int[] mergedArray = new int[nums1.length + nums2.length];
        int i = 0;
        boolean f1 = false;
        boolean f2 = false;
        if (nums1.length == 0 && nums2.length == 0) {
            return 0.0;
        } else if (nums1.length == 0){
            mergedArray = nums2;
        } else if (nums2.length == 0) {
            mergedArray = nums1;
        } else {
            while (i <= mergedArray.length / 2) {
                if (nums1[index1] <= nums2[index2] && !f1) {
                    mergedArray[i] = nums1[index1];
                    index1++;
                    if (index1 == nums1.length) {
                        f1 = true;
                        index1--;
                    }
                } else if (!f2) {
                    mergedArray[i] = nums2[index2];
                    index2++;
                    if (index2 == nums2.length) {
                        f2 = true;
                        index2--;
                    }
                }
                i++;
            }
        }
        
        if (mergedArray.length % 2 == 0) {
            return (mergedArray[mergedArray.length / 2] + mergedArray[mergedArray.length / 2 - 1]) / 2.0;
        } else {
            return mergedArray[mergedArray.length / 2];
        }
    }
}
