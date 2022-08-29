package com.java.datastrudtures.leetcode;

public class MaxAreaOfIslandP695 {
    // in case of no islands, we will return 0.
    // also any area would be bigger than 0 so no need to use Integer.MIN_VALUE
    static int result = 0;

    public static int maxAreaOfIsland(char[][] grid) {

        // check grid until finding "1" value
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    result = Math.max(result, traverse(grid, i, j));
                }
            }
        }

        return result;
    }

    private static int traverse(char[][] grid, int i, int j) {
        // if index is not within grid length or the value is not 1 not part of any island.
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] != '1') {
            return 0;
        }
        // set value to 0, so we don't visit again.
        grid[i][j] = '0';
        int count = 1;
        // increase count if the neighbor is also an island
        // since we're changing value to 0, we will visit neighbors of the neighbor only once.
        count += traverse(grid, i + 1, j);
        count += traverse(grid, i - 1, j);
        count += traverse(grid, i, j + 1);
        count += traverse(grid, i, j - 1);

        return count;
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

        System.out.println(maxAreaOfIsland(grid));
    }

}
