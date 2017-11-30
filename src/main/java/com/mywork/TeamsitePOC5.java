package com.mywork;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TeamsitePOC5 {

	static String dir = "C:\\Users\\43901757\\Documents\\Defects\\CE-769 Teamsite Integration\\NEW TEAMSITE Excels\\New folder\\psErr\\";
	static String TAG = "psErr";

	public static void main(final String[] args) {
		final List<String> s1 = new ArrayList<String>();
		final Map<String, String> MainFileMap = new LinkedHashMap<String, String>();
		final Map<String, String> WebFileMap = new LinkedHashMap<String, String>();
		final BufferedReader br = null;
		int count = 0;
		try {
			final String file1 = dir + "Excel_psErr.txt";

			final Scanner s = new Scanner(new BufferedReader(new FileReader(file1)))
					.useDelimiter("',");

			while (s.hasNext()) {

				final String stringToken = s.next();
				final String delims = ": \'";
				final String[] tokens = stringToken.split(delims);

				if (tokens[0].contains(TAG)) {
					MainFileMap.put(tokens[0].trim(), tokens.length > 1 ? tokens[1] : "");

					count++;
				}
			}
			System.out.println(MainFileMap.size() + "" + MainFileMap);
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
		System.out.println("*********************************");
		System.out.println("*********************************");
		System.out.println("*********************************");
		try {
			final String file2 = dir + "JS_psErr.txt";

			final Scanner s = new Scanner(new BufferedReader(new FileReader(file2)))
					.useDelimiter("',");

			while (s.hasNext()) {

				final String stringToken = s.next();
				final String delims = ": \'";
				final String[] tokens = stringToken.split(delims);

				if (tokens[0].contains(TAG)) {
					WebFileMap.put(tokens[0].trim(), tokens.length > 1 ? tokens[1] : "");

					count++;
				}
			}
			System.out.println(WebFileMap.size() + "" + WebFileMap);
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

		System.out.println("*********************************");
		System.out.println("*********************************");
		System.out.println("*********************************");

		for (final String sw : WebFileMap.keySet()) {
			for (final String sm : MainFileMap.keySet()) {
				if (sw.equals(sm)) {
					if (!WebFileMap.get(sw).equals(MainFileMap.get(sm))) {
						System.out.println(sw + "\n" + WebFileMap.get(sw) + "\n"
								+ MainFileMap.get(sw));
						System.out.println("***************");
					}
				}
			}
		}

	}

}
