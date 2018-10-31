package com.WindowSlidingProblems;

/**
 * Get the minimum window which have all the specified characters.
 */
public class MinimumWindowSubstring {

  static int len = Integer.MAX_VALUE;
  static String ans = "";

  public static void main(String[] args) {
    String str = "DDAABBBCDABC";
    String pattern = "ABC";

    int[] hash_pat = new int[256];
    int[] hash_str = new int[256];

    for(int i=0;i<pattern.length();i++){
      hash_pat[pattern.charAt(i)]++;
    }

    int count = 0;
    int start = 0;

    for(int end=0;end<str.length();end++){
      char ch = str.charAt(end);
      hash_str[ch]++;

      //matching with pattern
      if(hash_str[ch]!=0 && hash_pat[ch] >= hash_str[ch]){
        count++;
      }

      //its one of the result store it
      if(count == pattern.length()){

        if(end - start +1 <len){
          ans = str.substring(start,end+1);
        }

        //now trim the window from start
        //if useless charater then discard it else check the table until if str[ch] > pat[ch] then do --
        char chs = str.charAt(start);
        while (hash_pat[ch]==0 || hash_str[chs]>hash_pat[chs]){
          start++;
          hash_str[chs]--;
          chs = str.charAt(start);
        }

        hash_str[chs]--;
        start++;
        count--;
      }
    }
    System.out.println(ans);
  }
}
