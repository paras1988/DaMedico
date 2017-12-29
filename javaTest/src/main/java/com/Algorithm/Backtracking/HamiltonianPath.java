package com.Algorithm.Backtracking;

public class HamiltonianPath {
	public static void main(String args[])
	{
		/* Let us create the following graph
	      (0)--(1)--(2)
	       |   / \   |
	       |  /   \  |
	       | /     \ |
	      (3)-------(4)    */
		int graph1[][] = {
				{0, 1, 0, 1, 0},
				{1, 0, 1, 1, 1},
				{0, 1, 0, 0, 1},
				{1, 1, 0, 0, 1},
				{0, 1, 1, 1, 0},
		};

		// Print the solution
		hamCycle(graph1);

		/* Let us create the following graph
	      (0)--(1)--(2)
	       |   / \   |
	       |  /   \  |
	       | /     \ |
	      (3)       (4)    */
		int graph2[][] = {
				{0, 1, 0, 1, 0},
				{1, 0, 1, 1, 1},
				{0, 1, 0, 0, 1},
				{1, 1, 0, 0, 0},
				{0, 1, 1, 0, 0},
		};

		// Print the solution
		hamCycle(graph2);
	}

	private static void hamCycle(int[][] graph) {
		int[] sol=new int[graph[0].length+1];


	}
}