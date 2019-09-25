package com.ibm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.model.ClienteModel;
import com.ibm.repository.ClienteRepository;

import javassist.NotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	ClienteRepository clienteRepository;

	public List<ClienteModel> buscarClientes(){
		return clienteRepository.findAll();
	}
	
	public String buscarEnderecoCliente(Long id) throws NotFoundException {
		Optional<ClienteModel> cliente = clienteRepository.findById(id);
		if (cliente.isPresent()) {
			return cliente.get().getEndereco();
		}else {
			throw new NotFoundException("Not Found Api");
		}
		
	}
}
