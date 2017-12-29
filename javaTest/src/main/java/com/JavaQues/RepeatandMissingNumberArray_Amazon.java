package com.JavaQues;

import java.util.ArrayList;
import java.util.List;

/*
You are given a read only array of n integers from 1 to n.
Each integer appears exactly once except A which appears twice and B which is missing.
Return A and B.

Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
Note that in your output A should precede B.

Example:

Input:[3 2 1 5 3]
Output:[3, 4]

A = 3, B = 4

 */

public class RepeatandMissingNumberArray_Amazon {

	public static void main(String[] args) {
		List<Integer> a=new ArrayList<Integer>();
		a.add(3);
		a.add(1);
		a.add(2);
		a.add(5);
		a.add(3);

		ArrayList<Integer> res=new RepeatandMissingNumberArray_Amazon().repeatedNumber(a);
		System.out.println(res);
	}

	void xorDemoFun(){

		int[] arr={3,2,1,5,0};

		int n=arr.length;

		int x=0;
		for(int i=0;i<n;i++){
			x ^=arr[i];
			x ^=i+1;
		}
		System.out.println(x);
	}



	public ArrayList<Integer> repeatedNumber(final List<Integer> a) {

		ArrayList<Integer> res=new ArrayList<Integer>();

		Integer[] arr = new Integer[a.size()];
		a.toArray(arr);

		for(int i=0;i<arr.length;i++){
			if(arr[Math.abs(arr[i])-1]>0){
				arr[Math.abs(arr[i])-1]=-1*arr[Math.abs(arr[i])-1];
			}
			else{
				res.add(Math.abs(arr[i]));
			}
		}
		for(int i=0;i<arr.length;i++){
			if(arr[i]>0){
				res.add(i+1);
			}
		}
		return res;
	}
}
