package testes;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Agenda.Contato;
import Agenda.Telefone;

public class ContatoTestes {

	Contato contato = new Contato();
	Telefone telefone = new Telefone();
	List<Contato> listaContatos = new ArrayList<Contato>();
	List<Telefone> tels = new ArrayList<Telefone>();
	
	@BeforeEach
	public void setUp() {
		contato.setId(01);
		contato.setNome("Teste");
		telefone.setDdd((short)19);
		telefone.setNumero("2983982173987213");
		telefone.setTipoTelefone("Fixo");
		tels.add(telefone);
		contato.setTelefone(tels);
		listaContatos.add(contato);
	}
	
	@Test
	public void testeTelefoneContatos() {
		Contato cont = new Contato();
		Assertions.assertEquals(telefone, contato.getTelefones().get(0));
		Assertions.assertEquals((short)19, telefone.getDdd());
		Assertions.assertEquals("2983982173987213", telefone.getNumero());
		Assertions.assertEquals("Fixo", telefone.getTipoTelefone());
		Assertions.assertEquals(telefone, contato.getTelefones().get(0));
	}
	
	@Test
	public void testeContatos() {
		Assertions.assertEquals(contato, listaContatos.get(0));
		Assertions.assertTrue(contato.getId() == 01);
		Assertions.assertEquals("Teste", contato.getNome());
		Assertions.assertEquals(tels, contato.getTelefones());
	}
}
