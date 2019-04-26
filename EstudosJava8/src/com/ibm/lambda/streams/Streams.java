package com.ibm.lambda.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Streams {

	static public void intStreamRange() {
		IntStream.range(1, 10).forEach(System.out::print);
	}

	static public void intStreamWithSkip() {
		IntStream.range(1, 10).skip(5).forEach(System.out::print);
	}

	static public void intStreamWithSum() {
		System.out.println(IntStream.range(1, 10).sum());
	}

	static public void streamOfSorted() {
		Stream.of("Antonio", "Chirley", "Amoedo", "Edson").sorted().findFirst().ifPresent(System.out::print);
	}

	static public void arrayStreamFilter() {
		String[] names = { "Antonio", "Chirley", "Amoedo", "Edson", "Marley", "Jadson", "Valira", "Garosh", "Jaina",
				"Ratson", "Kain", "Shiva" };

		Arrays.stream(names).filter(x -> x.startsWith("A")).sorted().forEach(System.out::println);
	}

	static public void arrayMapAverage() {
		Arrays.stream(new int[] { 2, 4, 6, 8, 10, 12, 15 }).map(x -> x * x).average().ifPresent(System.out::println);
	}

	static public void listStreamFilter() {
		List<String> namesList = Arrays.asList("Antonio", "Chirley", "Amoedo", "Edson", "Marley", "Jadson", "Valira",
				"Garosh", "Jaina", "Ratson", "Kain", "Shiva");

		namesList.stream().map(String::toLowerCase).filter(x -> x.startsWith("a")).forEach(System.out::println);
	}

	static public void listStreamCollectors() {
		List<String> namesList = Arrays.asList("Antonio", "Chirley", "Amoedo", "Edson", "Marley", "Jadson", "Valira",
				"Garosh", "Jaina", "Ratson", "Kain", "Shiva");
		List<String> namesWithI = namesList.stream().filter(x -> x.contains("i")).collect(Collectors.toList());

		namesWithI.forEach(System.out::println);
	}

	static public void streamRowsCount() throws IOException {
		Stream<String> rows = Files
				.lines(Paths.get("C:\\Etudos-IBM\\EstudosJava8\\bin\\com\\ibm\\lambda\\texts\\Data.txt"));
		int rowCount = (int) rows.map(x -> x.split(",")).filter(x -> x.length == 3).count();

		System.out.println(rowCount + " Rows");
		rows.close();
	}

	static public void streamRowsParse() throws IOException {
		Stream<String> rows = Files
				.lines(Paths.get("C:\\Etudos-IBM\\EstudosJava8\\bin\\com\\ibm\\lambda\\texts\\Data.txt"));

		rows.map(x -> x.split(",")).filter(x -> x.length == 3).filter(x -> Integer.parseInt(x[1]) > 15)
				.forEach(x -> System.out.println(x[0] + " " + x[1] + " " + x[2]));
		rows.close();
	}

	static public void streamRowsHasMap() throws IOException {
		Stream<String> rows = Files
				.lines(Paths.get("C:\\Etudos-IBM\\EstudosJava8\\bin\\com\\ibm\\lambda\\texts\\Data.txt"));
		Map<String, Integer> map = new HashMap<>();

		map = rows.map(x -> x.split(",")).filter(x -> x.length == 3).filter(x -> Integer.parseInt(x[1]) > 15)
				.collect(Collectors.toMap(x -> x[0], x -> Integer.parseInt(x[1])));
		rows.close();
		for(String key : map.keySet()) {
			System.out.println(key + " " + map.get(key));
		}

	}
}
