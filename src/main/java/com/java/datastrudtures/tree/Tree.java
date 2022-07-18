package com.java.datastrudtures.tree;

/**
 *  *
 *  * Input:
 *  *            2
 *  *          /    \
 *  *         1      6
 *  *               /  \
 *  *              3    7
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
}
