package com.JavaQues;

/*
Please implement this method to
capitalize all first letters of the words in the given String.
All other symbols shall remain intact. If a word starts not with a letter, it shall remain intact too.
Assume that the parameter String can only contain spaces and alphanumeric characters.

NOTE: please keep in mind that the words can be divided by single or multiple spaces.
The spaces also can be found at the beginning or the end of the parameter string,
and you need to preserve them.

Please add a main method which evaluates and displays one or more test cases.
 */

public class Task_2 {

	public static void main(String[] args) {
		System.out.println(capitalizeFirstLetters("  dfdf dfdf "));
		System.out.println(capitalizeFirstLetters("df df"));
		System.out.println(capitalizeFirstLetters("  dfdf"));
		System.out.println(capitalizeFirstLetters(" 23 23  23fd"));
	}

	public static String capitalizeFirstLetters(String s) {

		String res="";
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)!=' '){
				res+=Character.toUpperCase(s.charAt(i));
				i++;
				while(i<s.length() && s.charAt(i)!=' '){
					res+=s.charAt(i);
					i++;
				}
				i--;
			}else{
				res+=s.charAt(i);
			}
		}
		return res;
	}

}