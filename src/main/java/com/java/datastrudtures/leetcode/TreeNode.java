package com.java.datastrudtures.leetcode;

public class TreeNode {
    TreeNode left;
    int data;
    TreeNode right;

    public TreeNode(TreeNode left, int data, TreeNode right) {
        this.left = left;
        this.data = data;
        this.right = right;
    }

    public TreeNode(int data) {
        this.data = data;
    }
}
