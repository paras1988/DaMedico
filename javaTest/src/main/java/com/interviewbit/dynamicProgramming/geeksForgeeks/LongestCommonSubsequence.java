package com.interviewbit.dynamicProgramming.geeksForgeeks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongestCommonSubsequence {


    public static void main(String[] args) throws IOException {
        BufferedReader S=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(S.readLine());

        while(n>0){
            String str = S.readLine();

            int x = Integer.parseInt(str.split(" ")[0]);
            int y = Integer.parseInt(str.split(" ")[1]);

            String a = S.readLine();
            String b = S.readLine();

            System.out.println(new LongestCommonSubsequence().recursive(a,b,x-1,y-1));
            System.out.println(new LongestCommonSubsequence().memoizedBottomUp(a,b,x,y));

        }
    }

    private int memoizedBottomUp(String a, String b, int i, int j) {
        int[][] res = new int[i+1][j+1];

        for(int x=0;x<i+1;x++){
            res[x][0] = 0;
            res[0][x] = 0;
        }

        for(int x=1;x<i+1;x++){
            for (int y=1;y<j+1;y++){
                if(a.charAt(x-1) == b.charAt(y-1)){
                    res[x][y] = res[x-1][y-1]+1;
                }
                else{
                    res[x][y] = Math.max(res[x-1][y],res[x][y-1]);
                }
            }
        }

        return res[i][j];
    }

    private int recursive(String a, String b, int x, int y) {


        if(x == -1 || y == -1){
            return 0;
        }

        if(a.charAt(x) == b.charAt(y)){
            return  1+ recursive(a,b,x-1,y-1);
        }
        else{
            return Math.max(recursive(a,b,x,y-1),
                    recursive(a,b,x-1,y));
        }
    }


}
/**
 *
 * Given two strings X and Y. The task is to find the length of the longest common substring.
 *
 * Input:
 * First line of the input contains number of test cases T. Each test case consist of three lines, first of which contains 2 space separated integers N and M denoting the size of string X and Y strings respectively. The next two lines contains the string X and Y.
 *
 * Output:
 * For each test case print the length of longest  common substring of the two strings .
 *
 * Constraints:
 * 1 <= T <= 200
 * 1 <= N, M <= 100
 *
 * Example:
 * Input:
 * 2
 * 6 6
 * ABCDGH
 * ACDGHR
 * 3 2
 * ABC
 * AC
 *
 * Output:
 * 4
 * 1
 *
 * Example:
 * Testcase 1: CDGH is the longest substring present in both of the strings.
 *
 *
 * */