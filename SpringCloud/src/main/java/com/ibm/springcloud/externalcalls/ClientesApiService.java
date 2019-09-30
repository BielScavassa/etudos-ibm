package com.ibm.springcloud.externalcalls;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.ibm.springcloud.client.ClienteServiceClient;
import com.ibm.springcloud.model.Cliente;

@Service
public class ClientesApiService {

	private ClienteServiceClient clienteServiceClient;

	@Autowired
	public ClientesApiService(ClienteServiceClient clienteServiceClient) {
		this.clienteServiceClient = clienteServiceClient;
	}

	@Async
	public CompletableFuture<String> getEndereco(Long id) {
		return CompletableFuture.completedFuture(clienteServiceClient.buscarEnderecoCliente(id));
	}
	
	@Async
	public CompletableFuture<List<Cliente>> getClientes() {
		return CompletableFuture.completedFuture(clienteServiceClient.buscarClientes());
	}
	
	@Async
	public CompletableFuture<String> getNome(Long id) {
		return CompletableFuture.completedFuture(clienteServiceClient.buscarNomeCliente(id));
	}
	

}
