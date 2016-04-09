package com.GeekFGeeks.DP;

/*
 * 
 * Input: arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}
  Output: 3 (1-> 3 -> 8 ->9)

  First element is 1, so can only go to 3. Second element is 3, so can make at most 3 steps eg to 5 or 8 or 9.

 * */
public class MinimumNumberofJumpsToReachEnd {

	public static void main(String[] args) {
		int arr[] ={1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
		int res=recursiveMinJumps(arr,0,arr.length-1);
		System.out.println(res);
	}

	static int recursiveMinJumps(int[] arr,int s,int e){

		if(s==e){
			return 0;
		}
		int jumps=0;
		int jumps_min=1000;
		for(int i=s+1;i<=e && i<=s+arr[s];i++){
			jumps=recursiveMinJumps(arr,i,e);

			if(jumps+1<jumps_min){
				jumps_min=jumps+1;
			}
		}
		return jumps_min;
	}

	static int minJumpsLeftToRight(int[] arr,int s,int e){

		return 0;
	}
}
