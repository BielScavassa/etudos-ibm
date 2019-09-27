package com.ibm.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.springcloud.client.ClienteServiceClient;
import com.ibm.springcloud.model.Cliente;

import feign.Logger;

@RestController
public class ClientController {

	@Autowired 
	ClienteServiceClient clienteServiceClient;
	
	@GetMapping("/listarClientes") 
	public ResponseEntity<List<Cliente>> clientes(){
		return ResponseEntity.status(HttpStatus.OK).body(clienteServiceClient.buscarClientes());
	}
	
	@GetMapping("/buscarEnderecoCliente/{id}")
	public ResponseEntity<String> enderecoCliente(@PathVariable Long id){
		return ResponseEntity.ok(clienteServiceClient.buscarEnderecoCliente(id));
	}
	
}
