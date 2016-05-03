package com.JavaQues;

public class LastAndSecndLast {

	public static void main(String[] args) {
		String word="ab";

		int length=word.length();
		System.out.print(word.charAt(length-1));
		if(length>1) {
			System.out.print(" "+word.charAt(length-2));
		}
	}
}
