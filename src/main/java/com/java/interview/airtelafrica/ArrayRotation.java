package com.java.interview.airtelafrica;

import java.util.*;

public class ArrayRotation {
    public static void main(String[] args) {
        Deque<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);


        int[] A = {1, 2, 3, 4, 5};
        int k = 3; //

        rotateList(list, k);

        //rotateArray(A, k);

        print(A);
    }

    private static void rotateList( Deque<Integer> list, int k) {
        // add the list
        for (int i = 0; i < list.size(); i++) {

        }
        // delete
    }

    private static void rotateArray(int[] A, int k) {
        // dry run
        for (int j = 0; j < k; j++) {
            int temp = A[A.length - 1]; //o(1)
            for (int i = A.length - 1; i > 0; i--) {
                // move to the right.
                //int temp = list.get(list.size() - 1);
                //list.get(i) =

                // store before owerriting the value
                A[i] = A[i - 1];
            }

            A[0] = temp;
        }
    }

    public static void print(int[] A) {
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + " ");
        }
    }
}
