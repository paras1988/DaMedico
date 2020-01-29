package com.interviewbit.tree.treeConstruction;

import com.interviewbit.tree.TreeNode;

public class BinaryTreeFromInorderAndPostorder {

    public static void main(String[] args) {
        int[] a0 = {2, 1, 3};
        int[] b0 = {2, 3, 1};

        TreeNode res = new BinaryTreeFromInorderAndPostorder().buildTree(a0,b0);
        System.out.println(res);


        int[] a = {7, 5, 6, 2, 3, 1, 4};
        int[] b = {5, 6, 3, 1, 4, 2, 7 };

        TreeNode res1 = new BinaryTreeFromInorderAndPostorder().buildTree(a,b);
        System.out.println(res1);


        int[] a1 = {17, 12, 24, 13, 2, 22, 9, 20, 18, 23, 3, 15, 21, 10, 4, 11, 19, 14, 16, 7, 1, 5, 6, 8};
        int[] b1 = {17, 13, 2, 22, 24, 18, 20, 9, 15, 3, 11, 4, 10, 14, 16, 19, 1, 7, 21, 23, 12, 6, 8, 5 };

        TreeNode res2 = new BinaryTreeFromInorderAndPostorder().buildTree(a1,b1);
        System.out.println(res2);

    }
    public TreeNode buildTree(int[] A, int[] B) {
        k = B.length-1;
        return buildTreeUtil(A,0,A.length-1,B);
    }

    int k;

    private TreeNode buildTreeUtil(int[] inorder, int is, int ie, int[] postorder) {

        if(is > ie){
            return null;
        }
        TreeNode root = null;

        int imid = 0;
        for(int i=is;i<= ie;i++){
            if(inorder[i] == postorder[k]){
                imid = i;
                root = new TreeNode(inorder[i]);
            }
        }
        k--;
        if(root == null){
            return null;
        }
        root.right = buildTreeUtil(inorder, imid + 1, ie, postorder);
        root.left = buildTreeUtil(inorder, is, imid-1, postorder);
        return root;
    }
}
/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 *
 *  Note: You may assume that duplicates do not exist in the tree.
 * Example :
 *
 * Input :
 *         Inorder : [2, 1, 3]
 *         Postorder : [2, 3, 1]
 *
 * Return :
 *             1
 *            / \
 *           2   3
 *
 * */