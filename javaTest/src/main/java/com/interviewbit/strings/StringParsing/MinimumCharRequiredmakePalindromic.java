package com.interviewbit.strings.StringParsing;

//in Beginning only read question carefully
public class MinimumCharRequiredmakePalindromic {

    public static void main(String[] args) {
        System.out.println(new MinimumCharRequiredmakePalindromic().solve("aabaabaaa"));
        System.out.println(new MinimumCharRequiredmakePalindromic().solve("ABCAA"));
        System.out.println(new MinimumCharRequiredmakePalindromic().solve("ABC"));
        System.out.println(new MinimumCharRequiredmakePalindromic().solve("AACECAAAA"));
        System.out.println(new MinimumCharRequiredmakePalindromic().solve("A"));
        System.out.println(new MinimumCharRequiredmakePalindromic().solve("hqghumeaylnlfdxfi"));
    }

    public int solve(String A) {
        String reverse = "";

        for (int i = A.length() - 1 ; i >= 0 ; i--)
            reverse = reverse + A.charAt(i);

        String str = A+"$"+reverse;

        int[] lps = computeLPS(str);
        return A.length() - lps[str.length()-1];
    }

    private int[] computeLPS(String str) {
        int[] res = new int[str.length()];

        int j = 0;
        res[j] = 0;
        for(int i=1; i< str.length();){
            if(str.charAt(i) == str.charAt(j)){
                j++;
                res[i] = j;
                i++;
            } else{
                if(j!=0){
                    j = res[j-1];
                }
                else{
                    res[i] = 0;
                    i++;
                }
            }
        }
        return res;
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