package com.interviewbit.arrays;

import java.util.Arrays;

public class WaveArray {

    public static void main(String[] args) {
        int[] arr = {67,674,44,1,3,6,34,76,98,7,2,4,5,9,8,23,234,12,22};
        int[] res = new WaveArray().wave(arr);
        for(int i:res){
            System.out.print(i+" ");
        }
    }

    public int[] wave(int[] A) {
        Arrays.sort(A);
        for(int i=0;i<A.length;i=i+2){
            if(i+1<A.length){
                int temp = A[i];
                A[i] = A[i+1];
                A[i+1] = temp;
            }
        }
        return A;
    }
}
