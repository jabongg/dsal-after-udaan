package com.java.datastrudtures.dp;

public class Knapsack01 {
    public static void main(String[] args) {
        int[] wt = {1, 3, 4, 5};
        int[] val = {1, 4, 5, 7};
        int W = 7;
        int n = wt.length;
        System.out.println(knapsack01Memoized(wt, val, W, n));
    }

    // recursive solution
    private static int knapsack01(int[] wt, int[] val, int W, int n) {
        if (W == 0 || n == 0) { // base condtion
            return 0;
        }

        // cases : 1. w[n - 1] < W :include or exclude (we have choice)
        // 2. w[n - 1] > W :exclude

        if (wt[n - 1] <= W)
            return Math.max(val[n - 1] + knapsack01(wt, val, W - wt[n - 1], n - 1), knapsack01(wt, val, W, n - 1));
        if (wt[n - 1] > W)
            return knapsack01(wt, val, W, n - 1);
        return 0;
    }

    // memoized solution
    private static int knapsack01Memoized(int[] wt, int[] val, int W, int n) {
        int[][] t = new int[n + 1][W + 1];

        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[0].length; j++) {
                t[i][j] = -1;
            }
        }


        if (W == 0 || n == 0) { // base condtion
            return 0;
        }

        if (t[n][W] != -1) {
            return t[n][W];
        }

        // cases : 1. w[n - 1] < W :include or exclude (we have choice)
        // 2. w[n - 1] > W :exclude

        if (wt[n - 1] <= W)
            return t[n][W] = Math.max(val[n - 1] + knapsack01(wt, val, W - wt[n - 1], n - 1), knapsack01(wt, val, W, n - 1));
        if (wt[n - 1] > W)
            return t[n][W] = knapsack01(wt, val, W, n - 1);
        return 0;
    }
}
