package com.JavaQues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MMT2_Micro_And_Array {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		String[] sd=line.split("\\s+");

		String line2=br.readLine();
		String[] sd2=line2.split("\\s+");
		List<Integer> list=new ArrayList<Integer>();
		for(String s:sd2){
			list.add(Integer.parseInt(s));
		}

		List<Integer> res=new ArrayList<Integer>();
		for(int i=0;i<Integer.parseInt(sd[1]);i++){
			String query=br.readLine();
			String[] queryArr=query.split("\\s+");
			if(queryArr[0].equals("0")){
				updateList(list,queryArr[1],queryArr[2]);
			}
			else if(queryArr[0].equals("1")){
				printRes(list,res,queryArr[1]);
			}
		}

		for(int i=0;i<res.size();i++){
			System.out.println(res.get(i));
		}
	}

	private static void updateList(List<Integer> list, String initial,
			String updatedIndex) {

		int index=Integer.parseInt(initial);
		if(index<=list.size()){

			list.remove(index-1);
			list.add(index-1,Integer.parseInt(updatedIndex));
		}

	}

	private static void printRes(List<Integer> list, List<Integer> res,
			String string) {

		for(int i=0;i<list.size();i++){
			if(list.get(i)>=Integer.parseInt(string)){
				res.add(i+1);
				return;
			}
		}
		res.add(-1);
	}
}
