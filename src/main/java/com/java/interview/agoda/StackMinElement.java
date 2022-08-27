package com.java.interview.agoda;

// find minimum element of stack O(1) time.
//Leetcode 155. Min Stack

import java.util.Stack;

public class StackMinElement {
    Stack s;
    Stack t;

    public StackMinElement() {
        s = new Stack<>();  // for tracking elements which are being pushed
        t = new Stack<>();  // for tracking min at any time
    }

    public void push(int val) {
        s.push(val);
        int min = (t.isEmpty() ||  val < (int) t.peek()) ? val : (int) t.peek(); // casting is necessary
        t.push(min);
    }

    public void pop() {
        s.pop();
        t.pop();
    }

    public int top() {
        return (int) s.peek();
    }

    public int getMin() {
        return (int) t.peek();
    }

    public static void main(String[] args) {

        StackMinElement minStack = new StackMinElement();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-1);

        System.out.println(minStack.getMin());
        System.out.println(minStack.top());

        minStack.pop();

        System.out.println(minStack.getMin());

    }

}
