package org.anirban.java8.demo.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamStringFiltering {

	public static void main(String[] args) {

		List<String> words = Arrays.asList("penitent", "bat", "customary", "queue", "orphanages",
				"floccinauccinihilipilification", "gypsy", "pneumomonoultramicroscopicsilicovolcanoconiosis",
				"deforestation", "bubble", "cat", "butterfly");

		List<String> result = words.stream().filter(word -> word.length() > 5)
				.collect(Collectors.toList());

		result.forEach(word -> System.out.println(word));
	}
}