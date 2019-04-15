package com.ibm.biblioteca.livro.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ibm.biblioteca.livro.model.LivroModel;

public interface LivroRepository extends CrudRepository<LivroModel, Long>{
	 List<LivroModel> findAll();
	 LivroModel save(LivroModel livro);
	 void deleteById(Long id);
}
