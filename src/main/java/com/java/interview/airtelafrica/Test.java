package com.java.interview.airtelafrica;

import java.util.ArrayList;
import java.util.Stack;

public class Test {

    public static void main(String[] args) {
        // A 0 2 11 9  5 7 upcoming greater element for all -1
        
        // variable to store the next greater element at any time O(1)
        Stack<Integer> listUpcomingGreater = new Stack<>();
        
        int[] A = {0, 2, 11, 9, 5, 7};

        for (int i = 0; i < A.length; i++) {
            listUpcomingGreater.push(A[i]); //0

            if (listUpcomingGreater.peek() > A[i]) {
                //
            }
        }

        extracted(A);
    }

    private static void extracted(int[] A) {
        int[] upcomingGrtrEl = upcomingGrtrEl(A);


        for (int i = 0; i < upcomingGrtrEl.length; i++) {
            if (upcomingGrtrEl[i] == 0) {
                upcomingGrtrEl[i] = -1;
            }
        }


        print(upcomingGrtrEl);
    }

    private static int[] upcomingGrtrEl(int[] A) {
        int[] upcomingGrtrEl = new int[A.length];
        for (int i = 0; i < A.length - 1; i++) {
            for (int j = i + 1; j < A.length; j++) {
                if (A[i] < A[j]) {
                    upcomingGrtrEl[i] = A[j];
                    break;
                }
            }
        }
        return upcomingGrtrEl;
    }

    private static void print(int[] A) {
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + " ");
        }
    }

}
