package com.Algorithm.Backtracking;

public class GenerateAllParentheses_123CombinationsPrint {

	public static void main(String[] args) {
		new GenerateAllParentheses_123CombinationsPrint(

		).generateCombinationsUtil(0,0,0,"",0,3);
	}

	private void generateCombinationsUtil(int one, int two, int three, String str, int index, int N) {

		if(one>N){
			return;
		}
		if(two>N){
			return;
		}
		if(three>N){
			return;
		}
		if(index==3*N){
			System.out.println(str);
			return;
		}

		str +="1";
		one++;
		generateCombinationsUtil(one,two,three,str,index+1,N);
		str=str.substring(0, str.length()-1);
		one--;

		str+="2";
		two++;
		generateCombinationsUtil(one,two,three,str,index+1,N);
		str=str.substring(0, str.length()-1);
		two--;

		str+="3";
		three++;
		generateCombinationsUtil(one,two,three,str,index+1,N);
		str=str.substring(0, str.length()-1);
		three--;
	}
}
