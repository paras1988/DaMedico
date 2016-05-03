package com.JavaQues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class EdgeverveQues2 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		final String[] str =line.split(" ");

		Integer a=Integer.parseInt(str[0]);
		Integer[] input=new Integer[a];
		Integer[] mod=new Integer[a];


		for(int i=0;i<input.length;i++){
			input[i]=Integer.parseInt(str[i+1]);
		}

		for(int i=2;;i++){
			for(int j=0;j<input.length;j++){
				mod[j]=input[j]%i;
			}
			if(isAllDifferent(mod)){
				System.out.println(i);
				break;
			}
		}

	}

	private static boolean isAllDifferent(Integer[] mod) {
		Set<Integer> set=new HashSet<Integer>();

		for(int i=0;i<mod.length;i++){
			set.add(mod[i]);
		}
		if(set.size()==mod.length){
			return true;
		}
		return false;
	}
}
