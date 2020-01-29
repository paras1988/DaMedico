package com.interviewbit.tree;

public class SymmetricBinaryTree {

    public int isSymmetric(TreeNode A) {
        if(isMirror(A.left, A.right)){
            return 1;
        }
        return 0;
    }

    private boolean isMirror(TreeNode a, TreeNode b) {
        if(a == null && b == null){
            return true;
        }
        if( a!= null && b!=null && a.val == b.val && isMirror(a.left,b.right) && isMirror(a.right,b.left)){
            return true;
        }
        return false;
    }
}
