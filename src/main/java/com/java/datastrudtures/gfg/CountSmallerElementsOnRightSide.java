package com.java.datastrudtures.gfg;

/*
Write a function to count number of smaller elements on right of each element in an array. Given an unsorted array arr[] of distinct integers, construct another array countSmaller[] such that countSmaller[i] contains count of smaller elements on right side of each element arr[i] in array.

Examples:

Input:   arr[] =  {12, 1, 2, 3, 0, 11, 4}
Output:  countSmaller[]  =  {6, 1, 1, 1, 0, 1, 0}
 */
public class CountSmallerElementsOnRightSide {


    public static void main(String[] args) {
        int arr[] =  {12, 1, 2, 3, 0, 11, 4};
        //int[] arr = {5, 4, 3, 2, 1};
        int countSmaller[] = new int[arr.length];

        countSmallerElementsOnRightSide(arr, countSmaller);
    }

    // O(N2)
    private static void countSmallerElementsOnRightSide(int[] arr, int[] countSmaller) {
        for (int i = 0; i < arr.length - 1; i++) {
            countSmaller[i] = 0;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    countSmaller[i]++;
                }
            }
        }

        printArray(countSmaller);
    }

    private static void printArray(int[] countSmaller) {
        for (int el: countSmaller ) {
            System.out.print(el + " ");
        }


    }
}
