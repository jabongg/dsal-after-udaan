package com.java.datastructures.recursion;

public class Print1ToN {
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
        print(n - 1);
        System.out.println(n);

    }
}
