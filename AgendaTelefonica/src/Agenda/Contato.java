package Agenda;

import java.util.ArrayList;
import java.util.List;

public class Contato {
	private Integer id;
	private String nome;
	List<Telefone> telefones;

	public Integer getId() {
		return id;
	}

	public void setId(Integer newId) {
		this.id = newId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String newNome) {
		this.nome = newNome;
	}

	public List<Telefone> getTelefones() {
		if(telefones == null) {
			telefones = new ArrayList<Telefone>();
		}
		return telefones;
	}

	public void setTelefone(List<Telefone> newTelefone) {
		this.telefones = newTelefone;
	}
}
