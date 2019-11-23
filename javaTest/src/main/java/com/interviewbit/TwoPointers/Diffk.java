package com.interviewbit.TwoPointers;

import java.util.Set;

public class Diffk {

    public static void main(String[] args) {
        int[] arr = {1 ,3 ,5};
        System.out.println(new Diffk().diffPossible(arr,4));

        int[] arr2 = {1 ,3 ,5, 12};
        System.out.println(new Diffk().diffPossible(arr2,7));

        int[] arr3 = { 2, 14, 18, 23, 25, 36, 40, 44, 44, 53, 54, 68, 71, 80, 94};
        System.out.println(new Diffk().diffPossible(arr3,82));

        int[] arr4 = {1 ,3 ,5};
        System.out.println(new Diffk().diffPossible(arr4,0));

    }

    public int diffPossible(int[] A, int B) {
        if(A.length < 2){
            return 0;
        }
        int j=1;
        for(int i=0;i<A.length;i++){
            j= Math.max(i+1,j);
            while (j<A.length && A[j]-A[i]<B){
                j++;
            }
            if(j == A.length){
                return 0;
            }
            if(A[j] - A[i] == B){
                return 1;
            }

        }
        return 0;
    }
}
/*Given an array ‘A’ of sorted integers and another non negative integer k, find if there
exists 2 indices i and j such that A[i] - A[j] = k, i != j.

 Example: Input :
    A : [1 3 5]
    k : 4
 Output : YES as 5 - 1 = 4
Return 0 / 1 ( 0 for false, 1 for true ) for this problem

Try doing this in less than linear space complexity.
*/