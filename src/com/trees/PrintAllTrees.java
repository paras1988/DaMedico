package com.trees;

import java.util.ArrayList;
import java.util.List;

public class PrintAllTrees {

	private static Node root;
	public static void main(String[] args) {

		final Integer intArray[] = { 4, 2, 6, 1, 3, 5, 7 };
		root = BuildTree.build123Recur(root, intArray);
		//TreeUtility.nonRecursiveTreeInorder(root);
		int in[] = {4,5,7};
		List<Node> list=printAllTrees(in,0,in.length-1);
		for (int i = 0; i < list.size(); i++) {
			TreeUtility.nonRecursiveTreePreorder(list.get(i));
			System.out.println("");
		}
	}
	private static List<Node> printAllTrees(int[] in, int s, int e) {

		List<Node> out=new ArrayList<Node>();
		if(e<s){
			out.add(null);
			return out;
		}
		for(int i=s;i<=e;i++){

			List<Node> ltrees=printAllTrees(in,s,i-1);
			List<Node> rtrees=printAllTrees(in,i+1,e);

			for(Node l:ltrees){
				for(Node r:rtrees){

					Node n=new Node(in[i]);

					n.left=l;
					n.right=r;
					out.add(n);
				}
			}
		}
		return out;
	}

}
