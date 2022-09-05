package com.java.datastructures.list;

import java.util.Stack;

/**
 * Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.
 *
 *
 *
 * Example 1:
 *
 * Input: heights = [2,1,5,6,2,3]
 * Output: 10
 * Explanation: The above is a histogram where width of each bar is 1.
 * The largest rectangle is shown in the red area, which has an area = 10 units.
 *
 * boundary condition, think of zero i.e. height is 0;
 */
public class LargestRectangleInHistogram {
    // geeksforgeeks solution java
    public static int largestRectangleArea(int[] heights) {

        Stack<Integer> s = new Stack<>();
        int ret = 0;
        int n = heights.length;
        for (int i = 0; i < n; i++)
        {
            while (s.isEmpty() == false && heights[s.peek()] >= heights[i])  // prev smaller ele loop
            {
                int tp = s.peek();
                s.pop();
                int curr = heights[tp] * (s.isEmpty() ? i : (i - s.peek() - 1));
                ret = Math.max(ret, curr);
            }
            s.push(i);  // when we push this item , the item below it is the previous smaller of it
        }

        while (!s.isEmpty())
        {
            int tp = s.peek();
            s.pop();
            int curr = heights[tp] * (s.isEmpty() ? n : (n - s.peek() - 1));
            ret = Math.max(ret, curr);
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
        //int[] heights = {0,9, 0,8};

        System.out.println(largestRectangleArea(heights));
    }
}
