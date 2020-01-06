package com.interviewbit.backtracking;

import java.util.ArrayList;

public class Permutations {

    ArrayList<ArrayList<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
        ArrayList in = new ArrayList();
        in.add(1);
        in.add(2);
        in.add(3);
        ArrayList<ArrayList<Integer>>  ress = new Permutations().permute(in);
        System.out.println(ress);
    }

    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {

        permuteUtil(A,0);
        return res;
    }

    private void permuteUtil(ArrayList<Integer> a, int index) {

        if(index == a.size()){
            res.add(new ArrayList<>(a));
        }

        for(int i=index ; i<a.size(); i++){
            swap2(a,i,index);
            permuteUtil(a,index+1);
            swap2(a,index,i);
        }
    }

    private void swap2(ArrayList<Integer> a, int i, int index) {
        int temp = a.get(i);
        a.set(i,a.get(index));
        a.set(index,temp);
    }


}

/*
* Given a collection of numbers, return all possible permutations.

Example:

[1,2,3] will have the following permutations:

[1,2,3]
[1,3,2]
[2,1,3]
[2,3,1]
[3,1,2]
[3,2,1]
 NOTE
No two entries in the permutation sequence should be the same.
For the purpose of this problem, assume that all the numbers in the collection are unique.


* */
