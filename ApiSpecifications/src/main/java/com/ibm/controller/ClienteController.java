package com.ibm.controller;

import com.ibm.dto.ClienteDto;
import com.ibm.model.ContaCliente;
import com.ibm.service.ClienteService;
import com.ibm.specification.ClienteCriteria;
import com.ibm.specification.example.SearchCriteriaExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/listarClientesBySpecSpring")
    public ResponseEntity<List<ContaCliente>> buscarClientesByClienteSpecification(@RequestParam("nome") String nome,
																				   @RequestParam("sobrenome") String sobrenome, @RequestParam("email") String email,
																				   @RequestParam("idade") Integer idade, @RequestParam("idadeMinima") Integer idadeMinima,
																				   @RequestParam("idadeMaxima") Integer idadeMaxima) {
        return ResponseEntity.status(HttpStatus.OK).body(
                clienteService.buscarClientesByClienteCriteria(new ClienteCriteria(nome, sobrenome, email, idade, idadeMinima, idadeMaxima, null)));
    }


    @GetMapping("/listarClientesBySpecConsulta")
    public ResponseEntity<List<ContaCliente>> buscarClientesByConsultaSpecification(@RequestParam("nome") String nome,
                                                                                  @RequestParam("sobrenome") String cpf,
                                                                                  @RequestParam("idade") Integer idade, @RequestParam("numero_conta") String numeroConta,
                                                                                  @RequestParam("agencia") String agencia, @RequestParam("ultima_mov") LocalDate ultimaMov,
																				  @RequestParam("saldo_conta") Double saldoConta) {
		System.out.println(LocalDate.now());
        return ResponseEntity.status(HttpStatus.OK).body(
                clienteService.buscarClientesByConsultaSpecification(new ClienteCriteria(nome, cpf, idade, numeroConta, agencia, ultimaMov, saldoConta)));

//	-------------------------------------------Beldung Example -------------------------------------------

    @GetMapping("/listarUmaSpec")
    public ResponseEntity<List<ContaCliente>> clientesUmaSpec() {
        return ResponseEntity.status(HttpStatus.OK).body(clienteService
                .buscarClientesUnicoCriterioDePesquisa(new SearchCriteriaExample("sobrenome", ":", "Sobrenome")));
    }

    @GetMapping("/listarDuasSpecs")
    public ResponseEntity<List<ContaCliente>> clientesDuasSpecs() {
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.buscarClientesDoisCriteriosDePesquisa(
                new SearchCriteriaExample("sobrenome", ":", "Sobrenome"), new SearchCriteriaExample("idade", "<", 20)));
    }

    // WIP
    @GetMapping("/listarSpecs")
    public ResponseEntity<List<ContaCliente>> clientesListSpecs(@RequestParam(value = "pesquisa") String pesquisa) {
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.buscarClientesListaCriterios(pesquisa));
    }

}
