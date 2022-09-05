package com.java.interview.tatadigital;

public class PieEuler {
    public static void main(String[] args) {

        /*
         * formula  pie * pie / 6 = 1/1^2 + 1/2^2 + 1/3^2 +....... + 1/N^2 <= series S
         * pie * pie = 6 (S)
         *             ________
         * pie =    ./ 6 * (S)
         */

        int S = 0; // for sum
        double pie = 0;
        int N = 1000; // N iterations

        for (int i = 1; i <= N; i++) {
            S = S + 1 / (i * i);
        }

        pie = Math.sqrt(6 * S);
        System.out.println("\uD835\uDF0B : " + "𝜋 :" + pie); //𝜋
    }
}
