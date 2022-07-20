package com.java.datastrudtures.dp;

/**
 * The Longest Increasing Subsequence (LIS) problem is to find the length of
 * the longest subsequence of a given sequence such that all elements of the subsequence are sorted in increasing order.
 * For example, the length of LIS for {10, 22, 9, 33, 21, 50, 41, 60, 80} is 6 and LIS is {10, 22, 33, 50, 60, 80}.
 */
public class LIS {

    public static void main(String[] args) {
        int[] A = {10, 22, 9, 33, 21, 50, 41, 60, 80};
        System.out.println(lis(A, A.length));
    }

    private static int lis(int[] A, int n) {

        // base condition
        if (n == 1) {
            return 1; // array of length 1 is always increasing sequence
        }

        // 2 cases : include or exclude the element
        int include = 1 + lis(A, n - 1);
        int exclude = lis(A, n - 1);

        return Math.max(include, exclude);
    }
}
