package com.interviewbit.arrays.Arraymath;

import java.util.Arrays;
import java.util.List;

public class MaxSumContiguousSubarray {

    public static void main(String[] args) {
        Integer arr[]={ -2,1,-3,4,-1,2,1,-5,4};
        List<Integer> arrL= Arrays.asList(arr);

        int res= maxSubArray(arrL);

        System.out.println(res);
    }

    private static int maxSubArray(List<Integer> arr) {

        int curr = arr.get(0);
        int max = curr;
        for(int i=1;i<arr.size();i++){
            curr = Math.max(arr.get(i),curr+arr.get(i));
            max = Math.max(max,curr);
            System.out.println(curr+" "+max);
        }
        return max;
    }
}
