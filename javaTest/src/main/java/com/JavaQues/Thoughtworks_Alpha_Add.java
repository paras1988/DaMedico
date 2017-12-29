package com.JavaQues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
Input:
2
2
123
abc
2
111
Xyz

out:
bdf
z00*/
public class Thoughtworks_Alpha_Add {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int testCases = Integer.parseInt(line);

		List<String> res=new ArrayList<String>();

		for(int i=1;i<=testCases;i++){

			String line1 = br.readLine();
			int testLines = Integer.parseInt(line1);
			List<String> list=new ArrayList<String>();
			for(int j=1;j<=testLines;j++){
				String line2 = br.readLine();
				list.add(line2);
			}
			res.add(new Thoughtworks_Alpha_Add().traverseAndAdd(list));
		}

		for(String str1:res){
			System.out.println(str1);
		}
	}
	/*
	public static void main(String[] args) {
		int a=new Thoughtworks_Alpha_Add().giveIntValue('a');
		int b=new Thoughtworks_Alpha_Add().giveIntValue('z');
		int c=new Thoughtworks_Alpha_Add().giveIntValue('A');
		int d=new Thoughtworks_Alpha_Add().giveIntValue('Z');
		int e=new Thoughtworks_Alpha_Add().giveIntValue('0');
		int f=new Thoughtworks_Alpha_Add().giveIntValue('9');

		System.out.println(a+" "+b+" "+c+" "+d+" "+e+" "+f+" ");

		char a1=new Thoughtworks_Alpha_Add().giveCharValue(10);
		char b1=new Thoughtworks_Alpha_Add().giveCharValue(35);
		char c1=new Thoughtworks_Alpha_Add().giveCharValue(0);
		char d1=new Thoughtworks_Alpha_Add().giveCharValue(9);
		char e1=new Thoughtworks_Alpha_Add().giveCharValue(11);
		char f1=new Thoughtworks_Alpha_Add().giveCharValue(2);

		System.out.println(a1+" "+b1+" "+c1+" "+d1+" "+e1+" "+f1+" ");

	}
	 */	String traverseAndAdd(List<String> list){

		 String temp=list.get(0);
		 list.remove(0);
		 for(String str:list){
			 temp=addtwoStrings(temp,str);
		 }

		 return temp;
	 }

	 private String addtwoStrings(String temp, String str) {
		 List<Character> res=new ArrayList<Character>();
		 int carry=0;
		 int i=0;
		 int j=0;
		 for(i=temp.length()-1,j=str.length()-1;i>=0 && j>=0;j--,i--){
			 int a=0;
			 int b=0;

			 if(i>=0) {
				 a= giveIntValue(temp.charAt(i));
			 }
			 if(j>=0) {
				 b= giveIntValue(str.charAt(j));
			 }
			 int c= addingValues(a,b,carry);
			 int d=0;
			 if(c>=36){
				 d=addingValues(a,b,-36,carry);
				 carry=c%35;
			 }else{
				 d=addingValues(a,b,carry);
				 carry=0;
			 }
			 res.add(giveCharValue(d));
		 }
		 List<Character> res2=new ArrayList<Character>();
		 for(int k=1;k<=res.size();k++){
			 res2.add(res.get(res.size()-k));
		 }
		 return convertToString(res2);
	 }


	 private String convertToString(List<Character> res2) {
		 String str="";
		 for(Character c:res2){
			 str +=c;
		 }
		 return str;
	 }
	 private int addingValues(int a, int b, int c, int d) {
		 return a+b+c+d;
	 }
	 private Character giveCharValue(int d) {
		 char ch;
		 if(d>=10 && d<=35){
			 ch=(char) (d+87);
		 }else{
			 ch=(char) (d+48);
		 }
		 return ch;
	 }
	 private int addingValues(int a, int b, int c) {
		 return a+b+c;
	 }
	 private int addingValues(int a, int b) {

		 return a+b;
	 }
	 private int giveIntValue(char ch) {
		 int res=0;
		 ch=Character.toLowerCase(ch);
		 if(ch>='a' && ch<='z'){
			 res=ch-87;
		 }else{
			 res=ch-48;
		 }
		 return res;
	 }


}
