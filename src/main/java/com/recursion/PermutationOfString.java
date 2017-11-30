package com.recursion;

public class PermutationOfString {
	public static void main(final String[] args) {
		final String str = "ABC";
		/*
		 * for(int i=0;i<str.length();i++) {
		 * showPermutation(str,i);
		 * }
		 */
		permuteString("", str);

		/*
		 * final String s = "abcd";
		 * final char[] arrCh = s.toCharArray();
		 * permutation(arrCh, 0, arrCh.length);
		 */
	}

	private static void showPermutation(final String str, final int i) {
		if (i != 0) {
			if (i - 0 == 1) {
				System.out.print(str.charAt(0));
			}
			if (i - 0 == 2) {
				System.out.print(str.charAt(1));
				System.out.print(str.charAt(0));
			}
			for (int j = 0; j < i; j++) {
				showPermutation(str.substring(0, i), j);
			}
		}
		if (i != str.length() - 1) {
			if (str.length() - i == 2) {
				System.out.print(str.charAt(str.length() - 1));
			}
			if (str.length() - i == 3) {
				System.out.print(str.charAt(str.length() - 2));
				System.out.print(str.charAt(str.length() - 1));
			}
			for (int j = i; j < str.length(); j++) {
				showPermutation(str.substring(i + 1, str.length()), j);
			}
		}
	}

	/*
	 * public static void permuteString(String beginningString, String endingString) {
	 * 
	 * }
	 */

	public static void permuteString(final String beginningString, final String endingString) {
		System.out.println("--> " + beginningString + "::" + endingString);
		if (endingString.length() <= 1) {
			System.out.println(beginningString + "::" + endingString);
		} else {
			for (int i = 0; i < endingString.length(); i++) {
				try {
					final String newString = endingString.substring(0, i)
							+ endingString.substring(i + 1);
					/*
					 * System.out.println(beginningString + endingString.charAt(i)
					 * + "-->newString--> " + newString);
					 */
					permuteString(beginningString + endingString.charAt(i), newString);
				} catch (final StringIndexOutOfBoundsException exception) {
					exception.printStackTrace();
				}
			}
		}
	}

	public static void permutation(final char[] arrA, final int left, final int size) {
		int x;
		if (left == size) {
			for (final char element : arrA) {
				System.out.print(element);
			}
		} else {
			for (x = left; x < size; x++) {
				swap(arrA, left, x);
				permutation(arrA, left + 1, size);
				swap(arrA, left, x);

			}
		}
	}

	public static void swap(final char[] arrA, final int i, final int j) {

		final char temp = arrA[i];
		arrA[i] = arrA[j];
		arrA[j] = temp;
	}

	public static void showCharArr(final char[] arrA) {
		for (final char element : arrA) {
			System.out.print(element);
		}
		System.out.print(" ");
	}
}
