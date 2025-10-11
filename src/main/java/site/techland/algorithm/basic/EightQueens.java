package site.techland.algorithm.basic;

import java.util.Arrays;

public class EightQueens {
    private int[] queens; // 皇后位置数组，queens[i]表示第i行皇后所在的列
    private int count;    // 解法计数器
    private static final int BOARD_SIZE = 8; // 棋盘大小

    public EightQueens() {
        queens = new int[BOARD_SIZE];
        count = 0;
    }

    /**
     * 解决八皇后问题的主方法
     */
    public void solve() {
        placeQueen(0); // 从第0行开始放置皇后
        System.out.println("总共找到 " + count + " 种解法");
    }

    /**
     * 递归放置皇后
     * @param row 当前要放置皇后的行
     */
    private void placeQueen(int row) {
        // 如果已经成功放置了8个皇后，找到一个解
        if (row == BOARD_SIZE) {
            count++;
            printSolution();
            return;
        }

        // 尝试在当前行的每一列放置皇后
        for (int col = 0; col < BOARD_SIZE; col++) {
            if (isSafe(row, col)) {
                queens[row] = col;  // 在当前行的col列放置皇后
                placeQueen(row + 1); // 递归放置下一行的皇后
                // 回溯：不需要显式撤销，因为queens[row]会被覆盖
            }
        }
    }

    /**
     * 检查在(row, col)位置放置皇后是否安全
     * @param row 行
     * @param col 列
     * @return 是否安全
     */
    private boolean isSafe(int row, int col) {
        // 检查与之前放置的所有皇后是否冲突
        for (int i = 0; i < row; i++) {
            // 检查同一列
            if (queens[i] == col) {
                return false;
            }
            // 检查对角线：行差 == 列差
            if (Math.abs(queens[i] - col) == Math.abs(i - row)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 打印当前解法
     */
    private void printSolution() {
        System.out.println("解法 " + count + ":");

//        for (int row = 0; row < BOARD_SIZE; row++) {
//            for (int col = 0; col < BOARD_SIZE; col++) {
//                if (queens[row] == col) {
//                    System.out.print("Q ");
//                } else {
//                    System.out.print(". ");
//                }
//            }
//            System.out.println();
//        }
        System.out.println(Arrays.toString(queens));
        System.out.println();
    }

    /**
     * 只打印一种解法（用于演示）
     */
    public void findOneSolution() {
        if (placeFirstSolution(0)) {
            System.out.println("找到一种解法:");
            printSolution();
        } else {
            System.out.println("无解");
        }
    }

    /**
     * 只寻找第一种解法
     */
    private boolean placeFirstSolution(int row) {
        if (row == BOARD_SIZE) {
            count = 1;
            return true;
        }

        for (int col = 0; col < BOARD_SIZE; col++) {
            if (isSafe(row, col)) {
                queens[row] = col;
                if (placeFirstSolution(row + 1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        EightQueens solver = new EightQueens();

        System.out.println("=== 八皇后问题求解 ===");
//        System.out.println("1. 只找一种解法:");
//        solver.findOneSolution();

        //System.out.println("2. 找所有解法:");
        solver.solve();
    }
}
