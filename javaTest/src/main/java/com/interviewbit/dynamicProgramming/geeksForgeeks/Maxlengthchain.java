package com.interviewbit.dynamicProgramming.geeksForgeeks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Maxlengthchain {


    public static void main(String[] args) throws IOException {
        BufferedReader S=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(S.readLine());

        while(n>0){
            n--;
            int count = Integer.parseInt(S.readLine());
            String vals[] = S.readLine().split(" ");

            Pair[] pairs = new Pair[count];
            for(int i=0;i<count;i++){
                pairs[i] = new Pair(Integer.parseInt(vals[2*i]),Integer.parseInt(vals[2*i+1]));
            }

            System.out.println(new Maxlengthchain().iterativeCallMemoized_bottomUp(pairs,count));
        }
    }

    private int iterativeCallMemoized_bottomUp(Pair[] pairs, int count) {

        Arrays.sort(pairs);
        int[] res = new int[count];

        for(int i=0;i<count;i++){
            res[i] = 1;
            for(int j=0;j<i;j++){
                if(pairs[i].a > pairs[j].b && res[i]<res[j]+1) {
                    res[i] = res[j] + 1;
                }
            }
        }
        int max = 0;
        for(int i=0;i<count;i++){
            if(res[i]> max){
                max =res[i];
            }
        }

        return max;
    }


    static class Pair implements Comparable{
        int a;
        int b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Object o) {
            Pair p =(Pair)o;
            return this.a - p.a;
        }
    }

}
/*
* You are given N pairs of numbers. In every pair, the first number is always smaller than the second number. A pair (c, d) can follow
* another pair (a, b) if b < c. Chain of pairs can be formed in this fashion. Your task is to complete the function maxChainLen which returns
* an integer denoting the longest chain which can be formed from a given set of pairs.

Input:
The first line of input contains an integer T denoting the no of test cases then T test cases follow .Then T test cases follow . The first
line of input contains an integer N denoting the no of pairs . In the next line are 2*N space separated values denoting N pairs.

Output:
For each test case output will be the length of the longest chain formed.

Constraints:
1<=T<=100
1<=N<=100

Example(To be used only for expected output):
Input
2
5
5  24 39 60 15 28 27 40 50 90
2
5 10 1 11

Output
3
1
​
Explanation
(i) the given pairs are {{5, 24}, {39, 60}, {15, 28}, {27, 40}, {50, 90} },the longest chain that can be formed is of length 3, and the chain
is {{5, 24}, {27, 40}, {50, 90}}
(ii) The max length chain possible is only of length one.
* */