package com.ibm.safebox.usecase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ibm.safebox.domain.ClientDomain;
import com.ibm.safebox.gateway.ClientGateway;

@Component
public class FindAll {
	
	private final ClientGateway clientGateway;
	private ModalValidator<ClientDomain> modalValidator;
	
	@Autowired
	public FindAll(ClientGateway clientGateway, ModalValidator<ClientDomain> modalValidator) {
		this.clientGateway = clientGateway;
		this.modalValidator = modalValidator;
	}

	public List<ClientDomain> execute(){
		List<ClientDomain> clientList = clientGateway.listAll();
		
		for(ClientDomain client : clientList) {
			modalValidator.execute(client);
		}
		
		return clientList;
	}
}
