package com.java.datastructures.leetcode;

public class PizzaWith3nSlicesP1388 {

    // O(N2)
    public static int maxSizeSlices(int[] slices) {

        int maxSum = 0;

        for (int i = 0; i < slices.length - 2; i++) {
            int maxEndingHere = 0;

            for (int j = i + 2; j < slices.length; j++) {
                int currSum = 0;
                currSum += slices[i] + slices[j];

                if (currSum > maxEndingHere) {
                    maxEndingHere = currSum;
                }
            }
            // simply updated maxSum if currSum > maxSum
            maxSum = maxSum < maxEndingHere ? maxEndingHere: maxSum;
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] slices = {4,1,2,5,8,3,1,9,7};
        System.out.println(maxSizeSlices(slices));
    }
}
