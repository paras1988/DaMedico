package com.JavaQues;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


/*6,4,1,5,2,7,1,_5,_6,_7,8,3,2
window 5,6,7

ans 3
 */

public class FindMinWindow {
	public static void main(String[] args) {

		Map<Integer,Node> map=new HashMap<Integer,Node>();

		int[] arr={6,4,1,5,2,7,1,5,6,7,8,3,2};
		Set<Integer> set=new HashSet<Integer>();
		set.add(5);
		set.add(6);
		set.add(7);

		boolean flag=false;
		int min=10000;

		for(int i=0;i<arr.length;i++){
			Node temp=new Node(arr[i]);
			if(set.contains(arr[i])) {
				map.put(arr[i],temp);
			}
			if(map.size()==set.size()){
				flag=true;
			}

			if(flag){
			}
		}

	}
}

class Node{
	int data;

	public Node(int i) {
		this.data=i;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
}