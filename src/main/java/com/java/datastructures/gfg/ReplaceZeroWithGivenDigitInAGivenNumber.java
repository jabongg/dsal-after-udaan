package com.java.datastructures.gfg;

/**
 * Given an integer as input and replace all the ‘0’ with ‘5’ in the integer.
 *
 * Examples:
 *
 * Input: 102
 * Output: 152
 * Explanation: All the digits which are '0' is replaced by '5'
 */
public class ReplaceZeroWithGivenDigitInAGivenNumber {
    public static void main(String[] args) {
        int number = 1020080345;
        int toBeReplacedDigit = 0;
        int replacingDigit = 5;
        int replacedNumber = replace(number, toBeReplacedDigit, replacingDigit);
        System.out.println(replacedNumber);
    }

    private static int replace(int number, int toBeReplacedDigit, int replacingDigit) {
        int replacedNumber = 0;
        int index = 0;
        while (number > 0) {
            int digit = number % 10;
            number = number / 10;
            if (digit == toBeReplacedDigit) {
                replacedNumber = replacedNumber + replacingDigit * (int) Math.pow(10, index);
            } else {
                replacedNumber = replacedNumber + digit * (int) Math.pow(10, index);
            }
            index++;
        }

        return replacedNumber;
    }
}
