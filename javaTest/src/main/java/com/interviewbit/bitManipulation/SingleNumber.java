package com.interviewbit.bitManipulation;

public class SingleNumber {

    public static void main(String[] args) {
        int[] arr = {1,2,2,3,1};
        System.out.println(new SingleNumber().singleNumber(arr));
    }

    public int singleNumber(final int[] A) {
        int res = A[0];

        for(int i=1;i<A.length;i++){
            res = res^A[i];
        }
        return res;
    }
}

/*Given an array of integers, every element appears twice except for one. Find
that single one.

Note: Your algorithm should have a linear runtime complexity. Could you implement it without
using extra memory?

Example :

Input : [1 2 2 3 1]
Output : 3

*/
