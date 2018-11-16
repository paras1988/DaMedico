package com.interviewbit.dp;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Determine if you are able to reach the last index.
 *
 * For example:
 * A = [2,3,1,1,4], return 1 ( true ).
 *
 * A = [3,2,1,0,4], return 0 ( false ).
 */
public class JumpGameArray {

  public static void main(String[] args) {
    int[] A = {2,3,1,1,4};
    System.out.println(new JumpGameArray().canJumpRecur(A));
    System.out.println(new JumpGameArray().canJump(A));

    int[] A2 = {3,2,1,0,4};
    System.out.println(new JumpGameArray().canJumpRecur(A2));
    System.out.println(new JumpGameArray().canJump(A2));

    int[] A3 = {1,1,1,1,1};
    System.out.println(new JumpGameArray().canJumpRecur(A3));
    System.out.println(new JumpGameArray().canJump(A3));

    int[] A4 = {1};
    System.out.println(new JumpGameArray().canJumpRecur(A4));
    System.out.println(new JumpGameArray().canJump(A4));

    int[] A5 = {1,0,0};
    System.out.println(new JumpGameArray().canJumpRecur(A5));
    System.out.println(new JumpGameArray().canJump(A5));
  }

  public int canJumpRecur(int[] A) {
    if(canJumpRecurUtil(A,0,A.length-1)){
      return 1;
    }
    return 0;
  }

  private boolean canJumpRecurUtil(int[] a, int s, int e) {
    if(s == e){
      return true;
    }
    for(int i = s+1 ; i<= s+a[s] ;i++){
      if(canJumpRecurUtil(a,i,e)){
        return true;
      }
    }
    return false;
  }

  public int canJump(int[] A) {
    int[] jump = new int[A.length];
    jump[A.length-1] = 1;

    for(int i = A.length-2;i>=0;i--){
      for(int j = i+1; j<= i+A[i]; j++){
        if(jump[j]==1){
          jump[i] = 1;
          break;
        }
      }
    }
    return jump[0];
  }
}
