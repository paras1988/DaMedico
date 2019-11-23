package com.interviewbit.arrays.Arraymath;

import java.util.Arrays;
import java.util.List;

public class MaxSumContiguousSubarray_2_doItAgain {

    public static void main(String[] args) {
        Integer arr[]={ -2,1,-3,4,-1,2,1,-5,4};
        List<Integer> arrL= Arrays.asList(arr);

        int res= maxSubArray(arrL);

        System.out.println(res);
    }

    private static int maxSubArray(List<Integer> arr) {

        int max = 0;
        int current = 0;

        for(int i=0;i<arr.size();i++){
            current = current + arr.get(i);
            if(current<0){
                current = 0;
            }
            if(current>max){
                max = current;
            }
        }

        return max;
    }
}
