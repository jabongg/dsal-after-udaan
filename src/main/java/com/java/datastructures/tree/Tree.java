package com.java.datastructures.tree;

import java.util.*;

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
        int currDiameter = 1 + lh + rh; // if passes from root.
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


    public static void printLeaves(TreeNode root) {

        if (root == null) {
            return;
        }

        printLeaves(root.left);
        printLeaves(root.right);
        if (root.left == null && root.right == null) {
            // it's a leaf node
            System.out.print(root.data + " ");
        }
    }


    public static void printLeftView(TreeNode root) {
        // using bfs traversal and then picking the first element from the queue for each iteration

    }


    public static void printRightView(TreeNode root) {
        // using bfs traversal and then picking the last element from the queue for each iteration

    }


    // using preorder traversal with reversed children
    public static List<Integer> rightSideView(TreeNode root) {

        List<Integer> rightViewNodes = new ArrayList<>();
        int level = 0; // for root
        rightViewHelper(root, level, rightViewNodes);

        return rightViewNodes;
    }

    public static void rightViewHelper(TreeNode root, int level, List<Integer> rightViewNodes) {
        // I'll be using preorder way

        // base case
        if (root == null) {
            return;
        }

        // induction
        if (level == rightViewNodes.size()) {
            rightViewNodes.add(root.data);
        }

        // hypothesis
        rightViewHelper(root.right, level + 1, rightViewNodes);
        rightViewHelper(root.left, level + 1, rightViewNodes);
    }

    public static List<Integer> leftSideView(TreeNode root) {
        List<Integer> leftViewNodes = new ArrayList<>();
        int level = 0;
        leftSideViewHelper(root, level, leftViewNodes);

        return leftViewNodes;
    }

    private static void leftSideViewHelper(TreeNode root, int level, List<Integer> leftViewNodes) {
        // using preorder for nodes
        // base case
        if (root == null) {
            return;
        }

        if (level == leftViewNodes.size()) {
            leftViewNodes.add(root.data);
        }

        //hypothesis
        leftSideViewHelper(root.left, level + 1, leftViewNodes);
        leftSideViewHelper(root.right, level + 1, leftViewNodes);

    }

    //private static TreeMap<Integer, Vector<Integer>> verticalNodesMap = new TreeMap<>();

    public static TreeMap<Integer, Vector<Integer>> printTreeVertically(TreeNode root) {

        int horizontalDistance = 0;
        TreeMap<Integer, Vector<Integer>> verticalNodesMap = new TreeMap<>();
        createVerticalNodesList(root, horizontalDistance, verticalNodesMap);
        return verticalNodesMap;
    }

    private static TreeMap<Integer, Vector<Integer>> createVerticalNodesList(TreeNode root, int horizontalDistance, TreeMap<Integer, Vector<Integer>> verticalNodesMap) {
        // base condition
        if (root == null) {
            return null;
        }

        // induction
        // get the vector list at horizontal distance
        Vector<Integer> verticalNodes = verticalNodesMap.get(horizontalDistance);

        if (verticalNodes == null) {
            verticalNodes = new Vector<>();
            verticalNodes.add(root.data);
        } else {
            verticalNodes.add(root.data);
        }

        // put the list corresponding the the horizontal distance
        verticalNodesMap.put(horizontalDistance, verticalNodes);

        // hypothesis
        createVerticalNodesList(root.left, horizontalDistance - 1, verticalNodesMap);
        createVerticalNodesList(root.right, horizontalDistance + 1, verticalNodesMap);
        return null;
    }

    public static void inorderIterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> nodes = new ArrayList<>();
        TreeNode temp = root;

        while (true) {
            if (temp != null) {
                stack.push(temp);
                temp = temp.left;
            } else {
                if (stack.isEmpty()) break;  //base condiion or exit condition

                temp = stack.pop();
                nodes.add(temp.data);
                temp = temp.right;
            }
        }

        System.out.println(nodes);
    }
}
