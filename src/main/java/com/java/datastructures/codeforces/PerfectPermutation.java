package com.java.datastructures.codeforces;

import java.util.Scanner;

public class PerfectPermutation {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        while (T-- != 0) {
            int n = scanner.nextInt();
            System.out.println(n);

            for (int i = 1; i <= n; i++) {
                System.out.print(" " + i);
            }
            System.out.println();
        }
    }

}
