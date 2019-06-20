package com.JavaQues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class AnalyticallyStable {

	public static void main(String args[]) throws Exception {
		new AnalyticallyStable().init2();

	}

	private void init() throws IOException {
		MyScanner sc = new MyScanner(System.in);
		int N = sc.nextInt();

//		int mod = 1000000007;

		for (int i = 0; i < N; i++) {
			String str = sc.next();
			int[] arr = new int[str.length()];
			Map<Integer,List<Integer>> map = new HashMap();
			for (int j = 0;j <  str.length(); j++) {
				List<Integer> list = new ArrayList<>();
				Integer count=0;
				for(int k=j+1; k< str.length();k++){
					if(str.charAt(k) == str.charAt(j)){
						list.add(k);
					}
					if(str.charAt(k)== str.charAt(j)+1){
						count++;
					}
				}
				if(!list.isEmpty()){
					map.put(j,list);
				}
				arr[j] = count;
			}
			System.out.println(arr);
			System.out.println(map);

			int res = 0;
			for(Map.Entry<Integer,List<Integer>> e:map.entrySet()){
				for(Integer v:e.getValue()){
					int t = arr[v]-1;
					res += (t*(t+1))/2;
				}
			}
			System.out.println(res);
		}

	}

	private void init2() throws IOException {
		MyScanner sc = new MyScanner(System.in);
		int N = sc.nextInt();
		int mod = 1000000007;

		for (int i = 0; i < N; i++) {
			String str = sc.next();
			int[] arr = new int[str.length()];
			Map<Integer,List<Integer>> map = new HashMap();
			for (int j = 0;j <  str.length(); j++) {
				Integer x = Character.getNumericValue(str.charAt(j));
				Integer x_1 = Character.getNumericValue(str.charAt(j))-1;
				List<Integer> list = new ArrayList<>();
				if(map.containsKey(x)){
					list = map.get(x);
				}
				list.add(j);
				map.put(x,list);
				if(map.containsKey(x_1)){
					List<Integer> list1 = map.get(x_1);
					for(Integer val:list1){
						arr[val] = arr[val]+1;
					}
				}
			}
	//		System.out.println(arr);
	//		System.out.println(map);

			long res = 0;
			for(Map.Entry<Integer,List<Integer>> e:map.entrySet()){
				List<Integer> list = e.getValue();
				for(int a=0;a<list.size();a++){
					for(int b=a+1;b<list.size();b++) {
						int c = arr[list.get(b)] - 1;
						res += (c * (c + 1)) / 2;
						if(res>mod){
							res = res % mod;
						}
					}
				}
			}
			System.out.println(res);
		}

	}

	class MyScanner {
		BufferedReader br;
		StringTokenizer st;

		public MyScanner(InputStream is) {
			br = new BufferedReader(new InputStreamReader(is));
			st = new StringTokenizer("");
		}

		public long nextLong() throws IOException {
			if (st.hasMoreTokens()) {
				return Long.parseLong(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			return nextLong();
		}

		String next() throws IOException {
			if (st.hasMoreTokens()) {
				return st.nextToken();
			}
			st = new StringTokenizer(br.readLine());
			return next();
		}

		int nextInt() throws IOException {
			if (st.hasMoreTokens()) {
				return Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			return nextInt();
		}
	}
}
