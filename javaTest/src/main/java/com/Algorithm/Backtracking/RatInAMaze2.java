package com.Algorithm.Backtracking;

import static com.Algorithm.Backtracking.RatInAMaze.isSafe;
import static com.Algorithm.Backtracking.RatInAMaze.printMaze;

public class RatInAMaze2 {
	static int N=4;

	public static void main(String[] args) {
		int maze[][]  =  
			{ {1, 0, 0, 0},
				{1, 1, 1, 1},
				{0, 1, 0, 0},
				{1, 1, 1, 1}
		};

		int sol[][] = {
			{0, 0, 0, 0},
			{0, 0, 0, 0},
			{0, 0, 0, 0},
			{0, 0, 0, 0}
		};

		solveMaze(maze,0,0, sol);
		printMaze(sol);
	}

	static int[] x_move  = {0,1};
	static int[] y_move  = {1,0};

	private static boolean solveMaze(int[][] maze,int x,  int y, int[][] sol) {
		if(x == 3 && y == 3){
			return true;
		}
		for(int i=0;i<2;i++){

			if(isSafe(maze,x,y)){
				//choose
				sol[x][y] = 1;

				//explore
				int x1 = x + x_move[i];
				int y1 = y + y_move[i];
				if(solveMaze(maze,x1,y1,sol)){
					return true;
				}

				//unchoose
				sol[x][y] = 0;
			}
		}
		return false;
	}

}
