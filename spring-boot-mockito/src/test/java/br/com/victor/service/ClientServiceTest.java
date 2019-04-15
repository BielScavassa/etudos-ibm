package br.com.victor.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.victor.repository.ClientRepository;
import br.com.victor.service.impl.ClientServiceImpl;

@TestConfiguration
@RunWith(SpringRunner.class)
public class ClientServiceTest {

	@Bean
	public ClientService clientService() {
		return new ClientServiceImpl();
	}
	
	@Autowired
	private ClientService clientService;
	
	@MockBean
	private ClientRepository ClientRepository;
	
	@Before
	public void setUp() {
		
	}
	
	@Test
	public void whenListAll() {
		//GIVEN
		
		
	}
}
