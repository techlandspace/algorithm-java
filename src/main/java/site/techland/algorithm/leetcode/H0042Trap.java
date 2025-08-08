package site.techland.algorithm.leetcode;

public class H0042Trap {
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height)); // 6
    }

    //1.暴力法，双层for循环
    public static int trap(int[] height) {
        int count = 0;
        for (int i = 0; i < height.length; i++) {
            if(height[i] == 0) {
                continue;
            }
            int lh = height[i];
            int rh = 0;
            int right = i + 1;
            for(int j = i + 1 ; j < height.length; j++) {
                if (height[j] >= lh) {
                    rh = height[j];
                    right = j;
                    break;
                }
                if (height[j] > rh) {
                    rh = height[j];
                    right = j;
                }
            }
            if (i == right - 1){
                continue;
            }
            int ch = Math.min(lh, rh);
            for(int j = i + 1; j < right; j++) {
                count += ch - height[j];
            }
            if (right == height.length - 1) {
                break;
            }
            i = right - 1;
        }
        return count;
    }

    //2.动态规划
    // public static int trap2(int[] height) {
        
    // }

    //3.双指针
    // public static int trap3(int[] height) {
        
    // }
}
