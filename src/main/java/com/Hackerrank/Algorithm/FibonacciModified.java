package com.Hackerrank.Algorithm;

public class FibonacciModified {

	public static void main(String[] args) {
		System.out.println(fibonacciMSeries(0,1,10));
	}

	static int fibonacciMSeries(int a,int b,int N){
		int[] arr=new int[N];
		arr[0]=a;
		arr[1]=b;
		for(int i=2;i<N;i++){
			arr[i]=-1;
		}
		fibonacciUtil(arr,2);
		return arr[N-1];
	}

	private static void fibonacciUtil(int[] arr,int i) {
		if(i==arr.length){
			return;
		}

		if(arr[i]==-1){
			arr[i]=arr[i-1]*arr[i-1]+arr[i-2];
		}
		fibonacciUtil(arr,i+1);
	}
}
