package com.ibm.biblioteca.livro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ibm.biblioteca.livro.model.LivroModel;
import com.ibm.biblioteca.livro.repository.LivroRepository;

public class LivroServiceImpl implements LivroService{

	@Autowired
	LivroRepository livroRepository;
	
	@Override
	public List<LivroModel> findAll() {
		return livroRepository.findAll();
	}

	@Override
	public LivroModel save(LivroModel livro) {
		return livroRepository.save(livro);
	}

	@Override
	public void deleteById(Long id) {
		livroRepository.deleteById(id);
	}

}
