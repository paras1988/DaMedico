package com.interviewbit.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;

public class RemoveElementfromArray {

    public static void main(String[] args) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        arr1.add(4);
        arr1.add(1);
        arr1.add(1);
        arr1.add(2);
        arr1.add(1);
        arr1.add(3);

        System.out.println(new RemoveElementfromArray().removeElement(arr1,1));
        System.out.println(Arrays.toString(arr1.toArray()));

        ArrayList<Integer> arr2 = new ArrayList<>();
        arr2.add(4);

        System.out.println(new RemoveElementfromArray().removeElement(arr2,1));
        System.out.println(Arrays.toString(arr2.toArray()));
    }

    public int removeElement(ArrayList<Integer> a, int b) {

        int j=0;
        for(int i=0;i<a.size();i++){
            if(a.get(i) != b){
                a.set(j++,a.get(i));
            }
        }
        return j;
    }
}
/*Remove Element

Given an array and a value, remove all the instances of that value in the array.
Also return the number of elements left in the array after the operation.
It does not matter what is left beyond the expected length.

 Example:
If array A is [4, 1, 1, 2, 1, 3]
and value elem is 1,
then new length is 3, and A is now [4, 2, 3]
Try to do it in less than linear additional space complexity.
*/