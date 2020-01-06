package com.interviewbit.hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeat {

    public static void main(String[] args) {
        System.out.println(new LongestSubstringWithoutRepeat().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new LongestSubstringWithoutRepeat().lengthOfLongestSubstring("bbbb"));
        System.out.println(new LongestSubstringWithoutRepeat().lengthOfLongestSubstring("abcaabbcdeabb"));
        System.out.println(new LongestSubstringWithoutRepeat().lengthOfLongestSubstring("dadbc"));
    }

    public int lengthOfLongestSubstring(String A) {
        Map<Character,Integer> map = new HashMap<>();

        int max = 0;
        int index = -1;
        int temp = 0;

        for(int i=0;i<A.length();i++){
            char ch = A.charAt(i);
            if(map.containsKey(ch) && map.get(ch)> index){
                temp = i- map.get(ch);
                index = map.get(ch);
            }
            else{
                temp++;
            }
            map.put(ch,i);
            if(temp>max){
                max = temp;
            }
        }

        return max;
    }
}
/*
*
* Given a string,
find the length of the longest substring without repeating characters.

Example:

The longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3.

For "bbbbb" the longest substring is "b", with the length of 1.


* */