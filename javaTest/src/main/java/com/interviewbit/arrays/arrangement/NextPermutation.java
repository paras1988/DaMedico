package com.interviewbit.arrays.arrangement;

import java.util.ArrayList;
import java.util.Collections;

/*
* Implement the next permutation, which rearranges numbers into the numerically next greater
* permutation of numbers for a given array A of size N.

If such arrangement is not possible, it must be rearranged as the lowest possible order
i.e., sorted in an ascending order.
*/

public class NextPermutation {

    public static void main(String[] args) {
        ArrayList<Integer> integers = getIntegers(4,5,8,6,3,2,1);
        new NextPermutation().nextPermutation(integers);

        integers = getIntegers(1,2,3);
        new NextPermutation().nextPermutation(integers);

        integers = getIntegers(3,2,1);
        new NextPermutation().nextPermutation(integers);

        integers = getIntegers(1,1,5);
        new NextPermutation().nextPermutation(integers);

        integers = getIntegers(251, 844, 767, 778, 658, 337, 10, 252, 632, 262, 707, 506, 701, 475, 410, 696, 631, 903, 516, 149, 344, 101, 42, 891, 991);
        new NextPermutation().nextPermutation(integers);


        integers = getIntegers(1,2);
        new NextPermutation().nextPermutation(integers);

    }

    private static ArrayList<Integer> getIntegers(int... is) {
        ArrayList<Integer> integers = new ArrayList<>();

        for(int i=0;i<is.length;i++){
            integers.add(is[i]);
        }
        return integers;
    }


    public void nextPermutation(ArrayList<Integer> a) {

        int s = -1;
        int e = 0;
        for(int i=a.size()-1;i>0;i--){
            if(a.get(i)>a.get(i-1)){
                s = i-1;
                break;
            }
        }
        if(s == -1){
            Collections.sort(a);
            printArr(a);
            return;
        }
        for(int i=a.size()-1;i>s;i--){
            if(a.get(i)>a.get(s)){
                e = i;
                break;
            }
        }
        swap(a, s, e);
        int j=1;
        //reverse rest.
        for(int i=s+1;i<s+1+((a.size()-s-1)/2);i++){
            if(j==i){
                break;
            }
            swap(a,i,a.size()-j);
            j++;
        }
        printArr(a);
    }

    private void printArr(ArrayList<Integer> a) {
        for(int i=0;i<a.size();i++){
            System.out.print(a.get(i)+" ");
        }
        System.out.println();
    }

    private void swap(ArrayList<Integer> a, int s, int e) {
        int temp = a.get(s);
        a.set(s,a.get(e));
        a.set(e,temp);
    }
}
