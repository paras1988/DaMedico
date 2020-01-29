package com.interviewbit.tree;

public class BalancedBinaryTree2 {


    public static void main(String[] args) {

    }


    public int isBalanced(TreeNode A) {
       if(getHeight(A) == -1){
           return 0;
       }
       return 1;
    }

    private int getHeight(TreeNode node) {
        if(node == null){
            return 0;
        }

        int lHeight = getHeight(node.left);
        int rHeight = getHeight(node.right);

        if(lHeight==-1 || rHeight==-1 || Math.abs(lHeight - rHeight)>1){
            return -1;
        }
        return Math.max(lHeight,rHeight)+1;
    }


}


/*
* Given a binary tree, determine if it is height-balanced.

 Height-balanced binary tree : is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
Return 0 / 1 ( 0 for false, 1 for true ) for this problem

Example :

Input :
          1
         / \
        2   3

Return : True or 1

Input 2 :
         3
        /
       2
      /
     1

Return : False or 0
         Because for the root node, left subtree has depth 2 and right subtree has depth 0.
         Difference = 2 > 1.
* */