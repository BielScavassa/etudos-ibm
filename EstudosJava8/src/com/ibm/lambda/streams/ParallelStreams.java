package com.ibm.lambda.streams;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.ibm.lambda.streams.models.Loja;

public class ParallelStreams {

	private void parallelStream(List<Loja> lojas) {

		Optional<Integer> somaFIliais = lojas.stream() // Ou parallelStream().
				.parallel()
				.filter(loja -> loja.getDono().getAtivo())
				.peek(loja -> System.out
				.printf("Nome Loja : %s (Nome da Thread: %s)", loja.getNomeLoja(), Thread.currentThread().getName()))
				.map(loja -> loja.getGerentes().size())
				.peek(loja -> System.out
						.printf("Nome da Thread Map: %s)", Thread.currentThread().getName()))
				.limit(2)
				.reduce(Integer::sum);

		System.out.println(somaFIliais);
	}

	public static void main(String[] args) throws IOException {
		ParallelStreams basics = new ParallelStreams();
		List<Loja> listLojas = Loja.criarListaLojas();

		basics.parallelStream(listLojas);

	}
}
