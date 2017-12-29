package com.JavaQues;

import java.util.ArrayList;

/*
Given an even number ( greater than 2 ), return two prime numbers whose sum will be equal to given number.

NOTE A solution will always exist. read Goldbach s conjecture

Example:


Input : 4
Output: 2 + 2 = 4

If there are more than one solutions possible, return the lexicographically smaller solution.

If [a, b] is one solution with a <= b,
and [c,d] is another solution with c <= d, then

[a, b] < [c, d]

If a < c OR a==c AND b < d.
 */
public class Prime_Sum {
	public static void main(String[] args) {

		int i=16777214;
		ArrayList<Integer> res=new Prime_Sum().primesum(i);
		System.out.println(res);

		System.out.println(new Prime_Sum().isPrime(16777199));
	}

	public ArrayList<Integer> primesum(int a) {
		ArrayList<Integer> res=new ArrayList<Integer>();
		if(isPrime(a-2)){
			res.add(2);
			res.add(a-2);
			return res;
		}
		for(int i=3;i<a;){
			if(isPrime(a-i) && isPrime(i)){
				res.add(i);
				res.add(a-i);
				return res;
			}
			i=i+2;
		}

		return res;
	}

	private boolean isPrime(int n) {

		for(int i=2;i<n;i++){
			if(n%i==0){
				return false;
			}
		}
		return true;
	}
}
