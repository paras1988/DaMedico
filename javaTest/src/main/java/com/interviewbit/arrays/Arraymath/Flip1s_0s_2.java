package com.interviewbit.arrays.Arraymath;

import java.util.ArrayList;
import java.util.List;

//find a subarray with maximum sum
public class Flip1s_0s_2 {

    public static void main(String[] args) {
        System.out.println(flip("01010100010101"));
        System.out.println(flip("111"));
        System.out.println(flip("000110001"));
        System.out.println(flip("010"));
        System.out.println(flip("1101010001"));
    }

    static List<Integer> flip(String A) {

        List<Integer> res = new ArrayList<>();
        int s= 0;
        int ee= 0;
        int ss = 0;
        int max = 0;

        for(int i=0;i<A.length();i++){
            if(A.charAt(i)=='0'){
                if(s==0){
                    ss = i;
                }
                ++s;
                ee = i;
            }
            else{
                --s;
            }
            if(ee - ss >= max){
                res = new ArrayList<>();
                res.add(ss);
                res.add(ee);

                max = ee-ss;
            }
            if(s<0){
                s=0;
            }
        }

        return res;
    }
}
