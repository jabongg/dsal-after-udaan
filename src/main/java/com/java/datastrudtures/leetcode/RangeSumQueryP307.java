package com.java.datastrudtures.leetcode;

/**
 * Given an integer array nums, handle multiple queries of the following types:
 *
 *     Update the value of an element in nums.
 *     Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.
 *
 * Implement the NumArray class:
 *
 *     NumArray(int[] nums) Initializes the object with the integer array nums.
 *     void update(int index, int val) Updates the value of nums[index] to be val.
 *     int sumRange(int left, int right) Returns the sum of the elements of nums between indices left and right inclusive (i.e. nums[left] + nums[left + 1] + ... + nums[right]).
 *
 *
 *
 * Example 1:
 *
 * Input
 * ["NumArray", "sumRange", "update", "sumRange"]
 * [[[1, 3, 5]], [0, 2], [1, 2], [0, 2]]
 * Output
 * [null, 9, null, 8]
 *
 * Explanation
 * NumArray numArray = new NumArray([1, 3, 5]);
 * numArray.sumRange(0, 2); // return 1 + 3 + 5 = 9
 * numArray.update(1, 2);   // nums = [1, 2, 5]
 * numArray.sumRange(0, 2); // return 1 + 2 + 5 = 8
 */
public class RangeSumQueryP307 {
    public static void main(String[] args) {
        // call for all NumArray methods here.

        char ch = Character.toLowerCase('U');
        System.out.println(ch);
    }
}


class NumArray {

    int[] nums;
    int[] input; // for calculations on updated array, taking a separate array.
    int sum;

    public NumArray(int[] nums) {
        this.nums = nums;
        input = nums;

        sum = 0;

        for (int i = 0; i < nums.length; i++)
            sum += nums[i];

    }

    public void update(int index, int val) {
        sum = sum - input[index]; // subtract old value
        input[index] = val; // updated new value
        sum = sum + val; // add new value

    }



    public int sumRange(int left, int right) {

        int result = sum;

        //subtract all the numbers sum before left
        int lsum = 0, rsum = 0;
        for (int i = 0; i < left; i++)
            result = result - nums[i];


        // subtract the sum of all numbers after right;
        for (int i = right + 1; i < nums.length; i++)
            result = result - nums[i];

        //sum = sum - (lsum + rsum);

        return result;
    }


}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
