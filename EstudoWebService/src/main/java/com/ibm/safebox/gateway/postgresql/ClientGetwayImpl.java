package com.ibm.safebox.gateway.postgresql;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ibm.safebox.domain.ClientDomain;
import com.ibm.safebox.domain.mapper.ClientMapper;
import com.ibm.safebox.gateway.ClientGateway;
import com.ibm.safebox.gateway.postgresql.entity.ClientEntity;

@Component
public class ClientGetwayImpl implements ClientGateway{

	private final ClientRepository clientRepository;
	private final ClientMapper clientMapper;
	
	@Autowired
	public ClientGetwayImpl(ClientRepository clientRepository, ClientMapper clientMapper) {
		this.clientRepository = clientRepository;
		this.clientMapper = clientMapper;
	}

	@Override
	public List<ClientDomain> listAll() {
		return null;
	}

	@Override
	public ClientDomain save(ClientDomain client) {
		ClientEntity saveClient = clientRepository.save(clientMapper.mapToEntity(client));
		
		return clientMapper.mapToDomain(saveClient);
	}



}
