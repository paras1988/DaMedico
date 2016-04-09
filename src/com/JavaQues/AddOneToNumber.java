package com.JavaQues;

import java.util.ArrayList;
import java.util.List;

/*
 * Given a non-negative number represented as an array of digits,

add 1 to the number ( increment the number represented by the digits ).

The digits are stored such that the most significant digit is at the head of the list.

Example:

If the vector has [1, 2, 3]

the returned vector should be [1, 2, 4]

as 123 + 1 = 124.

 */

public class AddOneToNumber {

	public static void main(String[] args) {

		ArrayList<Integer> list=new ArrayList<Integer>();
		list.add(0);
		list.add(0);
		list.add(4);
		list.add(4);
		list.add(6);
		list.add(0);
		list.add(9);
		list.add(6);
		list.add(5);
		list.add(1);

		List<Integer> res=new ArrayList<Integer>();
		res=new AddOneToNumber().plusOne(list);
		System.out.println(res);
	}

	public ArrayList<Integer> plusOne2(ArrayList<Integer> a) {

		int f=0;
		int count=a.size()-1;
		for(Integer x:a){
			f +=(int) (x*Math.pow(10,count));
			count--;
		}
		f=f+1;
		ArrayList<Integer> list=new ArrayList<Integer>();
		while(f!=0){
			list.add(f%10);
			f=f/10;
		}
		ArrayList<Integer> list2=new ArrayList<Integer>();
		int size=list.size();
		for(int j=size-1;j>=0;j--){
			list2.add(list.get(j));
		}

		return list2;
	}

	public ArrayList<Integer> plusOne(ArrayList<Integer> A) {

		for(int i=A.size()-1;i>=0;i--){
			if(A.get(i)+1<10){
				A.set(i,A.get(i)+1);
				break;
			}else{
				A.set(i,0);
			}
		}

		ArrayList<Integer> result = new ArrayList<>();
		if(allElementsAreZero(A)){
			result.add(1);
			result.addAll(A);
		}else{
			result.addAll(A);
		}

		removeZeroesFromStart(result);
		return result;
	}

	private void removeZeroesFromStart(ArrayList<Integer> result) {
		int count=0;
		for(Integer i:result){
			if(i==0){
				count++;
			}else{
				break;
			}
		}
		for(int i=0;i<count;i++){
			result.remove(0);
		}
	}

	private boolean allElementsAreZero(ArrayList<Integer> a) {
		for(Integer i:a){
			if(i!=0){
				return false;
			}
		}
		return true;
	}
}
