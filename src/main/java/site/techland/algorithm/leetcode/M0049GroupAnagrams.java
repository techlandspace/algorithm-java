package site.techland.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author techland
 * @description Given an array of strings strs, group the anagrams together. You can return the answer in any order. An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 * @date 2025/05/19
 */
public class M0049GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = {"bdddddddddd", "bbbbbbbbbbc"};
        System.out.println(groupAnagrams(strs)); // [["bat"],["nat","tan"],["ate","eat","tea"]]
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        return new ArrayList<>(
                Arrays.stream(strs)
                        .collect(Collectors.groupingBy(s -> {
                            char[] sortedS = s.toCharArray();
                            Arrays.sort(sortedS);
                            return new String(sortedS);
                        }))
                        .values()
        );
    }

    public static List<List<String>> groupAnagrams2(String[] strs) {
        return new ArrayList<>(Arrays.stream(strs)
                .collect(Collectors.groupingBy(str -> {
                    int[] counter = new int[26];
                    for (int i = 0; i < str.length(); i++) {
                        counter[str.charAt(i) - 'a']++;
                    }
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < 26; i++) {
                        // 这里的 if 是可省略的，但是加上 if 以后，生成的 sb 更短，后续 groupingBy 会更快。
                        if (counter[i] != 0) {
                            sb.append((char) ('a' + i));
                            sb.append(counter[i]);
                        }
                    }
                    return sb.toString();
                })).values());
    }
}
