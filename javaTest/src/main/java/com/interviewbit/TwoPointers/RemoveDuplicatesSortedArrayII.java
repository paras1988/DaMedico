package com.interviewbit.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;

public class RemoveDuplicatesSortedArrayII {

    public static void main(String[] args) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        arr1.add(1); arr1.add(1);arr1.add(1);arr1.add(2);arr1.add(2); arr1.add(2);
        arr1.add(3);
        arr1.add(3);

        System.out.println(new RemoveDuplicatesSortedArrayII().removeDuplicates(arr1));
        System.out.println(Arrays.toString(arr1.toArray()));

        ArrayList<Integer> arr2 = new ArrayList<>();
        arr2.add(5000); arr2.add(5000);arr2.add(5000);

        System.out.println(new RemoveDuplicatesSortedArrayII().removeDuplicates(arr2));
        System.out.println(Arrays.toString(arr2.toArray()));

        ArrayList<Integer> arr3 = new ArrayList<>();


        System.out.println(new RemoveDuplicatesSortedArrayII().removeDuplicates(arr3));
        System.out.println(Arrays.toString(arr3.toArray()));
    }

    public int removeDuplicates(ArrayList<Integer> a) {

        if(a.size()==0){
            return 0;
        }
        int count = 1;
        int j =0;

        for(int i=0;i<a.size()-1;i++){
            if(count<=2){
                a.set(j++,a.get(i));
                count++;
            }
            if(!a.get(i).equals(a.get(i+1)) ){
                count = 1;
            }
        }
        if(count <= 2 ) {
            a.set(j, a.get(a.size() - 1));
            j++;
        }
        return j;
    }
}
