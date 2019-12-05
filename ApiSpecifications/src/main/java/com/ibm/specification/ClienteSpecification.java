package com.ibm.specification;

import com.ibm.exception.ObrigatorioException;
import com.ibm.model.ContaCliente;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@AllArgsConstructor
public class ClienteSpecification implements ConsultaSpecification<ContaCliente>, Specification<ContaCliente> {

    private ClienteCriteria clientCriteria;

    //	Spring
	@Override
	public Predicate toPredicate(Root<ContaCliente> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
		Predicate predicate = addNome(root, criteriaBuilder);
		predicate = addSobrenome(root, criteriaBuilder, predicate);
		predicate = addEmail(root, criteriaBuilder, predicate);
		predicate = addIdade(root, criteriaBuilder, predicate);
		predicate = addEntreIdade(root, criteriaBuilder, predicate);
		return predicate;
	}

    @Override
    public Predicate consultaToPredicate(Root<ContaCliente> root, CriteriaBuilder criteriaBuilder) {
        Predicate predicate = addNome(root, criteriaBuilder);
        predicate = addSobrenome(root, criteriaBuilder, predicate);
        predicate = addEmail(root, criteriaBuilder, predicate);
        predicate = addIdade(root, criteriaBuilder, predicate);
        predicate = addEntreIdade(root, criteriaBuilder, predicate);
        return predicate;
    }

    private Predicate addNome(Root<ContaCliente> root, CriteriaBuilder criteriaBuilder) {
        if (clientCriteria.getNome() == null || clientCriteria.getNome().isEmpty())
            throw new ObrigatorioException("Nome");
        Predicate predicate = criteriaBuilder.like(root.get("nome"), "%" + clientCriteria.getNome() + "%");
        return predicate;
    }

    private Predicate addSobrenome(Root<ContaCliente> root, CriteriaBuilder criteriaBuilder, Predicate predicate) {
        if (clientCriteria.getSobrenome() == null || clientCriteria.getSobrenome().isEmpty())
            return predicate;
        Predicate predicateSobrenome = criteriaBuilder.like(root.get("sobrenome"), "%" + clientCriteria.getSobrenome() + "%");
        predicate = criteriaBuilder.and(predicate, predicateSobrenome);
        return predicate;
    }

    private Predicate addEmail(Root<ContaCliente> root, CriteriaBuilder criteriaBuilder, Predicate predicate) {
        if (clientCriteria.getEmail() == null || clientCriteria.getEmail().isEmpty())
            return predicate;
        Predicate predicateEmail = criteriaBuilder.equal(root.get("email"), clientCriteria.getEmail());
        predicate = criteriaBuilder.and(predicate, predicateEmail);
        return predicate;
    }

    private Predicate addIdade(Root<ContaCliente> root, CriteriaBuilder criteriaBuilder, Predicate predicate) {
        if (clientCriteria.getIdade() == null)
            return predicate;
        Predicate predicateIdade = criteriaBuilder.equal(root.get("idade"), clientCriteria.getIdade());
        predicate = criteriaBuilder.and(predicate, predicateIdade);
        return predicate;
    }

    private Predicate addEntreIdade(Root<ContaCliente> root, CriteriaBuilder criteriaBuilder, Predicate predicate) {
        if (clientCriteria.getIdadeMinima() == null || clientCriteria.getIdadeMaxima() == null)
            return predicate;
        Predicate predicateBetween = criteriaBuilder.between(root.get("idade"), clientCriteria.getIdadeMinima(),
                clientCriteria.getIdadeMaxima());
        predicate = criteriaBuilder.and(predicate, predicateBetween);
        return predicate;
    }

    //WIP
//	private Predicate addSomaIdades(Root<ClienteModel> root, CriteriaBuilder criteriaBuilder, CriteriaQuery<?> query,Predicate predicate) {
//		Expression<Number> sumIdade = criteriaBuilder.sum(root.get("idade"));
//		return query.multiselect(root.get("id"), root.get("nome"), sumIdade).groupBy(root.get("id"), root.get("nome")).where(predicate).getGroupRestriction();
//	}

}
