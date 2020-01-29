package com.interviewbit.dynamicProgramming.geeksForgeeks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

// You can't use greedy over here.
public class MinimumNumberOfCoins {

    static Integer[] denominations = { 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000};
    public static void main(String[] args) throws IOException {
        Arrays.sort(denominations, Collections.reverseOrder());

        BufferedReader S=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(S.readLine());

        while(n>0){
            int m=Integer.parseInt(S.readLine());
           // System.out.println(new MinimumNumberOfCoins().recursiveSolution(m));
            System.out.println(new MinimumNumberOfCoins().memoized_bottomup(m));
            System.out.println(Arrays.toString(new MinimumNumberOfCoins().memoized_bottomup_with_coins(m)));
        }
    }

    //TODO
    private int[] memoized_bottomup_with_coins(int m) {

        int[] arr= new int[m+1];
        int[] res= new int[m+1];

        arr[0] = 0;
        for(int i=1;i<arr.length;i++){
            arr[i] = Integer.MAX_VALUE;

            for(int j=0;j<denominations.length;j++){
                if(denominations[j]<=i){
                    int a = 1+arr[i-denominations[j]];
                    if(a < arr[i]){
                        arr[i] = a;
                        res[i] = denominations[j];
                    }
                }
            }
        }

        return res;
    }

    private int memoized_bottomup(int m) {

        int[] arr= new int[m+1];
        arr[0] = 0;
        for(int i=1;i<arr.length;i++){
            arr[i] = Integer.MAX_VALUE;

            for(int j=0;j<denominations.length;j++){
                if(denominations[j]<=i){
                    int a = 1+arr[i-denominations[j]];
                    if(a < arr[i]){
                        arr[i] = a;
                    }
                }
            }
        }

        return arr[m];
    }

    private int recursiveSolution(int m) {

        if(m<=0){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for(int i=0;i<denominations.length;i++){
            if(denominations[i]>m){
                continue;
            }
            int t = 1+recursiveSolution(m-denominations[i]);
            if(min > t){
                min = t;
            }
        }
        return min;

    }


}
/**
* Given a value N, total sum you have. You have to make change for Rs. N, and there is infinite supply of each of the
 * denominations in Indian currency, i.e., you have infinite supply of { 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000}
 * valued coins/notes, Find the minimum number of coins and/or notes needed to make the change for Rs N.
 *
 * Input:
 * The first line of input contains an integer T denoting the number of test cases. Each test case consist of an Integer
 * value N denoting the amount to get change for.
 *
 * Output:
 * Print all the denominations needed to make the change in a separate line.
 *
 * Constraints:
 * 1 ≤ T ≤ 100
 * 1 ≤ N ≤ 106
 *
 * Example:
 * Input:
 * 1
 * 43
 *
 * Output:
 * 20 20 2 1
 *
 * Explanation:
 * Testcase 1: Sum of Rs 43 can be changed with minimum of 4 coins/ notes 20, 20, 2, 1.
*
* */