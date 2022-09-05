package com.java.datastructures.array;


/**
 * Reverse a string without affecting special characters
 * <p>
 * Input:   str = "a,b$c"
 * Output:  str = "c,b$a"
 * <p>
 * <p>
 * Input:   str = "Ab,c,de!$"
 * Output:  str = "ed,c,bA!$"
 */
public class ReverseStringWithoutAffectingSpecialChars {
    public static void main(String[] args) {

        String str = "a!!!!!!!y!m!bhi";
        System.out.println("input: " + str);
        reverseStringWithoutAffectingSpecialCharacters(str);
    }

    private static void reverseStringWithoutAffectingSpecialChars(String str) {
        // to store the special chars at their proper position in first iteration
        char[] specialCharsAtPlace = new char[str.length()];  // O(n) space

        //O(n) time
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isAlphabetic(str.charAt(i))) {
                specialCharsAtPlace[i] = str.charAt(i);
            }
        }

        int l = 0; // filling the new array from beginning
        int r = str.length() - 1; // for iterating original string from end

        // O(n) space and time
        while (r >= 0) {
            if (!Character.isAlphabetic(str.charAt(r))) {
                r--;
            } else if (!Character.isAlphabetic(str.charAt(l))) {
                l++;
            } else {
                specialCharsAtPlace[l] = str.charAt(r);
                l++;
                r--;
            }
        }

       // checkSpecialChars(str.charAt());
        System.out.print("output: ");
        print(specialCharsAtPlace);

    }


    private static void reverseStringWithoutAffectingSpecialCharacters(String str) {
        // to store the special chars at their proper position in first iteration
        char[] specialCharsAtPlace = new char[str.length()];  // O(n) space

        //O(n) time
        for (int i = 0; i < str.length(); i++) {
            if (isSpecialChar(str.charAt(i))) {
                specialCharsAtPlace[i] = str.charAt(i);
            }
        }

        int l = 0; // filling the new array from beginning
        int r = str.length() - 1; // for iterating original string from end

        // O(n) space and time
        while (r >= 0) {
            if (isSpecialChar(str.charAt(r))) {
                r--;
            } else if (isSpecialChar(str.charAt(l))) {
                l++;
            } else {
                specialCharsAtPlace[l] = str.charAt(r);
                l++;
                r--;
            }
        }

        // checkSpecialChars(str.charAt());
        System.out.print("output: ");
        print(specialCharsAtPlace);

    }
    private static boolean isSpecialChar(char ch) {
        if ((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
            return false;
        }
        return true;
    }

    public static void print(char[] A) {
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i]);
        }
    }
}
