package com.recursion;

import com.mywork.MineLinkedList;
import com.mywork.Node;


public class ReverseLinkedList {

	public static Node head=null;
	static int arr[]={4,6,7,8,3,4,6,7,8};
	public static Node revhead=null;

	public static Node nonRecurHead=null;

	public static void main(final String[] args) {
		for (final int element : arr) {
			createLinkedList(element,head);
		}
		MineLinkedList.printList(head);
		reverseLinkedList(head);

		System.out.println("*************NON RECUR****************");
		for (final int element : arr) {
			createLinkedList(element,nonRecurHead);
		}
		MineLinkedList.printList(nonRecurHead);
		nonRecusriveReverseLinkedList(nonRecurHead);
		MineLinkedList.printList(nonRecurHead);



	}

	private static void nonRecusriveReverseLinkedList(final Node temp) {
		Node pre=null;
		Node curr=head;
		Node next=null;

		while(curr!=null){
			next=curr.next;
			curr.next=pre;
			pre=curr;
			curr=next;
		}
	}

	private static void reverseLinkedList(final Node temp) {

		if(temp.next==null){
			System.out.println(temp.data);
			createLinkedList(temp.data,revhead);
			return;
		}
		reverseLinkedList(temp.next);
		createLinkedList(temp.data,revhead);
		System.out.println(temp.data);

	}

	private static void createLinkedList(final int element,Node head) {

		if(head==null){
			final Node temp=new Node();
			temp.data=element;
			temp.next=null;
			head=temp;
		}else{
			Node curr=head;
			while(curr.next!=null){
				curr=curr.next;
			}

			final Node temp=new Node();
			temp.data=element;
			temp.next=null;
			curr.next=temp;
		}
	}
}
