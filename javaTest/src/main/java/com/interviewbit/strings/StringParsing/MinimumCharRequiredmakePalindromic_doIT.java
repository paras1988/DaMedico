package com.interviewbit.strings.StringParsing;

public class MinimumCharRequiredmakePalindromic_doIT {

    public static void main(String[] args) {
        System.out.println(new MinimumCharRequiredmakePalindromic_doIT().solve("aabaabaaa"));
        System.out.println(new MinimumCharRequiredmakePalindromic_doIT().solve("ABCAA"));
        System.out.println(new MinimumCharRequiredmakePalindromic_doIT().solve("ABC"));
        System.out.println(new MinimumCharRequiredmakePalindromic_doIT().solve("AACECAAAA"));
        System.out.println(new MinimumCharRequiredmakePalindromic_doIT().solve("A"));
        System.out.println(new MinimumCharRequiredmakePalindromic_doIT().solve("hqghumeaylnlfdxfi"));
    }

    public int solve(String A) {
        return 0;
    }

}
/*Given an string A. The only operation allowed is to insert characters in the beginning of the string.

Find how many minimum characters are needed to be inserted to make the string a palindrome string.



Input Format

The only argument given is string A.
Output Format

Return the minimum characters that are needed to be inserted to make the string a palindrome string.
For Example

Input 1:
    A = "ABC"
Output 1:
    2
    Explanation 1:
        Insert 'B' at beginning, string becomes: "BABC".
        Insert 'C' at beginning, string becomes: "CBABC".

Input 2:
    A = "AACECAAAA"
Output 2:
    2
    Explanation 2:
        Insert 'A' at beginning, string becomes: "AAACECAAAA".
        Insert 'A' at beginning, string becomes: "AAAACECAAAA".


        A : "hqghumeaylnlfdxfi"
Your function returned the following :
14
The expected returned value :
16


*/