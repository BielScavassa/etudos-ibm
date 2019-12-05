package com.ibm.service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ibm.dto.ClienteDto;
import com.ibm.repository.ClienteRepositoryImpl;
import com.ibm.specification.ConsultaSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.ibm.model.ContaCliente;
import com.ibm.repository.ClienteRepositorySpring;
import com.ibm.specification.ClienteSpecification;
import com.ibm.specification.ClienteCriteria;
import com.ibm.specification.example.ClienteSpecificationBuilderExample;
import com.ibm.specification.example.ClienteSpecificationExample;
import com.ibm.specification.example.SearchCriteriaExample;

@Service
public class ClienteService {

	ClienteRepositorySpring clienteRepositorySpring;
	ClienteRepositoryImpl clienteRepository;

	@Autowired
	public ClienteService(ClienteRepositorySpring clienteRepositorySpring, ClienteRepositoryImpl clienteRepository) {
		this.clienteRepositorySpring = clienteRepositorySpring;
		this.clienteRepository = clienteRepository;
	}

	public List<ContaCliente> buscarClientesByClienteCriteria(ClienteCriteria clienteCriteria) {
		ClienteSpecification clientSpecification = new ClienteSpecification(clienteCriteria);
		return clienteRepositorySpring.findAll(clientSpecification);
	}

	public List<ClienteDto> buscarClientesByConsultaSpecification(ClienteCriteria clienteCriteria) {
		ConsultaSpecification<ContaCliente> clientSpecification = new ClienteSpecification(clienteCriteria);
		return clienteRepository.bucarClientesbySpecification(clientSpecification);
	}
	
//	-------------------------------------------Beldung Example -------------------------------------------
	
	public List<ContaCliente> buscarClientesUnicoCriterioDePesquisa(SearchCriteriaExample searchCriteria) {
		ClienteSpecificationExample clienteSpecification = new ClienteSpecificationExample(searchCriteria);
		return clienteRepositorySpring.findAll(clienteSpecification);
	}

	public List<ContaCliente> buscarClientesDoisCriteriosDePesquisa(SearchCriteriaExample searchCriteria01,
																	SearchCriteriaExample searchCriteria02) {
		ClienteSpecificationExample clienteSpec01 = new ClienteSpecificationExample(searchCriteria01);
		ClienteSpecificationExample clienteSpec02 = new ClienteSpecificationExample(searchCriteria02);
		return clienteRepositorySpring.findAll(Specification.where(clienteSpec01).and(clienteSpec02));
	} 

	//WIP
	public List<ContaCliente> buscarClientesListaCriterios(String pesquisa) {
		ClienteSpecificationBuilderExample builder = new ClienteSpecificationBuilderExample();
		Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(\\w+?),");
		Matcher matcher = pattern.matcher(pesquisa + ",");
		while (matcher.find()) {
			builder.with(matcher.group(1), matcher.group(2), matcher.group(3), matcher.group(4));
		}

		Specification<ContaCliente> spec = builder.build();

		return clienteRepositorySpring.findAll(spec);
	}

}
