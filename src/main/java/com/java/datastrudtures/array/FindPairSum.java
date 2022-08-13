package com.java.datastrudtures.array;

public class FindPairSum {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 9};
        int sum = 8;
        findSumPairs(A, sum);
    }

    private static void findSumPairs(int[] A, int sum) {
        int i = 0;
        int j = A.length - 1;

        // i'll check for each i and j till i < j

        while (i < j) { //

            if (A[i] + A[j] < sum) {
                i++; // then increment i index
            } else if (A[i] + A[j] > sum) {
                j--;
            } else {
                System.out.println("pair is : " + A[i] + " " + A[j]);
                return; // break is important otherwise it will end up to an infinite loop;
            }
        }
        System.out.println("pair not found");
        return;
    }
}
