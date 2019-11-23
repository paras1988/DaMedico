package com.interviewbit.arrays.spaceRecycle;

import java.util.ArrayList;

public class SetMatrixZeros_3_doIt {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        ArrayList<Integer> i1 = getIntegers(1,1,1);
        ArrayList<Integer> i2 = getIntegers(1,0,1);
        ArrayList<Integer> i3 = getIntegers(1,0,0);



        a.add(i1);
        a.add(i2);
        a.add(i3);

        System.out.println(a);
        new SetMatrixZeros_3_doIt().setZeroes(a);
        System.out.println(a);
    }


    public void setZeroes(ArrayList<ArrayList<Integer>> a) {}

    private static ArrayList<Integer> getIntegers(int... is) {
        ArrayList<Integer> integers = new ArrayList<>();

        for(int i=0;i<is.length;i++){
            integers.add(is[i]);
        }
        return integers;
    }
}
