package com.java.datastructures.array;

import java.util.HashMap;
import java.util.Map;

public class FindPairSum {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 9, 10};
        int sum = 10;
        findSumPairsHashing(A, sum);
    }

    private static void findSumPairsHashing(int[] A, int sum) {
        Map<Integer, Integer> map = new HashMap<>(); // hashmap to store the values and check if sum-element is present in hashmap or not.

        for (int el : A) {

            if (!map.containsKey(sum - el)) {
                map.put(el, 1);
            } else {
                System.out.println(el + " " + (sum - el));
                //map.getOrDefault()
                //break; // if we want only one pair
            }
        }
    }


    private static void findSumPairs(int[] A, int sum) {
        int i = 0;
        int j = A.length - 1;

        // i'll check for each i and j till i < j

        while (i < j) { //

            if (A[i] + A[j] < sum) {
                i++; // then increment i index
            } else if (A[i] + A[j] > sum) {
                j--;
            } else {

                Pair pair = new Pair(A[i], A[j]);
                System.out.println("pair is : " + pair);
                return; // break is important otherwise it will end up to an infinite loop;
            }
        }
        System.out.println("pair not found");
        return;
    }


    static class Pair {
        int element1;
        int element2;

        public Pair(int element1, int element2) {
            this.element1 = element1;
            this.element2 = element2;
        }

        public int getElement1() {
            return element1;
        }

        public int getElement2() {
            return element2;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "element1=" + element1 +
                    ", element2=" + element2 +
                    '}';
        }
    }
}
