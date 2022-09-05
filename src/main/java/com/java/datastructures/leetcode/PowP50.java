package com.java.datastructures.leetcode;

public class PowP50 {
    public static double myPow(double x, int n) {

        double[] t = new double[Math.abs(n) + 1];

        // dp table;
        for (int i = 0; i < t.length; i++) {
            t[i] = -1;
        }

        double result = myPowHelper(x, Math.abs(n), t);
        if (n < 0) {
            return 1 / result;
        } else {
            return result;
        }


    }

    public static double myPowHelper(double x, int n, double[] t) {
        if (x == 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }

        if (t[n] != -1) {
            return t[n];
        }

        // hypothesis and induction
        return t[n] = x * myPowHelper(x, n - 1, t);

    }

    public static double myPower(double x, int m) {
        double temp = x;
        if (m == 0)
            return 1;
        temp = myPower(x, m / 2);
        if (m % 2 == 0)
            return temp * temp;
        else {
            if (m > 0)
                return x * temp * temp;
            else
                return (temp * temp) / x;
        }
    }


    public static void main(String[] args) {
        int n = -3;
        int x = -4;

        System.out.println(myPower(x, n));
    }
}
