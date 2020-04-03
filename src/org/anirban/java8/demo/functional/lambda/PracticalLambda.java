package org.anirban.java8.demo.functional.lambda;

import java.util.ArrayList;
import java.util.List;

@FunctionalInterface  
interface HelloWorld 
{
	String sayHello(String name);
}  

public class PracticalLambda 
{
	public static void main(String args[])
	{
		HelloWorld helloWorld = (String name) -> { return "Namaste! " + name; };
		System.out.println(helloWorld.sayHello("Jai Hind!"));
		anotherMethod();
		complicateLambda();
	}
	
	public static void anotherMethod()
	{
		List<String> list = new ArrayList<String>();  
        list.add("Anirban");  
        list.add("Vivek");  
        list.add("Mahesh");  
        list.add("Subarna");  
        list.add("Satya");  
        list.add("Rudra");  
        list.add("Vikas"); 
        list.add("Ruslan"); 
 
        list.forEach(  
            (name)->System.out.println(name)  
        );  
	}
	
	public static void complicateLambda()
	{
		HelloWorld helloWorld = (message) -> {
			String str1 = "Hello ";  
            String str2 = str1 + message;   
            String returnValue = strrev(str2);
            String ret = fastrev(returnValue, 0, returnValue.length()-1);
            return ret;
		};
		System.out.println(helloWorld.sayHello("Anirban Pal"));
	}
	
	
	// Both versions of Strrev below are buggy for higher surrogate pairs in UTF 16 or UTF 32 strings
	// However they are good for the standard 65535 characters...
	private static String strrev(String s)
	{
		char[] chars = s.toCharArray();
		int len=s.length();
		char temp;
		System.out.println(chars);
		for (int i=len;i>len/2;i--)
		{
			temp=chars[i-1];
			chars[i-1]=chars[len-i];
			chars[len-i]=temp;
		}
		return String.copyValueOf(chars);
	}
	
	private static String fastrev(String input, int start, int end)
	{
	    char[] str = input.toCharArray();
		// Iterate loop upto start not equal to end 
	    while (start < end) 
	    { 
	        // XOR for swapping the variable 
	        str[start] ^= str[end]; 
	        str[end] ^= str[start]; 
	        str[start] ^= str[end]; 
	  
	        ++start; 
	        --end; 
	    } 
	    return String.valueOf(str); 		
	}
}