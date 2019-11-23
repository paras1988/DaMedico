package com.interviewbit.binarySearch.SimpleBinarySearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SearchforRange {

    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        a.add(5);a.add(7);a.add(7);a.add(8);a.add(8);a.add(10);

        System.out.println(new SearchforRange().searchRange(a,8));
        System.out.println(new SearchforRange().searchRange(a,10));
        System.out.println(new SearchforRange().searchRange(a,5));
        System.out.println(new SearchforRange().searchRange(a,11));
        System.out.println(new SearchforRange().searchRange(a,2));

///////////
        List<Integer> a2 = new ArrayList<>();
        a2.add(5);a2.add(5);a2.add(5);

        System.out.println(new SearchforRange().searchRange(a2,5));
        System.out.println(new SearchforRange().searchRange(a2,10));

    }

    public ArrayList<Integer> searchRange(final List<Integer> a, int b) {
        ArrayList<Integer> res = new ArrayList<>();

        if(Collections.binarySearch(a,b) < 0){
            res.add(-1);res.add(-1);
            return res;
        }

        int min = 0;
        int max = a.size();

        int mid = 0;
        while (min < max){
            mid = min + (max - min)/2 ;

            if((mid == 0 && a.get(mid) ==  b) ||
                    (mid-1>=0 && a.get(mid) ==  b && a.get(mid-1) < b)){
                res.add(mid);
                break;
            }
            if(a.get(mid)< b){
                min = mid + 1;
            }
            else {
                max = mid;
            }
        }
        min = 0;
        max = a.size();

        while (min < max){
            mid = min + (max - min)/2 ;

            if((mid == a.size()-1 && a.get(mid) ==  b) ||
                    (mid+1< a.size() && a.get(mid) ==  b && a.get(mid+1) > b)){
                res.add(mid);
                break;
            }
            else if(a.get(mid)> b){
                max = mid;
            }
            else {
                min = mid + 1;

            }
        }
        return res;
    }
}


/*Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm’s runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example:

Given [5, 7, 7, 8, 8, 10]

and target value 8,

return [3, 4].

*/