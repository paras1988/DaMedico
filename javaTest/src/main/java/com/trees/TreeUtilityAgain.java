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
		System.out.println("\n****************countTreesAgain**********************");
		System.out.println(countTreesAgain(2)+" "+countTreesAgain(3)+" "+countTreesAgain(4)+" "+countTreesAgain(5));
		System.out.println("\n**************************************");

		System.out.println("\n**********getAncestors of Node********************");
		printAncestorAgain(root,5);
		root = null;
		final Integer intArray4[] = { 8, 4, 2, 6, 1, 3, 5, 7, 12, 10, 14, 9, 11, 13, 15 };
		System.out.println("\n**********perimeter of tree********************");

		root = BuildTree.build123Recur(root, intArray4);
		printPerimeterAgain(root);
		System.out.println("\n*************printPath*************************");
		root = null;
		root = BuildTree.build123Recur(root, intArray);
		// printPath(root, 5);

		System.out
		.println("\n*************Count BST subtrees that lie in given range*************************");
		Integer intArray5[] = { 10, 5, 1, 50, 40, 100 };
		root = null;
		root = BuildTree.build123Recur(root, intArray5);
		BSTcount = 0;
		countBSTSubtreeRangeAgain(root, 5, 45);
		final int count = BSTcount;
		System.out.println(count);

		BSTcount = 0;
		countBSTSubtreeRangeAgain(root, 1, 45);
		final int count2 = BSTcount;
		System.out.println(count2);

		/**
		 * Two nodes are cousins of each other if they are at same level
		 * and have different parents
		 */
		System.out
		.println("\n*************Check the nodes are cousin*********************");
		Integer[] intArray6 = {4 , 2, 6, 1, 3, 5, 7};
		root = null;
		root = BuildTree.build123Recur(root, intArray6);
		final boolean isCousin = isCousinAgain(root, 2, 7);
		final boolean isCousin2 = isCousinAgain(root, 1, 5);
		final boolean isCousin3 = isCousinAgain(root, 3, 7);
		final boolean isCousin4 = isCousinAgain(root, 2, 6);
		System.out.println(isCousin+" "+isCousin2+" "+isCousin3+" "+isCousin4);



		System.out
		.println("\n*********Print a Binary Tree in Vertical and Horizontal Order*************************");
		printVerticalAndHorizontalNodesAgain(root);

		System.out
		.println("\n*********get LCA by stack*************************");
		Node res= getLCAByStackAgain(root,5,1);
		Node res1= getLCAByStackAgain(root,3,1);
		Node res2= getLCAByStackAgain(root,512,1);
		Node res3= getLCAByStackAgain(root,7,5);
		System.out.println(res.data+" "+res1.data+" "+(res2!=null?res2.data:null)+" "+res3.data+" ");

		System.out
			.println("\n*********get LCA by not stack*************************");
		Node res4= getLCANotByStack(root,5,1);
		Node res5= getLCANotByStack(root,3,1);
		Node res6= getLCANotByStack(root,512,1);
		Node res7= getLCANotByStack(root,7,5);
		System.out.println(res4.data+" "+res5.data+" "+(res6!=null?res6.data:null)+" "+res7.data+" ");



/*		System.out
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
	*/
		Integer[] intArray7 ={5,8,2,1,4,9,10};
		System.out
		.println("\n*********Print all root to leaf paths*************************");
		root = null;
		root = BuildTree.build123Recur(root, intArray7);
		printAllRootToLeafPathsAgain(root,new int[1000],0);

		System.out
			.println("\n*********left view , right view , bottom view , top view paths*************************");

		//Left : 1. Level order,
		// 			 2. simple recursion when level changes print first

		//Bottom: 1. Level order
		//				2. Simple recursion update max depth

	}

	private static void printAllRootToLeafPathsAgain(Node root, int[] ints, int i) {

	}

	private static Node getLCANotByStack(Node root, int i, int j) {
		return null;
	}
	private static Node getLCAByStackAgain(Node root, int i, int j) {
		Stack<Node> stack1 = new Stack();
		Stack<Node> stack2 = new Stack();

		getAncestors(root,i,stack1);
		getAncestors(root,j,stack2);

		Node res = null;

		while (!stack1.empty() && !stack2.empty() && stack1.peek() == stack2.peek()){
			stack1.pop();
			res = stack2.pop();
		}

		return res;
	}

	private static boolean getAncestors(Node root, int i, Stack stack1) {
		if(root==null){
			return false;
		}
		if(root.getIntVal() == i ||
			getAncestors(root.left,i,stack1) ||
			getAncestors(root.right,i,stack1)){

			stack1.push(root);
			return true;
		}
		return false;
	}

	private static void printVerticalAndHorizontalNodesAgain(Node root) {
		//computeMinMax
		//printVertical(root,0);
		//printHorizontal(root);
	}

	private static boolean isCousinAgain(Node root, int i, int j) {
		int h1 = getheight(root,i,0);
		int h2 = getheight(root,j,0);

		if(h1 != h2){
			return false;
		}

		Node root1 = getAncestor(root,i);
		Node root2 = getAncestor(root,j);

		if(root1.data.compareTo(root2.data) == 0){
			return false;
		}
		return true;
	}

	private static Node getAncestor(Node root, int i) {
		if(root==null){
			return null;
		}
		if((root.left!= null && root.left.getIntVal() == i) ||
			(root.left!= null && root.right.getIntVal() == i)){
			return root;
		}

		Node res;
		res = getAncestor(root.left,i);
		if(res!=null){
			return res;
		}
		res = getAncestor(root.right,i);
		if(res!=null){
			return res;
		}
		return null;
	}

	private static int getheight(Node root, int i, int h) {
		if(root == null){
			return -1;
		}
		if(root.getIntVal() == i){
			return h;
		}
		int res;
		res = getheight(root.left,i,h+1);
		if(res!=-1){
			return res;
		}
		res = getheight(root.right,i,h+1);
		return res;
	}

	private static int BSTcount = 0;
	private static Boolean countBSTSubtreeRangeAgain(Node root, int i, int j) {
		if(root == null){
			return true;
		}
		boolean left = countBSTSubtreeRangeAgain(root.left,i,j);
		boolean right = countBSTSubtreeRangeAgain(root.right,i,j);

		if(left && right && root.getIntVal()>=i && root.getIntVal()<=j){
			BSTcount++;
			return true;
		}
		return false;
	}

	private static void printPerimeterAgain(Node root) {
		peripreorder(root);
		periinorder(root);
		peripostOrder(root);
	}

	private static void peripostOrder(Node root) {
		if(root==null){
			return;
		}
		if(root.right!=null && root.right.right!=null){
			peripostOrder(root.right);
			System.out.print(root.right.data+" ");
		}
	}

	private static void periinorder(Node root) {
		if(root == null){
			return;
		}
		periinorder(root.left);
		if(root.left == null && root.right == null){
			System.out.print(root.data+" ");
		}
		periinorder(root.right);
	}

	private static void peripreorder(Node root) {
		if(root==null){
			return;
		}
		if(root.left!=null && root.left.left!=null){
			System.out.print(root.left.data+" ");
			peripreorder(root.left);
		}
	}

	private static boolean printAncestorAgain(Node root, int i) {
		if(root == null){
			return false;
		}
		if(root.data.compareTo(i)==0 ||
			printAncestorAgain(root.left,i) ||
			printAncestorAgain(root.right,i)){
			System.out.print(root.data);
			return true;
		}
		return false;
	}

	private static int countTreesAgain(int count) {
		int total = 0;
		if(count == 0){
			return 0;
		}
		if(count == 1){
			return 1;
		}
		for(int i=1;i<=count;i++){
			total += countTreesAgain(i-1)+countTreesAgain(count-i);
		}
		return total;
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
