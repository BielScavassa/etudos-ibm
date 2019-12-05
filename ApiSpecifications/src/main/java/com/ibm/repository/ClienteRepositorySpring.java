package com.ibm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.ibm.model.ContaCliente;

@Repository
public interface ClienteRepositorySpring extends JpaRepository<ContaCliente, Long>, JpaSpecificationExecutor<ContaCliente> {

}
