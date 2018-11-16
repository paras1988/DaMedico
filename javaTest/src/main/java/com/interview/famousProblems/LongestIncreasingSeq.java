package com.interview.famousProblems;

public class LongestIncreasingSeq {
	
	/*
	 * LIS(arr)={if--> j<i && arr[j]<arr[i]
	 * 				then 1+max(LIS(arr[j])
	 * 			else
	 * 				1 
	 * 
	 * length of LIS for { 10, 22, 9, 33, 21, 50, 41, 60, 80 } is 6 and LIS is {10, 22, 33, 50, 60, 80}. 
	 * 
	 * */
	
	static int maxFinal=0;
	public static void main(String[] args) {
		int arr[]={8,3,12,4,5,6,7, 23,3};
		nonRecur(arr);
		LIS(arr,arr.length);
		System.out.println("Result is "+maxFinal);
		int maxRes=0;
		maxRes=memoizedLIS(arr);
		System.out.println("Result from memoized is "+ maxRes);
	} 
	
	private static void nonRecur(int[] arr) {
		int[] DP=new int[arr.length];
		int[] prev=new int[arr.length];
		
		for(int i=1;i<arr.length;i++){
			DP[i]=1;
			prev[i] = -1;

			for(int j=i-1;j>0;j--){
				
				if(j<i && 1+DP[j]>DP[i] && arr[j]<arr[i]){
					DP[i]=DP[j]+1;
					prev[i] = j;
				}
			}
		}
		
		int max=0;
		for(int i=0;i<DP.length;i++){
			if(DP[i]>max){
				max=DP[i];
			}
		}
		System.out.println("LIS from Non Recursive " + max);
	}
	
	static int LIS(int[] arr, int n){
		
		if(n==1)
			return 1;
		
		int res, max_ending_here = 1; 
		
		for(int i=1;i<n;i++){
			res=LIS(arr,i);
			if(arr[i-1] < arr[n-1] && res + 1 > max_ending_here)
	            max_ending_here = res + 1;
		}
		if(max_ending_here>maxFinal)
			maxFinal=max_ending_here;
		
		return max_ending_here;
	}
	
	static int memoizedLIS(int[] arr){
		
		int[] LIS=new int[arr.length];
		for(int i=0;i<arr.length;i++){
			LIS[i]=0;
		}
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<i;j++){
				if(arr[i]>arr[j] && LIS[i]<LIS[j]+1){
					LIS[i]=LIS[j]+1;
				}
			}
			if(LIS[i]==0){
				LIS[i]=1;
			}
		}
		int max=0;
		for(int i=0;i<arr.length;i++){
			if(LIS[i]>max){
				max=LIS[i];
			}
		}
		return max;
	}

}
