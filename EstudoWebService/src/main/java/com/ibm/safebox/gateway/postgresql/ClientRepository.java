package com.ibm.safebox.gateway.postgresql;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.safebox.gateway.postgresql.entity.ClientEntity;

@Repository
@Transactional
public interface ClientRepository extends CrudRepository<ClientEntity, Long>{
	
//	@Query("SELECT CLENTITY.id, CLENTITY.name FROM ClientEntity AS CLENTITY") Pesquisar pq nao transforma o objeto
	@Query("SELECT CLENTITY FROM ClientEntity AS CLENTITY")
	List<ClientEntity> findAll();

	ClientEntity save(ClientEntity client);
}
