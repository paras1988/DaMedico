package com.interviewbit.arrays.spaceRecycle;

import java.util.ArrayList;

public class SetMatrixZeros2 {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        ArrayList<Integer> i1 = getIntegers(1,1,1);
        ArrayList<Integer> i2 = getIntegers(1,0,1);
        ArrayList<Integer> i3 = getIntegers(1,0,0);



        a.add(i1);
        a.add(i2);
        a.add(i3);

        System.out.println(a);
        new SetMatrixZeros2().setZeroes(a);
        System.out.println(a);
    }


    public void setZeroes(ArrayList<ArrayList<Integer>> a) {

        int r = 1;
        int c = 1;

        int m = a.size()-1;
        int n = a.get(0).size()-1;
        for(int i=0;i<=n;i++){
            if(a.get(0).get(i)==0){
              r = 0;
              break;
            }
        }
        for(int i=0;i<=m;i++){
            if(a.get(i).get(0)==0){
                c = 0;
                break;
            }
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(a.get(i).get(j)==0){
                    a.get(i).set(0,0);
                    a.get(0).set(j,0);
                }
            }
        }
        System.out.println(a);

        for(int i=1;i<=n;i++){
            if(a.get(0).get(i)==0){
                for(int j=0;j<=m;j++){
                    a.get(j).set(i,0);
                }
            }
        }
        for(int i=1;i<=m;i++){
            if(a.get(i).get(0)==0){
                for(int j=0;j<=n;j++){
                    a.get(i).set(j,0);
                }
            }
        }
        if(r==0){
            for(int i=0;i<=n;i++){
                a.get(0).set(i,0);
            }
        }
        if(c==0){
            for(int i=0;i<=m;i++){
                a.get(i).set(0,0);
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
