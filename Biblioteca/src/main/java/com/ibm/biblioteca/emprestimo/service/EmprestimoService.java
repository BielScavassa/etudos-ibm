package com.ibm.biblioteca.emprestimo.service;

import java.util.List;

import org.jvnet.hk2.annotations.Service;

import com.ibm.biblioteca.emprestimo.model.EmprestimoModel;

public interface EmprestimoService {
	 List<EmprestimoModel> findAll();
	 EmprestimoModel save(EmprestimoModel emprestimo);
	 void deleteById(Long id);

}
