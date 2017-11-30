package com.Algorithm.Backtracking;
public class RatInAMaze {
	static int N=4;

	public static void main(String[] args) {
		int maze[][]  =  
			  { {1, 0, 0, 0},
				{1, 1, 0, 1},
				{0, 1, 0, 0},
				{1, 1, 1, 1}
		};

		solveMaze(maze);
	}

	private static void solveMaze(int[][] maze) {
		int sol[][] = { {0, 0, 0, 0},
				{0, 0, 0, 0},
				{0, 0, 0, 0},
				{0, 0, 0, 0}
		};

		if(solveMazeUtil(maze,0,0,sol)) {
			printMaze(sol);
		}
		else{
			System.out.println("No Answer found");
		}
	}

	private static void printMaze(int[][] maze) {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(maze[i][j]);
			}
			System.out.println("\n");
		}
	}

	private static boolean solveMazeUtil(int[][] maze, int i, int j, int[][] sol) {
		if(i==N-1 && j==N-1) {
			sol[i][j]=1;
			return true;
		}
		else{
			System.out.println("i "+i+" j "+ j);
			if(isSafe(maze,i,j)){
				sol[i][j]=1;
				if(solveMazeUtil(maze,i+1,j,sol)) {
					return true;
				}
				if(solveMazeUtil(maze,i,j+1,sol)) {
					return true;
				}

				sol[i][j]=0;
			}
			return false;
		}
	}

	static boolean isSafe(int[][] maze,int x,int y){
		if( x>=0 && y>=0 && x<N && y<N && maze[x][y]==1) {
			return true;
		}
		return false;
	}
}
