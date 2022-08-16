package com.java.datastrudtures.array;

public class FindPairClosestToGivenSum {
    public static void main(String[] args) {
        int[] A = {-1, 3, 8, 2, 9, 5};
        int[] B = {4, 1, 2, 10, 5, 20};

        int sum = 24;
        findSumPairsClosestToSum(A, B, sum);
    }

    private static void findSumPairsClosestToSum(int[] A, int[] B, int sum) {

        // I have to minimise the difference from the given sum.
        int minDiff = Integer.MAX_VALUE;
        int currDiff;

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                currDiff = sum - (A[i] + B[j]);

                if (Math.abs(currDiff) <= minDiff) {
                    minDiff = Math.abs(currDiff);

                    //if (currDiff == 0) // we will take help of flag to identify the last sored value.
                    //    System.out.println(A[i] + " " + B[j]);
                   // else
                        System.out.println(A[i] + " " + B[j]);
                }
            }
        }

    }


}
