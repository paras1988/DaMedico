package com.interviewbit.arrays.Arraymath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//find a subarray with maximum sum
public class Flip1s_0s {

    public static void main(String[] args) {
        System.out.println(flip("01010100010101"));
        System.out.println(flip("111"));
        System.out.println(flip("000110001"));
        System.out.println(flip("010"));
        System.out.println(flip("1101010001"));
        System.out.println(flip("00001111111111000000"));

    }

    static List<Integer> flip(String A) {
        int count = 0;
        int s = 0 , max =0;
        ArrayList<Integer> res = new ArrayList<>();

        for(int i=0;i<A.length();i++){
            if(count<0){
                s = i;
                count = 0;
            }
            count += (A.charAt(i)=='0')?1:-1;
            if(count>max){
                max = count;
                res = new ArrayList<>();
                res.add(s+1);
                res.add(i+1);
            }
        }
        return res;
    }
}
