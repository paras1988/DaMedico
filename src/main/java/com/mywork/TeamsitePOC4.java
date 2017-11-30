package com.mywork;
/*
 * Just check the tags
 * output: tags in main not in web
 * 
 * 
 * sample web just contain tags..:
 * 
 * psRes_REGULATORY_ECONOMICSECTOR_73
	psRes_REGULATORY_ECONOMICSECTOR_72

	  main is

	  "psRes_CHARGESCODE_SHAR" : "Share",
"psRes_CHARGESCODE_SHAR_DESC" : "The sender pays outgoing charges, the beneficiary pays receiving charges",
 * */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TeamsitePOC4 {
	static String dir="C:\\Users\\43901757\\Desktop\\POC teamsite\\PSRES\\After deployement to SDE3\\";
	static String TAG="psRes";

	public static void main(final String[] args) {
		final List<String> s1=new ArrayList<String>();

		BufferedReader br = null;

		try {
			final String file1=dir+"MainFileLatest.txt";

			final Scanner s = new Scanner(new BufferedReader(new FileReader(file1))).useDelimiter("\",");

			while (s.hasNext()) {

				final String stringToken=s.next();
				final String delims = "\\s+";
				final String[] tokens = stringToken.split(delims);

				for(final String str:tokens){
					if(str.contains(TAG)){
						s1.add(str.trim().replace("\"",""));
					}
				}
			}
			Collections.sort(s1);
			System.out.println(s1.size()+" "+s1);
			/**********/
		} catch (final IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (final IOException ex) {
				ex.printStackTrace();
			}
		}



		//2nd file

		final List<String> s2=new ArrayList<String>();
		String sCurrentLine;
		try {
			final String file1=dir+"WebFileTeamsite.txt";

			br=new BufferedReader(new FileReader(file1));

			while ((sCurrentLine = br.readLine()) != null) {
				s2.add(sCurrentLine.trim());
			}
			Collections.sort(s2);
			System.out.println(s2.size()+" "+s2);
			/**********/
		} catch (final IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (final IOException ex) {
				ex.printStackTrace();
			}
		}


		//TAGS IN MAIN NOT IN WEB

		for(final String str:s1){
			if(!s2.contains(str)){
				System.out.println(str);
			}
		}


	}
}
