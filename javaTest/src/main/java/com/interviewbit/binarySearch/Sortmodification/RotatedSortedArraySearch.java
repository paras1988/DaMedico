package com.interviewbit.binarySearch.Sortmodification;

import java.util.ArrayList;
import java.util.List;


/*Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7  might become 4 5 6 7 0 1 2 ).

You are given a target value to search. If found in the array, return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Input : [4 5 6 7 0 1 2] and target = 4
Output : 0

NOTE : Think about the case when there are duplicates. Does your current solution work? How does the time complexity change?*

*/
public class RotatedSortedArraySearch {

    public static void main(String[] args) {
        ArrayList<Integer> a1 = new ArrayList<>();
        a1.add(4);
        a1.add(5);
        a1.add(6);
        a1.add(7);
        a1.add(0);
        a1.add(1);
        a1.add(2);

        System.out.println(new RotatedSortedArraySearch().search(a1,4));
        System.out.println(new RotatedSortedArraySearch().search(a1,0));
        System.out.println(new RotatedSortedArraySearch().search(a1,3));
        System.out.println(new RotatedSortedArraySearch().search(a1,7));
        System.out.println(new RotatedSortedArraySearch().search(a1,5));
        System.out.println(new RotatedSortedArraySearch().search(a1,-5));

        System.out.println("//////////");
        a1 = new ArrayList<>();
        a1.add(4);
        a1.add(5);
        a1.add(6);
        a1.add(7);
        a1.add(8);

        System.out.println(new RotatedSortedArraySearch().search(a1,4));
        System.out.println(new RotatedSortedArraySearch().search(a1,0));
        System.out.println(new RotatedSortedArraySearch().search(a1,3));
        System.out.println(new RotatedSortedArraySearch().search(a1,7));
        System.out.println(new RotatedSortedArraySearch().search(a1,5));
        System.out.println(new RotatedSortedArraySearch().search(a1,-5));
    }

    public int search(final List<Integer> a, int b) {
        int min = 0;
        int max = a.size()-1;

        int mid = 0;
        while (min < max){
            mid = min + (max - min)/2;
            if(mid == 0 || a.get(mid) < a.get(mid-1)){
                break;
            }
            else if(a.get(mid) > a.get(max)){
                min = mid + 1;
            }
            else{
                max = mid;
            }
        }

        if(b > a.get(mid) && b>a.get(a.size()-1)){
            min = 0;
            max = mid;
        }
        else{
            min = mid;
            max = a.size()-1;
        }

        while(min < max){
            mid = min + (max - min)/2;
            if(a.get(mid) == b){
                return mid;
            }
            if(a.get(mid) > b){
                max = mid;
            }
            else{
                min = mid +1;
            }
        }
        return -1;
    }
}
