package com.java.datastrudtures.leetcode;

/**
 * There is an m x n grid with a ball. The ball is initially at the position [startRow, startColumn]. You are allowed to move the ball to one of the four adjacent cells in the grid (possibly out of the grid crossing the grid boundary). You can apply at most maxMove moves to the ball.
 *
 * Given the five integers m, n, maxMove, startRow, startColumn, return the number of paths to move the ball out of the grid boundary. Since the answer can be very large, return it modulo 109 + 7

 Input: m = 2, n = 2, maxMove = 2, startRow = 0, startColumn = 0
 Output: 6

 Constraints:
 1 <= m, n <= 50
 0 <= maxMove <= 50
 0 <= startRow < m
 0 <= startColumn < n

 */
public class OutOfBoundaryPathsP576 {
    double mod = 10e9+7;

    public static int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {

        //int[][][] t = new int[51][51][51]; // this is as per constraints.

        return findPathsHelper(m, n, maxMove, startRow, startColumn);
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

    public static void main(String[] args) {
        int m = 2, n = 2, maxMove = 2, startRow = 0, startColumn = 0;
        System.out.println(findPaths(m, n, maxMove, startRow, startColumn));
    }
}
