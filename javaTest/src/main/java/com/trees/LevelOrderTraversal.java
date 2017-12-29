package com.trees;

public class LevelOrderTraversal {
	public static void main(String[] args) {
		Node root = null;
		final Integer intArray[] = { 4, 2, 6, 1, 3, 5, 7 };
		root = BuildTree.build123Recur(root, intArray);
		TreeUtility.nonRecursiveTreeInorder(root);
		nonRecursiveLOT(root);
	
	}
	
	void recursiveLOT(Node node){
		
	}
	
	static void nonRecursiveLOT(Node node){
	/*Take queue add root 
	 * while(temp is not null)
	 * add(left and right)
	 * 
	 * 		*/
		Queue q=new Queue();
		q.enQueue(node);
		Node temp=node;

		while(temp!=null){
			if(temp.left!=null)
				q.enQueue(temp.left);
			if(temp.right!=null)
				q.enQueue(temp.right);
			temp=q.dequeue();
			System.out.println(temp.data);
		}
	}
}
