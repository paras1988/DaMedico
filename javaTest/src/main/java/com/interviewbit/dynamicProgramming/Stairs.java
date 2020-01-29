package com.interviewbit.dynamicProgramming;

public class Stairs {

    public static void main(String[] args) {

    }

    //non-memoized
    public int recurClimbStairs(int A) {
        if(A==0){
            return 1;
        }
        if(A==1){
            return 1;
        }
        return climbStairs(A-1)+climbStairs(A-2);
    }

    public int climbStairs(int A) {
        int[] res = new int[A+1];
        res[0] = 1;
        res[1] = 1;

        for(int i=2;i<=A;i++){
            res[i]= res[i-1]+res[i-2];
        }
        return res[A];
    }
}
/**
 *
 * You are climbing a stair case and it takes A steps to reach to the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 *
 *
 * Input Format:
 *
 * The first and the only argument contains an integer A, the number of steps.
 * Output Format:
 *
 * Return an integer, representing the number of ways to reach the top.
 * Constrains:
 *
 * 1 <= A <= 36
 * Example :
 *
 * Input 1:
 *
 * A = 2 Output 1:
 *
 * 2 Explanation 1:
 *
 * [1, 1], [2] Input 2:
 *
 * A = 3 Output 2:
 *
 * 3 Explanation 2:
 *
 * [1 1 1], [1 2], [2 1]
 *
 *
 * */