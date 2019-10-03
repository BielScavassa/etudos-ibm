package com.ibm.springcloud.controller;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.springcloud.client.ClienteServiceClient;
import com.ibm.springcloud.externalcalls.ClientesApiService;
import com.ibm.springcloud.model.Cliente;

@RestController
public class ClientController {

	private ClienteServiceClient clienteServiceClient;
	private ClientesApiService clientesApiService;

	@Autowired
	public ClientController(ClienteServiceClient clienteServiceClient, ClientesApiService clientesApiService) {
		this.clienteServiceClient = clienteServiceClient;
		this.clientesApiService = clientesApiService;
	}

	@GetMapping("/listarClientes")
	public ResponseEntity<List<Cliente>> clientes() {
		return ResponseEntity.status(HttpStatus.OK).body(clienteServiceClient.buscarClientes());
	}

	@GetMapping("/buscarNomeCliente/{id}")
	public ResponseEntity<String> nomeCliente(@PathVariable Long id) {
		return ResponseEntity.ok(clienteServiceClient.buscarNomeCliente(id));
	}
	
	@GetMapping("/buscarEnderecoCliente/{id}")
	public ResponseEntity<String> enderecoCliente(@PathVariable Long id) {
		return ResponseEntity.ok(clienteServiceClient.buscarEnderecoCliente(id));
	}

	@GetMapping("/buscarNomeClienteAsync/{id}")
	public ResponseEntity<String> nomeClienteAsync(@PathVariable Long id)
			throws InterruptedException, ExecutionException {
		CompletableFuture<String> nome = clientesApiService.getNome(id);
		return ResponseEntity.ok(nome.get());
	}
	
	@GetMapping("/buscarEnderecoClienteAsync/{id}")
	public ResponseEntity<String> enderecoClienteAsync(@PathVariable Long id)
			throws InterruptedException, ExecutionException {
		CompletableFuture<String> endereco = clientesApiService.getEndereco(id);
		return ResponseEntity.ok(endereco.get());
	}

	@GetMapping("/listarClientesAsync")
	public ResponseEntity<CompletableFuture<List<Cliente>>> clientesAsync()
			throws InterruptedException, ExecutionException {
		ResponseEntity<CompletableFuture<List<Cliente>>> retorno = ResponseEntity.ok(clientesApiService.getClientes());
		return retorno;
	}

	@GetMapping("/buscarNomeEnderecoClienteAsync/{id}")
	public ResponseEntity<String> nomeEnderecoClienteCombineAsync(@PathVariable Long id)
			throws InterruptedException, ExecutionException {
		CompletableFuture<String> nomeEndereco = clientesApiService.getNome(id)
				.thenCombineAsync(clientesApiService.getEndereco(id), (nome, endereco) -> nome + "\n" + endereco);
		return ResponseEntity.ok(nomeEndereco.get());
	}

	@GetMapping("/buscarNomeEnderecoModificadoClienteAsync/{id}")
	public ResponseEntity<String> nomeEnderecoClienteAsync(@PathVariable Long id)
			throws InterruptedException, ExecutionException {
		CompletableFuture<String> nome = clientesApiService.getNome(id);
		CompletableFuture<String> endereco = clientesApiService.getEndereco(id);

		CompletableFuture<String> nomeEnderecoModificado = nome
				.thenApplyAsync(nomeModificado -> "Nome: " + nomeModificado)
				.thenCombineAsync(endereco.thenApplyAsync(enderecoModificado -> "Endereco: "),
						(nomeModificado, enderecoModificado) -> nomeModificado + "\n" + enderecoModificado);

		return ResponseEntity.ok(nomeEnderecoModificado.get());
	}

}
