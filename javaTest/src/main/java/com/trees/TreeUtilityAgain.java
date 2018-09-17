package com.trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

@SuppressWarnings("unchecked")
public class TreeUtilityAgain {

	private static Node root;
	private static ArrayList path;

	public static void main(final String[] args) {

		final Integer intArray[] = { 4, 2, 6, 1, 3, 5, 7 };
		root = BuildTree.build123Recur(root, intArray);
		System.out.println(treeSizeRecur(root));
		System.out.println("**************************************");
		nonRecursiveTreeInorderAgain(root);
		System.out.println();
		System.out.println("**************************************");
		nonRecursiveTreePreorderAgain(root);
		System.out.println();
		System.out.println("**************************************");
		nonRecursiveTreePostorderAgain(root);
		System.out.println();
		System.out.println("**************************************");
		final Integer intArray2[] = { 5, 2, 6, 1, 3, 4, 7 };
		root = BuildTree.build123Recur(null, intArray2);
		final int maxDepth = maxDepthAgain(root);
		System.out.println(maxDepth);
		System.out.println("**************************************");
		root = null;
		root = BuildTree.build123Recur(root, intArray);
		System.out.println(hasPathSumAgain(root, 15));
		System.out.println(hasPathSumAgain(root, 16));
		System.out.println(hasPathSumAgain(root, 17));
		System.out.println("**************************************");
		root = null;
		root = BuildTree.build123Recur(root, intArray);
		final Node mirror = mirrorAgain(root);
		nonRecursiveTreeInorderAgain(mirror);
		System.out.println("\n**************************************");
		root = null;
		root = BuildTree.build123Recur(root, intArray);
		final Node doubleTree = doubleTreeAgain(root);
		nonRecursiveTreeInorderAgain(doubleTree);
		System.out.println("\n**************************************");
		root = null;
		root = BuildTree.build123Recur(root, intArray);
		final Integer intArray3[] = { 4, 2, 6, 1, 3, 5, 7 };
		Node root2 = null;
		root2 = BuildTree.build123Recur(root2, intArray3);
		final Boolean check = sameTreeAgain(root, root2);
		System.out.println("sameTree " + check);
		System.out.println("\n**************************************");
		System.out.println(countTreesAgain(5));
		System.out.println("\n**************************************");

		System.out
			.println("\n*************getAncestors of Node*************************");
		printAncestorAgain(root,5);
		/*root = null;
		final Integer intArray4[] = { 8, 4, 2, 6, 1, 3, 5, 7, 12, 10, 14, 9, 11, 13, 15 };
		root = BuildTree.build123Recur(root, intArray4);
		printPerimeter(root);
		System.out.println("\n*************printPath*************************");
		root = null;
		root = BuildTree.build123Recur(root, intArray);
		// printPath(root, 5);

		System.out
		.println("\n*************Count BST subtrees that lie in given range*************************");
		Integer intArray5[] = { 10, 5, 1, 50, 40, 100 };
		root = null;
		root = BuildTree.build123Recur(root, intArray5);
		final int count = countBSTSubtreeRange(root, 5, 45);
		System.out.println(count);

		System.out
		.println("\n*************Count BST subtrees that lie in given range*************************");
		Integer[] intArray6 = {4 , 2, 6, 1, 3, 5, 7};
		root = null;
		root = BuildTree.build123Recur(root, intArray6);
		final boolean isCousin = isCousin(root, 2, 7);
		final boolean isCousin2 = isCousin(root, 1, 5);
		final boolean isCousin3 = isCousin(root, 3, 7);
		final boolean isCousin4 = isCousin(root, 2, 6);
		System.out.println(isCousin+" "+isCousin2+" "+isCousin3+" "+isCousin4);



		System.out
		.println("\n*********Print a Binary Tree in Vertical and Horizontal Order*************************");
		printVerticalAndHorizontalNodes(root,5);

		System.out
		.println("\n*********get LCA by stack*************************");
		Node res= getLCAByStack(root,5,1);
		Node res1= getLCAByStack(root,3,1);
		Node res2= getLCAByStack(root,512,1);
		Node res3= getLCAByStack(root,7,5);
		System.out.println(res.data+" "+res1.data+" "+(res2!=null?res2.data:null)+" "+res3.data+" ");

		System.out
		.println("\n*********Print Binary Tree in 2-Dimensions*************************");
		print2D(root,"  ");

		System.out
		.println("\n*********Sink Odd nodes in Binary Tree*************************");
		//IMP.. As I am doing operation here from bottom so need postorder...
		Integer[] intArray7 ={5,8,2,1,4,9,10};
		root = null;
		root = BuildTree.build123Recur(root, intArray7);
		sinkOddNodes(root);
		System.out.println();

		System.out
		.println("\n*********Print all root to leaf paths*************************");
		root = null;
		root = BuildTree.build123Recur(root, intArray7);
		printAllRootToLeafPaths(root,new int[1000],0);*/
	}

	private static boolean printAncestorAgain(Node root, int i) {

		return false;
	}

	private static int countTreesAgain(int count) {
		/*for(int i=count;i>0;i--){
`
		}*/
		return 0;
	}

	private static Boolean sameTreeAgain(Node root1, Node root2) {
		if(root1 == null && root2 == null){
			return true;
		}
		if(root1 == null || root2 == null){
			return false;
		}
		return root1.data == root2.data &&
			sameTreeAgain(root1.left, root2.left) &&
			sameTreeAgain(root1.right, root2.right);
	}

	private static Node doubleTreeAgain(Node root) {

		if(root==null){
			return null;
		}

		Node doubleNode = new Node(root.data);
		doubleNode.left = doubleTreeAgain(root.left);
		root.left = doubleNode;
		root.right  = doubleTreeAgain(root.right);

		return root;
	}

	private static Node mirrorAgain(Node root) {
		if(root == null){
			return null;
		}
		Node node = new Node(root.data);
		node.left = mirrorAgain(root.right);
		node.right = mirrorAgain(root.left);
		return node;
	}

	private static boolean hasPathSumAgain(Node root, int sum) {
		if(root==null){
			if(sum==0){
				return true;
			}
			return false;
		}
		if(hasPathSumAgain(root.left,sum-(Integer) root.data) ||
			hasPathSumAgain(root.right,sum-(Integer) root.data)){
			return true;
		}
		else {
			return false;
		}
	}

	private static int maxDepthAgain(Node root) {
		if(root==null){
			return 0;
		}
		return 1 + Math.max(maxDepthAgain(root.left),maxDepthAgain(root.right));
	}

	private static void nonRecursiveTreePostorderAgain(Node root) {

	}

	private static void nonRecursiveTreePreorderAgain(Node root) {
		Stack<Node> stack = new Stack();
		stack.push(root);
		while (!stack.isEmpty()){
			Node node = stack.pop();
			System.out.print(node.data);

			if(node.right!=null){
				stack.push(node.right);
			}
			if(node.left!=null){
				stack.push(node.left);
			}

		}
	}

	private static void nonRecursiveTreeInorderAgain(Node root) {
		Stack<Node> stack = new Stack();
		stack.push(root);
		while(!stack.empty()){
			while(root.left!=null){
				stack.push(root.left);
				root = root.left;
			}
			Node node = stack.pop();
			System.out.print(node.data);
			if(node.right!=null){
				root = node.right;
				stack.push(root);
			}
		}
	}

	private static int treeSizeRecur(Node root) {
		if(root==null){
			return 0;
		}
		return 1+treeSizeRecur(root.left)+treeSizeRecur(root.right);
	}


}
