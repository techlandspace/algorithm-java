package site.techland.algorithm.leetcode;

import java.util.Arrays;

/**
 * @author techland
 * @description Given an array of strings strs, group the anagrams together. You can return the answer in any order. An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 * @date 2025/05/19
 */
public class M0128LongestConsecutive {
    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{9,1,4,7,3,-1,0,5,8,-1,6}));
    }

    public static int longestConsecutive(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        Arrays.sort(nums);
        int max = 0;
        int maxL = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] + 1== nums[i+1]) {
                maxL++;
            } else if (nums[i] == nums[i+1]){
                continue;
            } else {
                if (max < maxL) {
                    max = maxL;
                }
                maxL = 0;
            }
        }
        if (max < maxL) {
            max = maxL;
        }
        return max;
    }
}
