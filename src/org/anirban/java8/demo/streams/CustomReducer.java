package org.anirban.java8.demo.streams;

import java.util.stream.IntStream;

import org.anirban.java8.demo.model.Employee;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CustomReducer {

	private static class MyUtil {
		public static int add2Ints(int num1, int num2) {
			return num1 + num2;
		}
	}

	public static void main(String[] args) {

		IntStream.range(1, 10).reduce((x, y) -> x + y).ifPresent(s -> System.out.println(s));
		IntStream.range(1, 10).reduce(Integer::sum).ifPresent(s -> System.out.println(s));
		IntStream.range(1, 10).reduce(MyUtil::add2Ints).ifPresent(s -> System.out.println(s));

		anotherReducer();
	}

	public static void anotherReducer() {

		List<Employee> users = new ArrayList<>();
		users.add(new Employee("Frank", LocalDate.of(1979, 11, 23)));
		users.add(new Employee("Peter", LocalDate.of(1985, 1, 18)));
		users.add(new Employee("Lucy", LocalDate.of(2002, 5, 14)));
		users.add(new Employee("Albert", LocalDate.of(1996, 8, 30)));
		users.add(new Employee("Frank", LocalDate.of(1967, 10, 6)));

		int maxAge = users.stream().mapToInt(Employee::getAge)
						.reduce(0, (a1, a2) -> a1 > a2 ? a1 : a2);

		System.out.printf("The oldest employee's age: %s%n", maxAge);
	}

}
