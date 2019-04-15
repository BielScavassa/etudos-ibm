package com.ibm.biblioteca.sessao.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ibm.biblioteca.sessao.model.SessaoModel;

@Repository
public interface SessaoRepository extends CrudRepository<SessaoModel, Long>{

}
