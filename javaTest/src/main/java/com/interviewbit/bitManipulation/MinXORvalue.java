package com.interviewbit.bitManipulation;

import java.util.Arrays;

public class MinXORvalue {

    public static void main(String[] args) {
        int[] arr = {0,2,5,7};
        System.out.println(new MinXORvalue().findMinXor(arr));

        int[] arr1 = {0,4,7,9};
        System.out.println(new MinXORvalue().findMinXor(arr1));
    }

    public int findMinXor(int[] A) {
        Arrays.sort(A);
        int min = Integer.MAX_VALUE;
        int start = A[0];
        for(int i=1;i<A.length;i++){
            int xor =start^A[i];
            if(xor<min){
                min = xor;
            }
            start = A[i];
        }
        return min;
    }

}
/*Given an array of N integers, find the pair of integers in the array which have
minimum XOR value. Report the minimum XOR value.

Examples :
Input
0 2 5 7
Output
2 (0 XOR 2)
Input
0 4 7 9
Output
3 (4 XOR 7)

Constraints:
2 <= N <= 100 000
0 <= A[i] <= 1 000 000 000
*/