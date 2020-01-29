package com.interviewbit.tree.Levelorder;

import com.interviewbit.tree.TreeNode;

import java.util.*;

public class ZigZagLevelOrderTraversalBT {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode a = new TreeNode(3);
        TreeNode b = new TreeNode(1);
        TreeNode c = new TreeNode(5);
        TreeNode d = new TreeNode(6);
        TreeNode f = new TreeNode(7);
        TreeNode g = new TreeNode(8);

        root.left = a;
        root.right = b;

        a.left =c ;
        a.right = d;

        b.left = f;
        b.right = g;

        System.out.println(new ZigZagLevelOrderTraversalBT().zigzagLevelOrder(root));
    }

    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Stack<TreeNode> s = new Stack();
        Queue<TreeNode> q = new LinkedList();

        s.push(A);
        while (!s.isEmpty() || !q.isEmpty()){
            if(q.isEmpty()){
                ArrayList<Integer> temp = new ArrayList<>();
                while (!s.isEmpty()){
                    TreeNode t = s.pop();
                    temp.add(t.val);
                    if(t.left!=null){ ((LinkedList<TreeNode>) q).push(t.left);}
                    if(t.right!=null){ ((LinkedList<TreeNode>) q).push(t.right);}
                }
                if(!temp.isEmpty()) {
                    res.add(temp);
                }
            }
            if(s.isEmpty()){
                ArrayList<Integer> temp = new ArrayList<>();
                while (!q.isEmpty()){
                    TreeNode t = q.poll();
                    temp.add(t.val);
                    if(t.right!=null){ s.push(t.right);}
                    if(t.left!=null){ s.push(t.left);}
                }
                if(!temp.isEmpty()) {
                    res.add(temp);
                }
            }
        }
        return res;
    }
}
/**
 *
 * Given a binary tree, return the zigzag level order traversal of its nodes’ values. (ie, from left to right, then right to left
 * for the next level and alternate between).
 *
 * Example :
 * Given binary tree
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return
 *
 * [
 *          [3],
 *          [20, 9],
 *          [15, 7]
 * ]
 *
 * */