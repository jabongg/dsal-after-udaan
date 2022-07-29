package com.java.datastrudtures.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IsomorphicStringsP205 {
    private static boolean isIsomorphic(String word, String pattern) {
        Map<Character, Character> wMap = new HashMap<>(), pMap = new HashMap();
        for (int i = 0; i < word.length(); i++) {
            char a = word.charAt(i);
            char b = pattern.charAt(i);

            if (wMap.containsKey(a) && wMap.get(a) != b
                    || pMap.containsKey(b) && pMap.get(b) != a) {
                return false;
            }
            wMap.put(a, b);
            pMap.put(b, a);
        }
        return true;
    }

    public static void main(String[] args) {
        String words = "c";
        String pattern = "a";
        System.out.println(isIsomorphic(words, pattern));
    }
}
