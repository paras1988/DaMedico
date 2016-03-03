package com.JavaQues;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache<V> {

	Map<Integer,Node> map=new HashMap<Integer,Node>();
	private LinkedList<Node> list=new LinkedList<Node>();
	Node head=null;
	Node end=null;
	
	private class Node<V>{
		V val;
		Node next;
		Node previous;
	}

	Node get(Integer i){
		if(map.containsKey(i)){
			Node val=(Node) map.get(i);
			setHead(val);
			return val;	
		}
		return null;
	}

	private void setHead(Node node) {
		if(list.contains(node)){
			list.remove(node);
			node.previous.next=node.next;
			node.previous=null;
		}
		node.next=head;
		head=node;
	}
}
