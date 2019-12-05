package com.ibm.specification.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;

import com.ibm.model.ContaCliente;

import lombok.Data;

//WIP
@Data
public class ClienteSpecificationBuilderExample {

	private List<SearchCriteriaExample> params;

	public ClienteSpecificationBuilderExample() {
		this.params = new ArrayList<>();
	}

	@Autowired
	public ClienteSpecificationBuilderExample(List<SearchCriteriaExample> params) {
		this.params = params;
	}

	public ClienteSpecificationBuilderExample with(String key, String oparation, Object value, String orPredicate) {
		final Boolean isOrPredicate;
		if(orPredicate == "true") 
			isOrPredicate = true;
		else
			isOrPredicate = false;
		
		params.add(new SearchCriteriaExample(key, oparation, value, isOrPredicate));
		return this;
	}

	public Specification<ContaCliente> build() {
		if (this.params.size() == 0)
			return null;

		List<Specification<ContaCliente>> specs = params.stream().map(ClienteSpecificationExample::new)
				.collect(Collectors.toList());
		Specification<ContaCliente> result = specs.get(0);

		for (int i = 1; i < params.size(); i++) {
			result = params.get(i).isOrPredicate() ? Specification.where(result).or(specs.get(i))
					: Specification.where(result).and(specs.get(i));
		}

		return result;
	}
}
