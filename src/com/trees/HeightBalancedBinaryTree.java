package com.trees;

public class HeightBalancedBinaryTree {

	public static void main(String[] args) {
		Node root = null;
		Integer[] intArray7 ={5,8,9,10};
		root = BuildTree.build123Recur(root, intArray7);
		int res=new HeightBalancedBinaryTree().isBalanced(root);
		System.out.println(res);
	}

	public int isBalanced(Node root){

		boolean res=isBalanced2(root);
		if(res){
			return 1;
		}else{
			return 0;
		}
	}
	public Boolean isBalanced2(Node root){
		if(root==null){
			return true;
		}
		if(!isBalanced2(root.left) ||
				!isBalanced2(root.right) ||
				Math.abs(heightOfTree(root.left)- heightOfTree(root.right))>1){
			return false;
		}
		return true;
	}

	private int heightOfTree(Node root) {
		if(root==null){
			return 0;
		}

		int lht=heightOfTree(root.left);
		int rht=heightOfTree(root.right);

		if(lht>rht){
			return lht+1;
		}else{
			return rht+1;
		}
	}
}
