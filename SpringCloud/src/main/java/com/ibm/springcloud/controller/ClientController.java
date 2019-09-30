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

	@GetMapping("/buscarEnderecoCliente/{id}")
	public ResponseEntity<String> enderecoCliente(@PathVariable Long id) {
		return ResponseEntity.ok(clienteServiceClient.buscarEnderecoCliente(id));
	}

	@GetMapping("/buscarEnderecoClienteAsync/{id}")
	public String enderecoClienteAsync(@PathVariable Long id) throws InterruptedException, ExecutionException {
		ResponseEntity<CompletableFuture<String>> retorno = ResponseEntity.ok(clientesApiService.getEndereco(id));
		return retorno.getBody().get();
	}

	@GetMapping("/listarClientesAsync")
	public ResponseEntity<CompletableFuture<List<Cliente>>> clientesAsync()
			throws InterruptedException, ExecutionException {
		ResponseEntity<CompletableFuture<List<Cliente>>> retorno = ResponseEntity.ok(clientesApiService.getClientes());
		return retorno;
	}

	@GetMapping("/buscarNomeEnderecoClienteAsync/{id}")
	public String nomeEnderecoClienteAsync(@PathVariable Long id) throws InterruptedException, ExecutionException {
		String nome = ResponseEntity.ok(clientesApiService.getEndereco(id)).getBody().get();
		String endereco = ResponseEntity.ok(clientesApiService.getNome(id)).getBody().get();
		return nome + " " + endereco;
	}
	

	@GetMapping("/buscarNomeEnderecoClienteCombineAsync/{id}")
	public ResponseEntity<String> nomeEnderecoClienteCombineAsync(@PathVariable Long id)
			throws InterruptedException, ExecutionException {
		CompletableFuture<String> nomeEndereco = clientesApiService.getNome(id)
				.thenCombineAsync(clientesApiService.getEndereco(id), (nome, endereco) -> nome + "\n" + endereco);
		return ResponseEntity.ok(nomeEndereco.get());
	}


	@GetMapping("/buscarNomeEnderecoClienteSupplyAsync/{id}")
	public ResponseEntity<String> nomeEnderecoClienteSupplyAsync(@PathVariable Long id) throws InterruptedException, ExecutionException {
		CompletableFuture<String> nomeEndereco = CompletableFuture.supplyAsync(() -> {
			try {
				return clientesApiService.getNome(id).get();
			} catch (InterruptedException | ExecutionException e1) {
				e1.printStackTrace();
			}
			return null;
		})
				.thenComposeAsync(nome -> CompletableFuture.supplyAsync(() -> {
					try {
						return nome +  "\n" + clientesApiService.getEndereco(id).get();
					} catch (InterruptedException | ExecutionException e) {
						e.printStackTrace();
					}
					return null;
				}));
		return ResponseEntity.ok(nomeEndereco.get());
	}

}
