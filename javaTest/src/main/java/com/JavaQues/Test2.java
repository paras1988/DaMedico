package com.JavaQues;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
class Test2
{
	public static void main(String[] args) throws Exception
	{
		getMovieTitles("spiderman");
	}
	static String[] getMovieTitles(String substr){

		String[] str = new String[2];
		String inputFile = getOutput(substr,1);

		System.out.println(inputFile);

		return str;
	}

	static String getOutput(String str , int page){
		String output = "";

		try {
			StringBuilder stringBuilder = new StringBuilder("https://jsonmock.hackerrank.com/api/movies/search/?Title=");
			stringBuilder.append(str);
			stringBuilder.append("&page=");
			stringBuilder.append(Integer.toString(page));

			URL url = new URL(stringBuilder.toString());
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
					+ conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));

			//System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				//System.out.println(output);
				break;
			}
			conn.disconnect();
		}
		catch (Exception e){

		}

		return output;
	}


}
