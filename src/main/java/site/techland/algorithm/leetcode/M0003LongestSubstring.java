package site.techland.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author techland
 * @description Given a string s, find the length of the longest substring without duplicate characters.
 * @date 2025/05/27
 */
public class M0003LongestSubstring {

    public static void main(String[] args) {
        String s = "abcabcbb";
        int result = lengthOfLongestSubstring(s);
        System.out.println(result); // 3
    }

    public static int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        int left = 0;
        Map<Character, Integer> charMap = new HashMap<>();
        
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            if (charMap.containsKey(currentChar) && charMap.get(currentChar) >= left) {
                left = charMap.get(currentChar) + 1;
            }
            charMap.put(currentChar, right);
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
