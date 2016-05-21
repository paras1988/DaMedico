package com.JavaQues;

public class KnightTourProblem {
	/*
	 * 
	 * start:
	 * if its safe
	 * mark as 1
	 * recur() if true
	 * mark as 0
	 * 
	 * 
	 * If all squares are visited
	 * print the solution
	 * Else
	 * a) Add one of the next moves to solution vector and recursively
	 * check if this move leads to a solution. (A Knight can make maximum
	 * eight moves. We choose one of the 8 moves in this step).
	 * b) If the move chosen in the above step doesn't lead to a solution
	 * then remove this move from the solution vector and try other
	 * alternative moves.
	 * c) If none of the alternatives work then return false (Returning false
	 * will remove the previously added item in recursion and if false is
	 * returned by the initial call of recursion then "no solution exists" )
	 */

	public static void main(final String[] args) {
		final int N = 8;
		knightTourProblem(N);
	}

	private static void knightTourProblem(final int N) {
		final int[][] arr = new int[N][N];
		final int[] x = { 2, 1, -1, -2, -2, -1, 1, 2 };
		final int[] y = { 1, 2, 2, 1, -1, -2, -2, -1 };
		if (knightUtil(arr, 0, 0, 0, x, y, N)) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(arr[i][j]);
				}
				System.out.println("");
			}
		} else {
			System.out.println("NOOOO");
		}
	}

	static Boolean knightUtil(final int[][] arr, int move, int n, int m, final int[] x,
			final int[] y, final int N) {
		if (isResult(arr, n, m, N)) {
			return true;
		} else {
			for (int i = 0; i < 8; i++) {
				n = n + x[i];
				m = m + y[i];
				if (isSafe(arr, n, m, N)) {
					arr[n][m] = move;
					if (knightUtil(arr, move++, n, m, x, y, N)) {
						return true;
					}
					arr[n][m] = -1;
				}
			}
			return false;
		}

	}

	private static boolean isSafe(final int[][] arr, final int n, final int m, final int N) {

		if (n > 0 && m > 0 && n < N && m < N && arr[n][m] == -1) {
			return true;
		}
		return false;
	}

	private static boolean isResult(final int[][] arr, final int n, final int m, final int N) {
		if (arr[n][m] == N * N) {
			return true;
		}
		return false;
	}
}
