package com.java.datastructures.leetcode;

public class LongestPalindromicSubsequenceP516 {
        public static int longestPalindromeSubseq(String x) {

            int[][] t = new int[1001][1001]; // as per constraint.

            for (int i = 0; i < t.length; i++) {
                for (int j = 0; j < t[0].length; j++) {
                    t[i][j] = -1;
                }
            }

            StringBuilder input1 = new StringBuilder();

            // append a string into StringBuilder input1
            input1.append(x);

            // reverse StringBuilder input1
            String y = String.valueOf(input1.reverse());

            int n = x.length();
            int m = y.length();
            char[] xArray = x.toCharArray();
            char[] yArray = y.toCharArray();
            int lcsLength = lcsMemoization(xArray, yArray, n, m, t);
            return lcsLength;

        }

        // using recursion Memoization
        private static int lcsMemoization(char[] x, char[] y, int n, int m, int[][] t) {

            // base condition
            if (n == 0 || m == 0) {
                return 0;
            }

            if (t[n][m] != -1) {
                return t[n][m];
            }

            // if last characters match
            if (x[n - 1] == y[m - 1]) {
                return t[n][m] = 1 + lcsMemoization(x, y, n - 1, m - 1, t);
            } else {
                return t[n][m] = Math.max(lcsMemoization(x, y, n, m - 1, t), lcsMemoization(x, y, n - 1, m, t));
            }
        }

}
