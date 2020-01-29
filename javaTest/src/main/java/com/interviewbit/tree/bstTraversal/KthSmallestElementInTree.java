package com.interviewbit.tree.bstTraversal;

import com.interviewbit.tree.TreeNode;

public class KthSmallestElementInTree {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);

        c.left = b;
        b.left = a;
        c.right = d;

        System.out.println(new KthSmallestElementInTree().kthsmallest(c,3));

    }

    int c = 0;
    int res = 0;
    public int kthsmallest(TreeNode A, int B) {
        kthsmallestUitl(A,B);
        return res;
    }

    public void kthsmallestUitl(TreeNode A, int B) {
        if(A == null){
            return;
        }

        kthsmallest(A.left,B);
        c++;
        if(c == B){
            res =  A.val;
        }
        kthsmallest(A.right,B);
    }
}

/**
 *
 * Given a binary search tree, write a function to find the kth smallest element in the tree.
 *
 * Example :
 *
 * Input :
 *   2
 *  / \
 * 1   3
 *
 * and k = 2
 *
 * Return : 2
 *
 * As 2 is the second smallest element in the tree.
 *  NOTE : You may assume 1 <= k <= Total number of nodes in BST
 *
 *
 * */