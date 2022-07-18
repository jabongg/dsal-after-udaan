package com.java.datastrudtures.dp;

public class Knapsack01 {
    public static void main(String[] args) {
        int[] wt = {1, 3, 4, 5};
        int[] val = {1, 4, 5, 7};
        int W = 7;
        int n = wt.length;
        //System.out.println(knapsack01Memoized(wt, val, W, n));

        System.out.println(knapsack01Tabulation(wt, val, W, n));
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


    // Tabulation solution O(N) space
    private static int knapsack01Tabulation(int[] wt, int[] val, int W, int n) {
        // making and initializing dp array
        int[] dp = new int[W + 1];

        for (int i = 1; i < n + 1; i++) {
            for (int w = W; w >= 0; w--) {

                if (wt[i - 1] <= w)
                    // finding the maximum value
                    dp[w] = Math.max(dp[w],
                            dp[w - wt[i - 1]] + val[i - 1]);
            }
        }
        return dp[W]; // returning the maximum value of knapsack
    }


    // Returns the maximum value that can
    // be put in a knapsack of capacity W
    // Tabulation solution O(N2) space
    static int knapSackTabulation(int[] wt, int[] val, int W, int n) {
        int i, w;
        int K[][] = new int[n + 1][W + 1];

        // Build table K[][] in bottom up manner
        for (i = 0; i <= n; i++) {
            for (w = 0; w <= W; w++) {
                if (i == 0 || w == 0)
                    K[i][w] = 0;
                else if (wt[i - 1] <= w)
                    K[i][w]
                            = Math.max(val[i - 1]
                                    + K[i - 1][w - wt[i - 1]],
                            K[i - 1][w]);
                else
                    K[i][w] = K[i - 1][w];
            }
        }

        return K[n][W];
    }

}
