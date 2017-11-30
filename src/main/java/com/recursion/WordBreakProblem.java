package com.recursion;

import java.util.HashSet;

public class WordBreakProblem {

	String answer = "";

	public static void main(final String[] args) {
		final String s = "Heroaane";
		final HashSet<String> hs = new HashSet<String>();
		hs.add("I");
		hs.add("anyyy");
		hs.add("anyy");
		hs.add("any");
		hs.add("an");
		hs.add("a");
		hs.add("Hero");
		hs.add("Heroaane");

		new WordBreakProblem().wordBreak(s, hs);
	}

	public void wordBreak(final String s, final HashSet<String> hs) {
		if (find(s, hs, "")) {
		} else {
			System.out.println("Cant Break");
		}
	}

	public boolean find(final String s, final HashSet<String> dict, String answer) {
		// System.out.println(s + "  " + answer);
		if (s.length() == 0) {
			System.out.println(answer);
			return true;
		} else {
			int index = 0;
			String word = "";
			while (index < s.length()) {
				word += s.charAt(index);// add one char at a time
				// check if word exists in dictionary
				if (dict.contains(word)) {
					// add word to the answer and make a recursive call
					answer = answer + word + " ";
					if (find(s.substring(index + 1), dict, answer)) {
						return true;
					} else {
						// System.out.println(word + "  backtrack");
						index++;
						// return false;
					}
				} else {
					index++;
				}
			}
			return false;
		}
	}

}
