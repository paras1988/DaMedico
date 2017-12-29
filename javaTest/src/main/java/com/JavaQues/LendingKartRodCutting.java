package com.JavaQues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class LendingKartRodCutting {


	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int testCases = Integer.parseInt(line);

		List<Integer> list=new LinkedList<Integer>();
		for(int i=1;i<=testCases;i++){
			String input = br.readLine();
			int n = Integer.parseInt(input);
			list.add(n);
		}
		for(Integer i:list){
			System.out.println(rodCutting(i));
		}
	}

	private static int rodCutting(int n) {
		int count=0;
		for(int i=3;i<=n;i=2*i+1){
			count++;
		}
		return count;
	}
}
