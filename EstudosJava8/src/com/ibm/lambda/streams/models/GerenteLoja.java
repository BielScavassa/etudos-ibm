package com.ibm.lambda.streams.models;

public class GerenteLoja {

	private String nome;
	private Integer idade;
	private Boolean ativo;

	public GerenteLoja(String nome, Boolean ativo) {
		this.nome = nome;
		this.ativo = ativo;
	}

	public GerenteLoja(String nome, Integer idade, Boolean ativo) {
		this.nome = nome;
		this.idade = idade;
		this.ativo = ativo;
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

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	@Override
	public String toString() {
		return "GerenteLoja [nome=" + nome + ", idade=" + idade + ", ativo=" + ativo + "]";
	}

}
