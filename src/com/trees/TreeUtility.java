package com.trees;

import java.util.ArrayList;

public class TreeUtility {

	private static Node root;
	private static ArrayList path;

	public static void main(final String[] args) {

		final Integer intArray[] = { 4, 2, 6, 1, 3, 5, 7 };
		root = BuildTree.build123Recur(root, intArray);
		System.out.println(treeSizeRecur(root));
		System.out.println("**************************************");
		nonRecursiveTreeInorder(root);
		System.out.println();
		System.out.println("**************************************");
		nonRecursiveTreePreorder(root);
		System.out.println();
		System.out.println("**************************************");
		nonRecursiveTreePostorder(root);
		System.out.println();
		System.out.println("**************************************");
		final Integer intArray2[] = { 5, 2, 6, 1, 3, 4, 7 };
		root = BuildTree.build123Recur(root, intArray2);
		final int maxDepth = maxDepth(root);
		System.out.println(maxDepth);
		System.out.println("**************************************");
		root = null;
		root = BuildTree.build123Recur(root, intArray);
		final boolean hasPathSum = hasPathSum(root, 15);
		System.out.println(hasPathSum);
		System.out.println("**************************************");
		root = null;
		root = BuildTree.build123Recur(root, intArray);
		final Node mirror = mirror(root);
		nonRecursiveTreeInorder(mirror);
		System.out.println("\n**************************************");
		root = null;
		root = BuildTree.build123Recur(root, intArray);
		final Node doubleTree = doubleTree(root);
		nonRecursiveTreeInorder(doubleTree);
		System.out.println("\n**************************************");
		root = null;
		root = BuildTree.build123Recur(root, intArray);
		final Integer intArray3[] = { 4, 2, 6, 1, 3, 5, 7 };
		Node root2 = null;
		root2 = BuildTree.build123Recur(root2, intArray3);
		final Boolean check = sameTree(root, root2);
		System.out.println("sameTree " + check);
		System.out.println("\n**************************************");
		System.out.println(countTrees(5));
		System.out.println("\n**************************************");
		root = null;
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
		.println("\n*************getAncestors of Node*************************");
		printAncestor(root,5);

	}


	private static boolean printAncestor(Node root, int i) {

		if(root==null){
			return false;
		}
		if(root.data.compareTo(i)==0){
			return true;
		}

		if(printAncestor(root.left,i) || printAncestor(root.right,i)){
			System.out.println(root.data);
			return true;
		}
		return false;

	}


	@SuppressWarnings("unchecked")
	private static boolean isCousin(Node root, int i, int j) {
		Node parent1 =getParent(root,i);
		Node parent2 =getParent(root,j);

		if(parent1!=null && parent2!=null &&
				parent1.data.compareTo(parent2.data)!=0){
			int height1=getHeight(root,i,0);
			int height2=getHeight(root,j,0);
			if(height1==height2){
				return true;
			}
		}
		return false;
	}


	private static int getHeight(Node root, int i,int count) {

		if(root==null){
			return 0;
		}
		if(root.data.compareTo(i)==0){
			return count;
		}
		int h=getHeight(root.left,i,count+1);
		int r=getHeight(root.right,i,count+1);

		if(h>r){
			return h;
		}else{
			return r;
		}
	}


	private static int getHeightUtil(Node root, int i, int count) {

		return 0;
	}


	private static Node getParent(Node root, int i) {
		if(root==null){
			return null;
		}else if(root.left==null && root.right==null){
			return null;
		}
		else if((root.left!=null && root.left.data.compareTo(i)==0) ||
				(root.right!=null && root.right.data.compareTo(i)==0) ){
			return root;
		}
		else{
			if(getParent(root.left,i)!=null){
				return root.left;
			}
			if(getParent(root.right,i)!=null){
				return root.right;
			}
		}
		return null;
	}


	private static int countBSTSubtreeRange(final Node root, final int low, final int high) {
		int t = 0;
		if (root == null) {
			return 0;
		}
		if (BSTlessThanExpected(root.left, low, high) && BSTlessThanExpected(root.right, low, high)) {
			t = t + countBSTSubtreeRange(root.left, low, high)
					+ countBSTSubtreeRange(root.right, low, high);
		}
		return t;
	}

	private static boolean BSTlessThanExpected(final Node root, final int low, final int high) {
		if (root == null) {
			return false;
		}
		if (root.data.compareTo(high) < 0 && root.data.compareTo(low) > 0) {
			if (BSTlessThanExpected(root.left, low, high)
					&& BSTlessThanExpected(root.right, low, high)) {
				return true;
			}
		}
		return false;

	}

	private static Boolean printPath(final Node root, final Integer dest) {
		if (root == null) {
			return false;
		}
		if (root.data == dest || printPath(root.left, dest) || printPath(root.right, dest)) {
			System.out.print("  " + root.data);
			if (root != null) {
				path.add(root.data);
			}
			return true;
		}
		return false;
	}

	private static int treeSizeRecur(final Node root) {
		if (root == null) {
			return 0;
		}
		int size = 1;
		size = size + treeSizeRecur(root.left) + treeSizeRecur(root.right);
		return size;
	}

	// inorder non recursive.
	static void nonRecursiveTreeInorder(final Node root) {
		final Stack s = new Stack();
		Node curr = root;
		do {
			while (curr != null) {
				s.push(curr);
				curr = curr.left;
			}
			if (s.isEmpty()) {
				break;
			}
			curr = s.pop();
			System.out.print(curr.data);
			curr = curr.right;
		} while (true);
	}

	// preorder non recursive.
	public static void nonRecursiveTreePreorder(final Node root) {
		final Stack s = new Stack();
		Node curr = root;
		do {
			while (curr != null) {
				s.push(curr);
				System.out.print(curr.data);
				curr = curr.left;
			}
			if (s.isEmpty()) {
				break;
			}
			curr = s.pop();
			curr = curr.right;
		} while (true);
	}

	// postorder non recursive.
	private static void nonRecursiveTreePostorder(final Node root) {
		final Stack s = new Stack();
		Node curr = root;
		do {
			while (curr != null) {
				s.push(curr);
				curr = curr.left;
			}
			curr = s.top();
			if (s.top() == root) {
				System.out.println(root.data);
				break;
			}
			if (s.top().right == null) {
				curr = s.pop();
				System.out.print(curr.data);
				if (s.top().right == curr) {
					curr = s.pop();
					System.out.print(curr.data);
				}
			}
			if (s.top().right != curr) {
				curr = s.top().right;
			} else {
				curr = null;
			}
		} while (true);
	}

	private static int maxDepth(final Node root) {

		if (root == null) {
			return 0;
		}
		final int leftDepth = maxDepth(root.left);
		final int rightDepth = maxDepth(root.right);

		if (leftDepth > rightDepth) {
			return leftDepth + 1;
		} else {
			return rightDepth + 1;
		}
	}

	private static boolean hasPathSum(final Node root, final int sum) {

		if (root == null) {
			return false;
		}

		final int subsum = sum - ((Integer) root.data);
		if (subsum == 0) {
			return true;
		}
		return (hasPathSum(root.left, subsum) || hasPathSum(root.right, subsum));
	}

	private static Node mirror(final Node root) {

		final Node mRoot = new Node(root.data);

		if (root.left != null) {
			mRoot.right = mirror(root.left);
		}

		if (root.right != null) {
			mRoot.left = mirror(root.right);
		}

		return mRoot;
	}

	private static Node doubleTree(final Node root) {

		if (root == null) {
			return null;
		}

		doubleTree(root.left);
		doubleTree(root.right);

		final Node temp = root.left;
		root.left = new Node(root.data);
		root.left.left = temp;

		return root;
	}

	private static boolean sameTree(final Node root, final Node otherRoot) {

		if (root == null && otherRoot == null) {
			return true;
		}

		if (root != null && otherRoot != null) {
			return (root.data.compareTo(otherRoot.data) == 0 && sameTree(root.left, otherRoot.left) && sameTree(
					root.right, otherRoot.right));
		} else {
			return false;
		}
	}

	static int countTrees(final int numKeys) {
		if (numKeys == 0) {
			return 0;
		}

		if (numKeys == 1) {
			return 0;
		}

		if (numKeys == 2) {
			return 2;
		}

		if (numKeys == 3) {
			return 5;
		}

		int sum = 0;

		for (int i = 1; i <= numKeys; i++) {
			sum = sum + (countTrees(i - 1) + countTrees(numKeys - i));
		}
		return sum;
	}

	static void printPerimeter(final Node root) {
		System.out.print(root.data + ",");
		printPreorder(root.left);
		printPostorder(root.right);
		System.out.print(root.data + "...");
	}

	private static void printPreorder(final Node root) {

		if (root == null) {
			return;
		}

		System.out.print(root.data + ",");
		printPreorder(root.left);

		if (root != null) {
			temp(root.right);
		}
	}

	private static void printPostorder(final Node root) {

		if (root != null) {
			temp(root.left);
		}

		if (root == null) {
			return;
		}
		printPostorder(root.right);
		System.out.print(root.data + ",");
	}

	private static void temp(final Node root) {

		if (root == null) {
			return;
		}

		if (root.left == null && root.right == null) {
			System.out.print(root.data + ",");
		}

		temp(root.left);
		temp(root.right);
	}

}
