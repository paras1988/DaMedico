package com.interviewbit.hashing;

public class WindowString {

    public static void main(String[] args) {
        System.out.println(new WindowString().minWindow("ADOBECODEBANC","ABC"));
    }

    public String minWindow(String A, String B) {

        int[] pattern = new int[256];
        int[] str = new int[256];

        int min = Integer.MAX_VALUE;
        int rstart = 0;
        int rend = 0;

        for(int i=0;i<B.length();i++){
            pattern[B.charAt(i)]++;
        }

        int count = 0;
        int start = 0;

        for(int i=0;i<A.length();i++){
            str[A.charAt(i)]++;

            if(str[A.charAt(i)] <= pattern[A.charAt(i)]){
                count++;
            }

            if(count == B.length()){

                while (str[A.charAt(start)]>pattern[A.charAt(start)] || pattern[A.charAt(start)]==0){

                    if(str[A.charAt(start)]>pattern[A.charAt(start)]){
                        str[A.charAt(start)]--;
                    }

                    start++;
                }

                if(i-start+1<min){
                    rstart = start;
                    rend = i+1;
                    min = i-start+1;
                }
            }


        }
        return A.substring(rstart,rend);
    }
}

/*
*
* Given a string S and a string T, find the minimum window in S which will contain all the characters in
* T in linear time complexity.
Note that when the count of a character C in T is N, then the count of C in minimum window in S should be at least N.

Example :

S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC"

 Note:
If there is no such window in S that covers all characters in T, return the empty string ''.
If there are multiple such windows, return the first occurring minimum window ( with minimum start index ).
*
* */