package com.java.datastrudtures.leetcode;

import java.util.Stack;

/**
 * Given a string s, remove duplicate letters so that every letter appears once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "bcabc"
 * Output: "abc"
 *
 * Example 2:
 *
 * Input: s = "cbacdcbc"
 * Output: "acdb"
 */
public class RemoveDuplicateLettersP316 {

    public static void main(String[] args) {
        String s = "bcabc";
        System.out.println("input : " + s);
        System.out.print("output : ");
        System.out.println(removeDuplicateLetters(s));
    }

    public static String removeDuplicateLetters(String s) {
        Stack<Character> st = new Stack();
        int freq[] = new int[26];
        boolean exist[] = new boolean[26];

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            freq[ch - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            freq[ch - 'a']--;
            if (exist[ch - 'a']) continue;
            while (st.size() > 0 && st.peek() > ch && freq[st.peek() - 'a'] > 0) {
                char rem = st.pop();
                exist[rem - 'a'] = false;
            }
            st.push(ch);
            exist[ch - 'a'] = true;
        }
        char ans[] = new char[st.size()];
        int i = ans.length - 1;
        while (i >= 0) ans[i--] = st.pop();
        return new String(ans);
    }
}
