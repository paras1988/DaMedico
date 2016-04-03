package com.Algorithm.Backtracking;
public class N_Queen {
	public static void main(String[] args) {

		int board[][] = {
				{0, 0, 0, 0},
				{0, 0, 0, 0},
				{0, 0, 0, 0},
				{0, 0, 0, 0}
		};

		if (!solveNQUtil(board, 0))
		{
			System.out.println("Solution does not exist");

		}
		else{
			printMaze(board);
		}
	}
	private static void printMaze(int[][] maze) {
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				System.out.print(maze[i][j]);
			}
			System.out.print("\n");
		}
	}
	private static boolean solveNQUtil(int[][] board, int i) {
		if(i==4) {
			return true;
		}
		for(int j=0;j<4;j++){
			if(isSafe(board,i,j)){
				board[i][j]=1;
				if(solveNQUtil(board,i+1)) {
					return true;
				}
				board[i][j]=0;
			}
		}
		return false;
	}

	private static boolean isSafe(int[][] board, int i, int j) {
		int k=0;
		if(i>=0 && j>=0 && i<4 && j<4 && board[i][j]==0){
			for(int a=0;a<4;a++){
				if(board[i][a]==0 && board[a][j]==0){
					k++;
				}
			}

			if(i>=j){
				int a=i;
				int b=j;
				while(b>=0){
					if(board[a--][b--]!=0) {
						return false;
					}
				}
				a=i;b=j;
				while(a<4){
					if(board[a++][b++]!=0) {
						return false;
					}
				}
			}
			else{
				int a=i;
				int b=j;
				while(a>=0){
					if(board[a--][b--]!=0) {
						return false;
					}
				}
				a=i;b=j;
				while(b<4){
					if(board[a++][b++]!=0) {
						return false;
					}
				}
			}
			if(k==4) {
				return true;
			}
		}
		return false;
	}
}
