package org.anirban.java8.demo.functional;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class PatternAsPredicate {
	public static void main(String[] args) {
		List<String> progLangs = Arrays.asList("c#", "java", "python", "scala");
		Pattern p = Pattern.compile("a.a");

		// old way
		for (String lang : progLangs) {
			if (p.matcher(lang).find()) {
				System.out.println(lang);
			}
		}

		// new way
		progLangs.stream()
				.filter(p.asPredicate())
				.forEach(System.out::println);
	}
}