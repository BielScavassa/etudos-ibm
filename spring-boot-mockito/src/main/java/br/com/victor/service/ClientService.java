package br.com.victor.service;

import br.com.victor.model.Client;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public interface ClientService {

	List<Client> listAll();

	Client getById(Long id);

	Client saveOrUpdate(Client client);

	void delete(Long id);
	
	Client findByName(String name);

	boolean exists(String name);
}
