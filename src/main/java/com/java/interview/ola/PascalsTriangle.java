package com.java.interview.ola;

import java.util.*;

public class PascalsTriangle {

    private static Map<Integer, List<Integer>> pascalsMap = new HashMap<>();
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Enter value of n: ");
        int n = in.nextInt();

        int ncr[][] = new int[n][n];

        createPascalTriangle(n, ncr);
        //printPascalsTriangle(n, ncr);

        //System.out.println(pascalsMap);

        // get nth row of pascals.. O(1) get time now. counting from 0;
        System.out.println(pascalsMap.get(n - 1));

    }

    private static void printPascalsTriangle(int n, int[][] ncr) {
        for (int i = 0; i < n; i++) {
            for (int k = 1; k < n - i; k++) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
               // System.out.print(nCr(i, j) + " ");
                System.out.print(ncr[i][j]  + " ");
            }
            System.out.println();
        }
    }

    //Function to return the value of nCr
    private static int nCr(int n, int r) {
        if (n < r || n == 0)
            return 1;

        int num = 1, den = 1;
        for (int i = r; i >= 1; i--) {
            num = num * n--;
            den = den * i;
        }
        return num / den;
    }


    private static void createPascalTriangle(int n, int[][] ncr) {

        ncr[0][0] = 1;  //First element is always 1
        pascalsMap.put(0, Arrays.asList(1));
        //start from 2nd row i.e from i=1
        for (int i = 1; i < n; i++) {

            List<Integer> list = new ArrayList<>();
            //First element of each row is always 1
            ncr[i][0] = 1;
            list.add(ncr[i][0]);

            for (int j = 1; j <= i; j++) {
                ncr[i][j] = ncr[i - 1][j - 1] + ncr[i - 1][j];
                list.add(ncr[i][j]);
                pascalsMap.put(i, list);
            }
        }
    }
}


