package org.anirban.java8.demo.streams;

import java.util.Arrays;
import java.util.List;

public class StreamFilter {
	public static void main(String[] args) {

		List<String> programmingLanguages = Arrays.asList("c#", "java", "python", "scala");
		String exemptedLanguages="";
		
        // old way
        for (String lang : programmingLanguages) {
        	System.out.println("Languages with 'A'");
            if (lang.contains("a")) {
                System.out.print(lang + ", ");
            }
            else
            {
            	exemptedLanguages += lang + ";" ;
            }
        }
        System.out.println("Other Languages \n" + exemptedLanguages);

        System.out.println();

        // new way
        programmingLanguages.stream()
                .filter(lang -> lang.contains("a"))
                .forEach(lang -> System.out.println(lang));
	}
}