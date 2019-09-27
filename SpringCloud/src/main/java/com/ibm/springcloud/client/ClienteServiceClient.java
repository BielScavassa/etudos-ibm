package com.ibm.springcloud.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ibm.springcloud.configuration.FeignConfiguration;
import com.ibm.springcloud.model.Cliente;

@FeignClient(name = "cliente-service", url = "http://localhost:8081/cliente", configuration = FeignConfiguration.class)
public interface ClienteServiceClient {

	@GetMapping("/listar")
	public List<Cliente> buscarClientes();
	
	@GetMapping("/endereco/{id}")
	public String buscarEnderecoCliente(@PathVariable Long id);
}
