package com.java.datastrudtures.array;

/*
to find minimum partitioning such that all the partition is palindrome in itself.
 */
public class PalindromePartitioning {
    private static int[][] t = new int[1001][1001];

    public static void main(String[] args) {
        String s = "nitin";

        System.out.println(findMinimumPartioning(s));
    }

    //MCM based
    private static int findMinimumPartioning(String s) {
        char[] str = s.toCharArray();

        int i = 0;
        int k = 0; // value still to find out
        int j = str.length - 1;

        return solveMemo(str, i, j);
    }

    private static int solve(char[] str, int i, int j) {
        if (i >= j) {
            return 0;
        }

        if (isPalindrome(str, i, j)) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int temp = solve(str, i, k) + solve(str, k + 1, j) + 1;
            min = Math.min(temp, min);
        }
        return min;
    }

    //MCM based
    private static int findMinimumPartioningMemoized(String s) {
        char[] str = s.toCharArray();

        int i = 0;
        int k = 0; // value still to find out
        int j = str.length - 1;

        return solve(str, i, j);
    }

    private static int solveMemo(char[] str, int i, int j) {

        for (int p = 0; p < str.length; p++) {
            for (int q = 0; q < str.length; q++) {
                t[p][q] = -1;
            }
        }

        if (i >= j) {
            return 0;
        }

        if (isPalindrome(str, i, j)) {
            return 0;
        }

        if (t[i][j] != -1) {
            return t[i][j];
        }
        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int temp = solveMemo(str, i, k) + solveMemo(str, k + 1, j) + 1;
            min = Math.min(temp, min);
        }
        return t[i][j] = min;
    }


    public static boolean isPalindrome(char[] str, int startIdx, int endIdx) {
        while (startIdx <= endIdx) {
            if (str[startIdx] != str[endIdx]) {
                return false;
            }
            startIdx++;
            endIdx--;
        }

        return true;
    }
}
