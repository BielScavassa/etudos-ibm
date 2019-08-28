package com.ibm.lambda.functionalinterface;

public class DummyClassForTest implements DummyFunctionalInterface{

	private String id;
	private Integer nota;
	private String nome;
	private Boolean ativo;
	private Boolean vip;

	public DummyClassForTest(String id, Integer nota, String nome, Boolean ativo, Boolean vip) {
		this.id = id;
		this.nota = nota;
		this.nome = nome;
		this.ativo = ativo;
		this.vip = vip;
	}
	
	public DummyClassForTest(String nome) {
		this.nome = nome;
	}

	@Override
	public String printName(DummyClassForTest dummy) {
		return null;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public Boolean getVip() {
		return vip;
	}

	public void setVip(Boolean vip) {
		this.vip = vip;
	}

	@Override
	public String toString() {
		return "DummyForTest [id=" + id + ", nota=" + nota + ", nome=" + nome + ", ativo=" + ativo + ", vip=" + vip
				+ "]";
	}
}
