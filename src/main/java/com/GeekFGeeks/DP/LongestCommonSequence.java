package com.GeekFGeeks.DP;

/*
LCS for input Sequences �ABCDGH� and �AEDFHR� is �ADH� of length 3.
LCS for input Sequences �AGGTAB� and �GXTXAYB� is �GTAB� of length 4.
*/

public class LongestCommonSequence {

	public static void main(String[] args) {
		String str1="ABCDGH";
		String str2="AEDFHR";
		System.out.println(longestCommonSequenceUtil(str1,str2));
		System.out.println(memoizedLCS(str1,str2));
	}
	
	private static int longestCommonSequenceUtil(String str1, String str2){
		if(str1.length()==0 || str2.length()==0){
			return 0;
		}
		else if(str1.charAt(0)!=str2.charAt(0)){
			return maxLCS(longestCommonSequenceUtil(str1.substring(0),str2.substring(1)),
			longestCommonSequenceUtil(str1.substring(1),str2.substring(0)));
		}
		else{
			return (1+
			longestCommonSequenceUtil(str1.substring(1),str2.substring(1)));
		}
	}
	private static int maxLCS(int a, int b)
	{
	    return (a > b)? a : b;
	}
	private static int memoizedLCS(String str1,String str2){
		int m=str1.length();
		int n=str2.length();
		int LCSmat[][]=new int[m+1][n+1];
		
		for (int i=0; i<=m; i++)
		   {
		     for (int j=0; j<=n; j++)
		     {
		    	 if(i==0|| j==0){
		    		 LCSmat[i][j]=0;
		    	 }
		    	 else if(str1.charAt(i-1)!=str2.charAt(j-1)){
		    		 if(LCSmat[i-1][j]<LCSmat[i][j-1]){
			    		 LCSmat[i][j]=LCSmat[i][j-1];
			    	 }else{
			    		 LCSmat[i][j]=LCSmat[i-1][j];
			    	 }	 
		    	 }else{
		    		 if(LCSmat[i-1][j]<LCSmat[i][j-1]){
			    		 LCSmat[i][j]=LCSmat[i][j-1]+1;
			    	 }else{
			    		 LCSmat[i][j]=LCSmat[i-1][j]+1;
			    	 }
		    	 }
		     }
		   }
		return LCSmat[m][n];
	}
}
