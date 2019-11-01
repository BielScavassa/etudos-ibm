package com.ibm.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.ibm.exception.ObrigatorioException;
import com.ibm.model.ClienteModel;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ClienteSpecification implements Specification<ClienteModel> {
	private static final long serialVersionUID = 1L;

	private ClienteCriteria clientCriteria;

	@Override
	public Predicate toPredicate(Root<ClienteModel> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
		Predicate predicate = addNome(root, criteriaBuilder);
		predicate = addSobrenome(root, criteriaBuilder, predicate);
		predicate = addEmail(root, criteriaBuilder, predicate);
		predicate = addIdade(root, criteriaBuilder, predicate);
		predicate = addEntreIdade(root, criteriaBuilder, predicate);
		return predicate;
	}

	private Predicate addNome(Root<ClienteModel> root, CriteriaBuilder criteriaBuilder) {
		if (clientCriteria.getNome() == null || clientCriteria.getNome().isEmpty())
			throw new ObrigatorioException("Nome");
		Predicate predicate = criteriaBuilder.like(root.get("nome"), "%" + clientCriteria.getNome() + "%");
		return predicate;
	}

	private Predicate addSobrenome(Root<ClienteModel> root, CriteriaBuilder criteriaBuilder, Predicate predicate) {
		if (clientCriteria.getSobrenome() == null || clientCriteria.getSobrenome().isEmpty())
			return predicate;
		Predicate sobrenome = criteriaBuilder.like(root.get("sobrenome"), "%" + clientCriteria.getSobrenome() + "%");
		predicate = criteriaBuilder.and(predicate, sobrenome);
		return predicate;
	}

	private Predicate addEmail(Root<ClienteModel> root, CriteriaBuilder criteriaBuilder, Predicate predicate) {
		if (clientCriteria.getEmail() == null || clientCriteria.getEmail().isEmpty())
			return predicate;
		Predicate email = criteriaBuilder.equal(root.get("email"), clientCriteria.getEmail());
		predicate = criteriaBuilder.and(predicate, email);
		return predicate;
	}

	private Predicate addIdade(Root<ClienteModel> root, CriteriaBuilder criteriaBuilder, Predicate predicate) {
		if (clientCriteria.getIdade() == null )
			return predicate;
		Predicate idade = criteriaBuilder.equal(root.get("idade"), clientCriteria.getIdade());
		predicate = criteriaBuilder.and(predicate, idade);
		return predicate;
	}

	private Predicate addEntreIdade(Root<ClienteModel> root, CriteriaBuilder criteriaBuilder, Predicate predicate) {
		if (clientCriteria.getIdadeMinima() == null || clientCriteria.getIdadeMaxima() == null)
			return predicate;
		Predicate predicateBetween = criteriaBuilder.between(root.get("idade"), clientCriteria.getIdadeMinima(),
				clientCriteria.getIdadeMaxima());
		predicate = criteriaBuilder.and(predicate, predicateBetween);
		return predicate;
	}

}
