package br.com.victor.service.impl;

import java.util.Base64;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.victor.model.Client;
import br.com.victor.repository.ClientRepository;
import br.com.victor.util.CryptographyUtil;

import br.com.victor.service.ClientService;;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientRepository clientRepository;

	private static final Logger logger = LoggerFactory.getLogger(ClientServiceImpl.class);

	@Override
	public List<Client> listAll() {
		return clientRepository.findAll();
	}

	@Override
	public Client getById(Long id) {
		return clientRepository.findById(id);
	}

	@Override
	public Client saveOrUpdate(Client client) {
		try {
			CryptographyUtil cryp = new CryptographyUtil();
			cryp.saveKeysKeyStore(client.getusername(), client.getPassword());
			client.setPublicKey(cryp.getPublicKeyStr());
			client.setPassword(Base64.getEncoder()
					.encodeToString((cryp.encrypt(client.getPublicKey(), client.getPassword().getBytes()))));
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		clientRepository.save(client);
		return client;
	}

	@Override
	public void delete(Long id) {
		clientRepository.delete(id);
	}

	@Override
	public Client findByName(String name) {
		return clientRepository.findByName(name);
	}

	@Override
	public boolean exists(String name) {
		if (clientRepository.findByName(name) != null) {
			return true;
		}
		return false;
	}
}
