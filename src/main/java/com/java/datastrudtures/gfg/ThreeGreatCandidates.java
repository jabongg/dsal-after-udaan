package com.java.datastrudtures.gfg;


// A Java program to find a
// maximum product of a
// triplet in array of integers

import java.util.Arrays;

public class ThreeGreatCandidates {
    // Function to find a maximum product of a triplet in array of integers of size n
    static int maxProduct(int[] arr, int n) {
        // if size is less than 3, no triplet exists
        if (n < 3)
            return -1;

        // will contain max product
        int max_product = Integer.MIN_VALUE;

        //O(N3)
        for (int i = 0; i < n - 2; i++)
            for (int j = i + 1; j < n - 1; j++)
                for (int k = j + 1; k < n; k++)
                    max_product = Math.max(max_product,
                            arr[i] * arr[j] * arr[k]);

        return max_product;
    }

    // Driver Code
    public static void main(String[] args) {
        int[] arr = {1, -4, 3, -6, 7, 0};
        int n = arr.length;
        int max = threeGreatCandidates(arr, n);

        if (max == -1)
            System.out.println("No Triplet Exists");
        else
            System.out.println("Maximum product is " + max);
    }


    /* Function to find a maximum product of a triplet
  in array of integers of size n */
    static int threeGreatCandidates(int arr[], int n) {
        // if size is less than 3, no triplet exists
        if (n < 3) {
            return -1;
        }

        // Sort the array in ascending order
        Arrays.sort(arr);

        // Return the maximum of product of last three
        // elements and product of first two elements
        // and last element
        return Math.max(arr[0] * arr[1] * arr[n - 1],
                arr[n - 1] * arr[n - 2] * arr[n - 3]);
    }
}
