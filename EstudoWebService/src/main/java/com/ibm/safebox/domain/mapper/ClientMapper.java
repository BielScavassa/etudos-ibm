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
		ClientDomain clientDomain = new ClientDomain();
		
		clientDomain.setId(client.getId());
		clientDomain.setName(client.getName());
		clientDomain.setLastName(client.getLastName());
		clientDomain.setUsername(client.getUsername());
		clientDomain.setPassword(client.getPassword());
		clientDomain.setCellphone(client.getCellphone());
		
		return clientDomain;
	}
}
