package com.ibm.safebox.gateway.postgresql;

import java.util.ArrayList;
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
	public ClientDomain save(ClientDomain client) {
		ClientEntity saveClient = clientRepository.save(clientMapper.mapToEntity(client));
		
		return clientMapper.mapToDomain(saveClient);
	}

	@Override
	public List<ClientDomain> listAll() {
		//Java8
		//List<ClientDomain> clientList = clientRepository
				//.findAll().stream().map(client-> clientMapper.mapToDomain(client))
			//	.collect(Collectors.toList());		
		//return clientList;
		
		List<ClientEntity> clientEntityList = clientRepository.findAll();
		List<ClientDomain> saveClientList = new ArrayList<ClientDomain>();
		
		if(clientEntityList != null) {
			for(ClientEntity client : clientEntityList) {
				saveClientList.add(clientMapper.mapToDomain(client));
			}
		}
		
		return saveClientList;
	}
}
