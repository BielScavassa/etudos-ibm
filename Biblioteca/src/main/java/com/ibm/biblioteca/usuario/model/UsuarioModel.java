package com.ibm.biblioteca.usuario.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.ibm.biblioteca.emprestimo.model.EmprestimoModel;

@Entity
public class UsuarioModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	private String cpf;
	private int idade;
	@OneToMany
	private List<EmprestimoModel> emprestimos;
	
	public UsuarioModel(Long id, String nome, String cpf, int idade) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.idade = idade;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
}
