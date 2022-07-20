package com.java.datastrudtures.dp;

public class SubsetSum {

    // Returns the maximum value that can
    // be put in a knapsack of capacity W
    // Tabulation solution O(N2) space
    static boolean knapSackTabulation(int[] wt, int W, int n) {
        int i, w;
        boolean K[][] = new boolean[n + 1][W + 1];

        // Build table K[][] in bottom up manner
        for (i = 0; i <= n; i++) {
            for (w = 0; w <= W; w++) {
                if (i == 0)
                    K[i][w] = false;

                if (w == 0)
                    K[i][w] = true;

            }
        }


        for (i = 1; i <= n; i++) {  // starting from index 1 as i = 0 is already initialized.
            for (w = 1; w <= W; w++) {
                if (wt[i - 1] <= w)
                    K[i][w]
                            = K[i - 1][w - wt[i - 1]] ||
                            K[i - 1][w];
                else
                    K[i][w] = K[i - 1][w];
            }
        }
        return K[n][W];
    }


    public static void main(String[] args) {
        int[] weight = {1, 4, 5, 7};
        int W = 15;

        System.out.println("subset sum exists : " + (knapSackTabulation(weight, W, weight.length)));
    }
}
