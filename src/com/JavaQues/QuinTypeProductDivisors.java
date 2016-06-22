package com.JavaQues;

/*
 * Oz is in love with number theory, so he expects you to love it too and solve his problems. The current problem which has been given by Oz to you is in the form of an array. So, he has given you N integers i.e a1,a2,..,aN to deal with. You have to find the number of divisors of the product of all these integers.

Input :
The first line contains a single integer N. The second line contains N space seperated integers - a1,a2,..,aN.

Output :
Output a single integer — number of divisors of the product of all these integers. Since the answer can be very large, output it modulo 1000000007(109+7).

Constraints :
1 ≤ N ≤ 103.
1 ≤ ai ≤ 106 where i=1, 2, 3 ... N

 * */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class QuinTypeProductDivisors {

	static Set<Integer> factors=new HashSet<Integer>();
	static Integer modNumber=1000000007;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numberOfTestCases=Integer.parseInt(br.readLine().trim());

		String[] sd=br.readLine().split("\\s+");


		List<Integer> list=new ArrayList<Integer>();
		//list.add(2);
		//list.add(3);


		for(int i=0;i<sd.length;i++){
			list.add(Integer.parseInt(sd[i].trim()));
		}

		long res=numberOfFactors(list,modNumber);

		System.out.println(res);
	}

	private static long numberOfFactors(List<Integer> list, Integer modNumber) {

		Set<Integer> set=new HashSet<Integer>();

		int[] res=new int[1000000];


		for(Integer i:list){

			int temp=i;

			int j=2;


			while(j*j<=temp){

				while(temp%j==0){
					res[j]=res[j]+1;
					set.add(j);
					temp=temp/j;
				}
				j++;
			}

			if(temp>1){
				set.add(temp);
				res[temp] +=1;
			}
		}
		long prod=1;


		for(Integer i:set){
			prod=(prod*(res[i]+1))%modNumber;
			System.out.println("df"+ prod);
		}
		return prod;
	}
}


//changed int to long
//Integer to int
//Zeroes handling
//no problem in input