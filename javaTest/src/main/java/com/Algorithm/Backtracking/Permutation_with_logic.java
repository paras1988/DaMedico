package com.Algorithm.Backtracking;

/**
 * Think in terms of tree it create
 * Logic: choose one eleement iteratively. After choosing do same for rest of string.
 *
 * --> Choose / Explore / Unchoose
 */
public class Permutation_with_logic {
	public static void main(String[] args) {
		String str = "ABCD";
		permuteString(str,"");
	}

	private static void permuteString(String str, String result) {

		//System.out.println("string " + str);
		//System.out.println("result " + result);
		//base
		if(str.equals("")){
			System.out.println(result);
			return;
		}
		for(int i=0;i<str.length();i++){

			//choose - choose the character, add to result, delete from original
			result = result + str.charAt(i);
			String temp = str;
			str = str.replace(String.valueOf(str.charAt(i)),"");

			//explore
			permuteString(str,result);

			//unchoose
			result = result.substring(0,result.length()-1);
			str = temp;

		}
	}

}
