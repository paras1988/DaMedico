package com.JavaQues;

public class RatMaze {
	static final int N = 4;
	static final int M = 4;

	public static void main(final String[] args) {
		final int[][] input = { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 0, 1, 0, 0 }, { 1, 1, 1, 1 } };
		solveMaze(input);
	}

	/*
	 * If destination is reached
	 * print the solution matrix
	 * Else
	 * a) Mark current cell in solution matrix as 1.
	 * b) Move forward in horizontal direction and recursively check if this
	 * move leads to a solution.
	 * c) If the move chosen in the above step doesn't lead to a solution
	 * then move down and check if this move leads to a solution.
	 * d) If none of the above solutions work then unmark this cell as 0
	 * (BACKTRACK) and return false.
	 * 
	 * start from 1..
	 * if(1)
	 * go left
	 * else go down
	 */private static int[][] solveMaze(final int[][] input) {

		final int[][] output = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				output[i][j] = 0;
			}
		}

		if (ratMazeUtil(input, 0, 0, output) == false) {
			System.out.println("NOOOOO");
		} else {
			System.out.println("PRINTING");
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					System.out.print(output[i][j]);
				}
				System.out.println("");
			}
		}
		return output;
	}

	static Boolean ratMazeUtil(final int[][] input, final int a, final int b, final int[][] output) {
		if (a == N - 1 && b == M - 1) {
			output[a][b] = 1;
			return true;
		} else {
			if (isSafe(input, a, b)) {
				output[a][b] = 1;
				if (ratMazeUtil(input, a + 1, b, output)) {
					return true;
				}
				if (ratMazeUtil(input, a, b + 1, output)) {
					return true;
				}
				output[a][b] = 0;
				return false;
			}
			return false;
		}
	}

	private static boolean isSafe(final int[][] input, final int a, final int b) {
		if (a >= 0 && b >= 0 && a < N && b < M && input[a][b] == 1) {
			return true;
		}
		return false;
	}
}
