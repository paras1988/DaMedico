package com.interviewbit.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Subset {

    public static void main(String[] args) {
        ArrayList<Integer> a1 = new ArrayList<>();
        a1.add(1);a1.add(2);a1.add(3);
        System.out.println(new Subset().subsets(a1));
    }

    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        Collections.sort(A);

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        subsetsHelper(list, new ArrayList<>(), A, 0);

        return list;
    }

    private void subsetsHelper(ArrayList<ArrayList<Integer>> list , ArrayList<Integer> resultList, ArrayList<Integer> nums, int start) {
        list.add(new ArrayList<>(resultList));
      //  System.out.println("I value "+start);
      //  System.out.println("Result " +resultList);
        for(int i = start; i < nums.size(); i++){

            // add element
            resultList.add(nums.get(i));
            // Explore
            subsetsHelper(list, resultList, nums, i + 1);
            // remove
         //   System.out.println("BBefore "+resultList);
            resultList.remove(resultList.size() - 1);
         //   System.out.println("Affter "+resultList);
        }
    }
}
