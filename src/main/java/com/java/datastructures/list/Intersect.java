package com.java.datastructures.list;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Vector;

// Time: O(N) where N is the length of the larger array
// Space: O(N)

public class Intersect {
    public int[] intersect(int[] nums1, int[] nums2) {
        // This makes sure that nums1 is always the bigger array
        if (nums1.length > nums2.length) {
            return this.intersect(nums2, nums1);
        }

        // Hashmap to keep track of elements in nums1 and the amount of time they occur
        HashMap<Integer, Integer> countMap = new HashMap<>();
        // Put element into Hashmap
        for (int num : nums1) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // Write ptr to keep track of all the element we wrote in to output
        int wp = 0;

        // Go through nums2 and add the element that are intersected
        for (int num : nums2) {
            if (countMap.containsKey(num)) {
                int count = countMap.get(num);
                if (count > 0) {
                    nums1[wp] = num;
                    wp++;
                    count--;
                    countMap.put(num, count);
                }
            }
        }

        return Arrays.copyOfRange(nums1, 0, wp);
    }


    public int[] intersect2(int[] nums1, int[] nums2) {

        // vector to store the result
        Vector<Integer> v = new Vector<>();

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int n1 = nums1.length;
        int n2 = nums2.length;

        int i = 0;
        int j = 0;

        while (i < n1 && j < n2) {
            if (nums1[i] == nums2[j]) {
                v.add(nums1[i]);
                i++;
                j++;

            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        int[] result = new int[v.size()];

        for (int k = 0; k < v.size(); k++) {
            result[k] = v.get(k);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 9, 1, 6, 2, 9};
        int[] nums2 = {2, 9, 5, 2, 9};
//        int[] resultArray = new Intersect().intersect(nums1, nums2);
//        for (int el : resultArray) {
//            System.out.print(el + " ");
//        }

        int[] resultArray2 = new Intersect().intersect2(nums1, nums2);
        for (int el : resultArray2) {
            System.out.print(el + " ");
        }

    }
}
