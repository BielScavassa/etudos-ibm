package com.ibm.safebox.domain.mapper;

import org.springframework.stereotype.Component;

import com.ibm.safebox.domain.ClientDomain;
import com.ibm.safebox.gateway.postgresql.entity.ClientEntity;

@Component("ClientMapper")
public class ClientMapper {
	
	public ClientEntity mapToEntity(ClientDomain client) {
		ClientEntity clientEntity = new ClientEntity();
		
		clientEntity.setId(client.getId());
		clientEntity.setName(client.getName());
		clientEntity.setLastName(client.getLastName());
		clientEntity.setUsername(client.getUsername());
		clientEntity.setPassword(client.getPassword());
		clientEntity.setCellphone(client.getCellphone());
		
		return clientEntity;
	}
	
	public ClientDomain mapToDomain(ClientEntity client) {
		ClientDomain clientEntity = new ClientDomain();
		
		client.setId(clientEntity.getId());
		client.setName(clientEntity.getName());
		client.setLastName(clientEntity.getLastName());
		client.setUsername(clientEntity.getUsername());
		client.setPassword(clientEntity.getPassword());
		client.setCellphone(clientEntity.getCellphone());
		
		return clientEntity;
	}

}
