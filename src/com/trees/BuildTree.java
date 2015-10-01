package com.trees;
public class BuildTree {

	private static Node root;
	private static Node root2;
	private static Node root3;

	public static void main(final String[] args) {

		final Integer a = 12;
		final Integer b = 123;
		final Integer c = 34;

		final Integer intArray[]={343,67,8734,23,34,23,2,24,22,78};
		final Comparable compArray[]=intArray;

		root= build123(a , b , c);

		root2= build123(root2,compArray);

		root3=build123Recur(root3,compArray);


		System.out.println("Line written to debug");

	}

	private static Node build123(final Comparable a,final Comparable b,final Comparable c) {

		final Node temp=new Node(c);
		temp.left=new Node(a);
		temp.right=new Node(b);

		return temp;
	}

	private static Node build123( Node rootT,final Comparable []a) {

		for(final Comparable c:a){
			rootT=insert(rootT,c);
		}

		return rootT;

	}

	public static Node build123Recur( Node rootT,final Comparable []a) {

		for(final Comparable c:a){
			rootT=recursiveInsert(rootT,c);
		}

		return rootT;

	}

	private static Node insert(final Node rootT, final Comparable a) {
		if(rootT==null){
			return new Node(a);
		}
		else{
			Node curr=rootT;
			while(true){
				if(curr.data.compareTo(a)<0 && curr.right!=null){
					curr=curr.right;
				}else if(curr.left!=null && curr.data.compareTo(a)>=0){
					curr=curr.left;
				}else{
					break;
				}
			}
			if(curr.data.compareTo(a)==-1){
				curr.right=new Node(a);
			}else {
				curr.left=new Node(a);
			}


			return rootT;
		}
	}

	private static Node recursiveInsert(final Node rootT, final Comparable a) {
		if(rootT==null){
			return new Node(a);
		}
		else{
			if(rootT.data.compareTo(a)==-1){
				rootT.right=recursiveInsert(rootT.right,a);
			}else{
				rootT.left=recursiveInsert(rootT.left,a);
			}
			return rootT;
		}
	}

}
