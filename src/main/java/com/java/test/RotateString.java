package com.java.test;

import java.util.LinkedList;
import java.util.Queue;

public class RotateString {

    public static void main(String[] args) {
        String s = "abcdef"; //large case
        int n = 1; // large case
        Queue<Character> q = rotate(s, n);
        //System.out.println(q);


        while (!q.isEmpty())
            System.out.print(q.poll());

    }

    public static Queue<Character> rotate(String s, int n) {
        Queue<Character> q = new LinkedList<>();

        // filling the queue
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            q.offer(ch);
        }

        int leastRotation = n % s.length();

        for (int k = 0; k < leastRotation; k++) {
            char polledChar = q.poll();
            q.offer(polledChar);
        }

        return q;
    }
}
