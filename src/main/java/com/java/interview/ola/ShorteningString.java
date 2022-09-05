package com.java.interview.ola;

import java.util.HashSet;
import java.util.Set;

/**
 * Aon Test taken at August 30, 2022
 * given string
 * input : str ="zaaabccbaddd"
 * output : zd
 * <p>
 * all the consecutive characters will be deleted.
 * zaaabccbaddd     -> z(aa)ab(cc)ba(dd)d       -> za(bb)ad       -> z(aa)d       -> zd
 * these pairs will be deleted
 * <p>
 * <p>
 * <p>
 * https://www.geeksforgeeks.org/recursively-remove-adjacent-duplicates-given-string/?ref=lbp
 */
public class ShorteningString {
    // Driver Code
    public static void main(String[] args) {
        String str1 = "mississipie";
        System.out.println(str1 + " ->  " + removeConsecutiveChars(str1));
        String str2 = "ocvvcolop";
        System.out.println(str2 + " ->  " + removeConsecutiveChars(str2));
        String str3 = "zaaabccbaddd";
        System.out.println(str3 + " ->  " + removeConsecutiveChars(str3));
    }

    // taking global variable for comparison, so that while loop can stop
    static int receivedStringSize;
    static int passedStringSize;

    public static String removeConsecutiveChars(String str) {
        if (str.length() == 0 || str.length() == 1) return str;

        String removeDup = removeDuplicate(str);
        receivedStringSize = removeDup.length();

        while (passedStringSize != receivedStringSize) {
            removeDup = removeDuplicate(removeDup);
            receivedStringSize = removeDup.length();
        }

        //System.out.println(removeDup);
        return removeDup;
    }

    public static String removeDuplicate(String str) {
        passedStringSize = str.length();
        StringBuilder stringBuilder = new StringBuilder(str);
        //System.out.println(stringBuilder);

        int i = 0;
        int sbLength = stringBuilder.length();
        while (i < sbLength - 1) {
            if (stringBuilder.charAt(i) == stringBuilder.charAt(i + 1)) {
                stringBuilder.deleteCharAt(i + 1);
                stringBuilder.deleteCharAt(i); // start -> inclusive :: end ->exclusive
               sbLength = sbLength - 2;
            } else {
                i++;
            }
        }

        //System.out.println(stringBuilder);
        return String.valueOf(stringBuilder);
    }
}

