package com.ibm.springcloud.retryer;

import static br.com.six2six.fixturefactory.Fixture.from;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.ibm.springcloud.client.ClienteServiceClient;
import com.ibm.springcloud.controller.ClientController;
import com.ibm.springcloud.model.Cliente;

import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;

@RunWith(SpringRunner.class)
public class RetryerTest {

	@Autowired
	MockMvc mockMvc;
	
	@InjectMocks
	ClientController clientController;
	
	@Mock
	ClienteServiceClient clienteServiceClient;
	
	
	
	@Before
	public void before() {
		FixtureFactoryLoader.loadTemplates("templates");
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(clientController).build();
	}
	
	@Test
	public void retryListarClientesSucesso() throws Exception {
		List<Cliente> clientes = from(Cliente.class).gimme(2, "cliente valido");
		
		when(clienteServiceClient.buscarClientes()).thenReturn(clientes);
		
		mockMvc.perform(get("localhost:8080/listarClientes")).andExpect(status().isOk()).andReturn();
		
		
	}

	
}
