package com.JavaQues;

public class ReverseLinkedList {

	static Node head=null;
	public static void main(String[] args) {
		push(7);
		push(2);
		push(3);
		push(4);
		push(4);
		push(3);
		push(2);
		push(1);

		System.out.println(head);
		Node newHead=reverseList(head);
		System.out.println(newHead);
	}

	private static Node reverseList(Node head) {
		if(head==null || head.next == null) {
			return head;
		}
		Node sec=head.next;
		head.next=null;
		Node rest=reverseList(sec);
		sec.next=head;
		return rest;

	}

	static void push(int data){
		if(head==null){
			head=new ReverseLinkedList.Node(data);
		}else{
			Node temp=head;
			while(temp.next!=null){
				temp=temp.next;
			}
			temp.next=new Node(data);
		}
	}

	private static class Node{
		Node next;
		int data;

		Node(int data){
			this.data=data;
		}
	}

}

