package com.trees;

public class Stack {

	StackElement element=null;
	int elementCount=0;

	void push(final Node node){
		if(element==null){
			element=new StackElement(node);
		}else{
			StackElement curr=element;
			while(curr.next!=null){
				curr=curr.next;
			}
			curr.next=new StackElement(node);
		}
		elementCount++;
	}

	Node pop(){
		if(element==null) {
			return null;
		} else{
			StackElement curr=element;
			if(curr.next==null){
				element=null;
				return curr.node;
			}
			while(curr.next.next!=null){
				curr=curr.next;

			}
			final Node temp=curr.next.node;
			curr.next=null;
			return temp;
		}

	}

	Node top(){
		if(element==null) {
			return null;
		} else{
			StackElement curr=element;
			if(curr.next==null){
				//element=null;
				return curr.node;
			}
			while(curr.next.next!=null){
				curr=curr.next;
			}
			final Node temp=curr.next.node;
			//curr.next=null;
			return temp;
		}
	}


	Boolean isEmpty(){
		if(element==null){
			return true;
		}
		return false;
	}


	public static void main(final String[] args) {

		Node root = null;

		final Integer intArray[]={4,2,6,1,3,5,7};
		root=BuildTree.build123Recur(root,intArray);

		final Stack stack=new Stack();
		stack.push(root);
		stack.push(root.left);
		stack.push(root.right);
		stack.push(root.right.right);

		System.out.println(stack.pop().data);
		System.out.println(stack.pop().data);
		System.out.println(stack.pop().data);
		System.out.println(stack.pop().data);
	}
}


