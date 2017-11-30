package com.Algorithm.Backtracking;

import java.util.ArrayList;

public class GenerateAllParentheses {

	public static void main(String[] args) {
		ArrayList<String> a=new ArrayList<String>();
		new GenerateAllParentheses().generateParenthesisUtil(0,0,"",0,3);
	}

	public ArrayList<String> generateParenthesis(int a) {

		return null;
	}

	public void generateParenthesisUtil(int left,int right,String str,int index,int N) {

		if(left>N){
			return;
		}
		if(right>N){
			return;
		}

		if (right > left) {
			return;
		}

		if(index==2*N){
			System.out.println(str);
			return;
		}

		str +="(";
		left++;
		generateParenthesisUtil(left,right,str,index+1,N);
		str=str.substring(0, str.length()-1);
		left--;

		str+=")";
		right++;
		generateParenthesisUtil(left,right,str, index+1,N);
		str=str.substring(0, str.length()-1);
		right--;
	}
}
