package com.ibm.safebox.gateway.postgresql;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.safebox.domain.ClientDomain;
import com.ibm.safebox.gateway.postgresql.entity.ClientEntity;

@Repository
@Transactional
public interface ClientRepository extends CrudRepository<ClientEntity, Long>{
	List<ClientEntity> findAll();

	ClientEntity save(ClientEntity client);
}
