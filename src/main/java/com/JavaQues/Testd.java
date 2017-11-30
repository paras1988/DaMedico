package com.JavaQues;

/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;


class TestClass {
	public static void main(String args[] ) throws Exception {
		/*
		 * Read input from stdin and provide input before running
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int size = Integer.parseInt(line);
		int[] arr = new int[size];
		String arrayElements = br.readLine();
		String elements [] = arrayElements.split(" ");
		populateArrayElements(elements, size, arr);
		int numberOfQueries = Integer.parseInt(br.readLine());
		String[] strArray=new String[numberOfQueries];

		for (int i = 0; i < numberOfQueries; i++) {
			String query = br.readLine();
			strArray[i]=query;
		}
		fun(arr,strArray);

	}
	private static void fun(int[] arr, String[] strArray) {

		int max=0;
		for(int i=0;i<arr.length;i++){
			if(arr[i]>max){
				max=arr[i];
			}
		}
		Map<Integer,Integer> f=new HashMap<Integer,Integer>();

		for(int i=0;i<arr.length;i++){

			if(f.get(arr[i])==null){
				f.put(arr[i],applyFunctionToCalculateGCD(arr[i]));
			}
		}
		for(String str:strArray){
			final String queryDetails[] = str.split(" ");
			if ("C".equals(queryDetails[0])) {
				int source = Integer.parseInt(queryDetails[1]);
				int destination = Integer.parseInt(queryDetails[2]);
				if(source>destination){
					int temp=source;
					source=destination;
					destination=temp;
				}

				int res=0;
				for(int i=source;i<=destination;i++){
					res +=f.get(arr[i-1]);
				}
				System.out.println(res);

			} else if ("U".equals(queryDetails[0])) {
				int index = Integer.parseInt(queryDetails[1]);
				int value = Integer.parseInt(queryDetails[2]);
				f.put(value, applyFunctionToCalculateGCD(value));
				arr[index - 1] = value;
			}
		}
	}


	private static int applyFunctionToCalculateGCD(final int number) {
		int sum = 0;
		for (int i = 1; i <= number; i++) {
			sum += findGCD(i, number);
		}
		return sum;
	}

	private static int findGCD(final int a, final int b) {
		if(b == 0) {
			return a;
		}
		return findGCD(b, a % b);
	}


	private static void populateArrayElements(String[] elements, int size, int arr[]) {
		for (int i = 0; i < size; i++) {
			arr[i] = Integer.parseInt(elements[i]);
		}
	}
}
