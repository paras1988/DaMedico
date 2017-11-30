package com.JavaQues;

public class Vmware1 {

	static int min = Integer.MIN_VALUE + 1;
	static int max = Integer.MIN_VALUE + 1;
	static int diff = Integer.MIN_VALUE + 1;

	static int maxDifference(int a[]) {
		if (a.length >= 2) {
			for (int i = 0; i < a.length - 1; i++) {
				process(a, i);
			}
			if (diff == Integer.MIN_VALUE + 1) {
				return -1;
			}
			return diff;
		}
		return -1;
	}

	private static void process(int[] arr, int index) {
		if (index == 0) {
			if (arr[index + 1] >= arr[index]) {
				calculateDiff(arr[index + 1], arr[index]);
			} else {
				min = arr[index + 1];
				calculateDiff(max, min);
			}
		} else {
			if (arr[index + 1] > min) {
				calculateDiff(arr[index + 1], min);
			}

			if (arr[index + 1] > arr[index]) {
				calculateDiff(arr[index + 1], arr[index]);
			}
		}
	}

	private static void calculateDiff(int maximum, int minimum) {
		if (maximum != Integer.MIN_VALUE + 1 && maximum - minimum > diff) {
			max = maximum;
			min = minimum;
			diff = max - min;
		}
	}

	public static void main(String[] args) {
		int arr[]={6,5,4,3,2,1};
		System.out.println(maxDifference(arr));

		System.out.println(maxDifference2(arr));
	}

	static int maxDifference2(int[] arr) {

		int max=Integer.MIN_VALUE;
		for(int i=0;i<arr.length;i++){
			int cmax=Integer.MIN_VALUE;
			for(int j=i+1;j<arr.length;j++){

				if(arr[j]>arr[i] && arr[j]-arr[i]>cmax){
					cmax=arr[j]-arr[i];
				}

			}
			if(cmax>max){
				max=cmax;
			}
		}
		if(max==Integer.MIN_VALUE){
			return -1;
		}
		return max;
	}
}
