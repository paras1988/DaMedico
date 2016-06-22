package com.Heap;


public class Heapsort {

	static int N;

	public static void sortMax(int[] arr){
		heapifyMax(arr);


		for(int i=N;i>=0;i--){
			swap(arr,0, i);
			N = N-1;
			maxheap(arr, 0);
		}
	}

	private static void heapifyMax(int[] arr) {

		N=arr.length-1;
		for(int i=N/2;i>=0;i--){
			maxheap(arr,i);
		}
	}


	private static void maxheap(int[] arr, int i) {

		int left=i*2+1;
		int right=i*2+2;

		int max=i;
		if(left<=N && arr[left]>arr[max]){
			max=left;
		}
		if(right<=N && arr[right]>arr[max]){
			max=right;
		}

		if(max!=i){
			swap(arr,i,max);
			maxheap(arr,max);
		}
	}

	private static void swap(int[] arr, int i, int j) {
		int tmp=arr[i];
		arr[i]=arr[j];
		arr[j]=tmp;
	}


	public static void sortMin(int[] arr){
		heapifyMin(arr);


		for(int i=N;i>=0;i--){
			swap(arr,0, i);
			N = N-1;
			minHeap(arr, 0);
		}
	}
	private static void heapifyMin(int[] arr) {

		N=arr.length-1;
		for(int i=N/2;i>=0;i--){
			minHeap(arr,i);
		}
	}

	private static void minHeap(int[] arr,int i){
		int left=i*2+1;
		int right=i*2+2;

		int min=i;
		if(left<=N && arr[left]<arr[min]){
			min=left;
		}
		if(right<=N && arr[right]<arr[min]){
			min=right;
		}

		if(min!=i){
			swap(arr,i,min);
			minHeap(arr,min);
		}
	}
}


