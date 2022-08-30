package com.java.interview.ola;

import java.util.ArrayList;
import java.util.List;

/**
 *          void perm(String str){
 *             perm(str, “”);
 *          }
 *
 *          void perm(String str, String prefix){
 *              if(str.length() == 0){
 *                  System.out.println(prefix);
 *              } else{
 *                for(int i = 0; i < str.length(); i++){
 *                    String rem = str.substring(0, i) +
 *                                  str.substring(i + 1);
 *                    perm(rem, prefix + str.charAt(i));
 *                }
 *             }
 *          }
 */
public class PrintPermutations {

    private static List<String> permutations = new ArrayList<>();
    public static void main(String[] args) {
        String str = "ABCD";

        printPermutations(str);
        System.out.println(permutations);
    }

    private static void printPermutations(String str) {
        printPermutationsHelper(str, ""); // string and prefix
    }

    private static void printPermutationsHelper(String str, String prefix) {
        if (str.length() == 0) {
            //System.out.println(prefix);
            permutations.add(prefix);
        } else {
            for (int i = 0; i < str.length(); i++) {
                String remaining = str.substring(0, i) + str.substring(i + 1);
                printPermutationsHelper(remaining, prefix + str.charAt(i));
            }
        }
    }
}
