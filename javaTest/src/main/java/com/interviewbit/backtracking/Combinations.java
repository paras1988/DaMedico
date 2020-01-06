package com.interviewbit.backtracking;

import java.util.ArrayList;

public class Combinations {

    private ArrayList<ArrayList<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(new Combinations().combine(4,2));
    }

    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        if(k>n){
            return new ArrayList<>();
        }
        subset(0,n,k,new ArrayList<>());
        return res;
    }

    void subset(int j,int n,int k, ArrayList<Integer> temp){
        if(k==0){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i=j+1;i<=n;i++){
            temp.add(i);
            subset(i,n,k-1,temp);
            temp.remove(temp.size()-1);
        }
    }
}

/*
Given two integers n and k, return all possible combinations of k numbers out of 1 2 3 ... n.

Make sure the combinations are sorted.

To elaborate,

Within every entry, elements should be sorted. [1, 4] is a valid entry while [4, 1] is not.
Entries should be sorted within themselves.
Example :
If n = 4 and k = 2, a solution is:

[
  [1,2],
  [1,3],
  [1,4],
  [2,3],
  [2,4],
  [3,4],
]
 Warning : DO NOT USE LIBRARY FUNCTION FOR GENERATING COMBINATIONS.
Example : itertools.combinations in python.
If you do, we will disqualify your submission retroactively and give you penalty points.
*/