package com.Algorithm.Backtracking;

import java.util.ArrayList;

public class GeneratePermutations {

	static ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
	static int N;

	public static void main(String[] args) {
		ArrayList<Integer> arr=new ArrayList<Integer>();
		arr.add(1);
		arr.add(1);
		arr.add(2);
		N=arr.size();
		permute(arr,0);

	}
	public static void permute(ArrayList<Integer> a,int start) {

		if(start==N-1){
			System.out.println(a);
			return;
		}
		for(int i=start;i<a.size();i++){
			if(a.get(start)!=a.get(i) || start==i){   //This is 'combination' which discard repetition.
				swap(a,start,i);
				permute(a,start+1);
				swap(a,i,start);
			}
		}
	}

	private static void swap(ArrayList<Integer> a, int m, int n)  {

		int m2=a.get(m);
		int n2=a.get(n);

		a.set(m,n2);
		a.set(n,m2);
	}
}
