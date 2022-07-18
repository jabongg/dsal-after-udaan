package com.java.datastrudtures.tree;
/*
 *
 * Input:
 *            2
 *          /    \
 *         1      6
 *               /  \
 *              3    7
 */
public class TreeDriver {
    public static void main(String[] args) {
        TreeNode root = null;
        root = new TreeNode(null, 2, null);
        root.left = new TreeNode(null, 1, null);
        root.right = new TreeNode(null, 6, null);
        root.right.left = new TreeNode(null, 3 , null);
        root.right.right = new TreeNode(null, 7, null);


        Tree.inorder(root);

        System.out.println("\nheight :" + Tree.height(root));
    }
}
