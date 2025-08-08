package site.techland.algorithm.leetcode;

import java.util.Arrays;

/**
 * @author liquanfeng
 * @date 2025/8/6
 * @description 轮转数组
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右轮转 1 步: [7,1,2,3,4,5,6]
 * 向右轮转 2 步: [6,7,1,2,3,4,5]
 * 向右轮转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 *
 * 输入：nums = [-1,-100,3,99], k = 2
 * 输出：[3,99,-1,-100]
 * 解释:
 * 向右轮转 1 步: [99,-1,-100,3]
 * 向右轮转 2 步: [3,99,-1,-100]
 */
public class M0189Rotate {
    public static void main(String[] args) {
        int[] nums = {
            1,2,3,4,5,6,7
        };
        rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }

    public static void rotate(int[] nums, int k) {
        int[] tmp = nums.clone();
        k = k % nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                nums[i] = tmp[nums.length + i - k];
            } else {
                nums[i] = tmp[i-k];
            }
        }
    }

    public static void rotate2(int[] nums, int k) {
        //TODO 思考空间复杂度为O(1)的解法
    }

}
