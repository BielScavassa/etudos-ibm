package fatec.edu.gov.aulaspoo;

public class Escola {

	private String nome;
	private String endereco;
	private Integer idGoverno;

	public Escola(String nome, String endereco, Integer idGoverno) {
		this.nome = nome;
		this.endereco = endereco;
		this.idGoverno = idGoverno;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Integer getIdGoverno() {
		return idGoverno;
	}

	public void setIdGoverno(Integer idGoverno) {
		this.idGoverno = idGoverno;
	}


}
