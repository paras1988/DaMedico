package com.JavaQues;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BuildSmartIDE_GettingComments_VMWARE {

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);

		while(sc.hasNext()){
			String text=sc.nextLine();

			String patternString1 = "((//)(.*))";
			String patternString2=  "((/\\*)(.*))";
			String patternString3 = "((.*)(\\*/)(.*))";
			String patternString4 = "((.*)(/\\*)(.*)(\\*/))";

			Pattern pattern1 = Pattern.compile(patternString1);
			Pattern pattern2 = Pattern.compile(patternString2);
			Pattern pattern3 = Pattern.compile(patternString3);
			Pattern pattern4 = Pattern.compile(patternString4);

			Matcher matcher1 = pattern1.matcher(text);
			Matcher matcher2 = pattern2.matcher(text);
			Matcher matcher3 = pattern3.matcher(text);
			Matcher matcher4 = pattern4.matcher(text);


			if(matcher4.find()){
				System.out.println(matcher4.group(3)+""+matcher4.group(4)+""+matcher4.group(5));
			}
			else if(matcher2.find()){
				System.out.println(matcher2.group(1));

				if(!matcher3.find()){
					String text2=sc.nextLine();
					matcher3 = pattern3.matcher(text2);
					while(!matcher3.find()){
						System.out.println(text2);
						text2=sc.nextLine();
						matcher3 = pattern3.matcher(text2);
					}
					System.out.println(matcher3.group(1));
				}

			}
			else if(matcher1.find()) {
				System.out.println(matcher1.group(1));
			}
		}
		sc.close();
	}


}
