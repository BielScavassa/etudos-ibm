package com.ibm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.model.ClienteModel;
import com.ibm.service.ClienteService;
import com.ibm.specification.ClienteCriteria;
import com.ibm.specification.example.SearchCriteriaExample;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	private ClienteService clienteService;

	@Autowired
	public ClienteController(ClienteService clienteService) {
		this.clienteService = clienteService;
	}

	@GetMapping("/listarClientesBySpec")
	public ResponseEntity<List<ClienteModel>> buscarClientesByClienteSpecification(@RequestParam("nome") String nome,
			@RequestParam("sobrenome") String sobrenome, @RequestParam("email") String email,
			@RequestParam("idade") Integer idade, @RequestParam("idadeMinima") Integer idadeMinima,
			@RequestParam("idadeMaxima") Integer idadeMaxima) {
		return ResponseEntity.status(HttpStatus.OK).body(
				clienteService.buscarClientesByClienteCriteria(new ClienteCriteria(nome, sobrenome, email, idade, idadeMinima, idadeMaxima)));
	}

//	-------------------------------------------Beldung Example -------------------------------------------

	@GetMapping("/listarUmaSpec")
	public ResponseEntity<List<ClienteModel>> clientesUmaSpec() {
		return ResponseEntity.status(HttpStatus.OK).body(clienteService
				.buscarClientesUnicoCriterioDePesquisa(new SearchCriteriaExample("sobrenome", ":", "Sobrenome")));
	}

	@GetMapping("/listarDuasSpecs")
	public ResponseEntity<List<ClienteModel>> clientesDuasSpecs() {
		return ResponseEntity.status(HttpStatus.OK).body(clienteService.buscarClientesDoisCriteriosDePesquisa(
				new SearchCriteriaExample("sobrenome", ":", "Sobrenome"), new SearchCriteriaExample("idade", "<", 20)));
	}

	// WIP
	@GetMapping("/listarSpecs")
	public ResponseEntity<List<ClienteModel>> clientesListSpecs(@RequestParam(value = "pesquisa") String pesquisa) {
		return ResponseEntity.status(HttpStatus.OK).body(clienteService.buscarClientesListaCriterios(pesquisa));
	}

}
