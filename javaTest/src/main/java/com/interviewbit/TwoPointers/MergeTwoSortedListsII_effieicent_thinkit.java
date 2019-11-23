package com.interviewbit.TwoPointers;

import java.util.ArrayList;
import java.util.Collections;

public class MergeTwoSortedListsII_effieicent_thinkit {

    public static void main(String[] args) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        arr1.add(1);
        arr1.add(3);
        arr1.add(11);
        arr1.add(31);

        ArrayList<Integer> arr2 = new ArrayList<>();
        arr2.add(2);
        arr2.add(2);
        arr2.add(21);
        arr2.add(24);

        new MergeTwoSortedListsII_effieicent_thinkit().merge(arr1,arr2);
    }

    public void merge(ArrayList<Integer> a, ArrayList<Integer> b){}

}

/*Given two sorted integer arrays A and B, merge B into A as one sorted array.

 Note: You have to modify the array A to contain the merge of A and B. Do not output anything in your code.
TIP: C users, please malloc the result into a new array and return the result.
If the number of elements initialized in A and B are m and n respectively, the resulting size of array A after your code is executed should be m + n

Example :

Input :
         A : [1 5 8]
         B : [6 9]

Modified A : [1 5 6 8 9]

*/