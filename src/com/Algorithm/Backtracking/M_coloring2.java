package com.Algorithm.Backtracking;

public class M_coloring2 {
	public static void main(String args[])
	{
		/* Create following graph and test whether it is 3 colorable
	      (3)---(2)
	       |   / |
	       |  /  |
	       | /   |
	      (0)---(1)
		 */
		int graph[][] =
			{{0, 1, 1, 1},
				{1, 0, 1, 0},
				{1, 1, 0, 1},
				{1, 0, 1, 0},
			};
		int m = 3; // Number of colors
		graphColoring (graph, m);
	}

	private static void graphColoring(int[][] graph, int m) {

		int[] sol=new int[graph[0].length];



		if(graphColoringUitl(graph,m,sol,0)){
			System.out.println(sol);
		}
	}

	private static boolean graphColoringUitl(int[][] graph, int m, int[] sol,int node) {

		if(node==sol.length){
			return true;
		}
		for(int i=1;i<=m;i++){
			if(isSafe(graph,node,i,sol)){
				sol[node]=i;
				if(graphColoringUitl(graph,m,sol,node+1)){
					return true;
				}
				sol[node]=0;
			}
		}
		return false;
	}

	private static boolean isSafe(int[][] graph, int i, int j, int[] sol) {
		for (int a = 0; a < 4; a++) {
			if (graph[i][a]==1 && j == sol[a]) {
				return false;
			}
		}
		return true;
	}
}
