package com.interviewbit.arrays.Bucketing_Sorting;


import java.util.Arrays;

public class WaveArray {

    public static void main(String[] args) {

        int[] arr = {1,2,3,4};
        System.out.println(new WaveArray().wave(arr));
    }

    public int[] wave(int[] A) {
        Arrays.sort(A);
        for(int i=0;i<A.length;i=i+2){
            if(i+1<A.length){
                int temp = A[i+1];
                A[i+1] = A[i];
                A[i]  = temp;
            }
        }
        return A;
    }
}
