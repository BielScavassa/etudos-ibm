package com.ibm.lambda.streams.models;

public class GerenteLoja {

	private String nome;
	private Integer idade;

	public GerenteLoja(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	@Override
	public String toString() {
		return "GerenteLoja [nome=" + nome + ", idade=" + idade + "]";
	}

}
