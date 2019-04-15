package br.com.victor.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import br.com.victor.model.Client;

@RunWith(SpringRunner.class)
public class ClintRepositoryTest {

	@Mock
	private ClientRepository clientRepository;
	
	@Before
	public void setUp() {
		FixtureFactoryLoader.loadTemplates("br.com.victor.tamplates");
	}
	
	@Test
	public void whenFindByName_thenReturnClient() {
		//GIVEN
		Client client = Fixture.from(Client.class).gimme("client informations valid");
		List<Client> clientList = Fixture.from(Client.class).gimme(5,"client informations valid");
		String name = "gabriel";
		long id = 1L;
		
		//WHEN
		Mockito.when(clientRepository.findAll()).thenReturn(clientList);
		Mockito.when(clientRepository.findByName(name)).thenReturn(client);
		Mockito.when(clientRepository.findById(id)).thenReturn(client);
		
		//THEN
		assertThat(client.getId()).isEqualTo(id);
		assertThat(client.getName()).isEqualTo("gabriel");
		assertThat(client.getLastname()).isEqualTo("scavassa");
		assertThat(client.getusername()).isEqualTo("gabriel.scavassa@asdsa.com");
		assertThat(client.getCpf()).isEqualTo("12345678900");
		assertThat(clientList.size()).isEqualTo(5);
		
		assertThat(clientList.get(0).getId()).isEqualTo(id);
		assertThat(clientList.get(0).getName()).isEqualTo("gabriel");
		assertThat(clientList.get(0).getLastname()).isEqualTo("scavassa");
		assertThat(clientList.get(0).getusername()).isEqualTo("gabriel.scavassa@asdsa.com");
		assertThat(clientList.get(0).getCpf()).isEqualTo("12345678900");
	}
	
}
