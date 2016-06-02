package com.Algorithm.Backtracking;

import java.util.ArrayList;

public class PalindromePartitioning {


	String str="abcd";
	static ArrayList<ArrayList<String>> res=new ArrayList<ArrayList<String>>();

	public static void main(String[] args) {
		ArrayList<String> mStr=new ArrayList<String>();
		new PalindromePartitioning().partitionRecur(mStr,0);
		System.out.println(res);
	}

	public ArrayList<ArrayList<String>> partition(String str) {

		//		partitionRecur(str,0);
		return null;
	}

	private void partitionRecur(ArrayList<String> mStr, int index) {
		if(index==str.length()){
			res.add(new ArrayList<String>(mStr));
			return;
		}

		for(int i=index;i<str.length();i++){
			mStr.add(str.substring(index,i+1));
			partitionRecur(mStr,i+1);
			mStr.remove(mStr.size()-1);
		}

	}


}
