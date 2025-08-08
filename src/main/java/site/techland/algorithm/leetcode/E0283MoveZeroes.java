package site.techland.algorithm.leetcode;

import java.util.Arrays;

public class E0283MoveZeroes {
    
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeroes(int[] nums) {
        int zeroes = 0; // 记录0的个数
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) { // 如果当前元素是0，zeroes加1
                zeroes++;
            } else if (zeroes > 0) { // 如果当前元素不是0，并且zeroes大于0，将当前元素向前移动zeroes个位置
                nums[i - zeroes] = nums[i]; // 向前移动zeroes个位置，将当前元素覆盖掉前面的0
                nums[i] = 0; // 将当前元素设为0，即向前移动了zeroes个位置，原来的位置被0覆盖掉了
            }
        }
    }
}
