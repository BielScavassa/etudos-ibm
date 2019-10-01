package com.ibm.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.exception.NaoEncontradoException;
import com.ibm.model.ClienteModel;
import com.ibm.repository.ClienteRepository;

import javassist.NotFoundException;

@Service
public class ClienteService {

	private final static Logger LOG = LoggerFactory.getLogger(ClienteService.class);

	@Autowired
	ClienteRepository clienteRepository;

	public List<ClienteModel> buscarClientes() {
		LOG.info("Retorno buscarEnderecoCliente" + clienteRepository.findAll());
		return clienteRepository.findAll();
	}

	public String buscarNomeCliente(Long id) throws NotFoundException, InterruptedException{
		Thread.sleep(3000);
		LOG.info("Trying to buscarNomeCliente " + Thread.currentThread().getName());
		Optional<ClienteModel> cliente = clienteRepository.findById(id);
		if (cliente.isPresent()) {
			LOG.info("Retorno buscarNomeCliente: " + cliente.get().getNome());
			return cliente.get().getNome();
		} else {
			LOG.info("Retorno buscarNomeCliente: " + new NaoEncontradoException("Nome"));
			throw new NaoEncontradoException("Nome");
		}
	}
	
	public String buscarEnderecoCliente(Long id) throws NotFoundException {
		LOG.info("Trying to buscarEnderecoCliente " + Thread.currentThread().getName());
		Optional<ClienteModel> cliente = clienteRepository.findById(id);
		if (cliente.isPresent()) {
			LOG.info("Retorno buscarEnderecoCliente: " + cliente.get().getEndereco());
			return cliente.get().getEndereco();
		} else {
			LOG.info("Retorno buscarEnderecoCliente: " + new NaoEncontradoException("Endereco"));
			throw new NaoEncontradoException("Endereco");
		}

	}
	
}
