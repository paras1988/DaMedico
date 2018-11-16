package com.interviewbit.dp;

/**
 * Given an array of integers,
 * find the length of longest subsequence which is first increasing then decreasing.
 */
public class LongestBitonicSubsequence_V2 {

  public static void main(String[] args) {
    int[] A = {1,11,2,10,4,5,2,1};
    System.out.println(new LongestBitonicSubsequence_V2().longestSubsequenceLength(A));

    int[] A2 = {1};
    System.out.println(new LongestBitonicSubsequence_V2().longestSubsequenceLength(A2));

    int[] A3 = {1,1,1};
    System.out.println(new LongestBitonicSubsequence_V2().longestSubsequenceLength(A3));
  }

  public int longestSubsequenceLength(final int[] A) {

    int res = 0;
    int[] LIS = new int[A.length];
    int[] LDS = new int[A.length];

    for(int i=0;i<A.length;i++){
      int cmax = 1;
      for(int j=0;j<i;j++){
        if(A[j]<A[i] && cmax < LIS[j]+1){
          cmax = LIS[j]+1;
        }
      }
      LIS[i] = cmax;
    }

    for(int i=A.length-1;i>= 0;i--){
      int cmax = 1;
      for(int j=A.length-1;j>i;j--){
        if(A[j]<A[i] && cmax < LDS[j]+1){
          cmax = LDS[j]+1;
        }
      }
      LDS[i] = cmax;
    }

    for(int i=0;i<A.length;i++){
      int cres = LIS[i] + LDS[i] - 1;
      if(res < cres){
        res = cres;
      }
    }
    return res;
  }

}
