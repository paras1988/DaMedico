package com.interviewbit.dynamicProgramming;

public class MinJumpsArray {

    public static void main(String[] args) {
        int[] arr= {2,2,1,0,4};
        System.out.println(new MinJumpsArray().jump1(arr));

        int[] arr1= {0};
        System.out.println(new MinJumpsArray().jump(arr1));
    }


    public int jump1(int[] arr) {
        int n = arr.length;
        int jumps[] = new int[n]; // jumps[n-1] will hold the
        // result
        int i, j;

        jumps[0] = 0;

        // Find the minimum number of jumps to reach arr[i]
        // from arr[0], and assign this value to jumps[i]
        for (i = 1; i < n; i++) {
            jumps[i] = Integer.MAX_VALUE;
            for (j = 0; j < i; j++) {
                if (i <= j + arr[j] && jumps[j] != Integer.MAX_VALUE) {
                    jumps[i] = Math.min(jumps[i], jumps[j] + 1);
                    break;
                }
            }
        }
        if(jumps[n-1] == Integer.MAX_VALUE){
            return -1;
        }
        return jumps[n-1];
    }


    /// most optimized.
    public int jump(int[] arr) {
        if(arr.length == 1) { return 0; }

        int jumps = 0;
        int far = 0;
        int cend = 0;
        for(int i=0;i<arr.length-1;i++){
            if(i+arr[i] > far){
                far = i + arr[i];
            }
            if(i == cend){
                if(far <= i){return  -1;}
                jumps++;
                cend = far;
            }
        }
        return jumps;
    }


}

/**
 * Given an array of non-negative integers, A, of length N, you are initially
 * positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Return the minimum number of jumps required to reach the last index.
 *
 * If it is not possible to reach the last index, return -1.
 *
 * Input Format:
 *
 * The first and the only argument contains an integer array, A.
 * Output Format:
 *
 * Return an integer, representing the answer as described in the problem statement.
 * Constraints:
 *
 * 1 <= N <= 1e6
 * 0 <= A[i] <= 50000
 * Examples:
 *
 * Input 1:
 *     A = [2, 1, 1]
 *
 * Output 1:
 *     1
 *
 * Explanation 1:
 *     The shortest way to reach index 2 is
 *         Index 0 -> Index 2
 *     that requires only 1 jump.
 *
 * Input 2:
 *     A = [2,3,1,1,4]
 *
 * Output 2:
 *     2
 *
 * Explanation 2:
 *     The shortest way to reach index 4 is
 *         Index 0 -> Index 1 -> Index 4
 *     that requires 2 jumps.
 *
 *
 * */
