package com.JavaQues;


public class Task_3 {

	// Please do not change this interface
	public static ListNode resHead=null;

	interface ListNode {
		int getItem();
		ListNode getNext();
		void setNext(ListNode next);
	}

	public static ListNode reverse(ListNode node) {
		/*
        Please implement this method to
        reverse a given linked list.
		 */

		if(node==null){
			return null;
		}
		if(node.getNext()==null){
			resHead=node;
			return resHead;
		}
		ListNode temp=reverse(node.getNext());
		temp.setNext(node);
		return temp;
	}

}