package com.java.datastrudtures.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a BST, transform it into greater sum tree where each node contains sum of all nodes greater than that node.
 *
 * Example 1:
 *
 * Input:
 *            2
 *          /    \
 *         1      6
 *               /  \
 *              3    7
 * Output: 18 16 13 7 0
 * Explanation:
 * Every node is replaced with the
 * sum of nodes greater than itself.
 * The resultant tree is:
 *                16
 *              /    \
 *            18       7
 *                   /   \
 *                  13    0
 *
 */
public class BSTToGreaterSumTree {
    private static List<Integer> sortedData = new ArrayList<>();

    public static void transformTree( TreeNode root)
    {

        inorder(root);
        //code here
        int[] output = new int[sortedData.size()];
        int sum = 0;
        for (int i = sortedData.size() - 1; i > 0; i--) {
            output[i - 1] = sum + sortedData.get(i);
            sum = sum + sortedData.get(i);
        }

        output[sortedData.size() - 1] = 0; // setting last element to 0 (zero)

        printArray(output);
        //return output;
    }

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf(arr[i] + " ");
        }
    }

    public static void inorder( TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        sortedData.add(root.data);
        inorder(root.right);
    }

    public static void inorderReplaceNodeValues( TreeNode root) {
        if (root == null) {
            return;
        }

        inorderReplaceNodeValues(root.left);
       // root.data =  inorderReplaceNodeValues(root.right);
    }


    public static void main(String[] args) {
        TreeNode root = null;
        root = new TreeNode(null, 2, null);
        root.left = new TreeNode(null, 1, null);
        root.right = new TreeNode(null, 6, null);
        root.right.left = new TreeNode(null, 3 , null);
        root.right.right = new TreeNode(null, 7, null);

        transformTree(root);
        //Tree.inorder(root);
    }
}
