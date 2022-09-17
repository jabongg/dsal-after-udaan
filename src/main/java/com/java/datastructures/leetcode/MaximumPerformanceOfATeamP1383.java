package com.java.datastructures.leetcode;

import java.util.*;

/**
 * Problem Statement : Description :
 * You are given two integers n and k and two integer arrays speed and efficiency both of length n. There are n engineers numbered from 1 to n. speed[i] and efficiency[i] represent the speed and efficiency of the ith engineer respectively.
 * <p>
 * Choose at most k different engineers out of the n engineers to form a team with the maximum performance.
 * <p>
 * The performance of a team is the sum of their engineers' speeds multiplied by the minimum efficiency among their engineers.
 * <p>
 * Return the maximum performance of this team. Since the answer can be a huge number, return it modulo 109 + 7.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 6, speed = [2,10,3,1,5,8], efficiency = [5,4,3,9,7,2], k = 2
 * Output: 60
 * Explanation:
 * We have the maximum performance of the team by selecting engineer 2 (with speed=10 and efficiency=4) and engineer 5 (with speed=5 and efficiency=7). That is, performance = (10 + 5) * min(4, 7) = 60.
 * <p>
 * Example 2:
 * <p>
 * Input: n = 6, speed = [2,10,3,1,5,8], efficiency = [5,4,3,9,7,2], k = 3
 * Output: 68
 * Explanation:
 * This is the same example as the first but k = 3. We can select engineer 1, engineer 2 and engineer 5 to get the maximum performance of the team. That is, performance = (2 + 10 + 5) * min(5, 4, 7) = 68.
 * <p>
 * Example 3:
 * <p>
 * Input: n = 6, speed = [2,10,3,1,5,8], efficiency = [5,4,3,9,7,2], k = 4
 * Output: 72
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= k <= n <= 105
 * speed.length == n
 * efficiency.length == n
 * 1 <= speed[i] <= 105
 * 1 <= efficiency[i] <= 108
 */
public class MaximumPerformanceOfATeamP1383 {
    public static int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        long mod = (long) 1e9 + 7;
        int[][] engineers = new int[n][2]; // for respective speed and efficiency
        for (int i = 0; i < n; i++) {
            engineers[i][0] = speed[i];             // speed we be at 0 position
            engineers[i][1] = efficiency[i]; // then efficiency will at 1 position
        }


        // If we took n engineers then efficiency will be minimum we took from n engineers.
        // We need effieciency in decreasing order beacuse we need min efiiency
        print(engineers);
        Arrays.sort(engineers, (a, b) -> b[1] - a[1]);  // decreasing order so, b is before a
        print(engineers);

        // Now we will take PQ and store speed in it if elemnt grater then K then we will remove element from pq beacuse we need to take max speed so we took min heap.

        long sum = 0;
        long maxperformance = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // we need to remove min speed engineer so any engineer have less speed will be remove
        for (int i = 0; i < n; i++) {
            sum += engineers[i][0];
            pq.offer(engineers[i][0]);
            if (pq.size() > k) {
                sum -= pq.poll();
            }
            maxperformance = Math.max(maxperformance, sum * engineers[i][1]);
        }

        return (int) (maxperformance % mod);

    }

    public static void main(String[] args) {
        //Input: n = 6, speed = [2,10,3,1,5,8], efficiency = [5,4,3,9,7,2], k = 3
        // * Output: 68

        int n = 6;
        int[] speed = {2, 10, 3, 1, 5, 8};
        int[] efficiency = {5, 4, 3, 9, 7, 2};
        int k = 3;


        System.out.println("max performance of " + k + " engineers = " + maxPerformanceCalculation(n, speed, efficiency, k));
    }

    public static void print(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                System.out.println(A[i][j]);
            }
        }
    }


    static class Engineer {
        int speed;
        int efficiency;

        public Engineer(int speed, int efficiency) {
            this.speed = speed;
            this.efficiency = efficiency;
        }

        public int getSpeed() {
            return speed;
        }

        public int getEfficiency() {
            return efficiency;
        }
    }

    public static int maxPerformanceCalculation(int n, int[] speed, int[] efficiency, int k) {
        long mod = (long) 1e9 + 7;
        List<Engineer> engineers = new ArrayList<>(); // for respective speed and efficiency

        for (int i = 0; i < n; i++) {
            Engineer engineer = new Engineer(speed[i], efficiency[i]);
            engineers.add(engineer);
        }


        // If we took n engineers then efficiency will be minimum we took from n engineers.
        // We need efficiency in decreasing order beacuse we need min efficiency
        Collections.sort(engineers, Comparator.comparing(Engineer::getEfficiency).reversed());

        // Now we will take PQ and store speed in it if elemnt grater then K then we will remove element from pq beacuse we need to take max speed so we took min heap.

        long sum = 0;
        long maxperformance = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // we need to remove min speed engineer so any engineer have less speed will be remove
        for (int i = 0; i < n; i++) {
            int currEngineerSpeed = engineers.get(i).getSpeed();
            int currEngineerEfficiency = engineers.get(i).getEfficiency();
            sum += currEngineerSpeed;
            pq.offer(currEngineerSpeed);
            if (pq.size() > k) {
                sum -= pq.poll();
            }
            maxperformance = Math.max(maxperformance, sum * currEngineerEfficiency); // since efficiency is already in decreasing order
        }

        return (int) (maxperformance % mod);

    }

}