package com.mywork;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
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

public class TeamsitePOC6 {

	public static void main(final String[] args) throws IOException {
		final List<String> mainKeyList = new ArrayList<String>();
		final Set<String> webKeyList = new HashSet<String>();
		int i = 0;
		final String constand = "psLbl";
		final String dir = "C:\\Users\\43901757\\Documents\\Defects\\CE-769 Teamsite Integration\\NEW TEAMSITE Excels\\New folder\\"
				+ constand + "\\";
		final String fileJS = dir + "JS_" + constand + ".txt";
		final String xmlFile = dir + constand + ".xml";
		final String TAG = constand;
		// TODO remove end lines from Js and add comma at the last code.
		final Map<String, String> map1 = getMapfromJS(dir, fileJS, TAG);
		final Map<String, String> map2 = getMapfromXML(xmlFile);

		for (final Entry<String, String> main : map1.entrySet()) {

			mainKeyList.add(main.getKey());
			for (final Entry<String, String> web : map2.entrySet()) {

				webKeyList.add(web.getKey());
				if (main.getKey().equals(web.getKey())) {

					if (!main.getValue().trim().equals(web.getValue().trim())) {
						i++;
						System.out.println(main.getKey() + "\n" + main.getValue() + "\n"
								+ web.getValue().trim());
					}
					break;
				}
			}

		}
		System.out.println("\n\n\n:::::\n" + "" + "\n\n\n:::::\n");
		for (final Entry<String, String> main : map1.entrySet()) {
			if (!map2.containsKey(main.getKey())) {
				System.out.println(main.getKey() + "\n" + main.getValue() + "\n" + "--");
			}
		}

		System.out.println("\n\n\n:::::\n" + "" + "\n\n\n:::::\n");
		for (final Entry<String, String> main : map2.entrySet()) {
			if (!map1.containsKey(main.getKey())) {
				System.out.println(main.getKey() + "\n" + main.getValue() + "\n" + "--");
			}
		}
	}

	static Map<String, String> getMapfromJS(final String dir, final String file2, final String TAG)
			throws IOException {

		/*
		 * File file = new File(dir + "temp.txt");
		 * file = removeSpecificLines(file2, file);
		 */

		final Map<String, String> MainFileMap = new HashMap<String, String>();
		final BufferedReader br = null;
		int count = 0;

		try {
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

		return MainFileMap;
	}

	private static File removeSpecificLines(final String inputFile, final File tempFile)
			throws IOException {

		final BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		final BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

		final List<String> linesToRemoveStartsWith = new ArrayList<String>();
		linesToRemoveStartsWith.add("//");
		linesToRemoveStartsWith.add("\'en");
		linesToRemoveStartsWith.add("}");
		linesToRemoveStartsWith.add("define");
		linesToRemoveStartsWith.add("root");

		Boolean flag = true;

		String currentLine;

		while ((currentLine = reader.readLine()) != null) {
			if (currentLine.trim().startsWith("psErr_ERRORCODE_SS0001")) {
				System.out.println("df");
			}
			// trim newline when comparing with lineToRemove
			final String trimmedLine = currentLine.trim();
			for (final String s : linesToRemoveStartsWith) {
				if (trimmedLine.startsWith(s)) {
					flag = false;
					break;
				}
			}
			if (flag) {
				writer.write(currentLine + System.getProperty("line.separator"));

			}
			flag = true;
		}
		writer.write(",");
		reader.close();
		return tempFile;
	}

	static Map<String, String> getMapfromXML(final String file2) {
		final Map<String, String> WebFileMap = new HashMap<String, String>();
		final BufferedReader br = null;
		try {

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
		return WebFileMap;
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
