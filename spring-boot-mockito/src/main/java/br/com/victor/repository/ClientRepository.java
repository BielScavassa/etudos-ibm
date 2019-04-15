package br.com.victor.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.victor.model.Client;

@Repository
@Transactional
public interface ClientRepository extends JpaRepository<Client, Long> { 
	
	Client findByName(String name);
	Client findById(long id);
	
	List<Client> findAll();
}
