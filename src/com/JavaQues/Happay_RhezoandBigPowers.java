package com.JavaQues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/*Rhezo likes numbers of the form
A
B
AB. But computing
A
B
AB, for any
2
2 numbers
A
A and
B
B is a hard task for him. He would like you to help him out in this.

Input:
First line of input contains a single integer
A
A. Second line contains the integer
B
B.

Output:
Help Rhezo find
A
B
AB. As this number can be large, print it modulo
10
9
+
7
109+7.

Constraints:

1
≤
A
≤
10
9
1≤A≤109
1
≤
B
≤
10
10
5
1≤B≤10105
SAMPLE INPUT
4
3
SAMPLE OUTPUT
64*/
public class Happay_RhezoandBigPowers {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String sd1=br.readLine();
		String sd2=br.readLine();


		int a=Integer.parseInt(sd1);
		int b=Integer.parseInt(sd2);


		long ans=1;
		int mod=1000000007;

		for(int i=1;i<=b;i++){
			ans = (ans*a)%mod;
		}
		System.out.println(ans);
	}
}
