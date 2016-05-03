package com.JavaQues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class HoneyWell2_Oz_and_painting {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		Integer numberOfQueries=Integer.parseInt(line);

		List<Integer> res=new ArrayList<>();

		for(int i=0;i<numberOfQueries;i++){
			String query = br.readLine();
			String[] sd2=query.split("\\s+");

			int x=Integer.parseInt(sd2[0]);
			int y=Integer.parseInt(sd2[1]);
			int z=Integer.parseInt(sd2[2]);

			/*int x=1;
			int y=11;
			int z=7;*/
			res.add(maxPaintings(x,y,z));
		}
		for(Integer i:res){
			System.out.println(i);
		}
	}

	private static int maxPaintings(int x, int y, int z) {
		if(x<=0 && y<=0 && z<=0){
			return 0;
		}

		if(x<=0){
			return y/3+z/3;
		}
		if(y<=0){
			return x/3+z/3;
		}
		if(z<=0){
			return x/3+y/3;
		}

		return 1+maxOf(
				maxPaintings(x-3,y,z),
				maxPaintings(x,y-3,z),
				maxPaintings(x,y,z-3),
				maxPaintings(x-1,y-1,z-1)
				);

	}


	private static int maxOf(int a,int b,int c,int d) {

		if(a>b){
			if(a>c){
				return Math.max(a, d);
			}
			else{
				return Math.max(c, d);
			}
		}else{
			if(b>c){
				return Math.max(b, d);
			}
			else{
				return Math.max(c, d);
			}
		}
	}
}
