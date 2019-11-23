package com.interviewbit.arrays.Arraymath;

import java.util.ArrayList;

/*
*Given a positive integer n and a string s consisting only of letters D or I,
* you have to find any permutation of first n positive integer that satisfy the given input string.

D means the next number is smaller, while I means the next number is greater.

Notes

Length of given string s will always equal to n - 1
Your solution should run in linear time and space.
* */
public class findPermuation {

    public static void main(String[] args) {
        String str = "IIIDDDDDDDIIIIIDDDIIIDDDDDIDDDDDDDDD";
        int v = 37;

        ArrayList<Integer> res = new findPermuation().findPerm(str,v);
        System.out.println(res);
    }

    public ArrayList<Integer> findPerm(final String A, int B) {

        ArrayList<Integer> res = new ArrayList<>();

        int count = 1;
        for(int i=0;i<A.length();i++){

            if(A.charAt(i)=='I'){
                count++;
            }
            else{
                count--;
            }
        }
        if(count>0){
            for(int i=0;i<A.length();i++) {
                res.add(i+1);
            }
            return res;
        }
        count = Math.abs(count)+2;

        res.add(count);
        for(int i=0;i<A.length();i++){
            if(A.charAt(i)=='I'){
                res.add(++count);
            }
            else{
                res.add(--count);
            }
        }
        return res;

    }

}
