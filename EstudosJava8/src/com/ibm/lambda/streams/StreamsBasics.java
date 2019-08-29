package com.ibm.lambda.streams;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import com.ibm.lambda.streams.models.Loja;

public class StreamsBasics {

	private void findTresPrimeirasFiliais(List<Loja> lojas) {
		List<Loja> tresPrimeirasLojas = lojas.stream().filter(loja -> loja.getFlial() < 3)
				.collect(Collectors.toList());
		
		System.out.println("Tres primeiras lojas: " + tresPrimeirasLojas);
	}
	
	private void findLojaByNome(String nome) {
		List<Loja> lojas = Loja.criarListaLojas();
		
		lojas.stream()
				.filter(loja -> loja.getNomeLoja().equals(nome) ? true : false)
				.map(Loja::getNomeLoja)
				.limit(3)
				.distinct()
				.forEach(System.out::println);
	}
	
	public static void main(String[] args) throws IOException {
		StreamsBasics basics = new StreamsBasics();
		List<Loja> lojas = Loja.criarListaLojas();
		
		basics.findTresPrimeirasFiliais(lojas);
		basics.findLojaByNome("2");
	}

}
