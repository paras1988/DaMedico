package com.interviewbit.dp;

public class Stairs_V1 {

  public static void main(String[] args) {
    System.out.println(new Stairs_V1().climbStairsRecur(3));
    System.out.println(new Stairs_V1().climbStairs(3));

    System.out.println(new Stairs_V1().climbStairsRecur(1));
    System.out.println(new Stairs_V1().climbStairs(1));

    System.out.println(new Stairs_V1().climbStairsRecur(2));
    System.out.println(new Stairs_V1().climbStairs(2));

    System.out.println(new Stairs_V1().climbStairsRecur(11));
    System.out.println(new Stairs_V1().climbStairs(11));

  }

  public int climbStairsRecur(int A) {
    if(A < 0){
      return 0;
    }
    if(A == 0){
      return 1;
    }
    return climbStairsRecur(A-1)+climbStairsRecur(A-2);
  }


  public int climbStairs(int A) {

    if(A==0){
      return 0;
    }
    if(A==1){
      return 1;
    }
    int[] stairCount = new int[A];
    stairCount[0] = 1;
    stairCount[1] = 2;
    for(int i=2; i<A; i++){
      stairCount[i] = stairCount[i-1]+stairCount[i-2];
    }
    return stairCount[A-1];
  }
}
