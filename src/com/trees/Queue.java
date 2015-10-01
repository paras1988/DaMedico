package com.trees;

import java.util.LinkedList;
import java.util.List;

public class Queue {

	QueueElement qEl=null;
	QueueElement head=null;

	public Queue() {
	}

	boolean enQueue(Node node){
		if(qEl==null){
			qEl=new QueueElement(node);
			return true;
		}
		while(qEl.next!=null){
			qEl=qEl.next;
		}
		qEl.next=new QueueElement(node);
		
		return true;
	}

	Node dequeue(){
		return null;
	}

	class QueueElement{
		Node node;
		QueueElement next=null;

		QueueElement(Node node){
			this.node=node;
		}

		QueueElement(){
		}
	}
	
	public static void main(String[] args) {
		Node root = null;

		final Integer intArray[]={4,2,6,1,3,5,7};
		root=BuildTree.build123Recur(root,intArray);

		final Queue stack=new Queue();
		stack.enQueue(root);
		stack.enQueue(root.left);
		stack.enQueue(root.right);
		stack.enQueue(root.right.right);

		System.out.println(stack.dequeue().data);
		System.out.println(stack.dequeue().data);
		System.out.println(stack.dequeue().data);
		System.out.println(stack.dequeue().data);
	}
}
