package com.ibm.biblioteca.livro.service;

import java.util.List;

import com.ibm.biblioteca.livro.model.LivroModel;

public interface LivroService {
	 List<LivroModel> findAll();
	 LivroModel save(LivroModel livro);
	 void deleteById(Long id);
}
