package com.trees;

import java.util.ArrayList;
import java.util.List;

public class PrintAllTrees {

	private static Node root;
	public static void main(String[] args) {

		final Integer intArray[] = { 4, 2, 6, 1, 3, 5, 7 };
		root = BuildTree.build123Recur(root, intArray);
		//TreeUtility.nonRecursiveTreeInorder(root);
		int in[] = {4,5,6};
		List<Node> list=printAllTrees(in,0,in.length-1);
		for (int i = 0; i < list.size(); i++) {
			TreeUtility.nonRecursiveTreePreorder(list.get(i));
			System.out.println("");
		}
	}

	private static List<Node> printAllTrees(int[] in, int s, int e) {
		List<Node> nodes = new ArrayList<>();
		if(s>e){
			nodes.add(null);
			return nodes;
		}

		for (int i = s; i <= e; i++) {

			for (Node lnode : printAllTrees(in, s, i-1)) {
				for (Node rnode : printAllTrees(in, i+1, e)) {

					Node node = new Node(in[i]);
					node.left = lnode;
					node.right = rnode;
					nodes.add(node);
				}
			}
		}
		return nodes;
	}
}
