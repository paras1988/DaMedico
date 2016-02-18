package com.Algorithm.Backtracking;
public class M_coloring {
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
		int N=4;
		int[] sol=new int[N];
		for(int i=0;i<sol.length;i++){
			sol[i]=0;
		}
		if(graphColoringUtil(graph,m,sol,0)){
			for(int i=0;i<N;i++){
				System.out.print(sol[i]+" ");
			}

		}
		else{
			System.out.println("No Sol Exists");
		}
	}

	private static boolean graphColoringUtil(int[][] graph, int m, int[] sol,int i) {

		if(i==4) {
			return true;
		}
		for(int j=10;j<14;j++){
			if(isSafe(graph,i,j,sol)){
				sol[i]=j;
				if(graphColoringUtil(graph,m,sol,i+1)) {
					return true;
				}
				sol[i]=0;
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
