package com.java.datastrudtures.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Given an n x n matrix where each of the rows and columns is sorted in ascending order, return the kth smallest element in the matrix.
 * <p>
 * Note that it is the kth smallest element in the sorted order, not the kth distinct element.
 * <p>
 * You must find a solution with a memory complexity better than O(n2).
 */
public class KthSmallestElementInSortedMatrixP378 {
    public static void main(String[] args) {

        // matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8

        int[][] matrix = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        int k = 8;
        System.out.println(kthSmallest(matrix, k));
    }


    public static int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                queue.add(matrix[i][j]); // converting 2d array to single array. very good.
            }
        }

        int i = 1;
        while ( i <= k) {
            queue.remove();
        }

        return queue.element();
    }

    public static int kthSmallesttt(int[][] matrix, int k) {
        int lo = matrix[0][0];
        int hi = matrix[matrix.length - 1][matrix[0].length - 1] + 1;
        while (lo < hi) {
            int count = 0;
            int j = matrix[0].length - 1;
            int mid = lo + (hi - lo) / 2;
            for (int i = 0; i < matrix.length; i++) {
                while (j >= 0 && matrix[i][j] > mid) j--;
                count += j + 1;
            }
            if (count < k) lo = mid + 1;
            else hi = mid;

        }
        return lo;
    }

    public static int kthSmallestt(int[][] matrix, int k) {

        // binary search lagana hai
        int l = matrix.length * matrix.length;
        int[] singleArray = new int[l];
        int n = matrix.length;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                singleArray[n * i + j] = matrix[i][j]; // converting 2d array to single array. very good.
            }
        }

        Arrays.sort(singleArray);
        int KthSmallestNumber = 0;

        for (int i = 1; i <= k; i++) {
            if (i == k) {
                KthSmallestNumber = singleArray[i - 1];
            }
        }

        return KthSmallestNumber;
    }
}
