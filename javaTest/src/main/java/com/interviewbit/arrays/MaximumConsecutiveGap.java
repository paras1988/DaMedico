package com.interviewbit.arrays;

import java.util.Arrays;

public class MaximumConsecutiveGap {

    public static void main(String[] args) {
        int[] arr = {1,10,5};
        System.out.println(new MaximumConsecutiveGap().maximumGap(arr));
    }


    public int maximumGap(final int[] A) {
        Arrays.sort(A);
        int res = 0;
        for(int i=1;i<A.length;i++){
            int sub = A[i] - A[i-1];
            if(sub>res){
                res = sub;
            }
        }
        return res;
    }
}
