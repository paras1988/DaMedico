package com.JavaQues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxPositiveNumberArray_Google {

	public static void main(String[] args) {
		Integer[] arr={1, 2, 5, -7, 2, 3};
		List<Integer> list=Arrays.asList(arr);

		ArrayList<Integer> res=new MaxPositiveNumberArray_Google().maxset((ArrayList<Integer>)list);
		System.out.println(res);
	}

	public ArrayList<Integer> maxset(ArrayList<Integer> a) {
		int s=0;
		int e=0;
		int cmax=0;
		int smax=0;

		for(Integer i:a){

			if(i>0){
				e++;
				cmax=cmax+i;
			}
			if(i<0){
				s++;
				e++;
			}

		}


		return null;
	}
}
