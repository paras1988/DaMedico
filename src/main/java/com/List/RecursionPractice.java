package com.List;

public class RecursionPractice {
	
	public static void main(String[] args) {
		System.out.println(fun(400));
	}
	
	static int fun(int data){
		
		if(data==0)
			return data;
	
		int data2=data-1;
		
		System.out.println(data2);
		int data3=fun(data2);
		System.out.println(data3);
		return data3;
	}
}



