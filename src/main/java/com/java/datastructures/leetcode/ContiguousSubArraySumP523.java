package com.java.datastructures.leetcode;

import java.util.HashMap;

/**
 * Given an integer array nums and an integer k, return true if nums has a continuous subarray of size at least two whose elements sum up to a multiple of k, or false otherwise.
 *
 * An integer x is a multiple of k if there exists an integer n such that x = n * k. 0 is always a multiple of k.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [23,2,4,6,7], k = 6
 * Output: true
 * Explanation: [2, 4] is a continuous subarray of size 2 whose elements sum up to 6.
 */
public class ContiguousSubArraySumP523 {

    public static void main(String[] args) {
        int[] nums = {23,2,6,4,7};
        int k = 13;

        System.out.println(contiguousSubArraySumExists(nums, k));
    }

    private static boolean contiguousSubArraySumExists(int[] nums, int k) {
        for (int i = 0; i < nums.length - 1; i++) {
            int currSum = nums[i];
            for (int j = i + 1; j < nums.length; j++) { // doing this because we need minimum subarray of length 2.
                currSum = currSum + nums[j];

                if (isMultipleOfK(currSum, k)) {
                    return true;
                }
            }
        }
        return false;
    }


    // O(N) complexity using hashmap
    private static boolean doesContiguousSubArraySumExists(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int sum = 0;

        for(int i=0; i<nums.length; i++) {
            sum += nums[i];

            int remaining = sum % k;

            if(i!=0 && sum % k == 0) {
                return true;
            }

            if(map.containsKey(remaining)) {
                if(i-map.get(remaining)>1) {
                    return true;
                }
            } else {
                map.put(remaining, i);
            }
        }

        return false;
    }

    private static boolean isMultipleOfK(int currSum, int k) {
        return (currSum % k) == 0;
    }
}
