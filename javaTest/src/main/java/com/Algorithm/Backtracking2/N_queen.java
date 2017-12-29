package com.Algorithm.Backtracking2;

public class N_queen {

  public static void main(String[] args) {
    int board[][] = {
      {0, 0, 0, 0},
      {0, 0, 0, 0},
      {0, 0, 0, 0},
      {0, 0, 0, 0}
    };

    if (!solveNQUtil(board, 0)) {
      System.out.println("Solution does not exist");

    } else {
      printMaze(board);
    }
  }

  private static boolean solveNQUtil(int[][] board, int i) {

    if (solveNQUtilinner(board, board[0].length, i)) {
      return true;
    }
    return false;


  }

  private static boolean solveNQUtilinner(int[][] board, int length, int i) {
    if (i == length) {
      return true;
    }
    for (int j = 0; j < length; j++) {

      if (isSafeToPutQueen(board, i, j, length)) {
        board[i][j] = 1;
        if (solveNQUtilinner(board, length, i + 1)) {
          return true;
        }
        board[i][j] = 0;
      }
    }

    return false;
  }

  private static boolean isSafeToPutQueen(int[][] board, int row, int col, int length) {
    int i, j;

    /* Check this row on left side */
    for (i = 0; i < col; i++)
      if (board[row][i] == 1)
        return false;

     /* Check this col on left side */
    for (i = 0; i < row; i++)
      if (board[i][col] == 1)
        return false;

    /* Check lower diagonal on left side */
    for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
      if (board[i][j] == 1)
        return false;

    /* Check upper diagonal on left side */
    for (i = row, j = col; j >= 0 && i < length; i++, j--)
      if (board[i][j] == 1)
        return false;


    /* Check upper diagonal on left side */
    for (i = row, j = col; i >= 0 && j < length; i--, j++)
      if (board[i][j] == 1)
        return false;

    /* Check lower diagonal on left side */
    for (i = row, j = col; j < length && i < length; i++, j++)
      if (board[i][j] == 1)
        return false;

    return true;
  }


  private static void printMaze(int[][] board) {

    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++) {
        System.out.print(board[i][j]);
      }
      System.out.print("\n");
    }
  }

}
