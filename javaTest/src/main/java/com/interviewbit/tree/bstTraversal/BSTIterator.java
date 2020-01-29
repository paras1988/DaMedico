package com.interviewbit.tree.bstTraversal;

import com.interviewbit.tree.TreeNode;

import java.util.Stack;

public class BSTIterator {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(4);
        TreeNode a = new TreeNode(3);
        TreeNode b = new TreeNode(1);
        TreeNode c = new TreeNode(2);

        root.left = a;
        a.left = b;
        b.right = c;

        BSTIterator i = new BSTIterator(root);
         while (i.hasNext())
             System.out.print(i.next());
    }

    TreeNode root;
    Stack<TreeNode> stack = new Stack();

    TreeNode curr = null;

    public BSTIterator(TreeNode root) {
        this.root = root;

        curr = root;

        while (curr != null){
            stack.push(curr);
            curr = curr.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {

        if(stack.isEmpty()){
            return false;
        }
        curr = stack.pop();
        TreeNode r = curr.right;
        while (r != null) {
            stack.push(r);
            r = r.left;
        }

        return  curr!= null;
    }

    /** @return the next smallest number */
    public int next() {
        return curr.val;
    }

}
/**
 *
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root
 * node of a BST.
 *
 * The first call to next() will return the smallest number in BST. Calling next() again will return
 * the next smallest number in the BST, and so on.
 *
 *  Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the
 *  height of the tree.
 * Try to optimize the additional space complexity apart from the amortized time complexity.
*
* */