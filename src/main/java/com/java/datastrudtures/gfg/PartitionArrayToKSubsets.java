package com.java.datastrudtures.gfg;

import java.util.Arrays;

/**
 * Given an integer array a[ ] of N elements and an integer K, the task is to check if the array a[ ] could be divided into K non-empty subsets with equal sum of elements.
 * Note: All elements of this array should be part of exactly one partition.
 *
 * Example 1:
 *
 * Input:
 * N = 5
 * a[] = {2,1,4,5,6}
 * K = 3
 * Output:
 * 1
 * Explanation: we can divide above array
 * into 3 parts with equal sum as (2, 4),
 * (1, 5), (6)
 *
 * Constraints:
 * 1 ≤ K ≤ N ≤ 10
 * 1 ≤ a[i] ≤ 100
 */
public class PartitionArrayToKSubsets {
    public static boolean isKPartitionPossible(int a[], int n, int k)
    {
        // Your code here
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        boolean isSumMultipleOfk = (sum % k == 0);
        if (!isSumMultipleOfk) {
            return false;
        } else {
            return knapSackTabulation(a, sum / k, a.length);
        }
    }


    public static boolean knapSackTabulation(int[] wt, int W, int n) {
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


    public static boolean isKPartitionPossibleIterative(int a[], int n, int k)
    {
        if (k == 1) {
            return true;
        } else if (n < k) {
            return false;
        } else {
            int sum = 0;
            for (int i : a) {
                sum += i;
            }
            if (sum % k != 0) {
                return false;
            } else {
                int i = 0, j = n - 1, target = sum / k;
                Arrays.sort(a);
                while (i < j) {
                    if (a[i] + a[j] > target) {
                        if (a[j] == target) {
                            j--;
                        } else {
                            return false;
                        }
                    } else {
                        i++;
                        j--;
                    }
                }
                return true;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {2,1,4,5,6};
        int K = 3;
        int n = a.length;
        System.out.println(isKPartitionPossibleIterative(a, n, K));
    }
}
