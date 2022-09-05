package com.java.datastructures.leetcode;

import java.util.*;

public class WordSubsetsP916 {
    public static void main(String[] args) {
        String[] words1 = {"amazon", "apple", "facebook", "google", "leetcode"}, words2 = {"lo", "eo"};
        System.out.println(wordSubsets(words1, words2));
    }

    public static List<String> wordSubsets(String[] A, String[] B) {
        int[] count = new int[26], tmp;
        int i;
        for (String b : B) {
            tmp = counter(b);
            for (i = 0; i < 26; ++i)
                count[i] = Math.max(count[i], tmp[i]);
        }
        List<String> res = new ArrayList<>();
        for (String a : A) {
            tmp = counter(a);
            for (i = 0; i < 26; ++i)
                if (tmp[i] < count[i])
                    break;
            if (i == 26) res.add(a);
        }
        return res;
    }

    public static int[] counter(String word) {
        int[] count = new int[26];
        for (char c : word.toCharArray()) count[c - 'a']++;
        return count;
    }

}
