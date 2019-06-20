package com.trees;

public class Node{

	public Comparable data;
	public Node left=null;
	public Node right=null;

	Node(final Comparable c){
		data=c;
	}

	public int getIntVal(){
		return (Integer)data;
	}

}