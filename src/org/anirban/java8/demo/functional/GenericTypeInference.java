package org.anirban.java8.demo.functional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GenericTypeInference{
	public static void main(String[] args) {
		// ----------------------------------------------------------
		// generics instantiation
		// Java 5 and 6:
		Set<String> java5and6 = new HashSet<String>(new ArrayList<String>());

		// Java 7:
		Set<String> java7 = new HashSet<>(new ArrayList<String>());

		// Java 8
		Set<String> java8 = new HashSet<>(new ArrayList<>());
		// ----------------------------------------------------------
		// generic methods
		// Java 5-7
		printList(Collections.<String>emptyList());

		// Java 8
		printList(Collections.emptyList());

	}

	public static void printList(List<String> list) {
		System.out.println(list);
	}
}