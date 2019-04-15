package com.ibm.biblioteca.livro.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.ibm.biblioteca.emprestimo.model.EmprestimoLivroModel;
import com.ibm.biblioteca.sessao.model.SessaoModel;

@Entity
public class LivroModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	private String autor;
	@ManyToOne
	private SessaoModel sessao; 
	@OneToMany
	private List<EmprestimoLivroModel> emprestimoLivro;
	
	public LivroModel(Long id, String nome, String autor) {
		this.id = id;
		this.nome = nome;
		this.autor = autor;
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
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
}
