package com.ibm.repository;

import com.ibm.dto.ClienteDto;
import com.ibm.model.ContaCliente;
import com.ibm.specification.ConsultaSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import java.util.List;

@Repository
public class ClienteRepositoryImpl {

    private final EntityManager entityManager;

    @Autowired
    public ClienteRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<ClienteDto> bucarClientesbySpecification(ConsultaSpecification<ContaCliente> consultaSpecification){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ClienteDto> criteriaQuery = criteriaBuilder.createQuery(ClienteDto.class);
        Root<ContaCliente> root = criteriaQuery.from(ContaCliente.class);

        Predicate predicate = consultaSpecification.consultaToPredicate(root, criteriaBuilder);
        Expression<Number> sumIdade = criteriaBuilder.sum(root.get("idade"));
        criteriaQuery.multiselect(root.get("id"), root.get("nome"), sumIdade).groupBy(root.get("id"), root.get("nome")).where(predicate);
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

}
