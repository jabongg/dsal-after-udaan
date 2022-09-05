package com.java.datastructures.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
// |--------|
//     |---------|


//. |--------|
//.            |--------|

 */
public class MergeIntervalsP56 {
    public static int[][] merge(int[][] intervals) {

        if (intervals.length <= 1) return intervals;

        // otherwise sort the interval on basis of start index using comparator.
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        List<int[]> outputList = new ArrayList<>();
        int[] currInterval = intervals[0];
        outputList.add(currInterval);

        for (int[] intrvl : intervals) {
            int currBegin = currInterval[0];
            int currEnd = currInterval[1];
            int nextBegin = intrvl[0];
            int nextEnd = intrvl[1];


            if (currEnd >= nextBegin) {
                currInterval[1] = Math.max(currEnd, nextEnd);
            } else {
                currInterval = intrvl;
                outputList.add(currInterval);
            }
        }
        return outputList.toArray(new int[outputList.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{2, 3}, {2, 2}, {3, 3}, {1, 3}, {5, 7}, {2, 2}, {4, 6}};  //[[2,3],[2,2],[3,3],[1,3],[5,7],[2,2],[4,6]]
        int[][] mergedIntervals = merge(intervals);

        for (int i = 0; i < mergedIntervals.length; i++) {
            System.out.println("[" + mergedIntervals[i] + "]");

        }

    }
}
