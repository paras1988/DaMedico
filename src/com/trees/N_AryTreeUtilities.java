package com.trees;

import java.util.LinkedList;
import java.util.List;


public class N_AryTreeUtilities {

	public static void main(String[] args) {

		NaryNode root = new NaryNode(100);
		NaryNode childroot1 = new NaryNode(20);
		NaryNode childroot2 = new NaryNode(30);
		NaryNode childroot3 = new NaryNode(40);
		NaryNode childroot4 = new NaryNode(50);
		root.add(childroot1);
		root.add(childroot2);
		root.add(childroot3);
		root.add(childroot4);

		NaryNode child1ChildRoot1 = new NaryNode(80);
		NaryNode child2ChildRoot1 = new NaryNode(90);
		childroot1.add(child1ChildRoot1);
		childroot1.add(child2ChildRoot1);

		NaryNode child1ChildRoot2 = new NaryNode(110);
		childroot2.add(child1ChildRoot2);

		NaryNode child1ChildRoot3 = new NaryNode(120);
		NaryNode child2ChildRoot3 = new NaryNode(130);
		childroot3.add(child1ChildRoot3);
		childroot3.add(child2ChildRoot3);

		new N_AryTreeUtilities().display(root);

		/********************************Number of ways to traverse an N-ary tree*/

		List<Integer> listFact=new LinkedList<Integer>();
		getNumberOfWays(root,listFact);
		System.out.println(listFact);
		int res=1;
		for(int t:listFact){
			res *=getFactorial(t);
		}
		System.out.println(res);


	}

	private static int getFactorial(int t) {
		if(t==0){
			return 1;
		}
		return t*getFactorial(t-1);
	}

	private static void getNumberOfWays(NaryNode root,List<Integer> listFact) {

		if(root==null) {
			return;
		}
		if(root.getChildren()==null || root.getChildren().size()==0){
			return;
		}
		listFact.add(root.getChildren().size());
		for(NaryNode node:root.getChildren()){
			getNumberOfWays(node,listFact);
		}
	}

	private void display(NaryNode node) {
		if(node==null){
			return;
		}
		if(node.getChildren()!=null && node.getChildren().size() > 0) {
			for(int i = 0 ; i < node.getChildren().size() ; i++) {
				display((NaryNode)node.get(i));
			}
			System.out.println(node.getData());
		} else {
			System.out.println(node.getData());
		}

	}

}
