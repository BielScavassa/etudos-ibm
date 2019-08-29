package com.ibm.lambda.functionalinterface.models;

public class DummyFuncionario {

	private Integer nota;
	private String nome;
	private Boolean ativo;
	private DummyGerente gerente;

	public DummyFuncionario(Integer nota, String nome, Boolean ativo, DummyGerente gerente) {
		this.nota = nota;
		this.nome = nome;
		this.ativo = ativo;
		this.gerente = gerente;
	}

	public Integer getNota() {
		return nota;
	}

	public void setNota(Integer nota) {
		this.nota = nota;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public DummyGerente getGerente() {
		return gerente;
	}

	public void setGerente(DummyGerente gerente) {
		this.gerente = gerente;
	}

	@Override
	public String toString() {
		return "DummyFuncionario [nota=" + nota + ", nome=" + nome + ", ativo=" + ativo + ", gerente=" + gerente + "]";
	}

}
