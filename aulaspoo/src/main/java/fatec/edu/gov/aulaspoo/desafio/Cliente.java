package fatec.edu.gov.aulaspoo.desafio;

public class Cliente {

	private String nome;
	private String cpf;
	private Double carteira;
	private Carro carro;

	public Cliente() {
	}

	public Cliente(String nome, String cpf, Double carteira, Carro carro) {
		this.nome = nome;
		this.cpf = cpf;
		this.carteira = carteira;
		this.carro = carro;
	}

	// construtor copia, seguindo a ideia de não passar a referencia e sempre criar novos objetos
	public Cliente(Cliente cliente) {
		this.nome = cliente.getNome();
		this.cpf = cliente.getCpf();
		this.carteira = cliente.getCarteira();
		this.carro = new Carro(cliente.getCarro());
	}

	// seguindo a ideia de não passar a referencia e sempre criar novos objetos utizando o construtor copia da classe Carro
	public void alugarCarro(Carro carro) { // -> Desafio 6
		this.carro = new Carro(carro);
	}

	public String alugarCarroAprimorado(Carro carro, Funcionario funcionario) {
		this.carro = new Carro(carro);
		funcionario.setComissao(carro.getPreco() * 0.20);
		return "Carro alugado com sucesso";
	}

	// seguindo a ideia de não passar a referencia e sempre criar novos objetos utizando o construtor padrao da classe Carro
	public String devolverCarro() {
		this.carro = new Carro();
		return "Carro devolvido com sucesso.";
	}

	public String comprarCarro(Carro carro, Funcionario funcionario) {
		setCarteira(this.carteira - carro.getPreco());
		setCarro(carro);
		funcionario.setQtdVendas(+1);
		return "Carro comprado com sucesso";
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

	// Retornar uma copia do carro, para não passar a referencia
	public Carro getCarro() {
		return new Carro(this.carro);
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", cpf=" + cpf + ", carteira=" + carteira + ", carro=" + carro + "]";
	}

}
