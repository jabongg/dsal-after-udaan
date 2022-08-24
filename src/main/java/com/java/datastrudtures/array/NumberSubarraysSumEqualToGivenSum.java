package com.java.datastrudtures.array;

import java.util.HashMap;

public class NumberSubarraysSumEqualToGivenSum {
    public static void main(String[] args) {
        int arr[] = {10, 2, -2, -20, 10};
        int k = -10;
        int n = arr.length;


        findSubarraySum(arr, n, k);



        int res = 0;


       // findSubarraysWithGivenSum(arr, k, n, res);
    }

    private static void findSubarraysWithGivenSum(int[] arr, int k, int n, int res) {
        // calculate all subarrays
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                // calculate required sum
                sum += arr[j];
                // check if sum is equal to required sum
                if (sum == k)
                    res++;
            }
        }
        System.out.println(res);
    }


    // Function to find number of subarrays
    // with sum exactly equal to k.
    static int findSubarraySum(int arr[], int n, int sum) {
        // HashMap to store number of subarrays
        // starting from index zero having
        // particular value of sum.
        HashMap<Integer, Integer> prevSum = new HashMap<>();
        prevSum.put(0, 1);
        int res = 0;

        // Sum of elements so far.
        int currSum = 0;

        for (int i = 0; i < n; i++) {

            // Add current element to sum so far.
            currSum += arr[i];
            //calculate the sum that have to be removed
            //so that we can get the desired sum

            int removeSum = currSum - sum;

            //get count of occurrences of that sum that
            //have to removed and add it to res value
            if (prevSum.containsKey(removeSum))
                res += prevSum.get(removeSum);

            // Add currsum value to count of
            // different values of sum.
            prevSum.put(currSum, prevSum.getOrDefault(currSum, 0) + 1);
        }
        System.out.println(res);
        return res;
    }

}