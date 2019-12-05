package com.ibm.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public interface ConsultaSpecification<T> {

    Predicate consultaToPredicate(Root<T> root, CriteriaBuilder criteriaBuilder);
}
