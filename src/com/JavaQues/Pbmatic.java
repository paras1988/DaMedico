package com.JavaQues;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/*
 * Given an array of size m (m < n) and number from 1 to n. n-m numbers are missing in the array.
 * for eg n = 10 and m = 5
 * arra= [1,6,4,8,7] find the missing numbers in array. in this case missing numbers are
 * (2,3,5,9,10)
 */
public class Pbmatic {
	public static void main(final String[] args) {
		final int arr[] = { 1, 6, 4, 8, 7 };
		fun(arr);
	}

	static void fun(final int arr[]) {
		final Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();

		final int n = 10, m = 5;
		for (int i = 1; i <= n; i++) {
			map.put(i, false);
		}
		for (final int element : arr) {
			if (map.containsKey(element)) {
				map.put(element, true);
			}
		}
		for (final Entry e : map.entrySet()) {
			if (!(Boolean) e.getValue()) {
				System.out.println(e.getKey());
			}
		}
	}
}
