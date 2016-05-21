package com.Algorithm.Backtracking2;

public class RatInAMaze2 {

	public static void main(String[] args) {

		int[][] mat={
				{1, 0, 0, 0},
				{1, 1, 0, 1},
				{0, 1, 0, 0},
				{1, 1, 1, 1},
		};

		int[] src={0,0};
		int[] dest={0,0};
		solveRatInAMaze(mat,src,dest);
	}

	static void solveRatInAMaze(int[][] maze,int[] src,int[] dest){

		if(ratInAMazeUtil(maze,src,dest)){
			//printMaze(maze);
		}
		else{
			System.out.println("No Solution");
		}
	}

	private static boolean ratInAMazeUtil(int[][] maze, int[] src, int[] dest) {
		if(src[0]==dest[0] && src[1]==dest[1]){
			return true;
		}
		else{
			//move fwd src[1]+1
			src[1]=src[1]+1;
			if(isSafe(maze,src)){
				maze[src[0]][src[1]]=1;
				if(ratInAMazeUtil(maze,src,dest)){
					return true;
				}else{
					maze[src[0]][src[1]]=0;
				}
			}
			src[0]=src[0]+1;
			if(isSafe(maze,src)){
				maze[src[0]][src[1]]=1;
				if(ratInAMazeUtil(maze,src,dest)){
					return true;
				}else{
					maze[src[0]][src[1]]=0;
				}
			}

		}
		return false;
	}

	private static boolean isSafe(int[][] maze, int[] src) {
		// TODO Auto-generated method stub
		return false;
	}

}
