package com.interviewbit.dynamicProgramming.geeksForgeeks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class MinimumOperations {


    public static void main(String[] args) throws IOException {

        BufferedReader S=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(S.readLine());

        while(n>0){
            n--;
            int val=Integer.parseInt(S.readLine());
            //System.out.println(new MinimumOperations().recursiveCall(val));
            //System.out.println(new MinimumOperations().recursiveCallMemoized_topDon(val));
            System.out.println(new MinimumOperations().iterativeCallMemoized_bottomUp(val));
        }
    }

    private int recursiveCall(int val) {
        if(val == 1){
            return 1;
        }
        if(val == 0){
            return 0;
        }
        if(val%2 == 0) {
            return Math.min(recursiveCall(val / 2), recursiveCall(val - 1)) + 1;
        }
        return recursiveCall(val-1)+1;
    }

    Map<Integer, Integer> map = new HashMap<>();
    private int recursiveCallMemoized_topDon(int val) {
        if(val == 1){
            return 1;
        }
        if(val == 0){
            return 0;
        }
        if(map.containsKey(val)){
            return map.get(val);
        }
        if(val%2 == 0) {
            int res =  Math.min(recursiveCall(val / 2), recursiveCall(val - 1)) + 1;

            if(!map.containsKey(val)){
                map.put(val,res);
            }
            return res;
        }
        int res = recursiveCall(val-1)+1;
        if(!map.containsKey(val)){
            map.put(val,res);
        }
        return res;
    }

    private int iterativeCallMemoized_bottomUp(int val) {

        if(val == 0){
            return 0;
        }
        if(val == 1){
            return 1;
        }
        int res[] = new int[val+1];
        res[0] = 0;
        res[1] = 1;

        for(int i=2;i<=val;i++){
            if(i%2 ==0) {
                res[i] = 1+ Math.min(res[i / 2], res[i - 1]);
                continue;
            }
            res[i] = 1 + res[i-1];
        }

        return res[val];
    }

}
/**
 *
 * 6
 * 8
 * 7
 * 1
 * 2
 * 3
 * 4
 *
 * You are given a number N. You have to find the number of operations required to reach N from 0. You have 2 operations available:
 *
 * Double the number
 * Add one to the number
 * Input:
 * The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case contains an integer N.
 *
 * Output:
 * For each test case, in a new line, print the minimum number of operations required to reach N from 0.
 *
 * Constraints:
 * 1<=T<=100
 * 1<=N<=104
 *
 * Example:
 * Input:
 * 2
 * 8
 * 7
 * Input:
 * 4
 * 5
 *
 * Explanation:
 * Testcase1:
 * Input  : N = 8
 * Output : 4
 * 0 + 1 = 1, 1 + 1 = 2, 2 * 2 = 4, 4 * 2 = 8
 * Testcase2:
 * Input  : N = 7
 * Output : 5
 * 0 + 1 = 1, 1 + 1 = 2, 1 + 2 = 3, 3 * 2 = 6, 6 + 1 = 7
 *
 *
 * */