package com.interviewbit.arrays;

import java.util.Arrays;

public class MaximumUnsortedSubarray {

    public static void main(String[] args) {
        int[] arr = {1,3,2,4,5};
        int[] res = new MaximumUnsortedSubarray().subUnsort(arr);

        for(int i:res){
            System.out.println(i+" ");
        }
    }

    public int[] subUnsort(int[] A) {
        int[] res = new int[A.length];
        int c = 0;
        for(int i:A){
            res[c] = i;
            c++;
        }
        Arrays.sort(A);
        int s = -1;
        int e = 0;
        for(int i=0;i<A.length;i++){
            if(s==-1 && A[i] != res[i]){
                s = i;
            }
            if(s!=-1 && A[i] != res[i]){
                e = i;
            }
        }
        int[] r;
        if(s==-1){
            r = new int[1];
            r[0] = s;
            return r;
        }
        r = new int[2];
        r[0] = s;
        r[1] = e;
        return r;
    }
}
