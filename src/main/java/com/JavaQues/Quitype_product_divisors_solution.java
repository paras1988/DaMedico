package com.JavaQues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Quitype_product_divisors_solution {

	public static void main(String args[]) throws Exception {
		new Quitype_product_divisors_solution().init();

	}

	private void init() throws IOException {
		MyScanner sc = new MyScanner(System.in);
		int N = sc.nextInt();

		int array[] = new int[1000000];
		HashSet<Integer> divisorsSet = new HashSet<Integer>();
		int mod = 1000000007;

		for (int i = 0; i < N; i++) {
			int num = sc.nextInt();
			for (int j = 2;j*j<= num; j++) {

				while (num % j == 0) {
					num /= j;
					divisorsSet.add(j);
					array[j] += 1;
				}

			}
			if (num > 1) {
				divisorsSet.add(num);
				array[num]+=1;
			}
			// if (num % j == 0) {
			// divisorsSet.add(j);
			// array[j] += 1;
			// }
			// }
			// if (num > 0) {
			// divisorsSet.add(num);
			// array[num] += 1;
			// }
		}

		long ans = 1;
		Iterator<Integer> itor = divisorsSet.iterator();
		while (itor.hasNext()) {
			ans = (ans * (array[itor.next()] + 1)) % mod;
			System.out.println("df"+ ans);
		}

		System.out.println(ans);

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
