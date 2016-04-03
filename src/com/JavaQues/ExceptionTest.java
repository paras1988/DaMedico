package com.JavaQues;

public class ExceptionTest {
	public static void main(String[] args) {
		System.out.println(fun());
	}

	private static int fun() {
		int a=0;
		try{
			a=2+2+3;
			if(a!=0){
				throw new Exception();
			}
			return 2;
		}
		catch(Exception e){
			return 22;
		}
		finally{
			return 32;
		}
	}
}
