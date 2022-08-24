package com.java.datastrudtures.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a BST, transform it into greater sum tree where each node contains sum of all nodes greater than that node.
 * <p>
 * Example 1:
 * <p>
 * Input:
 *       2
 *     /  \
 *    1    6
 *       /  \
 *      3    7
 * Output: 18 16 13 7 0
 * Explanation:
 * Every node is replaced with the
 * sum of nodes greater than itself.
 * The resultant tree is:
 *          16
 *       /       \
 *      18       7
 *              /   \
 *              13    0
 */
public class BSTToGreaterSumTree {
    private static List<Integer> sortedData = new ArrayList<>();
    static int sum = 0;

    public static void transformTree(TreeNode root) {

        inorderList(root);
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

    public static void inorderList(TreeNode root) {
        if (root == null) {
            return;
        }

        inorderList(root.left);
        sortedData.add(root.data);
        inorderList(root.right);
    }

    public static void inorderReplaceNodeValues(TreeNode root) {
        if (root == null) {
            return;
        }

        inorderReplaceNodeValues(root.left);
        // root.data =  inorderReplaceNodeValues(root.right);
    }


    static void transformTreeUtil(TreeNode root) {

        // Base case
        if (root == null)
            return;

        // Recur for right subtree
        transformTreeUtil(root.right);

        // Update sum
        sum = sum + root.data;

        // Store old sum in current node
        root.data = sum - root.data;

        // Recur for left subtree
        transformTreeUtil(root.left);
    }


    public static void main(String[] args) {
        TreeNode root = null;
        root = new TreeNode(null, 2, null);
        root.left = new TreeNode(null, 1, null);
        root.right = new TreeNode(null, 6, null);
        root.right.left = new TreeNode(null, 3, null);
        root.right.right = new TreeNode(null, 7, null);

        Tree.inorder(root);
        System.out.println();
        //transformTree(root);
        transformTreeUtil(root);
        Tree.inorder(root);
    }
}
