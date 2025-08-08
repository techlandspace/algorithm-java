package site.techland.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author techland
 * @description Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k. A subarray is a contiguous non-empty sequence of elements within an array.
 * @date 2025/05/28 15:30:45 by techland using IntelliJ IDEA.
 */
public class M0560SubarraySum {
    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1,1,1}, 2));
    }

    //直接给出最优解
    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0, sum = 0;
        for (int num : nums) {
            sum += num; // 累加前缀和
            count += map.getOrDefault(sum - k, 0); // 如果存在前缀和为 sum - k 的子数组，则加上其出现次数
            map.put(sum, map.getOrDefault(sum, 0) + 1); // 更新前缀和出现次数
        }
        return count;
    }
}
