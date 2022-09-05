package com.java.datastructures.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NextGreaterElement {
    /* prints element and NGE pair for
     all elements of arr[] of size n */
    static void printNGE(int arr[], int n) {
        int next, i, j;
        for (i = 0; i < n; i++) {
            next = -1;
            for (j = i + 1; j < n; j++) {
                if (arr[i] < arr[j]) {
                    next = arr[j];
                    break;
                }
            }
            System.out.println(arr[i] + " -- " + next);
        }
    }

    public static void main(String args[]) {
        int arr[] = {11, 13, 21, 3};
        int n = arr.length;
        printNGEStack(arr, n);
    }

    public static void printNGEStack(int arr[], int n) {
        List<Integer> solution = new ArrayList<>();
        Stack<Integer> s = new Stack<>();

        for (int i = n - 1; i >= n; i--) {
            if (s.isEmpty()) {
                solution.add(-1);
            } else if (s.peek() > arr[i] && s.peek() > arr[i]) {
                solution.add(s.peek());
                i--;
            } else if (s.peek() <= arr[i] && s.size() > 0) {
                while (s.peek() < arr[i] && !s.isEmpty()) {
                    s.pop();
                }

                if (s.isEmpty()) {
                    solution.add(-1);
                } else {
                    solution.add(s.peek());
                }
            }

            s.push(arr[i]);
            i--;

        }
    }
}