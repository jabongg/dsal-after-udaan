package com.java.datastructures.array.slidingwindow;

import java.util.Arrays;

public class AverageOfSubarrayOfSizeK {
    public static double[] findAveragesBruteForce(int K, int[] arr) {
        double[] result = new double[arr.length - K + 1];

        for (int i = 0; i <= arr.length - K; i++) {
            // find sum of next 'K' elements
            double sum = 0;
            for (int j = i; j < i + K; j++)
                sum += arr[j];
            result[i] = sum / K; // calculate average
        }

        return result;
    }

    public static void main(String[] args) {
        double[] result = AverageOfSubarrayOfSizeK.findAverages(5, new int[]{1, 3, 2, 6, -1, 4, 1, 8, 2});
        System.out.println("Averages of subarrays of size K: " + Arrays.toString(result));
    }


    public static double[] findAveragesSlidingWindow(int K, int[] arr) {
        double[] result = new double[arr.length - K + 1];

        // calculate sum for first k elements
        double sum = 0;
        for (int i = 0; i < K; i++) {
            sum += arr[i];
        }
        result[0] = sum / K;

        // now start sliding the window
        // subtract the first element from the window, and add the new element coming to window
        // sliding the window here
        int i = 1;
        int j = K;
        while ( j < arr.length) {
            sum = (sum - arr[i - 1]) + arr[j];
            result[i] = sum / K;
            i++;
            j++;
        }

        return result;
    }


    public static double[] findAverages(int K, int[] arr) {
        double[] result = new double[arr.length - K + 1];
        double windowSum = 0;
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd]; // add the next element
            // slide the window, we don't need to slide if we've not hit the required window size of 'k'
            if (windowEnd >= K - 1) {
                result[windowStart] = windowSum / K; // calculate the average
                windowSum -= arr[windowStart]; // subtract the element going out
                windowStart++; // slide the window ahead
            }
        }
        return result;
    }
}