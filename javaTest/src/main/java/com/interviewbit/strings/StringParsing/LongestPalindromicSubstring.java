package com.interviewbit.strings.StringParsing;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("aaaabaaa"));
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("aaaabaa"));
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("a"));
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("ac"));
    }

    public String longestPalindrome(String A) {
        int start = 0;
        int max = 1;

        int low=0;
        int high=0;

        //get even
        for(int i=1;i<A.length();i++){
                low = i-1;
                high = i;
                while (low>=0 && high<A.length()){
                    if(A.charAt(low) == A.charAt(high)){
                        if(high-low+1 > max){
                            max = high-low+1;
                            start = low;
                        }

                        low--;
                        high++;
                    }
                    else {
                        break;
                    }
            }
        }
        //get odd
        for(int i=1;i<A.length()-1;i++){
                low = i-1;
                high = i+1;
                while (low>=0 && high<A.length()){
                    if(A.charAt(low) == A.charAt(high)){
                        if(high-low+1 > max){
                            max = high-low+1;
                            start = low;
                        }

                        low--;
                        high++;
                    }
                    else{
                        break;
                    }
            }
        }
        return A.substring(start,start+max);
    }

}

/*
Given a string S, find the longest palindromic substring in S.
Substring of string S:

S[i...j] where 0 <= i <= j < len(S)

Palindrome string:

A string which reads the same backwards. More formally, S is palindrome if reverse(S) = S.

Incase of conflict, return the substring which occurs first ( with the least starting index ).

Example :

Input : "aaaabaaa"
Output : "aaabaaa"
*/