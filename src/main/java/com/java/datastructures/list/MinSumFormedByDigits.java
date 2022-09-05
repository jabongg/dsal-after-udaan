package com.java.datastructures.list;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Given an array of digits (values are from 0 to 9), find the minimum possible sum of two numbers formed from digits of the array. All digits of given array must be used to form the two numbers.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input:
 * N = 6
 * arr[] = {6, 8, 4, 5, 2, 3}
 * Output:
 * 604
 */
public class MinSumFormedByDigits {
    public static long minimumSum(int arr[], int n) {
        // Your code goes here
        // sort the array. O(NLogN)

        Arrays.sort(arr);
        int minimumSum = 0;
        String num1 = "";
        String num2 = "";

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                num1 = num1.concat(String.valueOf((Integer) arr[i]));
            } else {
                num2 = num2.concat(String.valueOf((Integer) arr[i]));
            }
        }

        int firstNum = Integer.parseInt(num1);
        int secondNum = Integer.parseInt(num2);

        minimumSum = firstNum + secondNum;

        return minimumSum;
    }


    public static long minSumm(int arr[], int n) {
        // Your code goes here
        // sort the array. O(NLogN)

        Arrays.sort(arr);
        long minimumSum = 0;
        long num1 = 0;
        long num2 = 0;

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                num1 = num1 * 10 + arr[i];
            } else {
                num2 = num2 * 10 + arr[i];
            }
        }

        minimumSum = num1 + num2;

        return minimumSum;
    }

    public static void main(String[] args) {
        int[] arr = {6, 8, 4, 5, 2, 3};
        //int[] arr = {5, 3, 0, 7, 4};
        System.out.println(minSum(arr, arr.length));
    }

    public static long minSum(int arr[], int n) {
        // Your code goes here
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // to store the 2 numbers formed by array elements to
        // minimize the required sum
        long a = 0, b = 0;

        // Adding elements in Priority Queue
        for (int i = 0; i < n; i++)
            pq.add(arr[i]);

        // checking if the priority queue is non empty
        while (!pq.isEmpty()) {
            a *= 10;
            a += pq.element();
            pq.remove();
            if (!pq.isEmpty()) {
                b *= 10;
                b += pq.element();
                pq.remove();
            }
        }
        return a + b;
    }
}
