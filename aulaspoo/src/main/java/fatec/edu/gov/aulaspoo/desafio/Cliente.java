package fatec.edu.gov.aulaspoo.desafio;

public class Cliente {

	private String nome;
	private String cpf;
	private Double carteira;
	private Carro carro;

	public Cliente(String nome, String cpf, Double carteira, Carro carro) {
		this.nome = nome;
		this.cpf = cpf;
		this.carteira = carteira;
		this.carro = carro;
	}

	public Cliente() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Double getCarteira() {
		return carteira;
	}

	public void setCarteira(Double carteira) {
		this.carteira = carteira;
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", cpf=" + cpf + ", carteira=" + carteira + ", carro=" + carro + "]";
	}
	
	public String comprarCarro(Carro carro, Funcionario funcionario) {
		setCarteira(this.carteira - carro.getPreco());
		setCarro(carro);
		funcionario.setQtdVendas( + 1);
		return "Carro comprado com sucesso";
	}
	
}
