package com.recursion;

public class MergeSort {
	private static int[] numbers={99,87,65,34,23,9,6,5,4,3,1};
	private static int[] helper=new int[11];

	public static void main(final String[] args) {
		sort_mergeSort(numbers);
		for (final int number : numbers) {
			System.out.print(number+",");
		}
	}

	private static void sort_mergeSort(final int[] numbers2) {
		mergesort(0, numbers2.length - 1);

	}

	private static void mergesort(final int i, final int j) {
		if(i<j){
			final int middle = i + (j - i) / 2;
			//System.out.println(middle);

			mergesort(i,middle);
			mergesort(middle+1,j);

			merge(i,middle,j);
		}
	}

	/*private static void merge(final int i, final int middle, final int j) {
		//	System.out.println(i+" "+j);
		for(int k=i;k<=j;k++){
			helper[k]=numbers[k];
		}
		int a=i;
		final int b=middle;
		int c=middle+1;
		final int d=j;

		int t=a;
		while(a<=b && c<=d){
			if(helper[a]<=helper[c]){
				numbers[t]=helper[a];
				a++;
			}
			else{
				numbers[t]=helper[c];
				c++;
			}
			t++;
		}
		while(a<b){
			numbers[t]=helper[a];
			a++;
			t++;
		}
		while(c<d){
			numbers[t]=helper[c];
			c++;
			t++;
		}


	}
	 */

	private static void merge(final int low, final int middle, final int high) {

		// Copy both parts into the helper array
		for(int k=low;k<=high;k++){
			helper[k]=numbers[k];
		}

		int i = low;
		int j = middle + 1;
		int k = low;
		// Copy the smallest values from either the left or the right side back
		// to the original array
		while (i <= middle && j <= high) {
			if (helper[i] <= helper[j]) {
				numbers[k] = helper[i];
				i++;
			} else {
				numbers[k] = helper[j];
				j++;
			}
			k++;
		}
		// Copy the rest of the left side of the array into the target array
		while (i <= middle) {
			numbers[k] = helper[i];
			k++;
			i++;
		}
	}


}
