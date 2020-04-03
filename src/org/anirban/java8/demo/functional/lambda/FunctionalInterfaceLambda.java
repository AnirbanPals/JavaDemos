package org.anirban.java8.demo.functional.lambda;

/**
// Note: Changed name for avoiding name-space clash. Since Code is same - commented below/reduce REDUNDANCY 
// Same interface as AddInterface in  FunctionalInterfaceAnonymousInstance.java
 * 
@FunctionalInterface  
interface SimpleAddInterface 
{  
	void add(int a, int b);  
} 
*/

public class FunctionalInterfaceLambda 
{	 
	public static void main(String args[])
	{
		//Using lambda expressions
		AddInterface addInterface = (a, b)-> {
			 System.out.println(a + b);				 
		};

		// The lambda above compiles because the AddInterface used in the lambda,
		// comes from an entirely different file viz. FunctionalInterfaceAnonymousInstance.java
		// in the same package. A very bad practice...to search for files. (default package scope visible)
		// Ideally should have been declared in a file of its own name
		addInterface.add(10, 20);  
	}
}