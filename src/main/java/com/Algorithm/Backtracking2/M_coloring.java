package com.Algorithm.Backtracking2;

import java.util.Arrays;

public class M_coloring {
	/* Create following graph and test whether it is 3 colorable
    (3)---(2)
     |   / |
     |  /  |
     | /   |
    (0)---(1)
	 */

	static int numberOfVertices=4;

	public static void main(String[] args) {
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

		int[] sol=new int[graph.length];
		for(int i=0;i<sol.length;i++)
			sol[i]=-1;
		if(graphColoringUtil(graph,sol,0,m)){
			System.out.println(Arrays.asList(sol));
			for(int k=0;k<sol.length;k++){
				System.out.println(sol[k]);
			}
		}
		else{
			System.out.println("Solution doesn't exist");
		}
	}

	private static boolean graphColoringUtil(int[][] graph, int[] sol, int v,int m) {
		System.out.println("v is "+v);
		if(v==sol.length){
			return true;
		}
		for(int i=1;i<=100;i++){
			if(isSafe(graph,sol,v,i)){
				sol[v]=i;
				if(graphColoringUtil(graph,sol,v+1,m)){
					return true;
				}
				sol[v]=-1;
			}
		}
		return false;
	}

	private static boolean isSafe(int[][] graph, int[] sol, int v, int c) {
		for(int a=0;a<sol.length;a++){
			if(a!=v && graph[v][a]==1 && sol[a]==c){
				return false;
			}
		}
		return true;
	}
}
