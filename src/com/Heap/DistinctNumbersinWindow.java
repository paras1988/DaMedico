package com.Heap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DistinctNumbersinWindow {

	public static void main(String[] args) {

		ArrayList<Integer> arr=new ArrayList<Integer>();
		arr.add(1);
		arr.add(2);
		arr.add(1);
		arr.add(3);
		arr.add(4);
		arr.add(3);

		int windowSize=3;

		ArrayList<Integer> res=new DistinctNumbersinWindow().dNums(arr,windowSize);

		System.out.println(res);

	}

	public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {

		if(B>A.size()){
			return null;
		}
		ArrayList<Integer> res=new ArrayList<Integer>();
		Map<Integer,Integer> map=new HashMap<Integer,Integer>();

		int i=0;
		for(;i<B;i++){
			int val=A.get(i);
			if(map.containsKey(val)){
				map.put(val,map.get(val)+1);
			}else{
				map.put(val,1);
			}
		}
		res.add(map.size());
		for(;i<A.size();i++){
			int val=A.get(i-B);

			if(map.get(val)==1){
				map.remove(val);
			}else{
				map.put(val,map.get(val)-1);
			}

			val=A.get(i);
			if(map.containsKey(val)){
				map.put(val,map.get(val)+1);
			}else{
				map.put(val,1);
			}
			res.add(map.size());
		}
		return res;
	}
}
