package com.java.datastrudtures.recursion;

public class PrintNTo1 {
    public static void main(String[] args) {
        int N = 7;
        print(N);
    }

    private static void print(int n) {
        // base condition
        if (n == 1) {
            System.out.println(n);
            return;
        }
        System.out.println(n);
        print(n - 1);

    }
}
