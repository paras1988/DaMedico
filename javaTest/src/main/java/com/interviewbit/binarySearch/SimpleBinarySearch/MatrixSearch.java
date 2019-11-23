package com.interviewbit.binarySearch.SimpleBinarySearch;

import java.util.ArrayList;
import java.util.Collections;

public class MatrixSearch {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> input = new ArrayList<>();

        ArrayList<Integer> a1 = new ArrayList<>();
        a1.add(1);a1.add(3);a1.add(7);a1.add(10);

        ArrayList<Integer> a2 = new ArrayList<>();
        a2.add(10);a2.add(11);a2.add(17);a2.add(19);

        ArrayList<Integer> a3 = new ArrayList<>();
        a3.add(20);a3.add(30);a3.add(54);a3.add(79);

        input.add(a1);input.add(a2);input.add(a3);

        System.out.println(new MatrixSearch().searchMatrix(input,3));
        System.out.println(new MatrixSearch().searchMatrix(input,10));
        System.out.println(new MatrixSearch().searchMatrix(input,20));
        System.out.println(new MatrixSearch().searchMatrix(input,100));
        System.out.println(new MatrixSearch().searchMatrix(input,21));
        System.out.println(new MatrixSearch().searchMatrix(input,0));
    }

    public int searchMatrix(ArrayList<ArrayList<Integer>> a, int b) {

        int rowSize = a.get(0).size();
        int min = 0;
        int max = a.size();

        int mid = 0;
        while (min < max){
            mid = min + (max-min)/2;

            if(Collections.binarySearch(a.get(mid),b) < 0){
                if(a.get(mid).get(rowSize-1)< b){
                    min = mid+1;
                }
                else if(a.get(mid).get(0)> b){
                    max = mid;
                }
                else {
                    return 0;
                }
            }
            else{
                return 1;
            }
        }
        return 0;
    }
}

/*Write an efficient algorithm that searches for a value in an m x n matrix.

This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than or equal to the last integer of the previous row.
Example:

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return 1 ( 1 corresponds to true )

Return 0 / 1 ( 0 if the element is not present, 1 if the element is present ) for this problem*/
