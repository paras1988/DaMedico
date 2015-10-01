package com.List;

import com.List.MyList.Node;

public class RecursiveReverse {
	public static void main(String[] args) {
		MyList m=new MyList();
		m=m.create();
		//m=recursiveReverse(m.head);
		m.head=myReverse(m.head);
		m.print(m);
	}

	private static Node recursiveReverse(Node m) {
		if(m.link==null){
			return m.link;
		}
		else{
			recursiveReverse(m.link);
		}
		return null;
	}
	
	
	public static Node Reverse(Node list)

	{
	    if (list == null) return null; // first question

	    if (list.link == null) return list; // second question

	    // third question - in Lisp this is easy, but we don't have cons
	    // so we grab the second element (which will be the last after we reverse it)

	    Node secondElem = list.link;

	    // bug fix - need to unlink list from the rest or you will get a cycle
	    list.link = null;

	    // then we reverse everything from the second element on
	    Node reverseRest = Reverse(secondElem);

	    // then we join the two lists
	    secondElem.link = list;

	    return reverseRest;
	}
	
	public static Node myReverse(Node currNode){
		
		if(currNode==null || currNode.link==null)
			return currNode;
		
		Node nextNode=currNode.link;
		
		currNode.link=null;
		
		Node result=myReverse(nextNode);
		
		nextNode.link=currNode;
		
		return result;
	}
}
