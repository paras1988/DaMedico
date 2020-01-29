package com.interviewbit.dynamicProgramming.Suffix_prefix_dp;

public class MaxProductSubarray {

    public static void main(String[] args) {
        int[] arr = {2,3,-2,4};
        System.out.println(new MaxProductSubarray().maxProduct(arr));

        int[] arr2 = {0};
        System.out.println(new MaxProductSubarray().maxProduct(arr2));

        int[] arr3 = {-2};
        System.out.println(new MaxProductSubarray().maxProduct(arr3));

        int[] arr4 = {-1,-2,2};
        System.out.println(new MaxProductSubarray().maxProduct(arr4));
    }

    public int maxProduct(final int[] A){
        return 1;
    }
}
/**
 *
 * Find the contiguous subarray within an array (containing at least one number)
 * which has the largest product.
 *
 * Return an integer corresponding to the maximum product possible.
 *
 * Example :
 *
 * Input : [2, 3, -2, 4]
 * Return : 6
 *
 * Possible with [2, 3]
 *
 * */