package com.interviewbit.backtracking.Bruteforcebuilder;

import java.util.ArrayList;

public class PalindromePartitioning {

    private ArrayList<ArrayList<String>> res = new ArrayList<>();
    private int n;
    private static String str;

    public static void main(String[] args) {
        System.out.println(new PalindromePartitioning().partition("efe"));
    }

    public ArrayList<ArrayList<String>> partition(String a) {
        n =a.length();
        str = a;
        subset(0,new ArrayList<>());
        return res;
    }

    private void subset(int s, ArrayList<String> temp) {

        if(s >= n){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i=s;i<n;i++){
            if(ispal(s,i)){
                temp.add(str.substring(s,i+1));
                subset(i+1,temp);
                temp.remove(temp.size()-1);
            }
        }
    }

    static boolean ispal(int st,int end){

        while(st<end){
            if(str.charAt(st)!=str.charAt(end)){
                return false;
            }
            st++;
            end--;
        }
        return true;
    }
}
/*Given a string s, partition s such that every string of the partition is a palindrome.
Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

  [
    ["a","a","b"]
    ["aa","b"],
  ]
In the given example,
["a", "a", "b"] comes before ["aa", "b"] because len("a") < len("aa")

Seen this question in a real interview before
*/
