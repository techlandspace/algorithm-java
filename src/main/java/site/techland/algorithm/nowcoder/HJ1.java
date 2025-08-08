package site.techland.algorithm.nowcoder;

import java.util.Scanner;

/**
 * @author techland
 * @description 计算字符串最后一个单词的长度，单词以空格隔开。
 * @date 2025/05/09
 */
public class HJ1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nextLine = sc.nextLine();
        String[] split = nextLine.split(" ");
        System.out.println(split[split.length - 1].length());
    }
}
