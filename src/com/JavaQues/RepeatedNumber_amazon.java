package com.JavaQues;

import java.util.ArrayList;
import java.util.List;

public class RepeatedNumber_amazon {

	public static void main(String[] args) {

		List<Integer> list=new ArrayList<Integer>();
		list.add(3);
		list.add(4);
		list.add(1);
		list.add(4);
		list.add(1);

		int res=new RepeatedNumber_amazon().repeatedNumber(list);
		System.out.println(res);
	}

	public int repeatedNumber(final List<Integer> a) {

		Integer[] arr=new Integer[a.size()-1];
		for(int i=0;i<a.size();i++){


			if(arr[Math.abs(a.get(i))-1]!=null){
				return a.get(i);
			}else{
				arr[Math.abs(a.get(i))-1]=-1;
			}
		}
		return 0;
	}
}
