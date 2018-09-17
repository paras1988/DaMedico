package com.trees;

public class HeightBalancedBinaryTree {

	public static void main(String[] args) {
		Node root = null;
		Integer[] intArray7 ={5,8,9,10};
		root = BuildTree.build123Recur(root, intArray7);
		System.out.println(new HeightBalancedBinaryTree().isBalanced(root));

		root = null;
		Integer[] intArray8 ={5,4,6,10};
		root = BuildTree.build123Recur(root, intArray8);
		System.out.println(new HeightBalancedBinaryTree().isBalanced(root));

		root = null;
		Integer[] intArray9 ={5,4,6};
		root = BuildTree.build123Recur(root, intArray9);
		System.out.println(new HeightBalancedBinaryTree().isBalanced(root));
	}

	private boolean isBalanced(Node root){
		if(root == null){
			return true;
		}
		if(isBalanced(root.left)==isBalanced(root.right) && Math.abs(height(root.left) - height(root.right)) <= 1 ){
			return true;
		}
		return false;
	}

	private int height(Node root) {
		if(root == null){
			return 0;
		}
		return 1 + Math.max(height(root.left), height(root.right));
	}


}
