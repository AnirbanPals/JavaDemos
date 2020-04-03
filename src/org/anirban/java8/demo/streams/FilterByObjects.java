package org.anirban.java8.demo.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.anirban.java8.demo.model.NewUser;

public class FilterByObjects {

	public static void main(String[] args) {

		List<NewUser> persons = Arrays.asList(new NewUser("Jack", "jack234@gmail.com"),
				new NewUser("Peter", "pete2@post.com"), new NewUser("Lucy", "lucy17@gmail.com"),
				new NewUser("Robert", "bob56@post.com"), new NewUser("Martin", "mato4@imail.com"));

		List<NewUser> result = persons.stream()
							.filter(person -> person.getEmail().matches(".*post\\.com"))
								.collect(Collectors.toList());

		result.forEach(p -> System.out.println(p.getName()));
	}
}