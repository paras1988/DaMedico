package com.JavaQues.tests;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Test;

import com.JavaQues.QuinTypeBackendTaxiProblem;

public class QuinTypeBackendTaxiProblemTest {

	@Test
	public void generalCase(){
		int numberOfTaxi=5;

		Map<Integer,Integer> iMap=new LinkedHashMap<>();
		iMap.put(1,10);
		iMap.put(5,15);
		iMap.put(30,40);
		iMap.put(35,2);
		iMap.put(40,10);
		iMap.put(100,10);

		ArrayList<Integer> res=QuinTypeBackendTaxiProblem.getIndexOfTaxiAlloted(iMap,numberOfTaxi);

		printArrayList(res,"generalCase");
	}

	@Test
	public void generalWhenTaxisHaveGotFull(){
		int numberOfTaxi=2;

		Map<Integer,Integer> iMap=new LinkedHashMap<>();
		iMap.put(1,100);
		iMap.put(5,150);
		iMap.put(30,400);
		iMap.put(35,200);

		ArrayList<Integer> res=QuinTypeBackendTaxiProblem.getIndexOfTaxiAlloted(iMap,numberOfTaxi);

		printArrayList(res,"generalWhenTaxisHaveGotFull");
	}

	@Test
	public void generalWhenZeroTaxiThere(){
		int numberOfTaxi=0;

		Map<Integer,Integer> iMap=new LinkedHashMap<>();
		iMap.put(1,100);
		iMap.put(5,150);
		iMap.put(30,400);
		iMap.put(35,200);

		ArrayList<Integer> res=QuinTypeBackendTaxiProblem.getIndexOfTaxiAlloted(iMap,numberOfTaxi);

		printArrayList(res,"generalWhenZeroTaxiThere");
	}

	private void printArrayList(ArrayList<Integer> res,String str) {
		System.out.print(str+"::");
		for(int i=0;i<res.size();i++){
			System.out.print(res.get(i));
		}

		System.out.println();

	}
}