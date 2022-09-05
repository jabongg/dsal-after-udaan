package com.java.datastructures.tree;

//Java implementation to find lowest common ancestor of
// n1 and n2 using one traversal of binary tree

import java.util.LinkedList;
import java.util.Queue;

/* Class containing left and right child of current
node and key value*/
class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class LowestCommonAncestor {
    //Root of the Binary Tree
    private static Node root;

    Node findLCA(int n1, int n2) {
        return findLCA(root, n1, n2);
    }

    // This function returns pointer to LCA of two given
    // values n1 and n2. This function assumes that n1 and
    // n2 are present in Binary Tree
    Node findLCA(Node root, int n1, int n2) {
        // Base case
        if (root == null)
            return null;

        // If either n1 or n2 matches with root's key, report
        // the presence by returning root (Note that if a key is
        // ancestor of other, then the ancestor key becomes LCA
        if (root.data == n1 || root.data == n2)
            return root;

        // Look for keys in left and right subtrees
        Node lcaLeft = findLCA(root.left, n1, n2);
        Node lcaRight = findLCA(root.right, n1, n2);

        // If both of the above calls return Non-NULL, then one key
        // is present in one subtree and other is present in other,
        // So this node is the LCA
        if (lcaLeft != null && lcaRight != null)
            return root;

        // Otherwise check if left subtree or right subtree is LCA
        return (lcaLeft != null) ? lcaLeft : lcaRight;
    }


    /* Driver program to test above functions
    *
    *        1
    *       / \
    *      2   3
    *     / \ / \
    *    4  5 6  7
    * */
    public static void main(String args[]) {
        LowestCommonAncestor tree = new LowestCommonAncestor();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        System.out.println("LCA(4, 5) = " +
                tree.findLCA(4, 5).data);
        System.out.println("LCA(4, 6) = " +
                tree.findLCA(4, 6).data);
        System.out.println("LCA(3, 4) = " +
                tree.findLca(3, 4).data);
        System.out.println("LCA(2, 4) = " +
                tree.findLca(2, 4).data);

        System.out.println(nextRight(root, 4).data);
    }


    public static Node lca(Node root, int p1, int p2) {
        if (root == null || p1 == root.data || p2 == root.data)
            return root;

        Node l = lca(root.left, p1, p2);
        Node r = lca(root.right, p1, p2);

        if (l == null) {
            return r;
        } else if (r == null) {
            return l;
        } else {
            return root; // if both are not null, we have found the result
        }
    }

    public static Node findLca(int n1, int n2) {
        return lca(root, n1, n2);
    }


    public static Node findNextRight(Node root, int key) {
        Node result = new Node(-1);
        boolean keyFound = false;
        // try for bfs
        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            // check if key is already found
            if (keyFound) {
                return q.poll();
            }

            Node temp = q.poll();
            q.offer(temp.left);
            q.offer(temp.right);

            // logic for next right
            if (temp.data == key) {
                keyFound = true;
            }
        }
        return result;
    }


    public static Node nextRight(Node root, int key) {
        Node result = new Node(-1);
        // try for bfs
        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {

            int prevKey = -1;
            int len = q.size();

            for (int i = 0; i < len; i++) {
                Node curr = q.poll();

                if (prevKey == key) {
                    return curr;
                } else {
                    prevKey = curr.data;
                }


                if (curr.left != null)
                    q.offer(curr.left);

                if (curr.right != null)
                    q.offer(curr.right);

            }


        }
        return result;
    }
}
