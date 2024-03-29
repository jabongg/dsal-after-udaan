package com.java.datastrudtures.backtracking;

/**
 * vGiven an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 *
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 *
 *
 *
 * Example 1:
 *
 * Input: grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * Output: 1
 *
 * Example 2:
 *
 * Input: grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * Output: 3
 *
 *         char[][] grid = {
 *                 { '0', '0', '0', '0', '0', '0', '0' },
 *                 { '0', '1', '0', '1', '0', '0', '0' },
 *                 { '0', '1', '0', '1', '0', '0', '0' },
 *                 { '0', '1', '0', '1', '0', '1', '0' },
 *                 { '0', '1', '1', '1', '1', '1', '0' },
 *                 { '0', '0', '0', '1', '0', '0', '0' }
 *         };
 *
 *
 *
 * Constraints:
 *
 *     m == grid.length
 *     n == grid[i].length
 *     1 <= m, n <= 300
 *     grid[i][j] is '0' or '1'.
 */
public class IslandsCount {
    public static int numIslands(char[][] grid) {
        int maxIslands = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    maxIslands++;
                    dfs(grid, i, j); // 0 for current count
                }
            }
        }

        return maxIslands;
    }

    public static void dfs(char[][] grid, int i, int j) {
        // base condition for backtrack
        if (i < 0 || i > grid.length - 1 || j < 0 || j > grid[0].length - 1 || grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0';

        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);

    }

    public static void main(String[] args) {
        char[][] grid = {
                { '0', '0', '0', '0', '0', '0', '0' },
                { '0', '1', '0', '1', '0', '0', '0' },
                { '0', '0', '0', '1', '0', '0', '0' },
                { '0', '1', '0', '0', '0', '1', '0' },
                { '0', '1', '1', '1', '1', '1', '0' },
                { '0', '0', '0', '1', '0', '0', '0' }
        };

        System.out.println(numIslands(grid));
    }

}
