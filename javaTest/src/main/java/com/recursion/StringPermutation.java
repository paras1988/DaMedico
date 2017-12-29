package com.recursion;

import java.util.HashSet;
import java.util.Set;

public class StringPermutation {

	public static void main(final String[] args) {
		final String str = "ABCD";

		/*
		 * Set<String> hs = new HashSet<String>();
		 * hs = fun(str, hs);
		 * for (final String i : hs) {
		 * System.out.println(i + ":");
		 * }
		 */

		/*
		 * final String s = "abcd";
		 * final char[] arrCh = s.toCharArray();
		 * permutation(arrCh, 0, arrCh.length);
		 */

		final String str2 = "ABCD";
		int size = 0;
		for (final String st : myPermutationString(str2)) {
			System.out.println(st);
			size++;
		}
		System.out.println(size);
	}

	private static Set<String> fun(final String str, Set<String> hs) {

		if (str.length() == 0) {
			return null;
		}
		if (str.length() == 1) {
			hs.add(str);
			return hs;
		}

		for (int i = 0; i < str.length(); i++) {
			hs = fun(str.replace(str.substring(0, i - 1) + str.substring(i, str.length()), ""), hs);
			for (final String j : hs) {
				hs.add(str.charAt(i) + j);
				return hs;
			}
		}
		return hs;
	}

	private char[] arrA;

	public static void permutation(final char[] arrA, final int left, final int size) {
		int x;
		if (left == size) {
			for (final char element : arrA) {
				System.out.print(element);
			}
			System.out.print(" ");
		} else {
			for (x = left; x < size; x++) {
				swap(arrA, left, x);
				permutation(arrA, left + 1, size);
				swap(arrA, left, x);
				/*
				 * System.out.print("After swap -->");
				 * for (final char element : arrA) {
				 * System.out.print(element);
				 * }
				 * System.out.println("");
				 */
			}
		}
	}

	public static void swap(final char[] arrA, final int i, final int j) {
		final char temp = arrA[i];
		arrA[i] = arrA[j];
		arrA[j] = temp;
	}

	public static Set<String> myPermutationString(final String str) {

		if (str.length() == 0) {
			final Set<String> set = new HashSet<String>();
			return set;
		}

		if (str.length() == 1) {
			final Set<String> set = new HashSet<String>();
			set.add(str.substring(0, 1));
			return set;
		}


		final Set<String> set = new HashSet<String>();
		for (int i = 0; i < str.length(); i++) {
			final String charT = str.substring(i, i + 1);
			String t = "";
			if (i >= 1) {
				t += str.substring(0, i);
			}
			final Set<String> temp = myPermutationString(t + str.substring(i + 1, str.length()));

			for (final String s : temp) {
				set.add(charT + s);
			}
		}
		return set;
	}
}
