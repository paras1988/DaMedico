package com.interviewbit.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfSortedArrays {

    public static void main(String[] args) {
        int[] A = {1,2,3,3,4,5,6};
        int[] B = {3,3,5};
        int[] c  = new IntersectionOfSortedArrays().intersect(A,B);

        System.out.println(Arrays.toString(c));
    }

    public int[] intersect(final int[] A, final int[] B) {

        int i=0;
        int j=0;
        List<Integer> l = new ArrayList<>();

        while(i<A.length && j<B.length){
            if(A[i] < B[j]){
                i++;
            }
            else if(A[i] > B[j]){
                j++;
            }
            else{
                l.add(A[i]);
                i++;
                j++;
            }
        }
        int[] res = new int[l.size()];
        i=0;
        for(int a:l){
            res[i++] = a;
        }
        return res;
    }
}
