package com.JavaQues;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

	Map<Integer,Node> map=new HashMap<Integer,Node>();
	Node head=null;
	Node end=null;

	private class Node{
		Integer data;
		Node next;
		Node previous;
	}

	Node get(int key){
		if(map.containsKey(key)){
			Node n=map.get(key);
			remove(n);
			setHead(n);
		}
		return null;
	}

	private void setHead(Node n) {
		n.next=head;
		n.previous=null;

		if(head!=null){
			head.previous=n;
		}
		head=n;
		if(end==null){
			end=head;
		}
	}

	private void remove(Node n) {
		if(n.next!=null){
			n.next.previous=n.previous;
		}else{
			end=n.previous;
		}

		if(n.previous!=null){
			n.previous.next=n.next;
		}else{
			head=n.next;
		}
	}

	public void put(int key,Node n){
		if(map.containsKey(key)){
			Node oldValue=map.get(key);
			remove(oldValue);
			setHead(oldValue);
			oldValue.data=n.data;
		}
		else{
			setHead(n);
		}
	}
}
