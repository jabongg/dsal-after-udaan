package com.java.datastrudtures.leetcode;

public class FirstAndLastPositionP34 {
    public static int[] searchRange(int[] nums, int target) {

        //using binary search

        return findIndicesStartAndEnd(nums, target);

    }

    public static int[] findIndices(int[] nums, int target) {

        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;

        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] == target) {

                int i = mid;
                // move to left till you find different num
                while (i >= 0) {
                    if (nums[i] != target) {
                        result[0] = i + 1;
                        break;
                    }
                    i--;
                }

                int j = mid;

                while (j <= nums.length - 1) {
                    if (nums[j] != target) {
                        result[1] = j - 1;
                        break;
                    }
                    j++;
                }

                // similarly, move to right till you find different num

            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }

            if (result[0] != -1 && result[1] != -1) {
                break;
            }
        }

        return result;

    }



    public static int[] findIndicesStartAndEnd(int[] nums, int target) {

        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;

        int l = 0;
        int r = nums.length - 1;

        // iterate for starting index
        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] == target) {
                result[0] = mid;  // storing mid.. it will update everytime it will see a target.
                r = mid - 1; // moving to left
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        // iterate for starting index
        // reinitializing indices
        l = 0;
        r = nums.length -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] == target) {
                result[1] = mid;  // storing mid.. it will update everytime it will see a target.
                l = mid + 1; // moving to left
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return result;

    }

    public static void main(String[] args) {
        int[] A = {5,7,7,8,8,10};
        int target = 8;

        int[] result = searchRange(A, target);
        System.out.println(result[0] + " " + result[1]);


    }
}