package com.ibm.safebox.gateway.http.mapper;

import org.springframework.stereotype.Component;

import com.ibm.safebox.domain.ClientDomain;
import com.ibm.safebox.gateway.http.json.CreateNewUserRequest;
import com.ibm.safebox.gateway.http.json.CreateNewUserResponse;

@Component("ClientMapperHttp")
public class ClientMapper {

	public ClientDomain mapToDomain(CreateNewUserRequest client) {
		ClientDomain clientDomain = new ClientDomain();
		
		clientDomain.setName(client.getName());
		clientDomain.setLastName(client.getLastName());
		clientDomain.setUsername(client.getUsername());
		clientDomain.setPassword(client.getPassword());
		clientDomain.setCellphone(client.getCellphone());
		clientDomain.setBirthdate(client.getBirthdate());
		
		return clientDomain;
	}
	
	public CreateNewUserResponse mapToReponse(ClientDomain client) {
		CreateNewUserResponse clientResponse = new CreateNewUserResponse();

		clientResponse.setId(client.getId());
		clientResponse.setName(client.getName());
		clientResponse.setLastName(client.getLastName());
		clientResponse.setUsername(client.getUsername());
		
		return clientResponse;
	} 
}
