package fatec.edu.gov.aulaspoo.desafio;

public class Carro {
	private String tipoDeRoda;
	private String modelo;
	private Integer ano;
	private Double preco;

	public Carro() {
	}

	public Carro(String modelo, Integer ano, String tipoDeRoda, Double preco) {
		this.modelo = modelo;
		this.ano = ano;
		this.tipoDeRoda = tipoDeRoda;
		this.preco = preco;
	}
	
	//construtor copia
	public Carro(Carro carro) {
		this.tipoDeRoda = carro.getTipoDeRoda();
		this.modelo = carro.getModelo();
		this.ano = carro.getAno();
		this.preco = carro.getPreco();
	}

	public String getModelo() {
		return this.modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getTipoDeRoda() {
		return tipoDeRoda;
	}

	public void setTipoDeRoda(String tipoDeRoda) {
		this.tipoDeRoda = tipoDeRoda;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	@Override
	public String toString() {
		return "Carro [tipoDeRoda=" + tipoDeRoda + ", modelo=" + modelo + ", ano=" + ano + ", preco=" + preco + "]";
	}

}
