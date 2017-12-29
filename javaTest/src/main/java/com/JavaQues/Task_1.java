package com.JavaQues;

public class Task_1 {

	public static void main(String[] args) {
		int[] arr={1,3,4,-1,-3,-6,34};
		int res=getClosestToZero(arr);
		System.out.println(res);
	}
	public static int getClosestToZero(int[] a)  {

		int DIFF=Integer.MAX_VALUE;

		int temp=0;
		for(int i=0;i<a.length;i++){
			temp=a[i];
			if(temp<0){
				temp=temp*-1;
			}
			if(temp-0<=DIFF){
				DIFF=temp;
				if(a[i]<0){
					DIFF=a[i];
				}
			}
		}
		return DIFF;
	}
}
