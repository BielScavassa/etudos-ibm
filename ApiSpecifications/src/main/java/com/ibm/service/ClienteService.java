package com.ibm.service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.ibm.model.ClienteModel;
import com.ibm.repository.ClienteRepository;
import com.ibm.specification.ClienteSpecification;
import com.ibm.specification.ClienteCriteria;
import com.ibm.specification.example.ClienteSpecificationBuilderExample;
import com.ibm.specification.example.ClienteSpecificationExample;
import com.ibm.specification.example.SearchCriteriaExample;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository clienteRepository;

	
	public List<ClienteModel> buscarClientesByClienteCriteria(ClienteCriteria clienteCriteria) {
		ClienteSpecification clientSpecification = new ClienteSpecification(clienteCriteria);
		return clienteRepository.findAll(clientSpecification);
	}
	
	
//	-------------------------------------------Beldung Example -------------------------------------------
	
	public List<ClienteModel> buscarClientesUnicoCriterioDePesquisa(SearchCriteriaExample searchCriteria) {
		ClienteSpecificationExample clienteSpecification = new ClienteSpecificationExample(searchCriteria);
		return clienteRepository.findAll(clienteSpecification);
	}

	public List<ClienteModel> buscarClientesDoisCriteriosDePesquisa(SearchCriteriaExample searchCriteria01,
			SearchCriteriaExample searchCriteria02) {
		ClienteSpecificationExample clienteSpec01 = new ClienteSpecificationExample(searchCriteria01);
		ClienteSpecificationExample clienteSpec02 = new ClienteSpecificationExample(searchCriteria02);
		return clienteRepository.findAll(Specification.where(clienteSpec01).and(clienteSpec02));
	} 

	//WIP
	public List<ClienteModel> buscarClientesListaCriterios(String pesquisa) {
		ClienteSpecificationBuilderExample builder = new ClienteSpecificationBuilderExample();
		Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(\\w+?),");
		Matcher matcher = pattern.matcher(pesquisa + ",");
		while (matcher.find()) {
			builder.with(matcher.group(1), matcher.group(2), matcher.group(3), matcher.group(4));
		}

		Specification<ClienteModel> spec = builder.build();

		return clienteRepository.findAll(spec);
	}

}
