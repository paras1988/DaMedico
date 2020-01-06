package com.interviewbit.backtracking;

import java.util.ArrayList;

public class NQueens {

    ArrayList<ArrayList<String>> res = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(new NQueens().solveNQueens(4));
        System.out.println();
    }



    public ArrayList<ArrayList<String>> solveNQueens(int a) {
        int[][] board = initBoard(a);
        solveNQueens(a, 0,board);
        return res;
    }

    private void solveNQueens(int n, int row, int board[][]) {
       if(row>=n){
           res.add(boardToList(board,n));
           return;
       }

       for(int i=0;i<n;i++){
           if(isSafe(board, row, i, n)){
               board[row][i] = 1;
               solveNQueens(n,row+1,board);
               board[row][i] = 0;
           }
       }
    }

    private boolean isSafe(int[][] board, int row, int col, int N) {

        int i, j;

        /* Check this row on left side */
        for (i = 0; i < row; i++)
            if (board[i][col] == 1)
                return false;

        /* Check upper diagonal on left side */
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        /* Check upper diagonal on right side */
        for (i = row, j = col; i >= 0 && j < N; i--, j++)
            if (board[i][j] == 1)
                return false;

        return true;
    }

    private ArrayList<String> boardToList(int[][] board, int n) {
        ArrayList<String> arrayList = new ArrayList<>();
        for(int i=0;i<n;i++){
            String str = "";
            for(int j=0;j<n;j++){
                if(board[i][j] == 0){
                    str = str.concat(".");
                }
                else str = str.concat("Q");
            }
            arrayList.add(str);
        }
        return arrayList;
    }

    int[][] initBoard(int n){

        int board[][] = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j] = 0;
            }
        }
        return board;
    }
}
/*
* There exist two distinct solutions to the 4-queens puzzle:

[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]

*/