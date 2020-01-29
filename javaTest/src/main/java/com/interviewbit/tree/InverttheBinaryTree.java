package com.interviewbit.tree;

public class InverttheBinaryTree {

    public TreeNode invertTree(TreeNode A) {

        if(A == null){
            return null;
        }
        TreeNode t = invertTree(A.right);
        A.right = invertTree(A.left);
        A.left = t;

        return A;
    }

}
/**
 * Given a binary tree, invert the binary tree and return it.
 * Look at the example for more details.
 *
 * Example :
 * Given binary tree
 *
 *      1
 *    /   \
 *   2     3
 *  / \   / \
 * 4   5 6   7
 * invert and return
 *
 *      1
 *    /   \
 *   3     2
 *  / \   / \
 * 7   6 5   4
 *
 * */