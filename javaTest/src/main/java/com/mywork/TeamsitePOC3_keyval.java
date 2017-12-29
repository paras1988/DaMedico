package com.mywork;

/*
 * 
 * Made to compare to js files used after deployement.
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class TeamsitePOC3_keyval {
	static String dir = "C:\\Users\\43901757\\Documents\\Defects\\CE-769 Teamsite Integration\\NEW TEAMSITE Excels\\New folder\\";
	static String TAG = "psErr";

	public static void main(final String[] args) {
		final List<String> s1 = new ArrayList<String>();

		final Map<String, String> MainFileMap = new LinkedHashMap<String, String>();
		final Map<String, String> WebFileMap = new LinkedHashMap<String, String>();

		final BufferedReader br = null;
		int count = 0;

		try {
			final String file1 = dir + "MainFileLatest.txt";

			final Scanner s = new Scanner(new BufferedReader(new FileReader(file1)))
					.useDelimiter("\',");

			while (s.hasNext()) {

				final String stringToken = s.next();
				final String delims = ": \'";
				final String[] tokens = stringToken.split(delims);

				// final String[] tokensAfterRemovingSpace = tokens[0].replace("\"", "");
				// for(final String str:tokensAfterRemovingSpace){
				if (tokens[0].contains(TAG)) {
					MainFileMap.put(tokens[0].replace("\"", "").trim(),
							tokens.length > 1 ? tokens[1] : "");
					// System.out.println(tokens[1]);
					// System.out.println("==========");
					// break;
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

		// 2nd file
		System.out.println("\n\n");
		try {
			final String file1 = dir + "WebFileTeamsite.txt";

			final Scanner s = new Scanner(new BufferedReader(new FileReader(file1)))
					.useDelimiter("\",");

			while (s.hasNext()) {

				final String stringToken = s.next();
				final String delims = "\" : \"";
				final String[] tokens = stringToken.split(delims);

				// final String[] tokensAfterRemovingSpace = tokens[0].replace("\"", "");
				// for(final String str:tokensAfterRemovingSpace){
				if (tokens[0].contains(TAG)) {
					WebFileMap.put(tokens[0].replace("\"", "").trim(),
							tokens.length > 1 ? tokens[1] : "");
					// System.out.println(tokens[1]);
					// System.out.println("==========");
					// break;
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

		// Compare 2 maps....
		System.out.println("\n\n--------------RESULT-------------------------\n\n");
		final int i = 0;
		final int j = 0;

		final List<String> mainKeyList = new ArrayList<String>();
		final List<String> webKeyList = new ArrayList<String>();

		for (final Entry main : MainFileMap.entrySet()) {

			mainKeyList.add((String) main.getKey());
		}
		for (final Entry web : WebFileMap.entrySet()) {

			webKeyList.add((String) web.getKey());
		}

		for (final String main : mainKeyList) {
			for (final String web : webKeyList) {
				if (main.equals(web)) {
					if (!MainFileMap.get(main).equals(WebFileMap.get(main))) {
						System.out.println(main + ":" + MainFileMap.get(main) + ":"
								+ WebFileMap.get(main) + ":");
					}
				}

			}
		}
		/*
		 * for(final Entry web:WebFileMap.entrySet()){
		 * 
		 * webKeyList.add((String)web.getKey());
		 * if(main.getKey().equals(web.getKey())){
		 * 
		 * 
		 * if(!((String)main.getValue()).trim().equals(((String) web.getValue()).trim())){
		 * i++;
		 * System.out.println(main.getKey()+":"+main.getValue()+":"+((String)
		 * web.getValue()).trim()+":");
		 * }
		 * break;
		 * }
		 * }
		 * 
		 * }
		 */

		System.out.println("\n TAGS PRESENT IN MAIN AND NOT IN WEB FILE \n");
		/*
		 * for(final String m1:webKeyList) {
		 * System.out.print(m1);
		 * }
		 */
		/*
		 * final Set w=new TreeSet<>(webKeyList);
		 * final Set m=new TreeSet<>(mainKeyList);
		 * 
		 * System.out.println(m.size()+" "+m);
		 * 
		 * System.out.println("\n\n");
		 * System.out.println(w.size()+" "+w);
		 * System.out.println("\n\n");
		 */

		for (final String m : mainKeyList) {
			if (!webKeyList.contains(m)) {
				System.out.println(m + ":" + MainFileMap.get(m));
			}
		}

		System.out.println("\n TAGS PRESENT IN WEB AND NOT IN MAIN FILE \n");
		for (final String w : webKeyList) {
			if (!mainKeyList.contains(w)) {
				System.out.println(w + ":" + WebFileMap.get(w));
			}
		}

	}

}