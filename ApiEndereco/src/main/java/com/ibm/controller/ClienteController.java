package com.ibm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.model.ClienteModel;
import com.ibm.service.ClienteService;

import javassist.NotFoundException;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	private ClienteService clienteService;
	
	@Autowired	
	public ClienteController(ClienteService clienteService) {
		this.clienteService = clienteService;
	}

	@GetMapping("/listar")
	public ResponseEntity<List<ClienteModel>> clientes(){
		return ResponseEntity.status(HttpStatus.OK).body(clienteService.buscarClientes());
	}
	
	@GetMapping("/endereco/{id}")
	public ResponseEntity<String> enderecoCliente(@PathVariable Long id) throws NotFoundException{
		return ResponseEntity.status(HttpStatus.OK).body(clienteService.buscarEnderecoCliente(id));
	}
	
	@GetMapping("/nome/{id}")
	public ResponseEntity<String> nomeCliente(@PathVariable Long id) throws NotFoundException{
		return ResponseEntity.status(HttpStatus.OK).body(clienteService.buscarNomeCliente(id));
	}
}
