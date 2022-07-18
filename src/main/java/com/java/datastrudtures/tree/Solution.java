package com.java.datastrudtures.tree;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    static int sum;
    public static void transformTree (TreeNode root)
    {
        //code here
        sum = 0;
        transform(root);

    }
    public static void transform (TreeNode root)
    {

        if(root==null)
            return;
        transform(root.right);
        int t=sum;
        sum+=root.data;
        root.data=t;//swap
        transform(root.left);
    }

    public static void main(String[] args) {
        TreeNode root = null;
        root = new TreeNode(null, 2, null);
        root.left = new TreeNode(null, 1, null);
        root.right = new TreeNode(null, 6, null);
        root.right.left = new TreeNode(null, 3 , null);
        root.right.right = new TreeNode(null, 7, null);

        transformTree(root);
        Tree.inorder(root);
    }
}
