package site.techland.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class M0438FindAnagrams {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        //System.out.println(s.substring(0, 2)); // cba
        System.out.println(findAnagrams(s, p)); // [0, 6]
    }
    
    public static List<Integer> findAnagrams(String s, String p) {
        int left = 0;
        List<Integer> result = new ArrayList<>();
        int[] pCount = new int[26];
        int[] sCount = new int[26];

        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }

        for (int right = 0; right < s.length(); right++) {
            sCount[s.charAt(right) - 'a']++;
            if(sCount[s.charAt(right) -'a'] > pCount[s.charAt(right) - 'a']) {
                while(sCount[s.charAt(right) -'a'] > pCount[s.charAt(right) - 'a']) {
                    sCount[s.charAt(left) - 'a']--;
                    left++;
                }
            }
            if (Arrays.equals(pCount, sCount)) {
                result.add(left);
            }
        }
        return result;
    }
}
