package com.interviewbit.checkpoint;

public class kthsmallestInArray {

    public static void main(String[] args) {
        int[] arr = {9, 10 ,1 , 7};
        int B = 2;
        System.out.println(new kthsmallestInArray().kthsmallestInArray(arr,B));

    }

    public int kthsmallestInArray(final int[] A, int B) {

        int l = Integer.MAX_VALUE;
        int h = Integer.MIN_VALUE;

        for(int i=0;i<A.length;i++){
            if(A[i]<l){
                l = A[i];
            }
            if(A[i]>h) {
                h = A[i];
            }
        }

        while (l<h){
            int m = l + (h-l)/2;

            int countless = 0;
            int countEqual = 0;
            for(int i = 0 ;i <A.length;i++){
                if(A[i] < m){
                    countless++;
                }
                if(A[i] == m){
                    countEqual++;
                }
            }
            if(countless < B && countEqual+countless>=B){
                return m;
            }
            if(countless >= B){
                 h = m-1;
            }
            else {
                l = m+1;
            }
        }
        return l;
    }
}
/*Find the kth smallest element in an unsorted array of non-negative integers.

Definition of kth smallest element

 kth smallest element is the minimum possible n such that there are at least k elements in the array <= n.
In other words, if the array A was sorted, then A[k - 1] ( k is 1 based, while the arrays are 0 based )
NOTE
You are not allowed to modify the array ( The array is read only ).
Try to do it using constant extra space.

Example:

A : [2 1 4 3 2]
k : 3

answer : 2
*/