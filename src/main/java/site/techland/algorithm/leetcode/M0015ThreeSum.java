package site.techland.algorithm.leetcode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * 15. 三数之和
 * 
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * 
 * 示例：
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 满足要求的三元组集合为： [ [-1, 0, 1], [-1, -1, 2] ]
 * 
 * @author techland
 * @date 2025/05/22
 *
 */
public class M0015ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums)); // [[-1, -1, 2], [-1, 0, 1]]
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // 排序
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) { // 去重
                continue;
            }
            int left = i + 1; // 左指针
            int right = nums.length - 1; // 右指针
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right]; // 计算三数之和
                if (sum == 0) { // 找到三元组
                    result.add(Arrays.asList(nums[i], nums[left], nums[right])); // 添加到结果列表中
                    while (left < right && nums[left] == nums[left + 1]) { // 去重
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) { // 去重
                        right--;
                    }
                    left++; // 移动左指针
                    right--; // 移动右指针
                } else if (sum < 0) { // 三数之和小于0，左指针右移
                    left++;
                } else { // 三数之和大于0，右指针左移
                    right--;
                }
            }
        }
        return result;
    }
}