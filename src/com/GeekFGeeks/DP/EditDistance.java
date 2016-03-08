package com.GeekFGeeks.DP;

/*convert ‘str1′ into ‘str2′.

Insert
Remove
Replace*/

public class EditDistance {

	public static void main(String[] args) {
		System.out.println(editDistance_Recur("sunday","saturday",6,8));
	}

	static int editDistance_Recur(String str1,String str2, int m, int n){

		// If first string is empty, the only option is to
		// insert all characters of second string into first
		if(m==0){
			return n;
		}
		// If second string is empty, the only option is to
		// remove all characters of first string
		if(n==0){
			return m;
		}

		// If last characters of two strings are same, nothing
		// much to do. Ignore last characters and get count for
		// remaining strings.
		if(str1.charAt(m-1)==str2.charAt(n-1)){
			return (editDistance_Recur(str1,str2,m-1,n-1));
		}
		return (1+min(editDistance_Recur(str1,str2,m,n-1),
				editDistance_Recur(str1,str2,m-1,n-1),
				editDistance_Recur(str1,str2,m-1,n)));
	}

	private static int min(int a, int b,int c) {
		return (a<b)?((a<c)?a:c):((b<c)?b:c);
	}

	static void editDistance_nonRecur(String str1,String str2){
		int m=str1.length();
		int n=str2.length();

		int[][] arr=new int[m+1][n+1];

		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(i==0){
					arr[i][j]=j;
				}
				else if(j==0){
					arr[i][j]=i;
				}
				else if(str1.charAt(i)==str2.charAt(j)){
					arr[i][j]=arr[i-1][j-1];
				}
				else{
					arr[i][j]=1+min(arr[i][j-1],arr[i-1][j-1],arr[i][j-1]);
				}
			}
		}
		System.out.println(arr[m][n]);
	}
}
