package com.ibm.lambda.streams;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.ibm.lambda.streams.models.Loja;

public class GroupingStreams {

	//Group by 	
	private void groupingByFilial(List<Loja> listaLojas) {
		Map<Integer, List<Loja>> lojaFilial = listaLojas.stream()
				.collect(Collectors.groupingBy(loja -> loja.getFlial()));// ou .collect(Collectors.groupingBy(Loja::getFilial));
		
		System.out.println(lojaFilial);
	}
	
	//Multi level group by
	private void groupingByFilialAndNome(List<Loja> listaLojas) {
		Map<Integer, Map<String, List<Loja>>> lojaFilial = listaLojas.stream()
				.collect(Collectors.groupingBy((Loja::getFlial), Collectors.groupingBy(Loja::getNomeLoja)));
		
		System.out.println(lojaFilial);
	}

	public static void main(String[] args) throws IOException {
		GroupingStreams basics = new GroupingStreams();
		List<Loja> listLojas = Loja.criarListaLojas();

		basics.groupingByFilial(listLojas);
		basics.groupingByFilialAndNome(listLojas);

	}
}