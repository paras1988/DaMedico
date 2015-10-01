package com.mywork;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class TeamsitePOC {
	static String dir="C:\\Users\\43901757\\Desktop\\POC teamsite\\PSLBL\\After deployement to SDE3\\";
	public static void main(final String[] args) {
		final List<String> s1=new ArrayList<String>();

		BufferedReader br = null;

		try {

			String sCurrentLine;
			final String file=dir+"MainFile.txt";
			br = new BufferedReader(new FileReader(file));

			while ((sCurrentLine = br.readLine()) != null) {
				//System.out.println(sCurrentLine);
				final String[] tokens = sCurrentLine.split("\\s+");
				for(final String str:tokens){
					if(str.contains("psLbl")) {
						s1.add(str.replace("\"","")+":");
					}
				}
			}
			System.out.println("Main file label count:"+s1.size()+"\n"+s1);
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

		//Processing for second file

		System.out.println("================SHOWING 2nd file content===============");
		System.out.println("");
		System.out.println("");

		final List<String> s2=new ArrayList<String>();
		br = null;

		try {

			String sCurrentLine;
			final String file=dir+"WebFile.txt";
			br = new BufferedReader(new FileReader(file));

			while ((sCurrentLine = br.readLine()) != null) {
				//System.out.println(sCurrentLine);
				final String[] tokens = sCurrentLine.split("\\s+");
				for(final String str:tokens){
					if(str.contains("psLbl")) {
						s2.add(str+"");
					}
				}
			}
			System.out.println("Label count from web");
			System.out.println("Main file label count:"+s2.size()+"\n"+s2);
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
		System.out.println("showing s1 and s2");
		System.out.println(s1);
		System.out.println(s2);

		System.out.println("=============Removing those labels from main file which are their on web=========");
		final List<String> s3=s2;
		s3.removeAll(s1);
		System.out.println("Main file label- Remaining file label:"+s3.size()+"\n"+s3);


		System.out.println("=============Writing it to a file=========");

		Writer writer = null;

		try {
			writer = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(dir+"RemainingLabels.txt"), "utf-8"));
			for(final String str:s3){
				writer.write(str+"\n");
			}
		} catch (final IOException ex) {
			// report
		} finally {
			try {writer.close();} catch (final Exception ex) {//ignore}
			}

		}
		System.out.println("============= Reading and Writing it to a file=========");

		br = null;

		try {

			String sCurrentLine;
			final String file=dir+"MainFile.txt";
			writer = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(dir+"Final.txt"), "utf-8"));

			br = new BufferedReader(new FileReader(file));

			while ((sCurrentLine = br.readLine()) != null) {
				//System.out.println(sCurrentLine);
				for(final String str:s3){
					if(sCurrentLine.contains(str)){
						writer.write(sCurrentLine.replace(" '","").replace("',","")+"\n");
					}
				}
			}

		} catch (final IOException e) {
			e.printStackTrace();
		} finally {
			try {writer.close();} catch (final Exception ex) {}
			try {
				if (br != null) {
					br.close();
				}
			} catch (final IOException ex1) {
				ex1.printStackTrace();
			}
		}



	}
}
