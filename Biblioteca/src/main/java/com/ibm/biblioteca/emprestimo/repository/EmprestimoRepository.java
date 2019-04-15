package com.ibm.biblioteca.emprestimo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ibm.biblioteca.emprestimo.model.EmprestimoModel;

@Repository
public interface EmprestimoRepository extends CrudRepository<EmprestimoModel, Long>{
	 List<EmprestimoModel> findAll();
	 EmprestimoModel save(EmprestimoModel emprestimo);
	 void deleteById(Long id);
}
