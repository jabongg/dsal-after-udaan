package com.java.datastrudtures.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *Given a list of strings words and a string pattern, return a list of words[i] that match pattern. You may return the answer in any order.
 *
 * A word matches the pattern if there exists a permutation of letters p so that after replacing every letter x in the pattern with p(x), we get the desired word.
 *
 * Recall that a permutation of letters is a bijection from letters to letters: every letter maps to another letter, and no two letters map to the same letter.
 *
 *
 *
 * Example 1:
 *
 * Input: words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
 * Output: ["mee","aqq"]
 * Explanation: "mee" matches the pattern because there is a permutation {a -> m, b -> e, ...}.
 * "ccc" does not match the pattern because {a -> c, b -> c, ...} is not a permutation, since a and b map to the same letter.
 *
 */
public class FindAndReplacePatternP890 {
    public static List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> matchingWords = new ArrayList<>();
        for (String word : words) {
            if (isIsomorphic(word, pattern)) {
                matchingWords.add(word);
            }
        }

        return matchingWords;

    }


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
        String[] words = {"abc","deq","mee","aqq","dkd","ccc"};
        String pattern = "abb";
        List<String> result = findAndReplacePatternn(words, pattern);
        System.out.println(result);
    }


    public static List<String> findAndReplacePatternn(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        for (String word : words) {
            if (check(word, pattern)) res.add(word);
        }
        return res;
    }

    static boolean check(String a, String b) {
        for (int i = 0; i < a.length(); i++) {
            if (a.indexOf(a.charAt(i)) != b.indexOf(b.charAt(i))) return false;
        }
        return true;
    }
}