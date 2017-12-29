package com.JavaQues;


public class InterfaceAnnotation {
	
	public static void main(String[] args) {
		
		String primaryCountryCode="CN";
		String beneficiaryCountryCode="CN";
		if (primaryCountryCode == "CN" && beneficiaryCountryCode == "CN" 
				|| primaryCountryCode == "KR" && beneficiaryCountryCode == "KR" )
		{
			System.out.println("df");
		}
		else{
			System.out.println("dfd");
		}
		
			/*Class<ImplementsHelloTest> obj=ImplementsHelloTest.class;
		
		for(Field f:obj.getDeclaredFields()){
			
			if (f.isAnnotationPresent(HelloWorldtest.class)) {
			System.out.println("abvcv");
			}
		}
		for(Method method:obj.getDeclaredMethods()){
			
			if (method.isAnnotationPresent(HelloWorldtest.class)) {
				System.out.println("abvcv");
			}
		}*/
	}
}


@interface HelloWorldtest { 
	public String sayHello() default "hello world";

}
/*
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface HelloWorldMthod { 
	public String sayHello() default "hello world";

}
*/
class ImplementsHelloTest{
	
	@HelloWorldtest(sayHello="Hi")
	private static String abc;
	
/*	@HelloWorldtest(sayHello="Hi")
	private void fun(){}*/
}