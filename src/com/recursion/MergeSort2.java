package com.recursion;

import java.util.*;

public class MergeSort2
{
	public static void main(final String[] args)
	{
		final Integer[] a = {2, 6, 3, 5, 1};
		mergeSort(a);
		System.out.println(Arrays.toString(a));
	}

	public static void mergeSort(final Comparable [ ] a)
	{
		final Comparable[] tmp = new Comparable[a.length];
		mergeSort(a, tmp,  0,  a.length - 1);
	}


	private static void mergeSort(final Comparable [ ] a, final Comparable [ ] tmp, final int left, final int right)
	{
		if( left < right )
		{
			final int center = (left + right) / 2;
			mergeSort(a, tmp, left, center);
			mergeSort(a, tmp, center + 1, right);
			merge(a, tmp, left, center + 1, right);
		}
	}


	private static void merge(final Comparable[ ] a, final Comparable[ ] tmp, int left, int right, int rightEnd )
	{
		final int leftEnd = right - 1;
		int k = left;
		final int num = rightEnd - left + 1;

		while(left <= leftEnd && right <= rightEnd) {
			if(a[left].compareTo(a[right]) <= 0) {
				tmp[k++] = a[left++];
			} else {
				tmp[k++] = a[right++];
			}
		}

		while(left <= leftEnd) {
			tmp[k++] = a[left++];
		}

		while(right <= rightEnd) {
			tmp[k++] = a[right++];
		}

		// Copy tmp back
		for(int i = 0; i < num; i++, rightEnd--) {
			a[rightEnd] = tmp[rightEnd];
		}
	}
}