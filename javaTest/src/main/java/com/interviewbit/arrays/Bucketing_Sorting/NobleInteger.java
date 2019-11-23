package com.interviewbit.arrays.Bucketing_Sorting;


import java.util.Arrays;

/*
* Given an integer array, find if an integer p exists in the array
* such that the number of integers greater than p in the array
* equals to p
If such an integer is found return 1 else return -1.
* */
public class NobleInteger {

    public static void main(String[] args) {
        int[] arr = { -1, -2, 0, 0, 0, -3};
        int res = new NobleInteger().solve(arr);
        System.out.println(res);
    }

    public int solve(int[] A) {
        Arrays.sort(A);

        int count = 0;
        int prev = 0;
        for(int i=A.length;i>0;i--){
            if(Math.abs(A[i-1]) == count && A[i-1]!=prev){
                return 1;
            }
            ++count;
            prev = A[i-1];
        }
        if(A[A.length-1] == 0){
            return 1;
        }
        return -1;
    }
}
