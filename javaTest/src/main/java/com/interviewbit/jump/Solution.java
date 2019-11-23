package com.interviewbit.jump;

public class Solution {


    public static void main(String[] args) {
        System.out.println(new Solution().prettyPrint(3));
        System.out.println(new Solution().prettyPrint(4));
    }

    public int[][] prettyPrint(int A) {
        int n = A*2-1;
        int[][] res = new int[n][n];

        for(int i=0;i<A;i++){
            fillArray(res,i,n-1,A-i);
        }

        return res;
    }

    void fillArray(int[][] arr, int x, int A, int n){
        for(int i=x;i<=A-x;i++){
            arr[x][i] = n;
            arr[i][x] = n;
            arr[i][A-x] = n;
            arr[A-x][i] = n;
        }
    }
}
