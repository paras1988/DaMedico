package com.JavaQues;

import java.util.ArrayList;
import java.util.List;

/*
You are given a binary string(i.e. with characters 0 and 1) S consisting of characters S1, S2, …, SN. In a single operation, you can choose two indices L and R such that 1 ≤ L ≤ R ≤ N and flip the characters SL, SL+1, …, SR. By flipping, we mean change character 0 to 1 and vice-versa.

You aim is to perform ATMOST one operation such that in final string number of 1s is maximised. If you don’t want to perform the operation, return an empty array. Else, return an array consisting of two elements denoting L and R. If there are multiple solutions, return the lexicographically smallest pair of L and R.

Notes:
- Pair (a, b) is lexicographically smaller than pair (c, d) if a < c or, if a == b, then b < d.

For example,

S = 010

Pair of [L, R] | Final string
_______________|_____________
[1 1]          | 110
[1 2]          | 100
[1 3]          | 101
[2 2]          | 000
[2 3]          | 001

We see that two pairs [1, 1] and [1, 3] give same number of 1s in final string. So, we return [1, 1].
 */

public class FlipBitsToReachMax_Amazon {
	public static void main(String[] args) {

		final String s="0011101";
		List<Integer> res=new FlipBitsToReachMax_Amazon().flip(s);
		System.out.println(res);
	}
	public ArrayList<Integer> flip(String A) {

		Integer[] arr=new Integer[A.length()];
		for(int i=0;i<A.length();i++){
			int c=new Integer(A.substring(i, i+1));
			if(c==0){
				arr[i]=1;
			}else{
				arr[i]=-1;
			}
		}
		if(allMinusOnes(arr)){
			return new ArrayList<Integer>();
		}
		return maximumSumSubArray(arr);
	}
	private boolean allMinusOnes(Integer[] a) {
		for(Integer i:a){
			if(i==1){
				return false;
			}
		}
		return true;
	}
	private ArrayList<Integer> maximumSumSubArray(Integer[] arr) {

		int curr_max=arr[0];
		int max_so_far=arr[0];
		int s=0;
		int e=0;

		int t_start = 0;

		for(int i=1;i<arr.length;i++){
			if(arr[i]>curr_max+arr[i]){
				t_start = i + 1;
			}
			curr_max=Math.max(arr[i],curr_max+arr[i]);
			if(curr_max>max_so_far){
				s = t_start;
				e = i + 1;
			}
			max_so_far=Math.max(curr_max, max_so_far);

		}

		ArrayList<Integer> list=new ArrayList<Integer>();
		if(s==0) {
			list.add(1);
		}
		else{
			list.add(s);
		}

		if(e==0){
			list.add(1);
		}
		else{
			list.add(e);
		}

		return list;
	}

}
