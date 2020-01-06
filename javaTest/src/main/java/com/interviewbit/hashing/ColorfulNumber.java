package com.interviewbit.hashing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ColorfulNumber {

    public static void main(String[] args) {
        System.out.println(new ColorfulNumber().colorful(23));
    }

    public int colorful(int A) {
        ArrayList<Integer> list= new ArrayList();

        while (A!=0){
            list.add(A%10);
            A = A/10;
        }
        Set<Integer> set = new HashSet<>();

        for(int  i=0; i< list.size(); i++){
            Integer prod = 1;
            for(int  j=i; j< list.size(); j++){
                 prod = prod * list.get(j);
                 if(set.contains(prod)){
                     return 0;
                 }
                 set.add(prod);
            }
        }
        return 1;
    }
}
