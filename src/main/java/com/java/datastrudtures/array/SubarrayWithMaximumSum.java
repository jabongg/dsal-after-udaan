package com.java.datastrudtures.array;

/**
 * Given an array of integers, the task is to find the maximum subarray sum possible of all the non-empty subarrays.
 */
public class SubarrayWithMaximumSum {
    public static void main(String[] args) {
        //int[] arr = {-3, -4, 5, -1, 2, -4, 6, -1};
        //int[] arr = {-5, 4, 6, -3, 4, -1};

        // testing for all Negative numbers
        int[] arr = {-5, -4, -6, -3, -4, -1};

        //int subarrayWithMaxSum = subarrayWithMaxSum(arr);
        int subarrayWithMaxSum = subArrayWithMaximumSumKedanesAlgoAllNegative(arr);

        System.out.println(subarrayWithMaxSum);
    }

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf(arr[i] + " ");
        }
    }


    private static int subarrayWithMaxSum(int[] arr) {

        int maxSum = 0;
        int currSum = 0;

        //think of the boundary conditions also.
        for (int i = 0; i < arr.length; i++) {
            currSum = 0;
            for (int j = i; j < arr.length; j++) {
                currSum += arr[j];
                maxSum = maxSum < currSum ? currSum : maxSum;
            }
        }
        return maxSum;
    }

    // applying kedane's algorithm for both positive and negative values
    private static int subArrayWithMaximumSumKedanesAlgo(int[] A) {
        int maxSum = 0;
        int currSum = 0;

        // iterate through the array O(N)
        for (int i = 0; i < A.length; i++) {
            currSum += A[i];

            if (currSum > maxSum) {
                maxSum = currSum;
            }

            // if total sum of the subarray is less than zero, then reassign currSum to 0;
            if (currSum < 0) {
                currSum = 0;
            }
        }

        return maxSum;
    }


    // applying kedane's algorithm for only  negative values
    private static int subArrayWithMaximumSumKedanesAlgoAllNegative(int[] A) {
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;

        // iterate through the array O(N)
        for (int i = 0; i < A.length; i++) {
            currSum += A[i];

            if (currSum > maxSum) {
                maxSum = currSum;
            }

            // if total sum of the subarray is less than zero, then reassign currSum to 0;
            if (currSum < 0) {
                currSum = 0;
            }
        }

        return maxSum;
    }
}
