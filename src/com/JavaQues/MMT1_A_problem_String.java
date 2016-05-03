package com.JavaQues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
 * 
 * Sample Input
5
aacbb
2
a c
a b
Sample Output(Plaintext Link)
2
4
Explanation
For the first query, the possible substrings are aac and ac . Hence the answer is 2
For the second query, the possible substrings are aacbb , aacb ,acbb , and acb , hence making a total of 4
 */
public class MMT1_A_problem_String {

	public static void main(String[] args) throws IOException {


		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		line = br.readLine();

		int sum=0;
		int numberOfQueries=Integer.parseInt(br.readLine());
		List<String> queries=new ArrayList<String>();
		for(int i=1;i<=numberOfQueries;i++){
			queries.add(br.readLine());
		}

		for(String s:queries){

			String[] sd=s.split("\\s+");

			char g=sd[0].toCharArray()[0];
			char h=sd[1].toCharArray()[0];
			char[] letters={g,h};
			if(letters[0]!=letters[1]){
				sum +=countUtil(line, letters[0], letters[1]);
				sum +=countUtil(line, letters[1], letters[0]);
			}
			else{
				sum +=countUtil(line,letters[0]);
			}
			System.out.println(sum);
			sum=0;
		}

	}

	private static int countUtil(String str, char letters) {
		char[] input=str.toCharArray();
		int a=0;
		for(int i=0;i<input.length;i++){
			if(input[i]==letters){
				a++;
			}
		}
		int b=(a*(a-1))/2;
		return b;
	}

	static int countUtil(String str, char s,char e){

		int count=0;
		char[] input=str.toCharArray();
		int a=0;
		int b=0;
		for(int i=0;i<input.length;i++){

			if(input[i]==s){
				a++;
			}
			if(input[i]==e){
				count +=a;
			}
		}
		return count;
	}
}
