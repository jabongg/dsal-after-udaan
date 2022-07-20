package com.java.datastrudtures.leetcode;

import java.util.Arrays;

public class SubarraySumEqualsKP560 {
    public static int subarraySum(int[] nums, int k) {

        int i = 0;
        int j = nums.length - 1;
        int sum = 0;
        int count = 0;

        Arrays.sort(nums);

        while (i < j) {
            sum = nums[i] + nums[j];

            if (sum > k) {
                if (nums[j] == k) {  // then number itself is a subset
                    count++;
                }
                j--;
            } else if (sum == k) {
                count++;
                i++;
            } else {
                i++;
                j--;
            }


        }

        return count;
    }

    public static void main(String[] args) {
        int[] a = {1,1,1};
        int k = 2;

        System.out.println(subarraySum(a, k));
    }
}
