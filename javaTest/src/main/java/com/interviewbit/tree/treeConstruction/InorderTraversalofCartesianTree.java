package com.interviewbit.tree.treeConstruction;

import com.interviewbit.tree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;

public class InorderTraversalofCartesianTree {

    public TreeNode buildTree(ArrayList<Integer> A) {

        return buildTreeUtil(A,0,A.size());
    }

    private TreeNode buildTreeUtil(ArrayList<Integer> a, int s, int e) {
        if(s == e){
            return null;
        }
        int max = 0;
        int l = 0;
        for(int i=s;i<e;i++){
            if(a.get(i)>max){
                max = a.get(i);
                l = i;
            }
        }
        TreeNode res = new TreeNode(max);
        res.left = buildTreeUtil(a,s,l);
        res.right = buildTreeUtil(a,l+1,e);
        return res;
    }
}
