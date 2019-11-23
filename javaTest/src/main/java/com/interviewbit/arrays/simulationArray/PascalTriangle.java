package com.interviewbit.arrays.simulationArray;

import java.util.ArrayList;
import java.util.Arrays;

/*Given numRows, generate the first numRows of Pascal’s triangle.

Pascal’s triangle : To generate A[C] in row R, sum up A’[C] and A’[C-1] from previous row R - 1.

Example:

Given numRows = 5,

Return

[
     [1],
     [1,1],
     [1,2,1],
     [1,3,3,1],
     [1,4,6,4,1]
]
*/
public class PascalTriangle {

    public static void main(String[] args) {
        int[][] arr = new PascalTriangle().solve(5);
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }

        System.out.println(new PascalTriangle().generate(5));

    }

    public  int[][]  solve(int A) {
        int[][] arr  = new int[A][A];
        arr[0][0] = 1;
        for(int i=1;i<A;i++){
            for (int j=0;j<=i;j++){
                if(j==0){
                    arr[i][j] = arr[i-1][j];
                }
                else{
                    arr[i][j] = arr[i-1][j]+arr[i-1][j-1];
                }
            }
        }
        return arr;
    }



        public ArrayList<ArrayList<Integer>> generate(int A) {
            int numRows = A;
            ArrayList<ArrayList<Integer>> res = new ArrayList<>();

            if (A == 0)
                return res;

            res.add(new ArrayList<>());
            res.get(0).add(1);

            for (int i = 1; i < numRows; i++) {

                res.add(new ArrayList<>());

                res.get(i).add(1);

                for (int j = 0; j < i - 1; j++) {
                    int num = res.get(i - 1).get(j) + res.get(i - 1).get(j + 1);
                    res.get(i).add(num);
                }

                res.get(i).add(1);

            }

            return res;
        }


}
