package com.ibm.biblioteca.emprestimo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ibm.biblioteca.emprestimo.model.EmprestimoModel;
import com.ibm.biblioteca.emprestimo.repository.EmprestimoRepository;

@Component
public class EmprestimoServiceImpl implements EmprestimoService {

	@Autowired
	EmprestimoRepository emprestimoRepository;
	
	@Override
	public List<EmprestimoModel> findAll() {
		return emprestimoRepository.findAll();
	}

	@Override
	public EmprestimoModel save(EmprestimoModel emprestimo) {
		return emprestimoRepository.save(emprestimo);
	}

	@Override
	public void deleteById(Long id) {
		emprestimoRepository.deleteById(id);
	}

}
