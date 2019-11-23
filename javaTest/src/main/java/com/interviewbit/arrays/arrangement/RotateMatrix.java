package com.interviewbit.arrays.arrangement;


import java.util.ArrayList;

/*
You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

You need to do this in place.

Note that if you end up using an additional array, you will only receive partial score.

Example:

If the array is

[
    [1, 2, 3],
    [4, 5, 6],
    [7, 8, 9]
]
Then the rotated array becomes:

[
    [7, 4, 1],
    [8, 5, 2],
    [9, 6, 3],
]
 */
public class RotateMatrix {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        ArrayList<Integer> i1 = getIntegers(1,2,3,4);
        ArrayList<Integer> i2 = getIntegers(5,6,7,8);
        ArrayList<Integer> i3 = getIntegers(9,10,11,12);
        ArrayList<Integer> i4 = getIntegers(13,14,15,16);

        a.add(i1);
        a.add(i2);
        a.add(i3);
        a.add(i4);

        new RotateMatrix().rotate(a);
        System.out.println(a);

    }



/*
    public void rotate(ArrayList<ArrayList<Integer>> a) {

        int s = 0;
        int l = a.size()-1;
        while (s<=l){
            for(int i=s;i<l;i++){
                int temp = a.get(s).get(l-i);
                a.get(s).set(l-i,a.get(s+i).get(s));
                a.get(s+i).set(s,a.get(l).get(s+i));
                a.get(l).set(s+i,a.get(l-i).get(l));
                a.get(l-i).set(l,temp);
            }
            s++;
            l--;
        }
    }*/

    public void rotate(ArrayList<ArrayList<Integer>> a) {

        int s = 0;
        int l = a.size()-1;
        for(int i=0;i<l/2;i++){
            for(int j=i;j<l-i;j++){
                int temp = a.get(i).get(j);
                a.get(i).set(j,a.get(l-j).get(i));
                a.get(l-j).set(i,a.get(l-i).get(l-j));
                a.get(l-i).set(l-j,a.get(j).get(l-i));
                a.get(j).set(l-i,temp);
                System.out.println(a);
            }
        }
    }

    private static ArrayList<Integer> getIntegers(int... is) {
        ArrayList<Integer> integers = new ArrayList<>();

        for(int i=0;i<is.length;i++){
            integers.add(is[i]);
        }
        return integers;
    }
}

