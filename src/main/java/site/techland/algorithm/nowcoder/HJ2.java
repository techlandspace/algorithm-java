package site.techland.algorithm.nowcoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HJ2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chars1 = br.readLine().toLowerCase().toCharArray();
        char[] chars2 = br.readLine().toLowerCase().toCharArray();
        int count = 0;
        for (int i = 0; i < chars1.length; i++) {
            if  (chars1[i] == chars2[0]) {
                count++;
            }
        }
        System.out.println(count);
    }
}
