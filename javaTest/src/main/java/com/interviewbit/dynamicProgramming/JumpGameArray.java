package com.interviewbit.dynamicProgramming;

import java.util.ArrayList;

public class JumpGameArray {

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList();
        arr.add(3);
        arr.add(2);
        arr.add(1);
        arr.add(0);
        arr.add(4);

        System.out.println(new JumpGameArray().canJump(arr));

        arr = new ArrayList();
        arr.add(2);
        arr.add(2);
        arr.add(1);
        arr.add(0);
        arr.add(4);

        System.out.println(new JumpGameArray().canJump(arr));
    }

    //////////////////
    public int canJump1(ArrayList<Integer> A) {

        return jumpUtil(A,0);
    }

    private int jumpUtil(ArrayList<Integer> A, int j) {
        if(j+A.get(j) >= A.size()-1){
            return 1;
        }
        for(int i=j+1;i<=j+A.get(j);i++){
            if(jumpUtil(A,i) == 1){
                return 1;
            }
        }
        return 0;
    }

    ////////////////////////////////      Memoized
    public int canJump2(ArrayList<Integer> A) {
        int[] res = new int[A.size()];
        res[0] = 1;
        for(int i=1;i<A.size();i++){
            res[i] = 0;
        }

        for(int i=1;i<A.size();i++){
           for(int j=0;j<i;j++){
               if(j+A.get(j) >= i && res[j]!=0){
                   res[i] = 1;
                   break;
               }
           }
        }
        return res[A.size()-1];
    }


    //////////////////////////////// moreOptimized _ exactly needed  .. bottom up is one loop/////
    public int canJump(ArrayList<Integer> A) {
        if(A.size() == 1) { return 1;}
        int end = A.size()-1;
        for(int i=A.size()-1;i>=0;i--){
            if(i+A.get(i) >= end){
                end = i;
            }
        }
        return end == 0 ? 1 : 0;
    }



}
/**
 *
 * Given an array of non-negative integers, A, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Determine if you are able to reach the last index.
 *
 *
 * Input Format:
 *
 * The first and the only argument of input will be an integer array A.
 * Output Format:
 *
 * Return an integer, representing the answer as described in the problem statement.
 *     => 0 : If you cannot reach the last index.
 *     => 1 : If you can reach the last index.
 * Constraints:
 * 1 <= len(A) <= 1e6
 * 0 <= A[i] <= 30
 *
 * Examples:
 *
 * Input 1:
 *     A = [2,3,1,1,4]
 *
 * Output 1:
 *     1
 *
 * Explanation 1:
 *     Index 0 -> Index 2 -> Index 3 -> Index 4 -> Index 5
 *
 * Input 2:
 *     A = [3,2,1,0,4]
 *
 * Output 2:
 *     0
 *
 * Explanation 2:
 *     There is no possible path to reach the last index.
 *
 *
 * */