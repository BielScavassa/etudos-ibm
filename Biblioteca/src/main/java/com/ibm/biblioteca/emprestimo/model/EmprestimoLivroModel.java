package com.ibm.biblioteca.emprestimo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.ibm.biblioteca.livro.model.LivroModel;

@Entity
public class EmprestimoLivroModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@ManyToOne
	private LivroModel livro;
	@ManyToOne
	private EmprestimoModel emprestimo;
}
