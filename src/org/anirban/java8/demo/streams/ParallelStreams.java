package org.anirban.java8.demo.streams;

import java.math.BigInteger;

import java.util.stream.IntStream;

public class ParallelStreams {
	public static BigInteger bigFactorialIteration(int n) {

		BigInteger result = BigInteger.ONE;
		for (int i = 1; i <= n; i++) {
			result = result.multiply(BigInteger.valueOf(i));
		}
        return result;
	}

	public static BigInteger bigFactorialSequentialStream(int n) {
        return IntStream.rangeClosed(1, n)
            	.mapToObj(i -> BigInteger.valueOf(i))
            	.reduce(BigInteger.ONE, (a, b) -> a.multiply(b));
	}

	public static BigInteger bigFactorialParallelStream(int n) {
        return IntStream.rangeClosed(1, n)
        		.parallel()
            	.mapToObj(i -> BigInteger.valueOf(i))
            	.reduce(BigInteger.ONE, (a, b) -> a.multiply(b));
	}

	public static void time(String name, Runnable task) {
		long t1 = System.currentTimeMillis();
		task.run();
		long t2 = System.currentTimeMillis();

		System.out.println(name + ": " + (t2 - t1) + " ms");
	}

	public static void main(String[] args) {
        int n = 50000;
        time("iteration", () -> bigFactorialIteration(n));
        time("sequential stream", () -> bigFactorialSequentialStream(n));
        time("parallel stream", () -> bigFactorialParallelStream(n));
	}
}