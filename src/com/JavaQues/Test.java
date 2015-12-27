package com.JavaQues;


class Test
{
	public static void main(String[] args)
	{
		Test obj = new Test()
		{
			@Override
			public int hashCode()
			{
				return 40;
			}
		};
		System.out.println(obj.hashCode());
	}
}