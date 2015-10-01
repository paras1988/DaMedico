package com.trees;

public class BST1toN {
	private static Node root;

	public static void main(final String[] args) {

		final Integer intArray[] = { 4, 2, 6, 1, 3, 5, 7 };
		root = BuildTree.build123Recur(root, intArray);
		TreeUtility.nonRecursiveTreeInorder(root);
	}
}
