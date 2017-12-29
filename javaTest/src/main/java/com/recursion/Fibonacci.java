package com.recursion;

public class Fibonacci {
	public static int count = 0;

	public static void main(final String[] args) {
		System.out.println("fibonacci series of 10 numbers: ");
		for (int i = 1; i < 8; i++) {
			System.out.println(printFibo(i));
		}

		System.out.println(count);

	}

	private static int printFibo(final int i) {
		count++;
		if (i == 1) {
			return 0;
		}
		if (i == 2) {
			return 1;
		}
		final int j = printFibo(i - 2) + printFibo(i - 1);
		return j;
	}
}
