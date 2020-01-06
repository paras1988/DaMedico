package com.interviewbit.hashing;

import java.util.*;

public class Anagrams {

    public static void main(String[] args) {
        ArrayList<String> list= new ArrayList<>();
        list.add("cat");
        list.add("dog");
        list.add("god");
        list.add("tca");
        System.out.println(new Anagrams().anagrams(list));
    }

    public ArrayList<ArrayList<Integer>> anagrams(final List<String> A) {
        Map<String,ArrayList<Integer>>  map = new HashMap<>();

        for(int i=0;i<A.size();i++){
            String str = sortStr(A.get(i));
            if(map.containsKey(str)){
                ArrayList<Integer> ll = map.get(str);
                ll.add(i+1);
            }
            else{
                ArrayList<Integer> l = new ArrayList<>();
                l.add(i+1);
                map.put(str,l);
            }
        }
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        for(Map.Entry<String,ArrayList<Integer>> e: map.entrySet()){
            res.add(e.getValue());
        }
        return res;
    }

    private String sortStr(String s) {
        char[] cc = s.toCharArray();
        Arrays.sort(cc);
        return String.valueOf(cc);
    }

}
/*
* Given an array of strings, return all groups of strings that are anagrams.
* Represent a group by a list of integers representing the index in the original list.
* Look at the sample case for clarification.

 Anagram : a word, phrase, or name formed by rearranging the letters of another,
 such as 'spar', formed from 'rasp'
 Note: All inputs will be in lower-case.
Example :

Input : cat dog god tca
Output : [[1, 4], [2, 3]]
cat and tca are anagrams which correspond to index 1 and 4.
dog and god are another set of anagrams which correspond to index 2 and 3.
The indices are 1 based ( the first element has index 1 instead of index 0).

 Ordering of the result : You should not change the relative ordering of the words /
 phrases within the group. Within a group
 containing A[i] and A[j], A[i] comes before A[j] if i < j.
*
* */