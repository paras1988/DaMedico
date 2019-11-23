package com.interviewbit.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;

public class SortByColor {

    public static void main(String[] args) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        arr1.add(0);
        arr1.add(1);
        arr1.add(1);
        arr1.add(2);
        arr1.add(1);
        arr1.add(0);
        arr1.add(1);
        arr1.add(1);
        arr1.add(2);
        arr1.add(1);

        new SortByColor().sortColors(arr1);
        System.out.println(Arrays.toString(arr1.toArray()));

        ArrayList<Integer> arr2 = new ArrayList<>();
        arr2.add(0);

        new SortByColor().sortColors(arr2);
        System.out.println(Arrays.toString(arr2.toArray()));
    }

    public void sortColors(ArrayList<Integer> a) {
        int r=0;
        int w=0;
        int b=0;

        for(int i=0;i<a.size();i++){
            if(a.get(i) == 0){
                r++;
            }
            else if(a.get(i) == 1){
                w++;
            }
            else {
                b++;
            }
        }
        int j=0;
        for(int i=0;i<r;i++){ a.set(j++,0);}
        for(int i=0;i<w;i++){ a.set(j++,1);}
        for(int i=0;i<b;i++){ a.set(j++,2);}
    }
}
/*Given an array with n objects colored red, white or blue,
sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note: Using library sort function is not allowed.

Example :

Input : [0 1 2 0 1 2]
Modify array so that it becomes : [0 0 1 1 2 2]
*/