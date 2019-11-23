package com.interviewbit.strings.String_simulation;


public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs1 = {"abcdefgh", "aefghijk", "abcefgh"};
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(strs1));

        String[] strs2 = {"abab", "ab", "abcd"};
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(strs2));

        String[] strs3 = {"abcdefgh" , "abcefgh"};
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(strs3));


    }

    public String longestCommonPrefix(String[] A) {
        String str = A[0];
        for(int i = 1 ;i < A.length; i++){
            str = commonInTwo(str, A[i]);
        }
        return str;
    }

    private String commonInTwo(String s1, String s2) {
        String res ="";
        for(int i=0;i<s1.length() && i<s2.length();i++){
            if(s1.charAt(i) == s2.charAt(i)){
                res = res.concat(Character.toString(s1.charAt(i)));
            }
            else{
                break;
            }
        }
        return res;
    }
}
/*Given the array of strings A,
you need to find the longest string S which is the prefix of ALL the strings in the array.

Longest common prefix for a pair of strings S1 and S2 is the longest string S which is the prefix of both S1
and S2.

For Example, longest common prefix of "abcdefgh" and "abcefgh" is "abc".



Input Format

The only argument given is an array of strings A.
Output Format

Return longest common prefix of all strings in A.
For Example

Input 1:
    A = ["abcdefgh", "aefghijk", "abcefgh"]
Output 1:
    "a"
    Explanation 1:
        Longest common prefix of all the strings is "a".

Input 2:
    A = ["abab", "ab", "abcd"];
Output 2:
    "ab"
    Explanation 2:
        Longest common prefix of all the strings is "ab".*/