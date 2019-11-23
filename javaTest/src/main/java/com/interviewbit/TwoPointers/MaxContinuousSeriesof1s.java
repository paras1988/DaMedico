package com.interviewbit.TwoPointers;

import java.util.Arrays;

public class MaxContinuousSeriesof1s {

    public static void main(String[] args) {
        int[] A = {1 ,1 ,0 ,1 ,1 ,0 ,0 ,1 ,1 ,1 };
        System.out.println(Arrays.toString(new MaxContinuousSeriesof1s().maxone(A,1)));
        System.out.println(Arrays.toString(new MaxContinuousSeriesof1s().maxone(A,2)));
    }

    public int[] maxone(int[] A, int B) {

        int size = 0;
        int index = 0;
        int l=0;
        int r=0;
        int zeroCount = 0;
        while (r < A.length){
            if(zeroCount<=B){
                if(A[r] == 0){
                    zeroCount++;
                }
                r++;
            }
            if(zeroCount>B){
                if(A[l] == 0){
                    zeroCount--;
                }
                l++;
            }

            if(r-l > size){
                size = r-l;
                index = l;
            }
        }

        int[] res = new int[size];
        int j = 0;
        for(int i=index;i<index+size;i++){
            res[j++] = i;
        }
        return res;
    }
}
/*You are given with an array of 1s and 0s. And you are given with an integer M, which signifies number of flips allowed.
Find the position of zeros which when flipped will produce maximum continuous series of 1s.

For this problem, return the indices of maximum continuous series of 1s in order.

Example:

Input :
Array = {1 1 0 1 1 0 0 1 1 1 }
M = 1

Output :
[0, 1, 2, 3, 4]

If there are multiple possible solutions, return the sequence which has the minimum start index.*/