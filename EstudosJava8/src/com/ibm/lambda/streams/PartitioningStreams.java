package com.ibm.lambda.streams;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.ibm.lambda.streams.models.Loja;

public class PartitioningStreams {

	private void partitionByFilial(List<Loja> listaLoja) {
		Map<Boolean, List<Loja>> lojaPrimeiraFilial = listaLoja.stream()
				.collect(Collectors.partitioningBy(loja -> loja.getFlial() == 0));

		System.out.println(lojaPrimeiraFilial);
	}

	private void partitionByFilialAndGrouping(List<Loja> listaLoja) {
		Map<Boolean, Map<String, List<Loja>>> lojaPrimeiraFilial = listaLoja.stream().collect(
				Collectors.partitioningBy((loja -> loja.getFlial() == 0), Collectors.groupingBy(Loja::getNomeLoja)));

		System.out.println(lojaPrimeiraFilial);
	}

	public static void main(String[] args) throws IOException {
		PartitioningStreams basics = new PartitioningStreams();
		List<Loja> listLojas = Loja.criarListaLojas();

		basics.partitionByFilial(listLojas);
		basics.partitionByFilialAndGrouping(listLojas);

	}
}
