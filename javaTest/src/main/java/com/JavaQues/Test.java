package com.JavaQues;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
public class Test {

	public static void main(String[] args) {

		int count = 20;
		while (true){
            int[] memoryFillIntVar = new int[count];
            count = count*5;
            System.out.println(count);
		}

	}

	public static Date getDate(String date, String dateFormat) {
		SimpleDateFormat fmt = new SimpleDateFormat(dateFormat);
		try {
			return fmt.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

    public void generateOOM() throws Exception {
        int count = 20;
        System.out.println("\n=================> OOM test started..\n");
        for (int outerIterator = 1; outerIterator < 20; outerIterator++) {
            System.out.println("Iteration " + outerIterator + " Free Mem: " + Runtime.getRuntime().freeMemory());
            int loop1 = 2;
            int[] memoryFillIntVar = new int[count];
            do {
                memoryFillIntVar[loop1] = 0;
                loop1--;
            } while (loop1 > 0);
            count = count * 5;
            System.out.println("\nRequired Memory for next loop: " + count);
            Thread.sleep(1000);
        }
    }
}