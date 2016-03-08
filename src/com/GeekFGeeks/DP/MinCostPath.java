package com.GeekFGeeks.DP;

public class MinCostPath {
	public static void main(String[] args) {
		int mat[][] = {
				{1, 2, 3},
				{4, 8, 2},
				{1, 5, 3} };
		System.out.println(minCostPath(mat, 2, 2));
		System.out.println(minCostPath_DP(mat, 2, 2));
	}

	static int minCostPath(int[][] mat,int m,int n){
		if(m==0 || n==0 || (m==1 && n==1)){
			return mat[m][n]+mat[0][0];
		}
		return (mat[m][n]+min(minCostPath(mat,m-1,n), minCostPath(mat,m-1,n-1), minCostPath(mat,m,n-1)));
	}

	private static int min(int a, int b,int c) {
		return (a<b)?((a<c)?a:c):((b<c)?b:c);
	}

	static int minCostPath_DP(int[][] mat,int m,int n){
		int[][] dp=new int[m+1][n+1];

		for(int i=0;i<=m;i++){
			for(int j=0;j<=n;j++){
				if(i==0 && j==0){
					dp[i][j]=mat[i][j];
				}
				else if(i==0){
					dp[i][j]=mat[i][j]+dp[i][j-1];
				}
				else if(j==0){
					dp[i][j]=mat[i][j]+dp[i-1][j];
				}
				else{
					dp[i][j]=mat[i][j]+min(dp[i-1][j],dp[i-1][j-1],dp[i][j-1]);
				}
			}
		}

		return dp[m][n];
	}

}
