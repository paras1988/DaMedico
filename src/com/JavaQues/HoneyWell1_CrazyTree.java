package com.JavaQues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class HoneyWell1_CrazyTree {

	public static void main(String[] args) throws IOException {


		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		String[] sd=line.split("\\s+");

		int level=Integer.parseInt(sd[0]);
		int numberOfqueries=Integer.parseInt(sd[1]);

		int leafNode=(int) Math.pow(2, level-1);

		List<Integer> res=new ArrayList<>();

		for(int i=0;i<numberOfqueries;i++){
			String query = br.readLine();
			String[] sd2=query.split("\\s+");

			int l=Integer.parseInt(sd2[0]);
			int s=Integer.parseInt(sd2[1]);
			int e=Integer.parseInt(sd2[2]);

			/*int l=3;
			int s=1;
			int e=4;*/
			Map<Integer,Long[]> map=craxyTreeUtil(leafNode,level);
			res.add(processMapForResult(map,l,s,e));
		}

		for(Integer i:res){
			System.out.println(i);
		}
	}

	private static int processMapForResult(
			Map<Integer, Long[]> map, int l, int s, int e) {
		int sum=0;

		if(map.size()>0){
			List<Long> list=Arrays.asList(map.get(l));
			for(int i=s;i<=e;i++){
				sum +=list.get(i-1);
			}
		}
		return sum;
	}

	private static Map<Integer,Long[]> craxyTreeUtil(int leafNode, int level) {
		Map<Integer,Long[]> map=new HashMap<>();

		Long[] array=null;
		Long[] temp=new Long[leafNode];
		int count=0;

		for(int i=level;i>=1;i--){
			array=new Long[leafNode];
			for(int j=1;j<=leafNode;j++){

				if(i==level){
					array[count]=(long) j;
				}
				else{
					int a=j*2-1;
					int b=j*2-2;
					temp=map.get(i+1);
					array[count]=temp[a]*temp[b];
				}
				count++;
			}
			count=0;
			map.put(i,array);
			leafNode=leafNode/2;
		}

		return map;
	}
}
