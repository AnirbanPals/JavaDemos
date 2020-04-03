package org.anirban.java8.demo.functional;

@FunctionalInterface  
interface AddInterface{  
    void add(int a, int b);  
}  
 
public class TrivialFunctionalInterfaceExample implements AddInterface 
{
	public void add(int a, int b){  
        System.out.println(a+b);  
    } 
	public static void main(String args[]){
		TrivialFunctionalInterfaceExample fie = new TrivialFunctionalInterfaceExample();  
        fie.add(10, 20);  
	}
}