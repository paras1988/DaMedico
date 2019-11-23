package com.interviewbit.TwoPointers;

import java.util.Arrays;

public class MinimizeTheAbsoluteDifference {

    public static void main(String[] args) {
        int[] A = { 1, 4, 5, 8, 10};
        int[] B = {6, 9, 15 };
        int[] C = { 2, 3, 6, 6 };

        System.out.println(new MinimizeTheAbsoluteDifference().solve(A,B,C));
    }

    public int solve(int[] A, int[] B, int[] C) {
        int i=0;
        int j=0;
        int k=0;
        int res = 0;

        int min = Integer.MAX_VALUE;

        while (i<A.length && j<B.length && k<C.length){
            int temp =Math.max(A[i],Math.max(B[j],C[k])) - Math.min(A[i],Math.min(B[j],C[k]));
            if(temp < min){
                min = temp;
                res = temp;
            }
            temp = Math.min(A[i],Math.min(B[j],C[k]));

            if(temp == A[i]){
                i++;
            }
            else if(temp == B[j]){
                j++;
            }
            else{
                k++;
            }
        }
        return res;
    }
}
/*Given three sorted arrays A, B and C of not necessarily same sizes.

Calculate the minimum absolute difference between the maximum and minimum number
from the triplet a, b, c such that a, b, c belongs arrays A, B, C respectively.
i.e. minimize | max(a,b,c) - min(a,b,c) |.

Example :

Input:

A : [ 1, 4, 5, 8, 10 ]
B : [ 6, 9, 15 ]
C : [ 2, 3, 6, 6 ]
Output:

1
Explanation: We get the minimum difference for a=5, b=6, c=6 as |
max(a,b,c) - min(a,b,c) | = |6-5| = 1.

*/