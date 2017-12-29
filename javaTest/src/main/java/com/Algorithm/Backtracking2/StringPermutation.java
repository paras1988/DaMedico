package com.Algorithm.Backtracking2;

public class StringPermutation {

	public static void main(String[] args) {
		permuteString("ABC",0);
	}

	public static void permuteString(String str,int i){

		if(i==str.length()-1){
			System.out.println(str);
			return;
		}
		for(int c=i;c<str.length();c++){
			str=swap(str,i,c);
			permuteString(str,i+1);
			str=swap(str,c,i);
		}
	}

	private static String swap(String str, int i, int c) {
		char[] arr=str.toCharArray();
		char temp=arr[i];
		arr[i]=arr[c];
		arr[c]=temp;
		String res="";
		for(char d:arr){
			res=res+d;
		}
		str=res;
		return str;
	}
}
