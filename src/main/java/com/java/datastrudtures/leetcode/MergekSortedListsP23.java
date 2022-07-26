package com.java.datastrudtures.leetcode;

public class MergekSortedListsP23 {
    private static ListNode commonHead;
    private static boolean isCommonHeadDecided;
    private static ListNode lastNode;

    public static ListNode mergeKLists(ListNode[] lists) {
        for (int i = 0; i < lists.length - 1; i++) { // will take 2 lists together
            ListNode l2 = lists[i];

            //merge logic
            commonHead = merge(commonHead, l2);
        }

        return commonHead;
    }

    public static ListNode merge(ListNode l1, ListNode l2) {
        if (commonHead == null) {
            commonHead = l2;
            return commonHead;
        }
        ListNode curr1 = l1; ListNode next1 = null;
        ListNode curr2 = l2; ListNode next2 = null;
        ListNode prev1 = null; ListNode prev2 = null;
        boolean isCommonHeadToggled = false;

        while (curr1 != null && curr2 != null) {
            //check for lists head with smaller val
            if (curr1.val == curr2.val) {
                next1 = curr1.next;
                prev1 = curr1;
                curr1 = next1;
            }

            else if (curr1.val < curr2.val) {
                next1 = curr1.next;
                curr1.next = curr2;
                prev1 = curr1;
                curr1 = next1;
            }

            else if (curr1.val > curr2.val) {
                next2 = curr2.next;
                curr2.next = curr1;
                prev2 = curr2;
                curr2 = next2;
                if (!isCommonHeadToggled) {
                    commonHead = curr2;
                    isCommonHeadToggled = true;
                }
            }
        }

        // which one exhausted
        while (prev2 != null) {
            curr2 = curr2.next;
        }
        boolean isLastNodeAssigned = false;
        if (!isLastNodeAssigned) {
            lastNode = curr2; // prev value chahiye
            isLastNodeAssigned = true;
        }

        while (prev1 != null) {
            curr1 = curr1.next;
        }

        if (!isLastNodeAssigned) {
            lastNode = curr1; // prev value chahiye
            isLastNodeAssigned = true;
        }

        return commonHead;

    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next =  new ListNode(4);
        l1.next.next = new ListNode(5);


        ListNode l2 = new ListNode(1);
        l2.next =  new ListNode(3);
        l2.next.next = new ListNode(4);


        ListNode l3 = new ListNode(2);
        l3.next =  new ListNode(6);

        ListNode[] listNodes = new ListNode[3];
        listNodes[0] = l1;
        listNodes[1] = l2;
        listNodes[2] = l3;
        mergeKLists(listNodes);
    }

}