package com.java.interview.ola;

import java.util.HashSet;
import java.util.Set;

public class PrintAllPalindromicSubstring {
    static Set<String> palindromicSet = new HashSet<>();
    public static void main(String[] args) {
        String str = "nitin";

        printPalindromicSubstring(str);
        palindromicSet.forEach(£ -> System.out.print(£ + " ")); //option + 3 mac
    }

    private static void printPalindromicSubstring(String str) {
        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length(); j++) {
                String sub = str.substring(i, j + 1);
                if (isPalindrome(sub)) {
                    palindromicSet.add(sub); // to avoid duplicates
                }
            }
        }
    }

    private static boolean isPalindrome(String sub) {

        int i = 0;
        int j = sub.length() - 1;

        while (i < j) {
            if (sub.charAt(i) != sub.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
