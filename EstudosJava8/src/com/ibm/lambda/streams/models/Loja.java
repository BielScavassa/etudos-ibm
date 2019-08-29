package com.ibm.lambda.streams.models;

import java.util.ArrayList;
import java.util.List;

public class Loja {

	private String id;
	private String nomeLoja;
	private String cidade;
	private Integer flial;

	public Loja(String id, String nomeLoja, String cidade, Integer flial) {
		this.id = id;
		this.nomeLoja = nomeLoja;
		this.cidade = cidade;
		this.flial = flial;
	}



	public Loja(String nomeLoja, Integer flial) {
		this.nomeLoja = nomeLoja;
		this.flial = flial;
	}



	public static List<Loja> criarListaLojas() {
		List<Loja> listaVendas = new ArrayList<Loja>();
		for (int i = 0; i < 10; i++) {
			Loja loja = new Loja(String.valueOf(i), i);
			listaVendas.add(loja);
		}

		return listaVendas;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNomeLoja() {
		return nomeLoja;
	}

	public void setNomeLoja(String nomeLoja) {
		this.nomeLoja = nomeLoja;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Integer getFlial() {
		return flial;
	}

	public void setFlial(Integer flial) {
		this.flial = flial;
	}

	@Override
	public String toString() {
		return "Lojas [id=" + id + ", nomeLoja=" + nomeLoja + ", cidade=" + cidade + ", flial=" + flial + "]";
	}

}
