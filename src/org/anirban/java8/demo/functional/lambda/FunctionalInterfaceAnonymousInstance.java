package org.anirban.java8.demo.functional.lambda;
	 
@FunctionalInterface  
interface AddInterface{  
    void add(int a, int b);  
}  
 
public class FunctionalInterfaceAnonymousInstance 
{
	public static void main(String args[])
	{
		//without lambda expression, AddInterface implementation using anonymous class
		AddInterface addInterface = new AddInterface()
			{  
				public void add(int a, int b) {
						System.out.println(a + b);				
				} 
			};
		addInterface.add(10, 20);  
	}
}