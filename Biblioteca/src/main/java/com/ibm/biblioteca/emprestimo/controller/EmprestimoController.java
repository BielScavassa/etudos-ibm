package com.ibm.biblioteca.emprestimo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.biblioteca.emprestimo.model.EmprestimoModel;
import com.ibm.biblioteca.emprestimo.service.EmprestimoService;

@RestController
@RequestMapping("/emprestimo")
public class EmprestimoController {

	@Autowired
	EmprestimoService emprestimoService;
	
	@GetMapping("/all")
	public List<EmprestimoModel> listAll(){
		return emprestimoService.findAll();
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> save(@RequestBody EmprestimoModel emprestimo){
		return new ResponseEntity<>(emprestimoService.save(emprestimo), HttpStatus.OK);
	}
	
	@PutMapping("/")
	public ResponseEntity<?> update(@RequestBody EmprestimoModel emprestimo){
		emprestimoService.save(emprestimo);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id){
		emprestimoService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
