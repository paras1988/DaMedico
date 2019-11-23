package com.interviewbit.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class RemoveDuplicates {

    public static void main(String[] args) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        arr1.add(1); arr1.add(1);arr1.add(1);arr1.add(2);arr1.add(2); arr1.add(2);
        arr1.add(3);
        arr1.add(3);

        System.out.println(new RemoveDuplicates().removeDuplicates(arr1));

        ArrayList<Integer> arr2 = new ArrayList<>();
        arr2.add(5000); arr2.add(5000);arr2.add(5000);

        System.out.println(new RemoveDuplicates().removeDuplicates(arr2));
        System.out.println(Arrays.toString(arr2.toArray()));
    }

    public int removeDuplicates(ArrayList<Integer> a) {

        int j=0;
        for(int i=0;i<a.size()-1 && j<a.size();i++){
            if(!a.get(i+1).equals(a.get(i))){
                a.set(j,a.get(i));
                j++;
            }
        }
        a.set(j,a.get(a.size()-1));
        j++;
        return j;
    }
}
