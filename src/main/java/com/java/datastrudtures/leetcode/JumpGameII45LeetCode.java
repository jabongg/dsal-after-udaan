package com.java.datastrudtures.leetcode;

import java.util.Arrays;
import java.util.Vector;

public class JumpGameII45LeetCode {
    public static int jump(int[] nums) {
        return jumpHelper(nums, nums.length);
    }


    public static int jumpHelper(int[] nums, int n) {
        // for memoization
        int[] jumps = new int[n];

        if (n == 0 || nums[0] == 0) {
            return 0;
        } // end cannot be reached

        jumps[0] = 0;

        // Find the minimum number of jumps to reach arr[i]
        // from arr[0], and assign this value to jumps[i]
        for (int i = 1; i < n; i++) {
            jumps[i] = Integer.MAX_VALUE;

            for (int j = 0; j < i; j++) {
                if ((i <= j + nums[j]) && (jumps[j] != Integer.MAX_VALUE)) {
                    jumps[i] = Math.min(jumps[i], jumps[j] + 1);
                    break;
                }
            }
        }
        return jumps[n - 1];
    }



    public static boolean possibleToJump(Vector<Integer> nums, int jump) {
        int count = 0;
        int curMaxIndex = 0;
        int nextMaxIndex = 0;

        for (int i = 0; i < nums.size() - 1; i++) {
            nextMaxIndex = Math.max(nextMaxIndex, i + nums.get(i));
            if (i == curMaxIndex) {
                ++count;
                curMaxIndex = nextMaxIndex;
            }
        }

        return count <= jump;
    }

    public static int jump(Vector<Integer> nums) {
        // minimum possible jump = 0
        int lo = 0;
        // maximum possible jump is n-1
        int hi = nums.size() - 1;
        int ans = 0;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            // if we can reach with mid number of jumps then also possible with mid+1, mid+2....
            // so this is our one of the ans and search for optimise one
            // hence hi = mid-1;

            // if not possible to reach end with mid jump so not possible with mid-1, mid-2...
            // so lo = mid+1
            if (possibleToJump(nums, mid)) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return ans;

    }

    // driver program to test above function
    public static void main(String[] args) {
        int arr[] = {1, 0, 6, 1, 0, 9};

//        System.out.println("Minimum number of jumps to reach end is : "
//                + jump(arr));

        Vector<Integer> vector = new Vector<>();
        for (Integer el: arr) {
            vector.add(el);
        }

        System.out.println("Minimum number of jumps to reach end is : "
                + jumpMin(vector));;
    }

    //O(n) solution
    public static int jumpMin(Vector<Integer> vector) { //   vector[] : {1, 3, 0, 0, 0, 9};
        int l = vector.size();
        int jumps = 0;

        int maxCovered = 0;
        int currentMaxCovered = 0;

        for (int i = 0; i < l - 1; i++) {
            maxCovered = Math.max(maxCovered, i + vector.get(i));

            if (i == currentMaxCovered) {
                currentMaxCovered = maxCovered;
                jumps += 1;
            }
        }
        return jumps;
    }

    /**
     *  def jump(self, nums: List[int]) -> int:
     *
     *         l = len(nums)
     *         jumps = 0
     *         maxCovered = 0
     *         currentMaxCovered = 0
     *         for i in range(l-1):
     *             maxCovered = max(maxCovered, nums[i]+i)
     *             if i == currentMaxCovered:
     *                 currentMaxCovered = maxCovered
     *                 jumps+=1
     *
     *         return jumps
     */
}