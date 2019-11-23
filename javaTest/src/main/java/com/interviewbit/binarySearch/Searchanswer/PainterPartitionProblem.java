package com.interviewbit.binarySearch.Searchanswer;

public class PainterPartitionProblem {

    public static void main(String[] args) {
        int A = 1;
        int B = 1000000;
        int[] C = { 1000000, 1000000 };

        System.out.println(new PainterPartitionProblem().paint(A,B,C));
    }

    public int paint(int A, int B, int[] C) {

        if(A > C.length){
            A = C.length;
        }
        int min = 0;
        int max = 0;
        for(int i=0;i<C.length;i++){
            max += C[i];
            if(C[i]>min){
                min = C[i];
            }
        }

        while (min < max){

            int mid = min + (max - min)/2;
            int count = 0;
            int tot = 0;
            for(int i=0;i<C.length;i++){
                tot += C[i];
                if(tot>mid){
                    ++count;
                    tot = C[i] ;
                }
            }
            if(count < A){
                max = mid;
            }
            else{
                min = mid+1;
            }
        }
        return (int)((long)min*B % 10000003);
    }
}
