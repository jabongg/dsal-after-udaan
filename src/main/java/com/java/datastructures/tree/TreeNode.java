package com.java.datastructures.tree;

public class TreeNode {
    TreeNode left;
    int data;
    TreeNode right;

    public TreeNode(TreeNode left, int data, TreeNode right) {
        this.left = left;
        this.data = data;
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "left=" + left +
                ", data=" + data +
                ", right=" + right +
                '}';
    }
}
