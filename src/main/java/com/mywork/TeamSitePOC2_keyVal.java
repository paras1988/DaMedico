package com.mywork;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class TeamSitePOC2_keyVal {
	static String dir = "C:\\Users\\43901757\\Documents\\Defects\\CE-769 Teamsite Integration\\NEW TEAMSITE Excels\\New folder\\psErr\\";
	static String TAG = "psErr";

	public static void main(final String[] args) {
		final List<String> s1 = new ArrayList<String>();

		final Map<String, String> MainFileMap = new HashMap<String, String>();
		final Map<String, String> WebFileMap = new HashMap<String, String>();

		final BufferedReader br = null;
		int count = 0;

		try {
			final String file2 = dir + "JS_psErr.txt";

			final Scanner s = new Scanner(new BufferedReader(new FileReader(file2)))
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

		// Processing for second file

		System.out.println("================SHOWING 2nd file content===============");

		try {
			final String file2 = dir + "psErr.xml";

			// final Scanner s = new Scanner(new BufferedReader(new
			// FileReader(file2))).useDelimiter("',");

			final File file = new File(file2);

			final DocumentBuilder builder = DocumentBuilderFactory.newInstance()
					.newDocumentBuilder();
			final Document doc = builder.parse(file);

			// Normalize the XML Structure; It's just too important !!
			doc.getDocumentElement().normalize();

			// Here comes the root node
			final Element root = doc.getDocumentElement();
			// System.out.println(root.getNodeName());

			// Get all employees
			final NodeList nList = doc.getElementsByTagName("*");
			// System.out.println("============================");

			final List<String> abc = new ArrayList<String>();
			for (int temp = 0; temp < nList.getLength(); temp++) {
				final Element element = (Element) nList.item(temp);
				// System.out.println(element.getNodeName());
				abc.add(element.getNodeName());
			}

			// System.out.println(abc.size());

			final NodeList node = doc.getElementsByTagName("root");
			final Element element = (Element) node.item(0);

			// System.out.println(element.get);
			abc.remove(0);
			for (final String str : abc) {
				final NodeList title = element.getElementsByTagName(str);
				final Element line = (Element) title.item(0);
				final String value = getCharacterDataFromElement(line);
				WebFileMap.put(str, value);

			}

			/*
			 * System.out.println(
			 * "===================*******************================================");
			 * System.out.println(WebFileMap);
			 * System.out.println(MainFileMap);
			 * 
			 * System.out.println(
			 * "===================*******************================================");
			 */

		} catch (final Exception e) {
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
		System.out.println("===============COMPARE==============");

		// compare Maps:
		int i = 0;
		final int j = 0;

		final List<String> mainKeyList = new ArrayList<String>();
		final Set<String> webKeyList = new HashSet<String>();

		for (final Entry main : MainFileMap.entrySet()) {

			mainKeyList.add((String) main.getKey());
			for (final Entry web : WebFileMap.entrySet()) {

				webKeyList.add((String) web.getKey());
				if (main.getKey().equals(web.getKey())) {

					if (!((String) main.getValue()).trim().equals(((String) web.getValue()).trim())) {
						i++;
						System.out.println(main.getKey() + "\n" + main.getValue() + "\n"
								+ ((String) web.getValue()).trim());
					}
					break;
				}
			}

		}
	}

	public static String getCharacterDataFromElement(final Element e) {
		final Node child = e.getFirstChild();
		if (child instanceof CharacterData) {
			final CharacterData cd = (CharacterData) child;
			return cd.getData();
		}
		return "";
	}

}