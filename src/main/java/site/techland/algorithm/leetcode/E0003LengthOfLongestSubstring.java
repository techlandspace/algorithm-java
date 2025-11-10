package site.techland.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

public class E0003LengthOfLongestSubstring {
    public static void main(String[] args) {
        int i = lengthOfLongestSubstring("tmmzuxt");
        System.out.println(i);
    }

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        int left = 0;
        for(int i = 0; i < s.length(); i++){
            if (map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) >= left) {
                left = map.get(s.charAt(i)) + 1;
            } else {
                maxLen = Math.max(i - left +1, maxLen);
            }
            map.put(s.charAt(i), i);
        }
        return maxLen;
    }
}
