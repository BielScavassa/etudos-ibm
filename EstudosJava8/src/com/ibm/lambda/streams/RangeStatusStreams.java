package com.ibm.lambda.streams;

import java.io.IOException;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;

import com.ibm.lambda.streams.models.Loja;

public class RangeStatusStreams {

	IntStream streamOfInts = IntStream.range(1, 100);

	private void range() {
		IntStream ints = IntStream.range(1, 10);
		IntStream intsClosed = IntStream.rangeClosed(1, 10);
		
		ints.forEach(System.out::println);
		System.out.println("-------------");
		intsClosed.forEach(System.out::println);

	}
	
	private void testMaxAndMin() {
		IntStream intsClosed = IntStream.rangeClosed(1, 10);
		OptionalInt max = intsClosed.max();
		
		System.out.println("-------------");
		System.out.println("Max: " + max.getAsInt());
		
		intsClosed = IntStream.rangeClosed(1, 10);
		OptionalInt min = intsClosed.min();
		System.out.println("-------------");
		System.out.println("Min: " + min.getAsInt());
		
		intsClosed = IntStream.rangeClosed(1, 10);
		OptionalDouble avg = intsClosed.average();
		System.out.println("-------------");
		System.out.println("Avg: " + avg.getAsDouble());
		
	}

	public static void main(String[] args) throws IOException {
		RangeStatusStreams basics = new RangeStatusStreams();

		basics.range();
		basics.testMaxAndMin();
	}
}
