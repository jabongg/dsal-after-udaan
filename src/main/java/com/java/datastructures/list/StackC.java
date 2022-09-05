package com.java.datastructures.list;
    /*Java Program to implement a stack
            that supports findMiddle()and
            deleteMiddle in O(1)time*/

public class StackC {

    // Members of stack
    Node head = null;
    Node mid = null;
    int size = 0;

    public void push(int data) {
        Node temp = new Node(data);
        if (size == 0) {
            head = temp;
            mid = temp;
            size++;
            return;
        }

        head.next = temp;
        temp.prev = head;

        // update the pointers
        head = head.next;
        if (size % 2 == 1) {
            mid = mid.next;
        }
        size++;
    }

    public int pop() {
        int data = -1;
        if (size != 0) {
            data = head.num;
            if (size == 1) {
                head = null;
                mid = null;
            } else {
                head = head.prev;
                head.next = null;
                if (size % 2 == 0) {
                    mid = mid.prev;
                }
            }
            size--;
        }
        return data;
    }

    public int findMiddle() {
        if (size == 0) {
            return -1;
        }
        return mid.num;
    }

    public void deleteMiddle() {
        if (size != 0) {
            if (size == 1) {
                head = null;
                mid = null;
            } else if (size == 2) {
                head = head.prev;
                mid = mid.prev;
                head.next = null;
            } else {
                mid.next.prev = mid.prev;
                mid.prev.next = mid.next;
                if (size % 2 == 0) {
                    mid = mid.prev;
                } else {
                    mid = mid.next;
                }
            }
            size--;
        }
    }


    public static void main(String[] args) {
        StackC st = new StackC();
        st.push(11);
        st.push(22);
        st.push(33);
        st.push(44);
        st.push(55);
        st.push(66);
        st.push(77);
        st.push(88);
        st.push(99);
        System.out.println("Popped : " + st.pop());
        System.out.println("Popped : " + st.pop());
        System.out.println("Middle Element : " + st.findMiddle());
        st.deleteMiddle();
        System.out.println("Middle Element : " + st.findMiddle());
    }
}



