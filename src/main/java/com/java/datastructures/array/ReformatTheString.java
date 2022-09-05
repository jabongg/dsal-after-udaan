package com.java.datastructures.array;

/*
    you are given an alphanumeric string s.  You have to find a permutation of the string where no letter is followed by another letter and no digit is followed by another digit.
    i.e. no two adjecent charaters have the same typ.

    Return the reformatted string or return an empty string, if it is impossible to reformat the string.

    Input :  "a0b1c2"
    output: "0a1b2c"
 */
public class ReformatTheString {
    public static void main(String[] args) {
        String s = "a0b1c22nj";

        System.out.println(reformatTheString(s));
    }

    private static String reformatTheString(String s) {
        char[] sample = s.toCharArray();

        char[] digit = new char[s.length()];
        char[] alphabet = new char[s.length()];

        int j = 0, k = 0;
        int digitCount = 0;
        int alphabetCount = 0;

        for (int i = 0; i < s.length(); i++) {
            if (sample[i] >= 97 && sample[i] <= 122) {
                alphabet[j++] = sample[i];
                alphabetCount++;
            } else if (sample[i] >= 48 && sample[i] <= 57) {
                digit[k++] = sample[i];
                digitCount++;
            }
        }

        System.out.println("digitCount=" + digitCount);
        System.out.println("alphabetCount=" + alphabetCount);

        // append the null charecter at the end of both the arrays
        alphabet[j++] = '\0'; // ['a', 'b', 'c', '\0']
        digit[k++] = '\0'; // ['1', '2', 'e', '\0']

        // check if reformatting is possible or not.
        if (Math.abs(digitCount - alphabetCount) > 1) {
            return ""; // return empty string.
        }

        //otherwise merge both the arrays and return the permutated string.
        char[] result = new char[digitCount + alphabetCount];
        int resultIndex = 0;
        int alphabetIndex = 0;
        int digitIndex = 0;

        // iterate through both the arrays one by one and merge it.
        // start with the array with 'greater' length

        boolean flag = digitCount > alphabetCount ? true : false;

        for (int i = 0; i < s.length(); i++) {
            if (flag) {
                result[resultIndex++] = digit[digitIndex++];
            } else {
                result[resultIndex++] = alphabet[alphabetIndex++];
            }
            flag = !flag;
        }

//        while (alphabetIndex != alphabetCount && digitIndex != digitCount) {
//            if (digitCount > alphabetCount) { // order is important here.
//                result[resultIndex++] = digit[digitIndex++];
//                result[resultIndex++] = alphabet[alphabetIndex++];
//            } else {
//                result[resultIndex++] = alphabet[alphabetIndex++];
//                result[resultIndex++] = digit[digitIndex++];
//            }
//        }
//
//        // now check if larger array is exhausted or not
//        if (alphabetIndex != alphabetCount) {
//            result[resultIndex++] = alphabet[alphabetIndex++];
//        } else if (digitIndex != digitCount) {
//            result[resultIndex++] = digit[digitIndex++];
//        }


        return String.valueOf(result);
    }

}