package com.java.datastrudtures.dp;

public class CoinChangeProblem {

    public static void main(String[] args) {
        int[] coins = {1, 2, 3};
        int target = 4;
        int n = coins.length;
        System.out.println(knapSackTabulation(coins, target, n));
    }

    // Returns the maximum value that can
    // be put in a knapsack of capacity W
    // Tabulation solution O(N2) space
    static int knapSackTabulation(int[] wt, int W, int n) {
        int i, w;
        int K[][] = new int[n + 1][W + 1];

        // Build table K[][] in bottom up manner
        for (i = 0; i <= n; i++) {
            for (w = 0; w <= W; w++) {
                if (i == 0 || w == 0)
                    K[i][w] = 0;
                else if (wt[i - 1] <= w)
                    K[i][w]
                            = K[i - 1][w - wt[i - 1]] + K[i - 1][w];
                else
                    K[i][w] = K[i - 1][w];
            }
        }

        return K[n][W];
    }
}
