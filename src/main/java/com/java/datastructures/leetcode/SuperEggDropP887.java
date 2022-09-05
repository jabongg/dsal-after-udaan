package com.java.datastructures.leetcode;

public class SuperEggDropP887 {
    public static int superEggDrop(int e, int f) {
        int[][] t = new int[e + 1][f + 1];  // memoization table

        for (int i = 0; i < t.length; i++) { // we could have used e and f
            for (int j = 0; j < t[0].length; j++) {
                t[i][j] = -1; // for identification
            }
        }

        if (f == 0 || f == 1) return f;
        if (e == 1) return f;

        if (t[e][f] != -1)
            return t[e][f];

        int min = Integer.MAX_VALUE;
        // MCM pattern
        for (int k = 1; k <= f; k++) {
            // floor choice diagram

            int temp = 1 + Math.max(superEggDrop(e - 1, k - 1), superEggDrop(e, f - k)); // choosing max for worst case scenario

            min = Math.min(min, temp);
        }

        return t[e][f] = min;
    }

    //drive method
    public static void main(String[] args) {
        int floor = 25;
        int eggs = 3;

        System.out.println(superEggDrop(eggs, floor));
    }
}
