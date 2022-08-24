package com.java.datastrudtures.leetcode;

import com.sun.xml.internal.messaging.saaj.util.TeeInputStream;

import java.util.Stack;

/*
How's going Ladies-N-Gentlemen today we are going to solve another super question i.e. Flatten Binary Tree to LinkedList

Well, if you look at the question, you'll see that the Linked List has to be in preorder Traversal

So, if you know what preorder is then, you are good to go. A quick recap about preorder is, First we traverse to it's root then left and then right

Let's take an example to understand it.

Input: root = [1,2,5,3,4,null,6]
Output: [1,null,2,null,3,null,4,null,5,null,6]

image

Now, you have got the idea, let's see how we can solve this problem,

The first method We gonna use is # RECURSION

So, let's take a very small example to understand it.
image

This is about the smaller tree of 3 nodes, but what if we are given a bigger tree??

So, for that one what we gonna do is, instead of removing and attaching every single time, we gonna have 2 trees
> Left temporary tree
> Right temporary tree
And we gonna flatten these 2 trees and attach to right.
To flatten them we gonna use the help of recursion.

Now let's see what new steps would be.

    We'll take temp variable to store left & right node.

    Then, left will be point to null.

    Now, after this we going to flatten left & right tree (recursively)

    After this we attach left part to right side

    In the last we gonna traverse the bottom most node in the attached part and attached the right it.

class Solution {
    public void flatten(TreeNode root) {
        if(root == null) return;
        // step-1
        TreeNode Left = root.left;
        TreeNode Right = root.right;

        // step-2
        root.left = null;

        // step-3
        flatten(Left);
        flatten(Right);
        root.right = Left;
        TreeNode curr = root;

        // step-4
        while(curr.right != null) curr = curr.right;

        // step-5
        curr.right = Right;
    }
}

ANALYSIS:-

    Time Complexity :- BigO(N^2)

    Space Complexity :- BigO(height)

Now, let's talk about how we gonna reduce the space to O(1) as given in the question. To do that we gonna use,

# Morris Traversal

To, understand this let's take an example,
image

> So, in this we start from root.
> Then we check if it's left doesn't pointing to null, then go to it's right most node and attach it's right to become the root of my tree
> Let's see what I'm talking about.

image

So, as you can see now if I traverse the tree from 1-->2-->3-->4-->5-->6 as you can see now, after 4 am not going back again to 1 as my 4 node is pointing to 5, so that's how we are not using any extra space

> After doing that, I'll remove the root pointer and left of my root becomes null & right of my root will become this left tree.
> Let's see how's it goes like,

image

Now, again we going to repeat the same process,
> Check left,
> If not null, go to it's right most child
> Connect it root to right
> Connect the whole left to root->right
> Make root->left = null
> Update root to root->right

image

Now as you can see our tree has all the nodes on it's right, now flatten this out and look:

image

And we'll complete the process till the end, although "3" doesn't have it's left but we still go to it's right and complete the process till the end.

Now. let's code it up:-

class Solution {
    public void flatten(TreeNode root) {
        if(root == null) return;
        while(root != null){
            if(root.left != null) {
                TreeNode Left = root.left;
                TreeNode curr = Left;
                while(curr.right != null) curr = curr.right;
                curr.right = root.right;  // Morris Traversal main step
                root.left =null;
                root.right = Left;
            }
            root = root.right;
        }
    }
}

ANALYSIS :-

    Time Complexity :- BigO(N)

    Space Complexity :- BigO(1)

 */
public class FlattenBinaryTreeToLinkedListP114 {

    public static void flattenTree(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> s = new Stack<>();

        s.push(root);

        while (!s.isEmpty()) {
            TreeNode curr = s.pop();
            if (curr.right != null) {
                s.push(curr.right);
            }
            if (curr.left != null) {
                s.push(curr.left);
            }
            if (!s.isEmpty()) {
                curr.right = s.pop();
            }
            curr.left = null;
        }
    }


    public static void flatten(TreeNode root) {
        if (root == null) return;
        // step-1
        TreeNode Left = root.left;
        TreeNode Right = root.right;

        // step-2
        root.left = null;

        // step-3
        flatten(root.left);
        flatten(root.right);
        root.right = Left;
        TreeNode curr = root;

        // step-4
        while (curr.right != null) curr = curr.right;

        // step-5
        curr.right = Right;
    }


    /*
     * tree:
     *             1
     *           /  \
     *          2    5
     *         / \     \
     *        3   4     6
     */
    public static void flattenIterative(TreeNode root) {

        // for not loosing the head reference, storing root to temp

        TreeNode tempRoot = root; // we can return this root in the end.

        if (root == null) return;
        while (root != null) {
            if (root.left != null) {
                TreeNode Left = root.left;
                TreeNode curr = Left;
                while (curr.right != null) curr = curr.right;
                curr.right = root.right;  // Morris Traversal main step
                root.left = null;
                root.right = Left;
            }
            root = root.right;
        }
    }

    public static void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    /*
     * tree:
     *             1
     *           /  \
     *          2    5
     *         / \     \
     *        3   4     6
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);

        //flatten(root);
        flattenIterative(root);
        inorder(root);
    }


}
