package com.java.interview.tatadigital;

import java.util.Arrays;

public class MagicNumber {
    // This function checks validity of kaprekar's
// constant. It returns kaprekar's constant for
// any four digit number "n" such that all digits
// of n are not same.
    static int kaprekarRec(int n, int prev) {
        if (n == 0)
            return 0;

        // Store current n as previous number
        prev = n;

        // Get four digits of given number
        int[] digits = new int[4];
        for (int i = 0; i < 4; i++) {
            digits[i] = n % 10;
            n = n / 10;
        }

        // Sort all four digits in ascending order
        // And giet in the form of number "asc"
        Arrays.sort(digits);
        int asc = 0;
        for (int i = 0; i < 4; i++)
            asc = asc * 10 + digits[i];
        System.out.println("asc : " + asc);

        // Get all four digits in descending order
        // in the form of number "desc"
        Arrays.sort(digits);
        int desc = 0;
        for (int i = 3; i >= 0; i--)
            desc = desc * 10 + digits[i];

        System.out.println("desc : " + desc);
        // Get the difference of two numbers
        int diff = Math.abs(asc - desc);

        // If difference is same as previous, we have
        // reached kaprekar's constant
        if (diff == prev)
            return diff;

        // Else recur
        return kaprekarRec(diff, prev);
    }

    // A wrapper over kaprekarRec()
    static int kaprekar(int n) {
        int prev = 0;
        return kaprekarRec(n, prev);
    }

    // Driver code
    public static void main(String[] args) {
        // Trying few four digit numbers, we
        // always get 6174
        System.out.println(kaprekar(1000));
        System.out.println(kaprekar(1112));
        System.out.println(kaprekar(9812));
    }
}
