package com.ibm.biblioteca.sessao.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.ibm.biblioteca.livro.model.LivroModel;

@Entity
public class SessaoModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String Genero;
	@OneToMany
	private List<LivroModel> livros;
	
	public SessaoModel(Long id, String genero) {
		this.id = id;
		Genero = genero;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getGenero() {
		return Genero;
	}
	public void setGenero(String genero) {
		Genero = genero;
	}
	
}
