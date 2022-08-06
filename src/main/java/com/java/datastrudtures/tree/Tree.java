package com.java.datastrudtures.tree;

/**
 * *
 * * Input:
 * *            2
 * *          /    \
 * *         1      6
 * *               /  \
 * *              3    7
 */
public class Tree {
    public static void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int lh = height(root.left);
        int rh = height(root.right);

        return 1 + Math.max(lh, rh);
    }

    public static TreeNode deleteNode(TreeNode root, int k) {
        //add code here.
        if (root == null) {
            return null;
        }
        root.left = deleteNode(root.left, k);

        if (root.data >= k) {
            return root.left;
        }

        root.right = deleteNode(root.right, k);
        return root;
    }

    public static int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;

        //height
        int lh = height(root.left);
        int rh = height(root.right);

        //diameter
        int currDiameter = 1 + lh + rh;
        int ld = diameterOfBinaryTree(root.left);
        int rd = diameterOfBinaryTree(root.right);
        return Math.max(currDiameter, Math.max(ld, rd)) - 1; // for edges, not nodes;
    }


    public static TreeNode mirror(TreeNode root) {

        if (root == null) {
            return root;
        }

        root.left = mirror(root.left);
        root.right = mirror(root.right);

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        return root;

    }

    static int result = Integer.MIN_VALUE;

    public static int maxPathSum(TreeNode root) {
        maxPathSumHelper(root);
        return result;
    }

    public static int maxPathSumHelper(TreeNode root) {

        // base condition
        if (root == null) {
            return 0;
        }

        // hypothesis
        int l = maxPathSumHelper(root.left);
        int r = maxPathSumHelper(root.right);


        // induction
        int temp = Math.max(root.data + Math.max(l, r), root.data);

        int ans = Math.max(root.data + l + r, temp);

        result = Math.max(result, ans);

        return temp;
    }

    public static TreeNode addTwoTrees(TreeNode root1, TreeNode root2) {

        // handling edge cases
        if (root1 == null) {
            return root2;
        } else if (root2 == null) {
            return root1;
        }
        root1.left = addTwoTrees(root1.left, root2.left);
        root1.right = addTwoTrees(root1.right, root2.right);
        root1.data = root1.data + root2.data;


        return root1;
    }



}
