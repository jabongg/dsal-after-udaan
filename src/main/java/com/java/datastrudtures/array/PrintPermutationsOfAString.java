package com.java.datastrudtures.array;

public class PrintPermutationsOfAString {

    public static void main(String[] args) {
        String s = "ABC";
        printPermutations(s);
    }

    private static void printPermutations(String s) {
        printPermutationsHelper(s, "");        // helper method for printing permutation
    }

    private static void printPermutationsHelper(String s, String ans) {

        // base condition for recurusion to stop;
        if (s.length() == 0) {
            System.out.print(ans + " "); // empty string
            return;
        }


        for (int i = 0; i < s.length(); i++) {
            // capture the current character
            char ch = s.charAt(i);

            // capture rest of the strings
            String restOfTheString = s.substring(0, i) + s.substring(i + 1); // excluding charAt(i)


            // call recursively
            printPermutationsHelper(restOfTheString, ans + ch);
        }

    }
}
