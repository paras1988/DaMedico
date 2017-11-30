package com.Heap;

import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.TreeMap;

class ListNode {
	public int val;
	public ListNode next;
	ListNode(int x) { val = x; next = null; }
}

public class MergeKSortedLists {
	public static void main(String[] args) {
		ListNode a1=new ListNode(1);
		ListNode a2=new ListNode(10);
		ListNode a3=new ListNode(20);
		a1.next=a2;
		a2.next=a3;

		ListNode b1=new ListNode(4);
		ListNode b2=new ListNode(11);
		ListNode b3=new ListNode(13);
		b1.next=b2;
		b2.next=b3;

		ListNode c1=new ListNode(3);
		ListNode c2=new ListNode(8);
		ListNode c3=new ListNode(9);
		c1.next=c2;
		c2.next=c3;

		ArrayList<ListNode> arr=new ArrayList<ListNode>();
		arr.add(a1);
		arr.add(b1);
		arr.add(c1);

		ListNode res=new MergeKSortedLists().mergeKLists(arr);
		System.out.println(res);


		ListNode res2=new MergeKSortedLists().treeMergeKLists(arr);
		System.out.println(res2);

	}

	private ListNode treeMergeKLists(ArrayList<ListNode> arr) {


		TreeMap<Integer,ArrayList<ListNode>> map=new TreeMap<>();

		for(ListNode head:arr){

			while(head!=null){
				if(map.containsKey(head.val)){
					ArrayList<ListNode> list=map.get(head.val);
					list.add(head);
					map.put(head.val, list);
				}else{
					ArrayList<ListNode> list=new ArrayList<>();
					list.add(head);
					map.put(head.val, list);
				}
				head=head.next;
			}
		}

		ListNode res=null;
		ListNode head=null;

		for(Entry<Integer,ArrayList<ListNode>> e:map.entrySet()){

			for(ListNode l:e.getValue()){
				if(res==null){
					res=new ListNode(l.val);
					head=res;
				}else{
					res.next=l;
					res=res.next;
				}
			}
		}
		return head;
	}

	public ListNode mergeKLists(ArrayList<ListNode> a) {

		ListNode res=null;

		for(int i=0;i<a.size();i++){
			res=merge(a,res,a.get(i));
		}

		return res;
	}

	private ListNode merge(ArrayList<ListNode> a, ListNode listNode1,ListNode listNode2) {

		ListNode res=null;

		ListNode temp1=listNode1;
		ListNode temp2=listNode2;
		ListNode temp =null;

		while(temp1!=null && temp2!=null){

			if(temp1.val<temp2.val){
				if(res==null){
					res=new ListNode(temp1.val);
					temp=res;
				}else{
					temp.next=new ListNode(temp1.val);
					temp=temp.next;
				}
				temp1=temp1.next;
			}else{
				if(res==null){
					res=new ListNode(temp2.val);
					temp=res;
				}else{
					temp.next=new ListNode(temp2.val);
					temp=temp.next;
				}
				temp2=temp2.next;
			}
		}

		while(temp1!=null){
			if(temp==null){
				temp=temp1;
				res=temp;
				break;
			}else{
				temp.next=temp1;
				temp=temp.next;
				temp1=temp1.next;
			}
		}
		while(temp2!=null){
			if(temp==null){
				temp=temp2;
				res=temp;
				break;
			}else{
				temp.next=temp2;
				temp=temp.next;
				temp2=temp2.next;
			}
		}
		return res;
	}
}
