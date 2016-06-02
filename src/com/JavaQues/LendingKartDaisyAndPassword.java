package com.JavaQues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class LendingKartDaisyAndPassword {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int testCases = Integer.parseInt(line);
		List<String> list=new LinkedList<String>();

		for(int i=1;i<=testCases;i++){
			String input = br.readLine();
			list.add(input);
		}
		for(String s:list){
			String[] sd=s.split("\\s+");
			//boolean out=isPasswordValid(sd[0],sd[1]);
			boolean out=isPasswordValid2(sd[0],sd[1].trim());
			if(out){
				System.out.println("Possible");
			}else{
				System.out.println("Impossible");
			}

		}
	}

	private static boolean isPasswordValid2(String w, String p) {

		if(p.length()!=2*w.length()){
			return false;
		}
		int j=0;
		for(int i=0;i<p.length();i++){

			if(j<w.length() && w.charAt(j)==p.charAt(i)){
				j++;
			}
			else if(j==w.length() || w.charAt(j)!=p.charAt(i)){
				for(int k=j;k>0;k--){
					if(checkEquals(w,p,k)){
						i =k+w.length()-1;
						break;
					}else{
						j--;
					}
				}
			}
		}
		if(j==w.length()){
			return true;
		}

		return false;
	}

	private static boolean checkEquals(String w, String p, int k) {
		int j=0;
		for(int i=k;i<p.length() && j<w.length();i++){
			if(w.charAt(j)==p.charAt(i)){
				j++;
			}else{
				return false;
			}
		}
		if(j==w.length()){
			return true;
		}
		return false;
	}

	private static boolean isPasswordValid(String word, String password) {
		char[] passChar=password.toCharArray();
		char[] wordChar=word.toCharArray();

		int wLength=wordChar.length;
		int pLength=passChar.length;

		if(wLength>60 || pLength>60){
			return false;
		}
		int i=0;
		int k=0;

		while(pLength>i && wLength>k && passChar[i]==wordChar[k]){
			if(!(passChar[i] >= 'a' && passChar[i] <= 'z') &&
					!(passChar[i] >= 'A' && passChar[i] <= 'Z')){
				return false;
			}

			i++;
			k++;
		}
		int j=0;
		while(pLength>i && wLength>j && passChar[i]==wordChar[j]){
			if(!(passChar[i] >= 'a' && passChar[i] <= 'z') &&
					!(passChar[i] >= 'A' && passChar[i] <= 'Z')){
				return false;
			}
			j++;
			i++;
		}
		while(pLength>i && wLength>k && passChar[i]==wordChar[k]){
			if(!(passChar[i] >= 'a' && passChar[i] <= 'z') &&
					!(passChar[i] >= 'A' && passChar[i] <= 'Z')){
				return false;
			}
			i++;
			k++;
		}
		if(pLength==2*wLength && 2*k==i && i==2*wLength && j==k && j==wLength){
			return true;
		}
		return false;
	}




}
