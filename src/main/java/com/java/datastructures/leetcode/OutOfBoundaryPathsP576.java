package com.java.datastructures.leetcode;

import java.util.Arrays;

/**
 * There is an m x n grid with a ball. The ball is initially at the position [startRow, startColumn]. You are allowed to move the ball to one of the four adjacent cells in the grid (possibly out of the grid crossing the grid boundary). You can apply at most maxMove moves to the ball.
 * <p>
 * Given the five integers m, n, maxMove, startRow, startColumn, return the number of paths to move the ball out of the grid boundary. Since the answer can be very large, return it modulo 109 + 7
 * <p>
 * Input: m = 2, n = 2, maxMove = 2, startRow = 0, startColumn = 0
 * Output: 6
 * <p>
 * Constraints:
 * 1 <= m, n <= 50
 * 0 <= maxMove <= 50
 * 0 <= startRow < m
 * 0 <= startColumn < n
 */
public class OutOfBoundaryPathsP576 {
    private static int mod = 1000000007;

    public static int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {

        // initialize t with -1
        int[][][] t = new int[m][n][maxMove + 1]; // this is as per constraints.

        for (int[][] row : t) {
            for (int[] col : row) {
                Arrays.fill(col, -1);
            }
        }
        return findPathsMemoized(m, n, maxMove, startRow, startColumn, t);
        //return findPathsHelper(m, n, maxMove, startRow, startColumn);
    }

    private static int findPathsHelper(int m, int n, int maxMove, int r, int c) {

        if (r < 0 || r >= m || c < 0 || c >= n) { // boundary condtions.
            return 1; // still need one move
        }

        if (maxMove <= 0) {
            return 0; // boundary condtions.
        }


        return findPathsHelper(m, n, maxMove - 1, r, c - 1)
                + findPathsHelper(m, n, maxMove - 1, r, c + 1)
                + findPathsHelper(m, n, maxMove - 1, r + 1, c)
                + findPathsHelper(m, n, maxMove - 1, r - 1, c);
    }

    private static int findPathsMemoized(int m, int n, int maxMove, int r, int c, int[][][] t) {
            if (r == m || c == n || r < 0 || c < 0) { // boundary condtions.
                return 1; // still need one move
            }

            if (maxMove == 0) {
                return 0; // boundary condtions.
            }

            if (t[r][c][maxMove] >= 0) {
                return t[r][c][maxMove];
            }

            return t[r][c][maxMove] = ((findPathsMemoized(m, n, maxMove - 1, r, c - 1, t)
                    + findPathsMemoized(m, n, maxMove - 1, r, c + 1, t)) % mod
                    + (findPathsMemoized(m, n, maxMove - 1, r + 1, c, t)
                    + findPathsMemoized(m, n, maxMove - 1, r - 1, c, t)) % mod) % mod;
        }

        public static void main(String[] args) {
        int m = 2, n = 2, maxMove = 2, startRow = 0, startColumn = 0;
        System.out.println(findPaths(m, n, maxMove, startRow, startColumn));
    }
}
