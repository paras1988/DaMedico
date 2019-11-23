package com.interviewbit.TwoPointers;

import java.util.*;

public class Get3SumZero_doIt {

    public static void main(String[] args) {
        int[] arr = {1, -4, 0, 0, 5, -5, 1, 0, -2, 4, -4, 1, -1, -4, 3, 4, -1, -1, -3};
        int[][] res = new Get3SumZero_doIt().threeSum(arr);

        for(int[] a:res){
            System.out.println(Arrays.toString(a));
        }


    }
    public int[][] threeSum(int[] A) {
        List<int[]> res = new ArrayList<>();

        Set<Integer>  set = new HashSet<>();

        int l =0;
        int r =0;
        Arrays.sort(A);

        System.out.println(Arrays.toString(A));
        for(int i=0;i<A.length;i++){
            l = i+1;
            r = A.length-1;
            while (l<r){
                if(A[i] + A[l] + A[r] >0){
                    r--;
                }
                else if(A[i] + A[l] + A[r] <0){
                    l++;
                }
                else{
                    int[] temp = {A[i],A[l],A[r]};
                    l++;
                    if(set.contains(Arrays.hashCode(temp))){
                        continue;
                    }
                    set.add(Arrays.hashCode(temp));
                    res.add(temp);

                }
            }
        }

        int[][] t = new int[res.size()][3];
        int i =0;
        for(int[] a: res){
            t[i++] = a;
        }
        return t;

    }
}
/*Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
Find all unique triplets in the array which gives the sum of zero.

Note:

 Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
The solution set must not contain duplicate triplets. For example, given array S = {-1 0 1 2 -1 -4}, A solution set is:
(-1, 0, 1)
(-1, -1, 2)

E.g
A : [ 1, -4, 0, 0, 5, -5, 1, 0, -2, 4, -4, 1, -1, -4, 3, 4, -1, -1, -3 ]

[-5 0 5 ] [-5 1 4 ] [-4 -1 5 ] [-4 0 4 ] [-4 1 3 ] [-3 -2 5 ] [-3 -1 4 ]
[-3 0 3 ] [-2 -1 3 ] [-2 1 1 ] [-1 0 1 ] [0 0 0 ]


*/