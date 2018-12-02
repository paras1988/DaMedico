package com.JavaQues;


import java.util.ArrayList;
import java.util.List;

class Test
{
	public static void main(String[] args) throws Exception
	{
		List<String> str = new ArrayList<>();
		str.add("cdab");
		str.add("dcba");
		str.add("abcd");
		str.add("a");
		str.add("");

		List<String> str1 = new ArrayList<>();
		str1.add("abcd");
		str1.add("abcd");
		str1.add("abcdcd");
		str1.add("a");
		str1.add("");

		List<String> res = twins(str,str1);
		System.out.println(res);
	}

	public static List<String> twins(List<String> a, List<String> b) {
		List<String> result = new ArrayList<>();
		for(int i=0;i<a.size();i++){
			if(a.get(i).length() != b.get(i).length()){
				result.add("No");
				continue;
			}
			if(checkStr(a.get(i),b.get(i))){
				result.add("Yes");
			}
			else {
				result.add("No");
			}
		}
		return result;
	}

	private static boolean checkStr(String str1,String str2) {

		int xor = 0;
		for(int i=0;i<str1.length();i=i+2){
			xor = xor ^ str1.charAt(i);
			xor = xor ^ str2.charAt(i);
		}
		if(xor != 0){
			return false;
		}
		xor = 0;
		for(int i=1;i<str1.length();i=i+2){
			xor = xor ^ str1.charAt(i);
			xor = xor ^ str2.charAt(i);
		}
		if(xor != 0){
			return false;
		}
		return true;
	}
}
