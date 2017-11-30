package com.List;

public class MyList {

	Node head=null;
	
	public static void main(String[] args) {
		MyList m=new MyList();
		m=m.create();
		System.out.println(m);
		
	}
	MyList create(){
		MyList myList=new MyList();
		myList.add(12);
		myList.add(4);
		myList.add(16);
		myList.add(17);
		myList.add(18);
		myList.add(123);
		myList.add(34);
		myList.add(45);
		myList.add(676);
		myList.add(12344);
	
		return myList;
	} 
	
	void add(int data){
		if(head==null)
			head=new Node(data);
		
		else{
			Node curr=head;
			while(curr.link!=null){
				curr=curr.link;
			}
			
			curr.link=new Node(data);
		}
	}
	
	static class Node{
		Node link;
		int data;
		
		public Node(int data) {
			this.data=data;
			this.link=null;
		}
	}

	public void print(MyList m) {
		if(m.head!=null){
			Node curr=head;
			while(curr!=null){
				System.out.println(curr.data);
				curr=curr.link;
			}
		}
	}
}
