package com.trees;

import java.util.LinkedList;
import java.util.List;

public class NaryNode{
	int data;
	List<NaryNode> children;

	public NaryNode(int data) {
		this.data=data;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public List<NaryNode> getChildren() {
		return children;
	}
	public void setChildre(List<NaryNode> children) {
		this.children = children;
	}
	public boolean add(Object naryNode) {
		if(children==null){
			children=new LinkedList<NaryNode>();
		}
		children.add((NaryNode) naryNode);
		return true;
	}
	public Object get(int index) {
		// TODO Auto-generated method stub
		return children.get(index);
	}
}
