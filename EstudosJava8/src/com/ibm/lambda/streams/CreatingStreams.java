package com.ibm.lambda.streams;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

import com.ibm.lambda.streams.models.Loja;

public class CreatingStreams {

	//From Collections
	private void testCollectionStreams() {
		List<Loja> lojas = Loja.criarListaLojas();
		
		lojas.stream().forEach(System.out::println);
	}
	
	//Empty stream
	private void testEmptyStreams() {
		Stream<Loja> lojas = Stream.empty();
		System.out.println("Empty: " + lojas.count());
	}
	
	//From values/array
	private void testStreamsFromValues() {
		String [] nomesLojas = {"Magazine", "Dell", "Cybelar"};
		Stream<String> nomeLojas2 = Stream.of("Magazine", "Dell", "Cybelar");
		
		Stream<String> streamNomesLojas2 = Stream.of(nomesLojas);
		
		System.out.println("Qtd Lojas: " + nomeLojas2.count());
		System.out.println("Qtd Lojas Obj: " + streamNomesLojas2.count());
	}
	
	//Generate iterate stream
	
	public void testGenerateIterateStreams() {
		Stream<Double> randomStream = Stream.generate(Math::random).limit(3);
		randomStream.forEach(System.out::println);
		
		Stream<Integer> iterateNumbers = Stream.iterate(1, i -> i+1).limit(3);
		iterateNumbers.forEach(System.out::println);
	}
	
	public static void main(String[] args) throws IOException {
		CreatingStreams basics = new CreatingStreams();
		
		basics.testEmptyStreams();
		basics.testStreamsFromValues();
		basics.testCollectionStreams();
		basics.testGenerateIterateStreams();
		
	}
	
}
