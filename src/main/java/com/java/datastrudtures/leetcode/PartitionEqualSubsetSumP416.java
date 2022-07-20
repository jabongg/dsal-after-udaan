package com.java.datastrudtures.leetcode;

/**
 * Given a non-empty array nums containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,5,11,5]
 * Output: true
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 *
 * Example 2:
 *
 * Input: nums = [1,2,3,5]
 * Output: false
 * Explanation: The array cannot be partitioned into equal sum subsets.
 *
 * Constraints:
 *
 *     1 <= nums.length <= 200
 *     1 <= nums[i] <= 100
 */
public class PartitionEqualSubsetSumP416 {

    public boolean canPartition(int[] nums) {

        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        boolean isEvenSum = (sum % 2 == 0);

        if (!isEvenSum) {
            return false;
        } else {
            return knapSackTabulation(nums, sum / 2, nums.length);

        }

    }


    public boolean knapSackTabulation(int[] wt, int W, int n) {
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

}