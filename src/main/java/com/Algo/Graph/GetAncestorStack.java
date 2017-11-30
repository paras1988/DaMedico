package com.Algo.Graph;

import java.util.Stack;

public class GetAncestorStack {

	static Boolean flag=false;
	static class Node{
		int data;
		Node left;
		Node right;
		Node(int data){
			this.data=data;
		}
	}

	public static void main(String[] args) {

		Node root=new Node(1);
		Node a=new Node(2);
		Node b=new Node(3);
		Node c=new Node(4);
		Node d=new Node(5);
		Node e=new Node(6);
		Node f=new Node(7);
		root.left=a;
		a.left=b;
		a.right=c;
		root.right=d;
		d.left=e;
		d.right=f;

		Node g=new Node(8);
		Stack<Node> stack = new Stack<Node>();
		printAncestors(root,7,stack);
		//DFS(root,stack,f);
		System.out.println(stack);
	}

	static Stack<Node> DFS(Node node, Stack<Node> stack, Node e){

		Node temp=node;
		while(temp!=null){

		}

		return null;
	}

	static Boolean printAncestors(Node root, int target,Stack<Node> stack)
	{
		/* base cases */
		if (root == null) {
			return false;
		}

		if (root.data == target) {
			return true;
		}

		/* If target is present in either left or right subtree of this node,
	     then print this node */
		if ( printAncestors(root.left, target,stack) ||
				printAncestors(root.right, target,stack) )
		{
			stack.push(root);
			return true;
		}

		/* Else return false */
		return false;
	}
}
