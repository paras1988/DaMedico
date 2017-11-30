package com.Algorithm.Backtracking;

import java.util.ArrayList;

public class LetterPhone {

	public static void main(String[] args) {
		System.out.println(letterCombinations("1234"));
		System.out.println(letterCombinationsBacktrack("1234"));
	}

	private static char[] letterCombinationsBacktrack(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	public static ArrayList<String> letterCombinations(String A) {

		ArrayList<Character> digits[];
		digits = new ArrayList[10];

		for (int i = 0; i < 10; i++) {
			digits[i] = new ArrayList<>();
		}

		digits[0].add('0');
		digits[1].add('1');
		char c = 'a';
		int k;

		for (int i = 2; i < 10; i++) {
			k = 3;
			if (i == 7 || i == 9) {
				k = 4;
			}
			for (int j = 0; j < k; j++) {
				digits[i].add(c);
				c++;
			}
		}


		int i = 0;
		int n = A.length();
		int dig;
		ArrayList<String> res = new ArrayList<>();
		ArrayList<String> temp = new ArrayList<>();
		ArrayList<String> x;

		res.add("");

		while (i < n) {
			dig = A.charAt(i) - '0';

			for (String str : res) {
				for (char ch : digits[dig]) {
					String st = str + ch;
					temp.add(st);
				}
			}

			x = res;
			res = temp;
			temp = x;
			temp.clear();

			i++;
		}

		return res;
	}
}
