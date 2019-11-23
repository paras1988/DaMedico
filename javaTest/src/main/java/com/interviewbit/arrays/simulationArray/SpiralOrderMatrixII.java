package com.interviewbit.arrays.simulationArray;

/**
 * Given an integer n, generate a square matrix filled with elements from 1 to n2
 * in spiral order.
 *
 * Example:
 *
 * Given n = 3,
 *
 * You should return the following matrix:
 *
 * [
 *   [ 1, 2, 3 ],
 *   [ 8, 9, 4 ],
 *   [ 7, 6, 5 ]
 * ]
 */
public class SpiralOrderMatrixII {

    public static void main(String[] args) {
        System.out.println(new SpiralOrderMatrixII().generateMatrix(3));
    }

    public int[][] generateMatrix(int A) {

        int[][] a = new int[A][A];

        generateArray(a,0, A*A,1);
        return a;
    }

    private void generateArray(int[][] arr, int s, int max,int count) {
        int n = arr.length-1;

        for(int i=s;i<=n-s;i++){
            arr[s][i] = count++;
        }
        for(int i=s+1;i<=n-s;i++){
            arr[i][n-s] = count++;
        }
        for(int i=n-s-1;i>=s;i--){
            arr[n-s][i] = count++;
        }
        for(int i=n-s-1;i>s;i--){
            arr[i][s] = count++;
        }
        if(count<=max){
            generateArray(arr,s+1,max,count);
        }
    }
}
