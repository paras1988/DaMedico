package com.Algorithm.Backtracking;

import java.util.ArrayList;

public class Nqueens {

	static ArrayList<ArrayList<String>> res=new ArrayList<ArrayList<String>>();

	public static void main(String[] args) {
		int a=4;
		solveNQueens();
	}

	public static ArrayList<ArrayList<String>> solveNQueens() {

		String board[][] = {
				{".",".",".","."},
				{".",".",".","."},
				{".",".",".","."},
				{".",".",".","."}
		};


		solveNQueensUtil(board,0);
		System.out.println(res);
		return null;
	}

	private static void solveNQueensUtil(String[][] board, int row) {

		if(row==4){
			addBoardToResult(board);
			return;
		}
		for(int col=0;col<4;col++){
			if(isSafe(board,row,col)){
				board[row][col]="Q";
				solveNQueensUtil(board,row+1);
				board[row][col]=".";
			}
		}
	}

	private static void addBoardToResult(String[][] board) {

		for(int i=0;i<4;i++){
			ArrayList<String> list=new ArrayList<>();
			for(int j=0;j<4;j++){
				list.add(board[i][j]);
			}
			res.add(list);
		}
	}

	private static boolean isSafe(String board[][], int row, int col)
	{
		int i, j;
		int N=4;
		/* Check this row on left side */
		for (i = 0; i < col; i++) {
			if (board[row][i].equals("Q")) {
				return false;
			}
		}

		for (i = 0; i < row; i++) {
			if (board[i][col].equals("Q")) {
				return false;
			}
		}

		/* Check upper diagonal on left side */
		for (i=row, j=col; i>=0 && j>=0; i--, j--) {
			if (board[i][j].equals("Q")) {
				return false;
			}
		}

		for (i=row, j=col; i<N && j<N; i++, j++) {
			if (board[i][j].equals("Q")) {
				return false;
			}
		}

		for (i=row, j=col; i>=0 && j<N; i--, j++) {
			if (board[i][j].equals("Q")) {
				return false;
			}
		}

		/* Check lower diagonal on left side */
		for (i=row, j=col; j>=0 && i<N; i++, j--) {
			if (board[i][j].equals("Q")) {
				return false;
			}
		}

		return true;
	}

	/*private static boolean isSafe(String[][] board, int i, int j) {
		int k=0;
		if(i>=0 && j>=0 && i<4 && j<4 && board[i][j].equals(".")){
			for(int a=0;a<4;a++){
				if(board[i][a].equals(".") && board[a][j].equals(".")){
					k++;
				}
			}

			if(i>=j){
				int a=i;
				int b=j;
				while(b>=0){
					if(!board[a--][b--].equals(".")) {
						return false;
					}
				}
				a=i;b=j;
				while(a<4){
					if(!board[a++][b++].equals(".")) {
						return false;
					}
				}
			}
			else{
				int a=i;
				int b=j;
				while(a>=0){
					if(!board[a--][b--].equals(".")) {
						return false;
					}
				}
				a=i;b=j;
				while(b<4){
					if(!board[a++][b++].equals(".")) {
						return false;
					}
				}
			}
			if(k==4) {
				return true;
			}
		}
		return false;
	}*/
}
