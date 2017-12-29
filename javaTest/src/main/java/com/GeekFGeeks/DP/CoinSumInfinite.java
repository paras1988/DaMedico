package com.GeekFGeeks.DP;

import java.util.ArrayList;

public class CoinSumInfinite {

	public static void main(String[] args) {
		ArrayList<Integer> input=new ArrayList<Integer>();
		input.add(1);
		input.add(2);
		input.add(3);

		int res=new CoinSumInfinite().coinchange(input,4);
		System.out.println(res);
	}

	public int coinchange(ArrayList<Integer> a, int b) {

		if(b==0){
			return 1;
		}
		if(b<0){
			return 0;
		}
		if(a.size()<1 && b>=1){
			return 0;
		}

		int res=0;
		ArrayList<Integer> temp=new ArrayList<>();
		temp.addAll(a);
		temp.remove(temp.get(0));
		res=coinchange(temp, b)+coinchange(a, b-a.get(0));
		return res;
	}

}
