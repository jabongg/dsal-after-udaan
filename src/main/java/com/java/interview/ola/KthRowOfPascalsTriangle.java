package com.java.interview.ola;

public class KthRowOfPascalsTriangle {
    public static void main(String[] args) {
        int k = 3;

        printPascalTriangle(k);
    }

    private static void printPascalTriangle(int k) {
        for (int i = 0; i <= k; i++) {
//            for (int j = 0; j <= k - i; j++) {
//                // for left spacing
//                System.out.print(" ");
//            }

            for (int j = 0; j <= i; j++) {
                //ncr formula
                System.out.println(" " + factorial(i) / factorial(j) * factorial(i - j));
            }
        }
    }

    private static int factorial(int i) {
        if (i == 0) return 1;
        return i * factorial(i - 1);
    }
}
