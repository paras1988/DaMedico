package com.interviewbit.arrays.spaceRecycle;

import com.interviewbit.arrays.arrangement.RotateMatrix;

import java.util.ArrayList;


/*
* Given a boolean matrix mat[M][N] of size M X N, modify it such that if a matrix cell mat[i][j] is 0 (or true) then make all the cells of ith row and jth column as 0.
Example 1
1,0,1,1
1,1,1,1
1,1,0,1
1,1,1,1
1,1,1,1

[
[0, 0, 0, 0],
[1, 0, 0, 1],
[0, 0, 0, 0],
[1, 0, 0, 1],
[1, 0, 0, 1]]
* */
public class SetMatrixZeros {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        ArrayList<Integer> i1 = getIntegers(1,0,1,1);
        ArrayList<Integer> i2 = getIntegers(1,1,1,1);
        ArrayList<Integer> i3 = getIntegers(1,1,0,1);
        ArrayList<Integer> i4 = getIntegers(1,1,1,1);
        ArrayList<Integer> i5 = getIntegers(1,1,1,1);

        a.add(i1);
        a.add(i2);
        a.add(i3);
        a.add(i4);
        a.add(i5);

        new SetMatrixZeros().setZeroes(a);
        System.out.println(a);
    }


    public void setZeroes(ArrayList<ArrayList<Integer>> a) {
        int m = a.size()-1;
        int n = a.get(0).size()-1;
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(a.get(i).get(j)==0){
                    processRow(a,i);
                    processCol(a,j);
                }
            }
        }
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(a.get(i).get(j)==-1){
                    a.get(i).set(j,0);
                }
            }
        }

    }

    private void processCol(ArrayList<ArrayList<Integer>> a, int j) {
        int m = a.size()-1;

        for(int i=0;i<=m;i++){
            if(a.get(i).get(j)==1){
                a.get(i).set(j,-1);
            }
        }
    }

    private void processRow(ArrayList<ArrayList<Integer>> a, int j) {
        int n = a.get(0).size()-1;

        for(int i=0;i<=n;i++){
            if(a.get(j).get(i)==1){
                a.get(j).set(i,-1);
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
