package com.Algorithm.Backtracking;

public class PermutationAgain {
	public static void main(String[] args) {
		String str="ABC";

		permuteString(str,0);
	}

	private static void permuteString(String str, int c) {

		if(c==str.length()){
			System.out.println(str);
			return;
		}
		for(int i=c;i<str.length();i++){
			str=swap(str,i,c);
			permuteString(str,c+1);
			str=swap(str,c,i);
		}

	}

	private static String swap(String str, int a, int c) {

		char[] arr=str.toCharArray();

		char temp=arr[a];
		arr[a]=arr[c];
		arr[c]=temp;

		str=new String(arr);
		return str;
	}
}
