package com.ibm.safebox.gateway.http.mapper;

import org.springframework.stereotype.Component;

import com.ibm.safebox.domain.ClientDomain;
import com.ibm.safebox.gateway.http.json.UserRequestsAndResponses;

@Component("ClientMapperHttp")
public class ClientMapper {

	public ClientDomain mapToDomain(UserRequestsAndResponses client) {
		ClientDomain clientDomain = new ClientDomain();
		
		clientDomain.setName(client.getName());
		clientDomain.setLastName(client.getLastName());
		clientDomain.setUsername(client.getUsername());
		clientDomain.setPassword(client.getPassword());
		clientDomain.setCellphone(client.getCellphone());
		clientDomain.setBirthdate(client.getBirthdate());
		
		return clientDomain;
	}
	
	public UserRequestsAndResponses mapToReponse(ClientDomain client) {
		UserRequestsAndResponses clientResponse = new UserRequestsAndResponses();

		clientResponse.setId(client.getId());
		clientResponse.setName(client.getName());
		clientResponse.setLastName(client.getLastName());
		clientResponse.setUsername(client.getUsername());
		clientResponse.setPassword(client.getPassword());
		clientResponse.setBirthdate(client.getBirthdate());
		clientResponse.setCellphone(client.getCellphone());
		
		return clientResponse;
	} 
}
