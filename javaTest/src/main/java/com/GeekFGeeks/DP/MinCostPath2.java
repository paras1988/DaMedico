package com.GeekFGeeks.DP;

/**
 * Minimum Cost Path with Left, Right, Bottom and Up moves allowed
 */
public class MinCostPath2 {

	public static void main(String[] args) {
		int mat[][] =  {
			{31, 100, 65, 12, 18},
			{10, 13, 47, 157, 6},
			{100, 113, 174, 11, 33},
			{88, 124, 41, 20, 140},
			{99, 32, 111, 41, 20}
		};
		System.out.println(minCostPath(mat, 0, 0));
	}

	static int minCostPath(int[][] mat,int m,int n){
	  return 0;
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
