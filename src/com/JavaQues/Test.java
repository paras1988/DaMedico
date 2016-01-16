package com.JavaQues;


class Test
{
	public static void main(String[] args) throws Exception
	{
		int a=0;
		int b=1;
		try{
			fun();
		}
		catch(Exception e){
			System.out.println("asdfa");
		}


		System.out.println(a);
	}

	static int fun() throws Exception{

		throw new NullPointerException();

	}
}
