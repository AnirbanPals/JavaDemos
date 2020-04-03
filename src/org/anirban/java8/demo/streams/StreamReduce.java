package org.anirban.java8.demo.streams;

import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.Arrays;
import java.util.OptionalDouble;

public class StreamReduce {
	public static void main(String[] args) {

		int sum = Stream.of(1, 2, 3, 4, 5).reduce(0, (acc, i) -> acc + i);
		System.out.println(sum);

		int sum2 = IntStream.rangeClosed(1, 5).sum();
		System.out.println(sum2);

		int mult = IntStream.rangeClosed(1, 5).reduce(1, (acc, i) -> acc * i);
		System.out.println(mult);
		
        int vals[] = { 2, 4, 6, 8, 10, 12, 14, 16 };
		        
        OptionalDouble avg = Arrays.stream(vals).average();
		System.out.printf("The sum of values: %lf%n", avg.getAsDouble());
		        
		long n = Arrays.stream(vals).count();
		System.out.printf("The number of values: %d%n", n);        
	}
}