package fatec.edu.gov.aulaspoo.desafio;

public class Gerente extends Funcionario {
	private String loja;
	private Funcionario funcionario;

	public Gerente() {
	}

	public Gerente(Long id, String nome, Double comissao, Double salario, Integer qtdVendas, String loja,
			Funcionario funcionario) {
		super(id, nome, comissao, salario, qtdVendas);
		this.loja = loja;
		this.funcionario = funcionario;
	}

	// Construtor copia segundo a ideia de não passar a referencia e sempre criar novos objetos
	public Gerente(Gerente gerente) {
		super(gerente.getId(), gerente.getNome(), gerente.getComissao(), gerente.getSalario(), gerente.getQtdVendas());
		this.loja = gerente.getLoja();
		this.funcionario = new Funcionario(gerente.getFuncionario());
	}

	public String getLoja() {
		return loja;
	}

	public void setLoja(String loja) {
		this.loja = loja;
	}

	public Funcionario getFuncionario() {
		return new Funcionario(funcionario);
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

}
