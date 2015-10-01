package com.JavaQues;

public class NQueeenProblem {
	static final int N = 4;

	/*
	 * 1) Start in the leftmost column
	 * 2) If all queens are placed
	 * return true
	 * 3) Try all rows in the current column. Do following for every tried row.
	 * a) If the queen can be placed safely in this row then mark this [row,
	 * column] as part of the solution and recursively check if placing
	 * queen here leads to a solution.
	 * b) If placing queen in [row, column] leads to a solution then return
	 * true.
	 * c) If placing queen doesn't lead to a solution then umark this [row,
	 * column] (Backtrack) and go to step (a) to try other rows.
	 * 4) If all rows have been tried and nothing worked, return false to trigger
	 * backtracking.
	 */
	public static void main(final String[] args) {
		placeQueen(4);
	}

	static void placeQueen(final int N) {
		final boolean[][] arr = new boolean[N][N];
		if (queenPlaceUtil(arr, 0, 0, 4) == false) {
			System.out.println("NOOO");
		} else {
			System.out.println("PRINTING");
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(arr[i][j]);
				}
				System.out.println("");
			}
		}
	}

	static Boolean queenPlaceUtil(final boolean[][] input, final int a, final int b, final int N) {
		if (N == 0) {
			return true;
		} else {
			for (int i = a; i < 4; i++) {
				if (isSafe(input, i, b)) {
					input[i][b] = true;
					if (queenPlaceUtil(input, a, b + 1, N - 1)) {
						return true;
					}
					input[i][b] = false;
				}
			}
			return false;
		}
	}

	private static boolean isSafe(final boolean[][] board, final int row, final int col) {
		int i, j;

		/* Check this row on left side */
		for (i = 0; i < col; i++) {
			if (board[row][i]) {
				return false;
			}
		}

		/* Check upper diagonal on left side */
		for (i = row, j = col; i >= 0 && j >= 0; i--, j--) {
			if (board[i][j]) {
				return false;
			}
		}

		/* Check lower diagonal on left side */
		for (i = row, j = col; j >= 0 && i < N; i++, j--) {
			if (board[i][j]) {
				return false;
			}
		}

		return true;
	}
}
