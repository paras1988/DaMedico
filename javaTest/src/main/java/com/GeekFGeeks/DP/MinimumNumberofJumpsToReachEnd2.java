package com.GeekFGeeks.DP;

import static com.GeekFGeeks.DP.MinimumNumberofJumpsToReachEnd.recursiveMinJumps;

/*
 * Input: arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}
  Output: 3 (1-> 3 -> 8 ->9)

  First element is 1, so can only go to 3. Second element is 3, so can make at most 3 steps eg to 5 or 8 or 9.

 * */
public class MinimumNumberofJumpsToReachEnd2 {

	public static void main(String[] args) {
		int arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
		int res = recursiveMinJumps2(arr, 0, arr.length - 1);
		System.out.println(res);
	}

	private static int recursiveMinJumps2(int[] arr, int s, int n) {
		if(s>n){
			return 0;
		}
		int min = Integer.MAX_VALUE;
		for(int i=s+1;i<s+arr[s];i++){
			int lmin = 1+recursiveMinJumps2(arr,i,n);
			if(min > lmin){
				min = lmin;
			}
		}
		return min;
	}


}