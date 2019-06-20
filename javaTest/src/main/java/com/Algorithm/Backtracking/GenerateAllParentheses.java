package com.Algorithm.Backtracking;

public class GenerateAllParentheses {

	public static void main(String[] args) {
		new GenerateAllParentheses(

		).generateParenthesisUtil(0,0,"",0,3);
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
		System.out.println("LEFT "+left+"-"+right+"-"+str);
		generateParenthesisUtil(left,right,str,index+1,N);
		str=str.substring(0, str.length()-1);
		left--;

		str+=")";
		right++;
		System.out.println("RIGHT "+left+"-"+right+"-"+str);
		generateParenthesisUtil(left,right,str, index+1,N);
		str=str.substring(0, str.length()-1);
		right--;
	}
}
