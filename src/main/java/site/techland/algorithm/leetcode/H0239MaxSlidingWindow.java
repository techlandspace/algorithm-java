package site.techland.algorithm.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author techland
 * @description You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.
 * @date 2025/05/29 15:30:45 by techland using IntelliJ IDEA.
 */
public class H0239MaxSlidingWindow {

    public static void main(String[] args) {
        System.out.println(maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3)); // [3,3,5,5,6,7]
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        // 1. 创建双端队列存储索引
        Deque<Integer> deque = new LinkedList<Integer>();
        
        // 2. 初始化第一个窗口 [0, k-1]
        for (int i = 0; i < k; ++i) {
            // 维护队列单调递减：移除所有小于当前值的元素
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i); // 将当前索引入队
        }

        // 3. 创建结果数组
        int[] ans = new int[n - k + 1];
        ans[0] = nums[deque.peekFirst()]; // 第一个窗口的最大值
        
        // 4. 处理后续窗口 [k, n-1]
        for (int i = k; i < n; ++i) {
            // 4.1 维护队列单调递减
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i); // 加入新元素索引
            
            // 4.2 移除超出窗口范围的元素
            while (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            
            // 4.3 记录当前窗口最大值
            ans[i - k + 1] = nums[deque.peekFirst()];
        }
        return ans;
    }
}
