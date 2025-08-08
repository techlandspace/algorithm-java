package site.techland.algorithm.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author liquanfeng
 * @date 2025/8/7
 * @description
 */
public class M0073SetZeros {
    public static void main(String[] args) {
        int[][] matrix =  {
                {1,1,1},{1,0,1},{1,1,1}
        };
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println();
        System.out.println();
        setZeroes(matrix);
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public static void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    s1.add(i);
                    s2.add(j);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (s1.contains(i) || s2.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
