package com.java.datastructures.tree;

import java.util.List;
import java.util.TreeMap;
import java.util.Vector;

import static com.java.datastructures.tree.Tree.*;

/*
 *
 * Input:
 *            3
 *          /    \
 *         1      16
 *          \    /  \
 *           2   4    27
 *
 * === prune tree
 *             1
 *          /    \
 *         1      1
 *          \    /  \
 *           0   0    0
 *                   /
 *                  1
 */
public class TreeDriver {
    public static void main(String[] args) {
        TreeNode root = null;
        root = new TreeNode(null, 1, null);
        root.left = new TreeNode(null, 1, null);
        root.right = new TreeNode(null, 1, null);
        root.left.right = new TreeNode(null, 0, null);
        root.right.left = new TreeNode(null, 0, null);
        root.right.right = new TreeNode(null, 0, null);
        root.right.right.left = new TreeNode(null, 1, null);


//        TreeNode root1 = root;
//
//        TreeNode root2 = null;
//        root2 = new TreeNode(null, 22, null);
//        root2.left = new TreeNode(null, 11, null);
//        root2.right = new TreeNode(null, 26, null);
//        root2.left.right = new TreeNode(null, 17, null);
//        root2.right.left = new TreeNode(null, 24 , null);
//        root2.right.right = new TreeNode(null, 37, null);


        System.out.println("inorder traversal of the tree : ");
        inorderIterative(root);

        //System.out.println("\nheight : " + height(root));

        //System.out.println("diameter : " + diameterOfBinaryTree(root));
        //Tree.deleteNode(root, 6);

        // inorder(root);
        // System.out.println();

        //System.out.println("mirrored tree");
        //Tree.mirror(root);

        //inorder(root);

        //System.out.println();
        //System.out.println("maxPath sum : " + maxPathSum(root));

        //TreeNode addedTreesSum = Tree.addTwoTrees(root1, root2);
        //inorder(addedTreesSum);
//        System.out.println();
//
//        System.out.println("print Leaves of the tree: ");
//        Tree.printLeaves(root);
//        System.out.println();
//        List<Integer> rightViewNodes = Tree.rightSideView(root);
//        System.out.println("right view of the tree : " + rightViewNodes);
//
//        System.out.println();
        List<Integer> leftViewNodes = Tree.leftSideView(root);
        System.out.println("left view of the tree : " + leftViewNodes);

        TreeMap<Integer, Vector<Integer>> verticalNodesMap = Tree.printTreeVertically(root);
        System.out.println("left view of the tree : " + verticalNodesMap);

        Tree.inorder(Tree.pruneTree(root));


    }
}
