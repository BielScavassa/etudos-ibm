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
import com.ibm.specification.ClienteSpecification;
import com.ibm.specification.SearchCriteria;

import javassist.NotFoundException;

@Service
public class ClienteService {

	private final static Logger LOG = LoggerFactory.getLogger(ClienteService.class);

	@Autowired
	ClienteRepository clienteRepository;

	public List<ClienteModel> buscarClientesPorSobrenome(SearchCriteria searchCriteria) {
		ClienteSpecification clienteSpecification = new ClienteSpecification(searchCriteria);
		return clienteRepository.findAll(clienteSpecification);
	}

	public String buscarNomeCliente(Long id) throws NotFoundException, InterruptedException{
		Optional<ClienteModel> cliente = clienteRepository.findById(id);
		if (cliente.isPresent()) {
			return cliente.get().getNome();
		} else {
			throw new NaoEncontradoException("Nome");
		}
	}
	
	public String buscarEmailCliente(Long id) throws NotFoundException {
		Optional<ClienteModel> cliente = clienteRepository.findById(id);
		if (cliente.isPresent()) {
			return cliente.get().getEmail();
		} else {
			throw new NaoEncontradoException("Email");
		}

	}
	
}
