package com.interviewbit.backtracking;

import java.util.ArrayList;

public class Sudoku {

    public static void main(String[] args) {
        ArrayList<ArrayList<Character>> a = new ArrayList<>();
        a.add(getArraylist("53..7...."));
        a.add(getArraylist("6..195..."));
        a.add(getArraylist(".98....6."));
        a.add(getArraylist("8...6...3"));
        a.add(getArraylist("4..8.3..1"));
        a.add(getArraylist("7...2...6"));
        a.add(getArraylist(".6....28."));
        a.add(getArraylist("...419..5"));
        a.add(getArraylist("....8..79"));

        new Sudoku().solveSudoku(a);
        System.out.println("cc");
    }

    private static ArrayList<Character> getArraylist(String s) {
        ArrayList<Character> res = new ArrayList<>();
        for(Character c: s.toCharArray()){
            res.add(c);
        }
        return res;
    }

    public void solveSudoku(ArrayList<ArrayList<Character>> a) {
        int[][] intArr = getIntegerMatrix(a);

        solveSudokuUtil(intArr);

        getResultForArr(intArr,a);

    }

    private void getResultForArr(int[][] intArr, ArrayList<ArrayList<Character>> a) {
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                a.get(i).set(j,String.valueOf(intArr[i][j]).toCharArray()[0]);
            }
        }
    }

    private Boolean solveSudokuUtil(int[][] intArr) {
        int row = 0;
        int col = 0;
        Boolean isComplete = true;
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(intArr[i][j] == 0){
                    row = i;
                    col = j;
                    isComplete = false;
                    break;
                }
            }
        }
        if(isComplete){
           return true;
        }

        for(int i=1;i<=9;i++){
            if(isSafe(intArr, row, col, i)){
                intArr[row][col] = i;
                if(solveSudokuUtil(intArr)){
                    return true;
                }
                intArr[row][col] = 0;
            }
        }
        return false;
    }

    public static boolean isSafe(int[][] board,
                                 int row, int col,
                                 int num)
    {
        // row has the unique (row-clash)
        for (int d = 0; d < board.length; d++)
        {
            // if the number we are trying to
            // place is already present in
            // that row, return false;
            if (board[row][d] == num)
            {
                return false;
            }
        }

        // column has the unique numbers (column-clash)
        for (int r = 0; r < board.length; r++)
        {
            // if the number we are trying to
            // place is already present in
            // that column, return false;

            if (board[r][col] == num)
            {
                return false;
            }
        }

        // corresponding square has
        // unique number (box-clash)
        int sqrt = (int) Math.sqrt(board.length);
        int boxRowStart = row - row % sqrt;
        int boxColStart = col - col % sqrt;

        for (int r = boxRowStart;
             r < boxRowStart + sqrt; r++)
        {
            for (int d = boxColStart;
                 d < boxColStart + sqrt; d++)
            {
                if (board[r][d] == num)
                {
                    return false;
                }
            }
        }

        // if there is no clash, it's safe
        return true;
    }

    private int[][] getIntegerMatrix(ArrayList<ArrayList<Character>> a) {
        int[][] res = new int[9][9];
        for(int i=0;i<9;i++){
           for(int j=0;j<9;j++){
               if(String.valueOf(a.get(i).get(j)).equals(".")){
                   res[i][j] = 0;
               }
               else{
               res[i][j] = Integer.parseInt(String.valueOf(a.get(i).get(j)));
           }
           }
        }
        return res;
    }
}

/*
* For the above given diagrams, the corresponding input to your program will be

[[53..7....], [6..195...], [.98....6.], [8...6...3], [4..8.3..1], [7...2...6], [.6....28.], [...419..5], [....8..79]]
and we would expect your program to modify the above array of array of characters to

[[534678912], [672195348], [198342567], [859761423], [426853791], [713924856], [961537284],

* */
