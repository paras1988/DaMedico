package com.JavaQues;


public class GridUniquePath_GAM {
	public static void main(String[] args) {
		System.out.println(new GridUniquePath_GAM().uniquePaths(2,2));
	}
	public int uniquePaths(int a, int b) {

		return uniquePaths1(a-1,b-1);
	}

	private int uniquePaths1(int a, int b) {
		if(a==0){
			return 1;
		}
		if(b==0){
			return 1;
		}
		return (uniquePaths1(a-1,b)+uniquePaths1(a,b-1));
	}
}
