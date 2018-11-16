package com.interviewbit.arrays;

import java.util.Arrays;

public class MaxNonNegativeSubArray {

  public static void main(String[] args) {
    int[] A = {1, 2, 5, -7, 2, 3};
    System.out.println("");
    for (int i:maxset(A)){
      System.out.print(i);
    }

    int[] B = {-1, -1, -1, -1, -1};
    System.out.println("");
    for (int i:maxset(B)){
      System.out.print(i);
    }

    int[] B1 = {1};
    System.out.println("");
    for (int i:maxset(B1)){
      System.out.print(i);
    }

    int[] B2 = {1,2,-1,-1,-4,4};
    System.out.println("");
    for (int i:maxset(B2)){
      System.out.print(i);
    }

    int[] B3 = {0,0,-1,0};
    System.out.println("");
    for (int i:maxset(B3)){
      System.out.print(i);
    }

    int[] B4 = {1967513926, 1540383426, -1303455736, -521595368 };
    System.out.println("");
    for (int i:maxset(B4)){
      System.out.print(i);
    }
  }

  public static int[] maxset(int[] A) {
    int s = -1;
    int e = -1;
    int c_s = 0;
    int c_e = 0;
    long sum = 0;
    long csum = 0;

    for(int i=0;i<A.length;i++){
      if(A[i]<0){
        if(csum > sum || (csum == sum && c_e-c_s>s-e)){
          sum = csum;
          s  = c_s;
          e = c_e;
        }
        c_s = i+1;
        csum = 0;
      }
      else{
        c_e = i;
        csum += A[i];
      }
    }
    if(csum > sum || (csum == sum && c_e-c_s>e-s)){
      s  = c_s;
      e = c_e;
    }
    int[] res = new int[e-s+1];
    if(s == -1){
      res = new int[0];
    }
    for(int i=0;i<res.length;i++){
      res[i] = A[s++];
    }
    return res;
  }
}
