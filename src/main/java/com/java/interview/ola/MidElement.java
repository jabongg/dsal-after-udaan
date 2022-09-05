package com.java.interview.ola;

import java.util.ArrayList;
import java.util.List;

/** Aon Test taken at August 30, 2022
 * ignore all negative numbers and then print the mid element of the new array of positive numbers.
 * Its guaranteed that there will always be at least one positive number
 * // order should be maintained as the original array.
 * // in case of 2 mid element, pick the element with lower index.
 */
public class MidElement {
    private static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        int[] A = {-24, 2, 3, -34, -9, 14, 7, 90};

        printMidElement(A);
    }

    private static void printMidElement(int[] A) {
        for (int i = 0; i < A.length; i++) {
            if (A[i] > 0) {
                list.add(A[i]);
            }
        }
        // mid element
        int mid = 0 + (list.size() - 1 - 0)  / 2;
        System.out.print(list.get(mid));
    }
}
