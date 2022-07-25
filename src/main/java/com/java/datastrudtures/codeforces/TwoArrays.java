package com.java.datastrudtures.codeforces;

import java.util.Scanner;

public class TwoArrays {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] a = new int[n];
        int[] b = new int[m];

        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }

        System.out.println(findFinalScore(a, b, n, m));
    }

    private static int findFinalScore(int[] a, int[] b, int n, int m) {
        // alice plays first
        int[][] board = new int[n][m];
        // rook initial poistion board[0][0]
        int score = 0;

        //dp se hoga


        // bob plays after alice


        return 0;
    }
}
