package site.techland.algorithm.leetcode;

/**
 * @author liquanfeng
 * @date 2025/8/1
 * @description
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * 问总共有多少条不同的路径？
 */
public class M0062 {


    public static void main(String[] args) {
        //解析 向下和向右一共需要移动 m + n - 2步，随机挑选任意步数向右移动n-1步，因此结果为 C(m+n-2, n-1) = (m+n-2)! / ((m-1)! * (n-1)!)
        int i = uniquePaths(3, 7);
    }

    public static int uniquePaths(int m, int n) {
        int r = 1;
        for (int i = m, j = 1; j < n; i++, j++) {
            System.out.println("r=" + r + " i=" + i + " j=" + j);
            r = r * i / j;
        }
        return r;
    }
}
