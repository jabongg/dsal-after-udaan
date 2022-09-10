package com.java.datastructures.array;

public class PairWithTargetSum {
    // TODO: Write your code here

    public static int[] search(int[] arr, int targetSum) {
        int[] indexPair = {-1, -1};
        int i = 0;
        int j = arr.length - 1;

        while (i < j) {
            if (arr[i] + arr[j] == targetSum) {
                arr[0] = i;
                arr[1] = j;
                break;
            } else if (arr[i] + arr[j] < targetSum) {
                i++;
            } else {
                j--;
            }
        }
        return indexPair;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 6};
        int target = 6;
        System.out.println(search(arr, target));
    }
}
