package com.java.datastructures.leetcode;

public class LongestCommonSubsequenceP1143 {


    public int longestCommonSubsequence(String x, String y) {

        int[][] t = new int[1001][1001]; // as per constraint.

        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[0].length; j++) {
                t[i][j] = -1;
            }
        }

        int n = x.length();
        int m = y.length();
        char[] xArray = x.toCharArray();
        char[] yArray = y.toCharArray();
        return lcsMemoization(xArray, yArray, n, m, t);
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
            return t[n][m] = Math.max(lcsMemoization(x, y, n - 1, m, t), lcsMemoization(x, y, n, m - 1, t));
        }
    }

    // using Tabulation
    public static int longestCommonSubsequenceTabulation(String X, String Y) {
        int m = X.length();
        int n = Y.length();
        char[] text1 = X.toCharArray();
        char[] text2 = Y.toCharArray();

        // intialize a dp array
        int[][] L = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {

                //base condition
                if (i == 0 || j == 0) {
                    L[i][j] = 0;
                }

                // if last charecters match
                else if (text1[i - 1] == text2[j - 1]) {
                    L[i][j] = L[i - 1][j - 1] + 1;
                }
                // if last characters didn't match
                else {
                    L[i][j] = Math.max(L[i][j - 1], L[i - 1][j]);
                }
            }
        }

        // before returning the length, lets print the lcs.
        printLCS(L, text1, text2, m, n);

        return L[m][n];
    }

    public static void printLCS(int[][] L, char[] X, char[] Y, int m, int n) {
        // Following code is used to print LCS
        int index = L[m][n];
        int temp = index;

        // Create a character array to store the lcs string
        char[] lcs = new char[index + 1];
        lcs[index]
                = '\u0000'; // Set the terminating character


        int i = m;
        int j = n;

        while (i > 0 && j > 0) {
            if (X[i - 1] == Y[j - 1]) {
                lcs[index - 1] = X[i - 1]; // put the character which is common. it can be Y[i - 1] also, both are same character.
                i--;
                j--;
                index--;

            }
            // If not same, then find the larger of two and
            // go in the direction of larger value
            else if (L[i - 1][j] > L[i][j - 1])
                i--;
            else
                j--;
        }

        // Print the lcs
        printLCSCharacters(X, Y, temp, lcs);

    }

    private static void printLCSCharacters(char[] X, char[] Y, int temp, char[] lcs) {
        System.out.print("LCS of " + X + " and " + Y
                + " is ");
        for (int k = 0; k <= temp -1; k++) // since it will print '\u0000' charecter also, so doing temp - 1;
            System.out.print(lcs[k]);
    }

    private static void printArray(char[] lcs) {
        for (char ch: lcs) {
            System.out.println(ch);
        }
    }

    public static void main(String[] args) {
        String X = "AGGTAB";
        String Y = "GXTXAYB";
        int m = X.length();
        int n = Y.length();
        System.out.println();
        System.out.println(longestCommonSubsequenceTabulation(X, Y));
    }
}
