package com.interviewbit.dynamicProgramming;

public class LengthOfLongestSequence {

    public static void main(String[] args) {
        int[] arr = {1, 11, 2, 10, 4, 5, 2, 1};
        System.out.println(new LengthOfLongestSequence().longestSubsequenceLength(arr));
    }

    public int longestSubsequenceLength(final int[] A) {
        int[] lis = new int[A.length];
        int[] lds = new int[A.length];

        for(int i=0;i<A.length;i++){
            lis[i] = 0;
            lds[i] = 0;
        }
        lis[0] = 1;
        lds[0] = 1;

        for(int i=0;i<A.length;i++){
            for(int j=0;j<i;j++){
                if(A[i] > A[j] && lis[i] < lis[j]+1){
                    lis[i] = lis[j]+1;
                }
            }
        }


        for(int i=A.length-1;i>=0;i--){
            for(int j=A.length-1;j>i;j--){
                if(A[i] > A[j] && lds[i] < lds[j]+1){
                    lds[i] = lds[j]+1;
                }
            }
        }

        int max = 0;
        for(int i=0;i<A.length;i++){
            if(max<lis[i]+lds[i]){
                max = lis[i]+lds[i];
            }
        }

        return max;
    }
}
/**
 *
 * Given an array of integers, A of length N, find the length of longest subsequence which is
 * first increasing then decreasing.
 *
 * Input Format:
 *
 * The first and the only argument contains an integer array, A.
 * Output Format:
 *
 * Return an integer representing the answer as described in the problem statement.
 * Constraints:
 *
 * 1 <= N <= 3000
 *
 *1 <= A[i] <= 1e7
 * Example:
 *
 * Input 1:
 *     A = [1, 2, 1]
 *
 * Output 1:
 *     3
 *
 * Explanation 1:
 *     [1, 2, 1] is the longest subsequence.
 *
 * Input 2:
 *     [1, 11, 2, 10, 4, 5, 2, 1]
 *
 * Output 2:
 *     6
 *
 * Explanation 2:
 *     [1 2 10 4 2 1] is the longest subsequence.
 * */