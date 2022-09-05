package com.java.datastructures.array;

public class MinJumpToReachTheEnd {

    public static void main(String[] args) {
        int[] A = {2, 3, 1, 1, 2, 4, 2, 0, 1, 1};

        int n = A.length;
       // int minJump = calculateMinJumpToReachTheEnd(A, n);
       // System.out.println(minJump);


        int arr[] = new int[]{1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};

        // calling minJumps method
        System.out.println(minJumps(arr));

    }

    private static int calculateMinJumpToReachTheEnd(int[] A, int n) {
        // edge case
        if (A[0] == 0) {
            return -1; // not possible to reach the end
        }

        if (A[0] > A.length) {
            return 1; // because it can jump directly with max steps and go outside of the array.
        }


        int jumpCount = 0;
        int minJump = Integer.MAX_VALUE;

        // now general scenario
        int jump = A[0]; // max steps at a time...jump
        int steps = jump;

        // one variable to maintain if the current index is greater than the array size or not.

        while (steps > 0) {
            if (steps > A.length) {
                jumpCount++; // because it can jump directly with max steps and go outside of the array.
                return jumpCount;
            }

            // if any element is found to be zero and j != A.length - 1;// not reached to end
            if (A[steps] != 0) {
                jumpCount++;
                steps = A[steps];
            }
        }

        jumpCount++; // increasing as it is already reached to the end.

        minJump = Math.min(minJump, jumpCount);
        return jumpCount;
    }

    static int minJumps(int arr[]) {
        if (arr.length <= 1)
            return 0;

        // Return -1 if not possible to jump
        if (arr[0] == 0)
            return -1;

        // initialization
        int maxReach = arr[0];
        int step = arr[0];
        int jump = 1;

        // Start traversing array
        for (int i = 1; i < arr.length; i++) {
            // Check if we have reached the end of the array
            if (i == arr.length - 1)
                return jump;

            // updating maxReach
            maxReach = Math.max(maxReach, i + arr[i]);

            // we use a step to get to the current index
            step--;

            // If no further steps left
            if (step == 0) {
                // we must have used a jump
                jump++;

                // Check if the current index/position or lesser index is the maximum reach point from the previous indexes
                if (i >= maxReach)
                    return -1;

                // re-initialize the steps to the amount of steps to reach maxReach from position i.
                step = maxReach - i;
            }
        }

        return -1;
    }

}

