package com.interviewbit.arrays.Bucketing_Sorting;


/*
* Given an array A of integers, find the maximum of j - i subjected to the constraint of A[i] <= A[j].

If there is no solution possible, return -1.

Example :

A : [3 5 4 2]

Output : 2
for the pair (3, 4)
* */
public class MaxDistance_doIT {

    public static void main(String[] args) {
        int[] arr = {3,2,1,5,4,2};
        System.out.println(new MaxDistance_doIT().maximumGap(arr));

        int[] arr2 = {1,1,1,1};
        System.out.println(new MaxDistance_doIT().maximumGap(arr2));

    }

    public int maximumGap(final int[] A) {
        return 0;
    }
}
