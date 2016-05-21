package com.Algorithm.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class AllPossibleSubsets {

	static int N;
	static ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
	static List<Integer> l=new ArrayList<Integer>();

	public static void main(String[] args) {

		l.add(1);
		l.add(2);
		//	l.add(3);


		subsets((ArrayList<Integer>)l);
		System.out.println(res);

	}
	public static void subsets(ArrayList<Integer> a) {
		ArrayList<Integer> temp=new ArrayList<Integer>();
		N=a.size();
		subsetsUtil(temp,0);
	}

	private static void subsetsUtil(ArrayList<Integer> arr,int index) {

		if (index == N) {
			res.add(new ArrayList<>(arr));
			return;
		}

		subsetsUtil(arr,index + 1);
		arr.add(l.get(index));
		subsetsUtil(arr,index + 1);
		arr.remove(arr.size() - 1);

	}
}
