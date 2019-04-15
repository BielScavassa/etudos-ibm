package com.ibm.safebox.gateway;

import java.util.List;

import com.ibm.safebox.domain.ClientDomain;

public interface ClientGateway {
	List<ClientDomain> listAll();
	
	ClientDomain save(ClientDomain client);
}
