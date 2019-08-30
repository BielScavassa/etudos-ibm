package com.ibm.lambda.streams;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import com.ibm.lambda.streams.models.GerenteLoja;
import com.ibm.lambda.streams.models.Loja;

public class FlatMapStreams {

	String[] frutas = new String[] { "Banana", "Mamao", "Morango" };
	String[] vegetais = new String[] { "feijao", "Alface", "Acelga" };

	private void flatMapping(List<Loja> listLojas) {
		Stream<GerenteLoja> stringStream = listLojas.stream().flatMap(loja -> loja.getGerentes().stream());

		stringStream.forEach(System.out::println);
	}

	private void flatMapVegetaisFrutas() {
		Stream<List<String>> frutasVegetais = Stream.of(Arrays.asList(frutas), Arrays.asList(vegetais));

		frutasVegetais.flatMap(mapper -> mapper.stream()).forEach(System.out::println);
	}

	public static void main(String[] args) throws IOException {
		FlatMapStreams basics = new FlatMapStreams();
		List<Loja> listLojas = Loja.criarListaLojas();

		basics.flatMapping(listLojas);
		basics.flatMapVegetaisFrutas();
	}
}
