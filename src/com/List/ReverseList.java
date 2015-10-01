package com.List;

import com.List.MyList.Node;

public class ReverseList {
	public static void main(String[] args) {
		MyList m=new MyList();
		m=m.create();
		m=reverse(m);
		m.print(m);
	}

	private static MyList reverse(MyList m) {
		MyList m2=new MyList();
		
		if(m.head==null){
			return null;
		}
		else{
			Node curr=m.head;
			while(m.head!=null){
				m.head=m.head.link;
				m2=moveNode(m2,curr);
				curr=m.head;
			}
		}
		return m2;
	}

	private static MyList moveNode(MyList m2, Node curr) {
	
		if(m2.head==null){
			curr.link=null;
			m2.head=curr;
		}else{
			curr.link=m2.head;
			m2.head=curr;
		}
		return m2;
	}
	
}
