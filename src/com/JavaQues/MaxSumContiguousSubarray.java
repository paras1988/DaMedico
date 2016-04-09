package com.JavaQues;

import java.util.Arrays;
import java.util.List;

public class MaxSumContiguousSubarray {

	public static void main(String[] args) {
		Integer arr[]={ -9,7, -8,8, -6, -3,3};
		List<Integer> arrL=Arrays.asList(arr);

		int res=maxSubArray(arrL);

		System.out.println(res);

	}

	public static int maxSubArray(final List<Integer> a) {

		int curr_max=a.get(0);
		int max=a.get(0);
		int count=0;

		for(Integer i:a){


			if(count>0){
				System.out.println(curr_max+" "+max);
				curr_max = max(i, curr_max+i);
				max = max(max, curr_max);
			}
			count++;
		}

		if(max>curr_max) {
			return max;
		} else{
			return curr_max;
		}
	}
	private static int max(int i, int j) {
		return (i>j?i:j);
	}


}
