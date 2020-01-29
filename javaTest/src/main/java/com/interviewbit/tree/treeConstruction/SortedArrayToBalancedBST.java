package com.interviewbit.tree.treeConstruction;

import com.interviewbit.tree.TreeNode;

public class SortedArrayToBalancedBST {

    public static void main(String[] args) {
        int[] arr ={1,2,3};
        TreeNode res = new SortedArrayToBalancedBST().sortedArrayToBST(arr);
        System.out.println(res);
    }

    public TreeNode sortedArrayToBST(final int[] A) {

        return sortedArrayToBSTUtil(A,0,A.length);

    }

    private TreeNode sortedArrayToBSTUtil(int[] a, int s, int e) {
        if(s==e){
            return null;
        }
        int mid = (s + e)/2;

        TreeNode t = new TreeNode(a[mid]);
        t.left = sortedArrayToBSTUtil(a,s,mid);
        t.right = sortedArrayToBSTUtil(a,mid+1,e);

        return t;
    }
}
/**
 *
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 *  Balanced tree : a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every
 *  node never differ by more than 1.
 *
 * Example :
 *
 *
 * Given A : [1, 2, 3]
 * A height balanced BST  :
 *
 *       2
 *     /   \
 *    1     3
 *
 * */