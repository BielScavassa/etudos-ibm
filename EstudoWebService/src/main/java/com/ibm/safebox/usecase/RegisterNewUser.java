package com.ibm.safebox.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ibm.safebox.domain.ClientDomain;
import com.ibm.safebox.gateway.ClientGateway;

@Component
public class RegisterNewUser {

	private ClientGateway clientGateway;
	private ModalValidator<ClientDomain> modalValidator;
	
	@Autowired
	public RegisterNewUser(ClientGateway clientGateway, ModalValidator<ClientDomain> modalValidator) {
		this.clientGateway = clientGateway;
		this.modalValidator = modalValidator;
	}
	
	public ClientDomain execute(ClientDomain client) {
		modalValidator.execute(client);
		ClientDomain clientDomainSaved = clientGateway.save(client);
		
		clientDomainSaved.setPassword(null);
		return clientDomainSaved;
	}
}
