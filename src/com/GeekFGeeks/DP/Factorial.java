package com.GeekFGeeks.DP;

public class Factorial {
	static int count=0;
	static int count1=0;

	public static void main(String[] args) {
		int N=10;
		for(int i=0;i<=N;i++) {
			System.out.print(NonDP(i)+"::");
		}
		System.out.println("count "+count);

		//Memoized Version
		System.out.print(MemoizedFact(N)+"::");
		System.out.println(count);
	}

	private static String MemoizedFact(int N) {
		int[] arr=new int[N];
		arr[0]=0;
		arr[1]=1;
		for(int i=2;i<N;i++){
			arr[i]=-1;
		}


		for(int i=0;i<N;i++){
			MemoizedFactUtil(arr,i);
		}
		////////////////////////////////////////////////////////////////
		int[] arr1=new int[N+1];
		arr1[0]=0;
		arr1[1]=1;
		for(int i=2;i<=N;i++){
			arr1[i]=-1;
		}

		System.out.println("Fact of"+ N +"is"+MemoizedFactUtilRecur(arr1,N));
		System.out.println("count1 "+count1);
		return null;
	}

	private static void MemoizedFactUtil(int[] arr, int n) {
		if(arr[n]!=-1){

		}else{
			arr[n]=arr[n-1]+arr[n-2];
		}
		System.out.println(arr[n]);
	}

	private static int NonDP(int i) {
		count++;
		if(i==1){
			return 1;
		}else if(i==0){
			return 0;
		}else{
			return (NonDP(i-1)+NonDP(i-2));
		}
	}

	private static int MemoizedFactUtilRecur(int[] arr, int n) {
		count1++;
		if(arr[n]!=-1){
			return arr[n];
		}
		arr[n]=MemoizedFactUtilRecur(arr,n-1)+MemoizedFactUtilRecur(arr,n-2);
		return arr[n];
	}
}
