package com.interviewbit.arrays.Bucketing_Sorting;


/*
* Given an array A of integers, find the maximum of j - i subjected to the constraint of A[i] <= A[j].

If there is no solution possible, return -1.

Example :

A : [3 5 4 2]

Output : 2
for the pair (3, 4)
* */
public class MaxDistance {

    public static void main(String[] args) {
        int[] arr = {3,2,1,5,4,2};
        System.out.println(new MaxDistance().maximumGap(arr));

        int[] arr2 = {1,1,1,1};
        System.out.println(new MaxDistance().maximumGap(arr2));

    }

    public int maximumGap(final int[] A) {
        int n  = A.length;
        int[] lmin = new int[n];
        int[] rmax = new int[n];

        lmin[0] = A[0];
        for(int i=1;i<A.length;i++){
            lmin[i] = Math.min(lmin[i-1],A[i]);
        }

        rmax[n-1] = A[n-1];
        for(int i=n-2;i>=0;i--){
            rmax[i] = Math.max(rmax[i+1],A[i]);
        }

        int i=0;
        int j=0;

        int maxDiff = 0;
        while(i<n && j<n){
            if(lmin[i]<=rmax[j]){
                maxDiff = Math.max(maxDiff,j-i);
                j++;
            }
            else{
                i++;
            }
        }
        return maxDiff;
    }
}
