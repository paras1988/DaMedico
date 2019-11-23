package com.interviewbit.arrays.simulationArray;

/*Given an array of integers, A of length N, find out the maximum sum sub-array of non negative numbers from A.

The sub-array should be contiguous i.e., a sub-array created by choosing the second and fourth element and skipping the third
element is invalid.

Maximum sub-array is defined in terms of the sum of the elements in the sub-array.

Find and return the required subarray.

NOTE:

    1. If there is a tie, then compare with segment's length and return segment which has maximum length.
    2. If there is still a tie, then return the segment with minimum starting index.
    */
public class MaxNonNegativeSubArray_2 {

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
    int[] res = new int[A.length];

    int csum = 0;
    int maxsum = 0;

    int[] carray = new int[A.length];

    int j = 0;
    for(int i=0;i<A.length;i++){
      if(A[i]<0){
        csum = 0;
        j = 0;
        carray = new int[A.length];
        continue;
      }
      csum = csum + A[i];
      carray[j++] = A[i];

      if(csum>maxsum ){
        maxsum = csum;
        res = carray;
      }
    }
    return res;
  }
}
