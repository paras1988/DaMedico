package com.interviewbit.TwoPointers;

import java.util.ArrayList;

public class MergeTwoSortedListsII {

    public static void main(String[] args) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        arr1.add(1);
        arr1.add(3);


        ArrayList<Integer> arr2 = new ArrayList<>();
        arr2.add(2);
        arr2.add(2);


        new MergeTwoSortedListsII().merge(arr1,arr2);
    }

    public void merge(ArrayList<Integer> a, ArrayList<Integer> b) {
        int i=0;

        while (i<a.size()){
            if(a.get(i) <= b.get(0)){
                i++;
            }
            else {
                int temp = a.get(i);
                int temp2 = b.get(0);
                b.set(0,temp);
                placeTempInProperPlace(temp, b);
                a.set(i,temp2);
            }
        }
        i=0;
        while (i<b.size()){
            a.add(b.get(i));
            i++;
        }
    }

    private void placeTempInProperPlace(int temp, ArrayList<Integer> b) {
        int i=1;
        while (i<b.size() && temp > b.get(i)){
            b.set(i-1,b.get(i));
            i++;
        }
        b.set(i-1,temp);
    }

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