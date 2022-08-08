package com.java.datastrudtures.array.slidingwindow;

public class SubarrayWithMaximumSumOfGivenKSize {


    public static int findMaxSumSubArraySlidingWindow(int k, int[] arr) {
        // TODO: Write your code here

        int maxSum = Integer.MIN_VALUE; // it will store the final result

        int currSum = 0;

        for (int i = 0; i < k; i++) {
            currSum += arr[i];
        }

        if (maxSum < currSum) {
            maxSum = currSum;
        }

        // now start sliding the window
        int i = 0; // the element exiting the window
        int j = k; // the next coming element to window

        while (j < arr.length) {
            currSum = (currSum - arr[i]) + arr[j];
            if (maxSum < currSum) {
                maxSum = currSum;
            }
            j++;
            i++;
        }

        return maxSum;
    }


    public static int findMaxSumSubArrayBruteForce(int k, int[] arr) {
        int maxSum = 0, windowSum;
        for (int i = 0; i <= arr.length - k; i++) {
            windowSum = 0;
            for (int j = i; j < i + k; j++) {
                windowSum += arr[j];
            }
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }

    public static int findMaxSumSubArray(int k, int[] arr) {
        int windowSum = 0, maxSum = 0;
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd]; // add the next element
            // slide the window, we don't need to slide if we've not hit the required window size of 'k'
            if (windowEnd >= k - 1) {
                maxSum = Math.max(maxSum, windowSum);
                windowSum -= arr[windowStart]; // subtract the element going out
                windowStart++; // slide the window ahead
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println("Maximum sum of a subarray of size K: "
                + SubarrayWithMaximumSumOfGivenKSize.findMaxSumSubArraySlidingWindow(3, new int[]{2, 1, 5, 1, 3, 2}));
        System.out.println("Maximum sum of a subarray of size K: "
                + SubarrayWithMaximumSumOfGivenKSize.findMaxSumSubArraySlidingWindow(2, new int[]{2, 3, 4, 1, 5}));
    }
}
