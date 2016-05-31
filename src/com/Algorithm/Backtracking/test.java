package com.Algorithm.Backtracking;

import java.lang.reflect.Constructor;

public class test {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws Exception{
		teste e=new teste();
		boolean res=false;
		try{
			res=e.throwCustomException();
		}
		catch(CustomException ce){
			res=true;
		}
		if(res){
			Class c=Class.forName("com.Algorithm.Backtracking.CustomException");
			Constructor cd=c.getConstructor(String.class);
			Object o=cd.newInstance("CustomException");
			if(o instanceof Exception){
				res=true;
			}
			else{
				res=false;
			}
		}

	}

}

class CustomException extends Exception{
	CustomException(String s) {
		super(s);
	}
}

class teste{
	public boolean throwCustomException() throws CustomException{

		return true;
	}
}