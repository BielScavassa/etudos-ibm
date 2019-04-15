package com.ibm.biblioteca.livro.controller;

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

import com.ibm.biblioteca.livro.model.LivroModel;
import com.ibm.biblioteca.livro.service.LivroService;

@RestController
@RequestMapping("/livros")
public class LivroController {

	@Autowired
	LivroService livroService;
	
	@GetMapping("/all")
	public List<LivroModel> listAll(){
		return livroService.findAll();
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> save(@RequestBody LivroModel livro){
		return new ResponseEntity<>(livroService.save(livro), HttpStatus.OK);
	}
	
	@PutMapping("/")
	public ResponseEntity<?> update(@RequestBody LivroModel livro){
		livroService.save(livro);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id){
		livroService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
