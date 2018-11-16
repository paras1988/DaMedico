package com.interviewbit.dp;

/**
 * Given an array of integers,
 * find the length of longest subsequence which is first increasing then decreasing.
 */
public class LongestBitonicSubsequence_V1 {

  public static void main(String[] args) {
    int[] A = {1,1,1,1};
    System.out.println(new LongestBitonicSubsequence_V1().longestSubsequenceLength(A));
  }

  public int longestSubsequenceLength(final int[] A) {

    int res = 0;

    for(int i=0;i<A.length;i++){
      int cres = LIS(A,0,i)+LDS(A,i,A.length)-1;
      if(res < cres){
        res = cres;
      }
    }
    return res;
  }

  private int LDS(int[] a, int s, int e) {
    int[] LDS = new int[e];

    for(int i = e-1; i >= s; i--){
      int cmax = 1;
      for (int j = e-1 ; j > i ; j--){
        if(a[i] > a[j] && cmax < LDS[j]+1){
          cmax = LDS[j]+1;
        }
      }
      LDS[i] = cmax;
    }
    int max = 0;
    for(int i=0;i<e;i++){
      max = max<LDS[i]? LDS[i]:max;
    }
    return max;
  }

  private int LIS(int[] a, int s, int e) {
    int[] LIS = new int[e-s+1];

    for(int i = s; i <= e; i++){
      int cmax = 1;
      for (int j = 0; j<i ; j++){
        if(a[i] > a[j] && cmax < LIS[j]+1){
          cmax = LIS[j]+1;
        }
      }
      LIS[i] = cmax;
    }
    int max = 0;
    for(int i=0;i<=e;i++){
      max = max<LIS[i]? LIS[i]:max;
    }
    return max;
  }
}
